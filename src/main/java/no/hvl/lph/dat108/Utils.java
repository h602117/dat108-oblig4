package no.hvl.lph.dat108;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Utils {

    public static String[] hashPassword(String password, String salt) {

        if (salt == null) {
            salt = generateSalt();
        }

        char[] passChars = password.toCharArray();
        byte[] saltBytes = DatatypeConverter.parseHexBinary(salt);

        byte[] keyhash = null;
        try {
            PBEKeySpec pks = new PBEKeySpec(passChars, saltBytes, 1000, 256);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            keyhash = skf.generateSecret(pks).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return new String[] { DatatypeConverter.printHexBinary(keyhash), DatatypeConverter.printHexBinary(saltBytes) };
    }

    private static String generateSalt() {
        byte[] salt = new byte[16];
        try {
            SecureRandom randy = SecureRandom.getInstance("SHA1PRNG");
            randy.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return DatatypeConverter.printHexBinary(salt);
    }

    public static boolean validatePassword(String password, String hash, String salt) {
        String[] hashAndSalt = hashPassword(password, salt);
        return hashAndSalt[0].equals(hash);
    }
}
