package no.hvl.lph.dat108;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class Utils {

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

    public static boolean validatePassword(String password, String hash, String salt) {
        String[] hashAndSalt = hashPassword(password, salt);
        return hashAndSalt[0].equals(hash);
    }

    public static boolean isLoggedIn(HttpSession session) {
        Object _isLoggedIn = session.getAttribute("isLoggedIn");
        return _isLoggedIn != null && (boolean) _isLoggedIn == true;
    }

    public static boolean login(HttpServletRequest request, Participant participant, String password) {
        logout(request.getSession());
        HttpSession session = request.getSession();

        if (participant == null) {
            System.out.printf("Login failed, could not find user\n");
            return false;
        }

        if (!validatePassword(password, participant.getPassHash(), participant.getPassSalt())) {
            System.out.printf("Login for user '%s', failed with wrong password\n", participant.getPhonenumber());
            return false;
        }

        session.setMaxInactiveInterval(60);
        session.setAttribute("phonenumber", participant.getPhonenumber());
        session.setAttribute("isLoggedIn", true);
        System.out.printf("Login success\n");

        return true;
    }

    public static void logout(HttpSession session) {
        session.invalidate();
    }

}
