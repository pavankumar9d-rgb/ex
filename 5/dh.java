import java.math.BigInteger;

class dh {
    public static void main(String[] args) {
        BigInteger p = BigInteger.valueOf(23);
        BigInteger g = BigInteger.valueOf(5);

        BigInteger privateA = BigInteger.valueOf(6);
        BigInteger privateB = BigInteger.valueOf(15);

        BigInteger publicA = g.modPow(privateA, p);
        BigInteger publicB = g.modPow(privateB, p);

        BigInteger keyA = publicB.modPow(privateA, p);
        BigInteger keyB = publicA.modPow(privateB, p);

        System.out.println("Public key of A: " + publicA);
        System.out.println("Public key of B: " + publicB);
        System.out.println("Shared key of A: " + keyA);
        System.out.println("Shared key of B: " + keyB);

        if (keyA.equals(keyB)) {
            System.out.println("Key exchange successful.");
        }
    }
}