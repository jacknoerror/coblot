package com.bocclottery.data;



public class Const implements NetConst{
	
	public static float SCREEN_WIDTH,SCREEN_HEIGHT;
	
	public static final String _URL_BASE = "http://www.zj.bank-of-china.com/jfcj";
//	public static final String _URL_BASE = "http://qfcsoft.test.tnc.cn/jfcj";//≤‚ ‘ª∑æ≥
	// public static final String _URL_BASE = "http://192.168.1.110/jfcj";
//	 public static final String _URL_BASE =	 "http://192.168.199.105:8081/zjboc_jf_cj_www";
	public static final String _URL_INVOKE = "/invoke";
	public static final String _URL_JSON = "/json";
	public static final String _URL = _URL_BASE + _URL_INVOKE + _URL_JSON;
	public static final String _URL_HTML = _URL_BASE + "/html";
	public static final String _URL_GETTIME = _URL_BASE + _URL_INVOKE;
	
	
	
}
