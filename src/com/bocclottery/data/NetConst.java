package com.bocclottery.data;

import android.os.Environment;



public interface NetConst  {
	
	public static final String NO_DATA = "暂无";
	
	//192.168.200.244:80  访问代理
	public static final String PROXY_HOST = "192.168.200.244";//
	public static final int 	PROXY_PORT= 80;
	
	public static final long TIMEOUT_REQUEST = 1000*60*2;
	public static final long TIMEOUT_REQUEST_10 = 1000*60*2;//
//	public static final String URL_FORGETPWD="http://member.qfc.cn/my/get-password.action";
	
	public static final boolean DEBUG = false;//测试环境
	public static final boolean FORMAL = false;//正式环境
	
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

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_PUBLIC_GIFT_SERVICE_GET_GIFT_BY_ACT_ID = "com.mobile.zjboc.cj.gift.PublicGiftService.getGiftByActId";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_PUBLIC_GIFT_SERVICE_GET_ALL_ACT = "com.mobile.zjboc.cj.gift.PublicGiftService.getAllAct";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_GIFT_EXCHANGE_INFO_SERVICE_MOBILE_SEARCH_GIFT_EXCHANGE_INFO = "com.mobile.zjboc.cj.gift.GiftExchangeInfoService.mobileSearchGiftExchangeInfo";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_GIFT_EXCHANGE_INFO_SERVICE_MOBILE_SEND_MESSAGE = "com.mobile.zjboc.cj.gift.GiftExchangeInfoService.mobileSendMessage";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_GIFT_EXCHANGE_INFO_SERVICE_MOBILE_EXCHANGE_GIFT = "com.mobile.zjboc.cj.gift.GiftExchangeInfoService.mobileExchangeGift";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_EXECUTE_ENROLL_ACTION = "com.mobile.zjboc.cj.gift.ActInfoService.executeEnrollAction";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_MOBILE_GET = "com.mobile.zjboc.cj.gift.ActInfoService.mobileGet";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_EXECUTE_GIFT_INDEX_ACTION = "com.mobile.zjboc.cj.gift.ActInfoService.executeGiftIndexAction";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_EXECUTE_QUERY_ACTION = "com.mobile.zjboc.cj.gift.ActInfoService.executeQueryAction";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_EXECUTE_SURVEY_INFO_ACTION = "com.mobile.zjboc.cj.gift.ActInfoService.executeSurveyInfoAction";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ENROLL_INFO_SERVICE_MOBILE_SAVE = "com.mobile.zjboc.cj.gift.EnrollInfoService.mobileSave";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_ADDRESS_INFO_SERVICE_MOBILE_GET = "com.mobile.zjboc.cj.member.AddressInfoService.mobileGet";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_ADDRESS_INFO_SERVICE_MOBILE_SAVE = "com.mobile.zjboc.cj.member.AddressInfoService.mobileSave";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_ADDRESS_INFO_SERVICE_MOBILE_SET_DEFAULT = "com.mobile.zjboc.cj.member.AddressInfoService.mobileSetDefault";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_ADDRESS_INFO_SERVICE_MOBILE_DELETE = "com.mobile.zjboc.cj.member.AddressInfoService.mobileDelete";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_MOBILE_CHANGE_PASSWORD = "com.mobile.zjboc.cj.member.MemberInfoService.mobileChangePassword";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_MOBILE_FIND_PASSWORD = "com.mobile.zjboc.cj.member.MemberInfoService.mobileFindPassword";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_ADD_EXCHANGE_GIFT = "com.mobile.zjboc.cj.member.MemberInfoService.addExchangeGift";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_MOBILE_LOGOUT = "com.mobile.zjboc.cj.member.MemberInfoService.mobileLogout";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_MOBILE_SEND_SMS = "com.mobile.zjboc.cj.member.MemberInfoService.mobileSendSms";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_SURVEY_SURVEY_INFO_SERVICE_MOBILE_GET = "com.mobile.zjboc.cj.survey.SurveyInfoService.mobileGet";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_SURVEY_SURVEY_INFO_SERVICE_MOBILE_SAVE = "com.mobile.zjboc.cj.survey.SurveyInfoService.mobileSave";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_PROMOTE_PROMOTE_SERVICE_MOBILE_SEARCH_PROMOTE_GIFT_INFO = "com.mobile.zjboc.cj.promote.PromoteService.mobileSearchPromoteGiftInfo";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_PROMOTE_PROMOTE_SERVICE_MOBILE_SEARCH_PROMOTE_GIFT_DETAIL = "com.mobile.zjboc.cj.promote.PromoteService.mobileSearchPromoteGiftDetail";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_PROMOTE_PROMOTE_SERVICE_MOBILE_OPERATE_PROMOTE_GIFT_DETAIL = "com.mobile.zjboc.cj.promote.PromoteService.mobileOperatePromoteGiftDetail";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_GIFT_INFO_SERVICE_GET_LEFT_NUM_MAP = "com.mobile.zjboc.cj.gift.GiftInfoService.getLeftNumMap";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_GET_ALL_INFO_AND_ADVERTISE = "com.mobile.zjboc.cj.gift.MobileMergeService.getAllInfoAndAdvertise";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_MOBILE_LOGIN_AND_EXECUTE_MEMBER_ACTION = "com.mobile.zjboc.cj.gift.MobileMergeService.mobileLoginAndExecuteMemberAction";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_MOBILE_GET_MEMBER_NEW = "com.mobile.zjboc.cj.gift.MobileMergeService.mobileGetMemberNew";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_MOBILE_ADD_MEMBER_NEW = "com.mobile.zjboc.cj.gift.MobileMergeService.mobileAddMemberNew";

	public static final String APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_MOBILE_GIFT_AND_GET_LEFT_NUM = "com.mobile.zjboc.cj.gift.MobileMergeService.mobileGiftAndGetLeftNum";

	public static final String APINAME_MOBILE_GET_PARTICIPATE_SIZE_AND_EXCHANGE_SIZE = "com.mobile.zjboc.cj.gift.MobileMergeService.mobileGetParticipateSizeAndExchangeSize";
	
//	public static final String REQUEST_OPEN_API_PRODUCT_SERISE_FINDALL = "open.api.product.serise.findall";















}
