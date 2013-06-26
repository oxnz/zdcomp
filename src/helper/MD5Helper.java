package helper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Helper {
	public static String invitation = "zdworks";

	public static String encrypt(String s) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		String pass = "";
		try {
			pass = encoder.encode(md5.digest(s.getBytes("utf-8")));
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return pass;
	}
	
}
