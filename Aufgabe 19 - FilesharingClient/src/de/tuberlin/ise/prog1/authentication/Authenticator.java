/**
 * 
 */
package de.tuberlin.ise.prog1.authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Dave
 *
 */
public class Authenticator {

	public static byte [] getHash(String firstname, String lastname){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update((firstname+lastname).getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("MD5 does not exist on your machine. Please, contact je@ise.tu-berlin.de and enclose the following stack trace:");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	

}
