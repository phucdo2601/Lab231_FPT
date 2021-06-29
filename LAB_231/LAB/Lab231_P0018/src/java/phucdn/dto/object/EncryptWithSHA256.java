/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EncryptWithSHA256 {

    public static String hassPassBySHA256(String textToHash) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
            byte[] hashedByetArray = digest.digest(byteOfTextToHash);
            String encoded = Base64.getEncoder().encodeToString(hashedByetArray);
            return encoded;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptWithSHA256.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        EncryptWithSHA256 hashPass = new EncryptWithSHA256();
        System.out.println(EncryptWithSHA256.hassPassBySHA256("12345678"));
    }
}
