/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pe.clases;

import com.mongodb.DBObject;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import pe.edu.bean.UsuarioBean;
import sun.misc.BASE64Encoder;

/**
 *
 * @author GooMoonRyong
 */
public class Utilitarios {
    
    public static String makePasswordHash(String password, String salt) {
        try {
            String saltedAndHashed = password + "," + salt;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(saltedAndHashed.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            byte hashedBytes[] = (new String(digest.digest(), "UTF-8")).getBytes();
            return encoder.encode(hashedBytes) + "," + salt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 is not available", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 unavailable?  Not a chance", e);
        }
    }

    public static boolean password(String pass,UsuarioBean u,DBObject db) {
        
        String hashedAndSalted = (String) db.get("password");

        String salt = hashedAndSalted.split(",")[1];
        
        if (!hashedAndSalted.equals(Utilitarios.makePasswordHash(pass, salt))) {
            System.out.println(Utilitarios.makePasswordHash(pass, salt));
            return false;
        }else{
            return true;
        }
    }
    
    
    
}
