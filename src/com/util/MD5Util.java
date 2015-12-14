package com.util;

import java.security.MessageDigest;

public class MD5Util {

	public final static String MD5(String s) {
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));

			}
			return change(sb.toString());
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String change(String b) {
		char letters[] = new char[b.length()];
		for(int i=0;i<b.length();i++){
		   
			char letter = b.charAt(i);
			if(letter>='a' && letter<='z'){
				letter = (char) (letter-32);
			}
			letters[i] = letter;
		}
		  
		return new String(letters);
	}
}