
package com.UCC.conexion;

import java.net.PasswordAuthentication;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;
import javax.websocket.Session;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author LUIS
 */
public class Security {
    
    public static String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	} 
	catch (NoSuchAlgorithmException e) {		
		e.printStackTrace();
		return null;
	}
	    
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
	    
	for(byte b : hash) {        
		sb.append(String.format("%02x", b));
	}
	    
	return sb.toString();
}
    
   public static String numeroaleatorio() {
    String numeroaleatorio;
    int length = 6; 
    Random random = new Random();
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      sb.append(random.nextInt(10)); 
    }
    numeroaleatorio = sb.toString(); 
    return numeroaleatorio;
    
}
    
    
    
}
