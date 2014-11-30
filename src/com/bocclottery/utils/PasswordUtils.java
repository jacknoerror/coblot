package com.bocclottery.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/** 
 *
 *
 * @Project: qfp_core
 * @File: PasswordUtils.java 
 * @Date: 2012-3-14 
 * @Author: 周强
 * @Copyright: 版权�?�� (C) 2012 浙江中国轻纺城网络有限公司，并保留所有权�? 
 *
 * 注意：本内容仅限于浙江中国轻纺城网络有限公司内部传阅，禁止外泄以及用于其他的商业目的 
 */

public class PasswordUtils {

	private static MessageDigest md;
	private static final String EncodeType = "SHA-256";

	private static final char[] hexDigits	= { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'A', 'B', 'C', 'D', 'E', 'F' };
	
	private static final char[] randomChars	= { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	static {
		try {
			md = MessageDigest.getInstance(EncodeType);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private static String encode(String str) {
		md.update(str.getBytes());
		byte[] bytes = md.digest();
		StringBuffer sb = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; ++i) {
			char c0 = hexDigits[(bytes[i] & 0xF0) >> 4];
			char c1 = hexDigits[bytes[i] & 0x0F];
			sb.append(c0);
			sb.append(c1);

		}
		return sb.toString();
	}

	public static String encrypt(String password) throws Exception {
		if(null==password||password.isEmpty())
			throw new Exception("password can not be null or empty");
		
		String tempKey = MyRandomStringUtils.random(10, randomChars);
		password = tempKey + password;
		return tempKey + encode(password);
	}

	public static boolean validPassword(String passwordSys, String passwordUsr) {
		try{
			String tempKey = passwordSys.substring(0, 10);
			if (passwordSys.equals(tempKey + encode(tempKey + passwordUsr)))
				return true;
			else
				return false;
		}catch(Exception e) {
			return false;
		}
	}
}
