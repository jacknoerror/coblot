/**
 * 
 */
package com.bocclottery.utils;

/**
 * @author taotao
 *
 */
public class MyRandomStringUtils {

	public static String random(int size, char[] chars) throws Exception{
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++){
			int randomChar = getRandomChar(chars);
			sb.append(chars[randomChar]);
		}
		return sb.toString();
	}

	/**
	 * @param chars
	 * @return
	 */
	private static int getRandomChar(char[] chars) {
		return (int) (Math.random()*chars.length);
	}
	
	
}
