/*
 * Decompiled with CFR 0.152.
 */
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class \u0569
implements X509TrustManager {
    \u0569() {
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public static void main(String[] stringArray) {
        throw new RuntimeException("Invalid execution context: 0x5ba859");
    }
}

