import java.util.Scanner;

class hill {
    private static String clean(String text) {
        return text.toUpperCase().replaceAll("[^A-Z]", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text (letters only): ");
        String text = clean(sc.nextLine());

        if (text.length() == 0) {
            System.out.println("Please enter at least one letter.");
            return;
        }

        if (text.length() % 2 != 0) {
            text += "X";
        }

        String encrypted = "";
        String decrypted = "";

        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'A';
            int b = text.charAt(i + 1) - 'A';

            int x = (3 * a + 3 * b) % 26;
            int y = (2 * a + 5 * b) % 26;

            encrypted += (char) (x + 'A');
            encrypted += (char) (y + 'A');
        }

        for (int i = 0; i < encrypted.length(); i += 2) {
            int x = encrypted.charAt(i) - 'A';
            int y = encrypted.charAt(i + 1) - 'A';

            int a = (15 * x + 17 * y) % 26;
            int b = (20 * x + 9 * y) % 26;

            decrypted += (char) (a + 'A');
            decrypted += (char) (b + 'A');
        }

        if (decrypted.endsWith("X")) {
            decrypted = decrypted.substring(0, decrypted.length() - 1);
        }

        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}