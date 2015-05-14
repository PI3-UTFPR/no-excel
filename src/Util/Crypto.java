package Util;

public class Crypto {
	
	public String encrypt(String text) {
		return BCrypt.hashpw(text, BCrypt.gensalt(12));
    }
     
    public boolean checkHash(String text, String hashed)  {
    	return BCrypt.checkpw(text, hashed);
    }
}
