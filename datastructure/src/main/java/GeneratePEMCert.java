import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

public class GeneratePEMCert {

    public static void main(String... args) {
       /*String pemcert =  new GeneratePEMCert().readCertAsPem("src/main/resources/tbsc-wrmhl.p12", "mHafWFMAJneCBRkD7jGa".toCharArray());
       System.out.println("PEM Cert :: " + pemcert);

       try (FileWriter fileWriter = new FileWriter("src/main/resources/tbsc_prod.pem")) {
           fileWriter.write(pemcert);
       } catch (IOException e) {
           e.printStackTrace();
       }*/

       new GeneratePEMCert();
        Integer n=0;

       System.out.println("test "+n);

    }

    private String readCertAsPem(String filePath, char[] password) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

            keyStore.load(new FileInputStream(filePath), password);
            List<String> aliases = Collections.list(keyStore.aliases());
            X509Certificate cert = (X509Certificate) keyStore.getCertificate(aliases.get(0));
            String str = convertToBase64PEMString(cert).replace("\n", "");
            return str;
        } catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String convertToBase64PEMString(X509Certificate x509Cert) throws IOException {
        StringWriter sw = new StringWriter(2 * 1024);
        try (JcaPEMWriter pw = new JcaPEMWriter(sw)) {
            pw.writeObject(x509Cert);
        }
        return sw.toString();
    }
}
