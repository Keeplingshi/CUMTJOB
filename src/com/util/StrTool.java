package com.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StrTool {
	/**
	 * 将一个string 转成 UTF8形式的string
	 * @param content
	 * @return
	 */
	public static String string2UTF8(String content)
	{
		String str=null;
		if(content==null){
			return null;
		}
		try {
			str = URLEncoder.encode(content,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 将一个 UTF8 解析成string
	 * @param content
	 * @return
	 */
	public static String UTF82String(String content)
	{
		String str=null;
		if(content==null){
			return null;
		}
		try {
			str=URLDecoder.decode(content,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
}
