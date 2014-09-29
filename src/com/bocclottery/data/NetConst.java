package com.bocclottery.data;

import android.os.Environment;



public interface NetConst  {
	
	public static final String NO_DATA = "暂无";
	
	//192.168.200.244:80  访问代理
	public static final String PROXY_HOST = "192.168.200.244";//
	public static final int 	PROXY_PORT= 80;
	
	public static final long TIMEOUT_REQUEST = 1000*60*2;
	public static final long TIMEOUT_REQUEST_10 = 1000*60*2;//
	public static final String URL_FORGETPWD="http://member.qfc.cn/my/get-password.action";
	
	public static final boolean DEBUG = false;//测试环境
	public static final boolean FORMAL = true;//正式环境
	
	public static final URLFactory _UF = new URLFactory(FORMAL);
	
	public static final String URL_OPENAPI_APPKEY = "openApiAppKey";
	public static final String URL_OPENAPI_BUSICODE = "openApiBusiCode";
	public static final String URL_OPENAPI_TIMESTAMP = "openApiTimestamp";
	public static final String URL_OPENAPI_VALIDCODE = "openApiValidCode";
	public static final String URL_OPENAPI_USERCODE = "openApiUserCode";
	public static final String URL_OPENAPI_SESSIONKEY = "openApiSessionKey";
	
//	public static final String PARAMS_USERNAME = "userName";

	public static final String RESULT_SIGN = "resultSign";
	public static final String RESULT_OBJECT="resultObj";
	public static final String RESULT_ERROR_MSG="errorMsg";//
	
//	public static final String REQUEST_OPEN_API_PRODUCT_SERISE_FINDALL = "open.api.product.serise.findall";















}
