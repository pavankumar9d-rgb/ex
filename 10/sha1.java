import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

class sha1 {
    public static void main(String[] args) throws Exception {
        String text = "Hello World";

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(text.getBytes(StandardCharsets.UTF_8));

        StringBuilder result = new StringBuilder();
        for (byte b : digest) {
            result.append(String.format("%02x", b & 0xff));
        }

        System.out.println("Text: " + text);
        System.out.println("SHA-1 digest: " + result);
    }
}