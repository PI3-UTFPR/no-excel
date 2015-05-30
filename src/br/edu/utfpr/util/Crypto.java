package br.edu.utfpr.util;

public class Crypto {
	
	public static String encrypt(String text) {
		return BCrypt.hashpw(text, BCrypt.gensalt(10));
    }
     
    public static boolean checkHash(String text, String hashed)  {
    	return BCrypt.checkpw(text, hashed);
    }
}
