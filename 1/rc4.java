import java.nio.charset.StandardCharsets;

class rc4 {
    private static byte[] encrypt(byte[] data, byte[] key) {
        int[] s = new int[256];

        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }

        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + (key[i % key.length] & 0xff)) % 256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        byte[] result = new byte[data.length];
        int i = 0;
        j = 0;

        for (int n = 0; n < data.length; n++) {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;

            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            int k = s[(s[i] + s[j]) % 256];
            result[n] = (byte) (data[n] ^ k);
        }

        return result;
    }

    private static String toHex(byte[] data) {
        StringBuilder out = new StringBuilder();

        for (byte b : data) {
            out.append(String.format("%02x", b & 0xff));
        }

        return out.toString();
    }

    public static void main(String[] args) {
        String text = "Helloworld";
        byte[] key = "SecretKey".getBytes(StandardCharsets.UTF_8);

        byte[] encrypted = encrypt(text.getBytes(StandardCharsets.UTF_8), key);
        byte[] decrypted = encrypt(encrypted, key);

        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + toHex(encrypted));
        System.out.println("Decrypted text: " + new String(decrypted, StandardCharsets.UTF_8));
    }
}