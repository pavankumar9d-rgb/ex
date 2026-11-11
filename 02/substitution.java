import java.util.Scanner;

class substitution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine().toUpperCase();

        System.out.print("Enter key: ");
        int key = sc.nextInt();
        key = ((key % 26) + 26) % 26;

        String encrypted = "";
        String decrypted = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                encrypted += (char) ((ch - 'A' + key) % 26 + 'A');
            } else {
                encrypted += ch;
            }
        }

        for (int i = 0; i < encrypted.length(); i++) {
            char ch = encrypted.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                decrypted += (char) ((ch - 'A' - key + 26) % 26 + 'A');
            } else {
                decrypted += ch;
            }
        }

        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}