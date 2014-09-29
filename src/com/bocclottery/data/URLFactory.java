package com.bocclottery.data;

public class URLFactory {
	
	private String url;
	private final String OPEN_API_SESSION_KEY = "openApiSessionKey";
	private final String OPEN_API_APP_SECRET = "zjboc_jfcj";
	private final String OPEN_API_APP_KEY = "zjboc_jfcj";
	
	public URLFactory(boolean formal) {
		if(formal){
			url = "";//TODO
		}else{
			url = "";
			
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
