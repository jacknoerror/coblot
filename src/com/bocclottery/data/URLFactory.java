package com.bocclottery.data;

public class URLFactory {
	
	private String url;
	private final String OPEN_API_SESSION_KEY = "openApiSessionKey";
	private final String OPEN_API_APP_SECRET = "zjboc_new";
	private final String OPEN_API_APP_KEY = "zjboc_new";
	
	public URLFactory(boolean formal) {
		if(formal){
			url = "http://192.168.199.158:8080/new_zjboc_cj2_www/invoke/json";//TODO
		}else{
			url = "http://test.qfc.com.cn/cj/invoke/json";
			
		}
			
	}
	
	public final String getUrl() {
		return url;
	}

	public final String getOPEN_API_SESSION_KEY() {
		return OPEN_API_SESSION_KEY;
	}

	public final String getOPEN_API_APP_SECRET() {
		return OPEN_API_APP_SECRET;
	}

	public final String getOPEN_API_APP_KEY() {
		return OPEN_API_APP_KEY;
	}
	
	
}
