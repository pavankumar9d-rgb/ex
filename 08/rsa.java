import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;
import javax.crypto.Cipher;

class rsa {
    public static void main(String[] args) throws Exception {
        String text = "Hello World";

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        byte[] encrypted = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Encrypted text: " + Base64.getEncoder().encodeToString(encrypted));
        System.out.println("Decrypted text: " + new String(decrypted, StandardCharsets.UTF_8));
    }
}