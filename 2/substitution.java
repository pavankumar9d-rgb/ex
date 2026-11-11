import java.util.Scanner;

class substitution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String normal = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String coded = "QWERTYUIOPASDFGHJKLZXCVBNM";

        System.out.print("Enter text: ");
        String text = sc.nextLine().toUpperCase();

        String encrypted = "";
        String decrypted = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int pos = normal.indexOf(ch);

            if (pos == -1) {
                encrypted += ch;
            } else {
                encrypted += coded.charAt(pos);
            }
        }

        for (int i = 0; i < encrypted.length(); i++) {
            char ch = encrypted.charAt(i);
            int pos = coded.indexOf(ch);

            if (pos == -1) {
                decrypted += ch;
            } else {
                decrypted += normal.charAt(pos);
            }
        }

        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}