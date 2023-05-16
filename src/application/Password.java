package application;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    
    private static byte[] getSalt() {
        byte[] salt = System.getProperty("PASSWORD_SALT").getBytes();
        return salt;
    }
    
    public static String getSecurePassword(String password) {
        
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(getSalt());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return generatedPassword;
        
    }
    
}
