# NSC Lab Java Programs

Programs are arranged in folders `1` through `11`, matching the sets in the NSC LAB question sheet. Each `.java` file is a standalone program and uses only standard Java libraries.

## Notes

- The Diffie-Hellman questions in the source sheet mention HTML and JavaScript; these two programs are implemented in Java as requested.
- Set 1(b) and Set 7(a) mention RC4 and Blowfish. Both algorithms are included as separate short programs in those set folders.
- The Hill Cipher uses the fixed 2 x 2 key matrix `[[3, 3], [2, 5]]` and accepts alphabetic text, padding an odd-length message with `X`.
- AES, DES and Blowfish examples demonstrate encryption and decryption for lab learning. RC4, DES, MD5 and SHA-1 are legacy algorithms and are not suitable for new security systems.
- The Blowfish programs generate a fresh key at runtime.

Each file has a matching lowercase class name, so the file can be opened and run independently in Geany.
