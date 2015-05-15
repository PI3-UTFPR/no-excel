package Util;

public class Crypto {
	
	public String encrypt(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
     
    public boolean checkHash(String password, String hashed)  {
    	return BCrypt.checkpw(password, hashed);
    }
}
