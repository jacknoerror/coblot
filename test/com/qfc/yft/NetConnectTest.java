package com.qfc.yft;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.AndroidTestCase;
import android.util.Log;

import com.bocclottery.MyApplication;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.ActInfoService.ExecuteSurveyInfoActionRequest;
import com.bocclottery.net.GiftExchangeInfoService.MobileSearchGiftExchangeInfoRequest;
import com.bocclottery.net.MemberInfoService.MobileSendSmsRequest;
import com.bocclottery.net.MobileMergeService.GetAllInfoAndAdvertiseRequest;
import com.bocclottery.net.MobileMergeService.MobileGetParticipateSizeAndExchangeSizeRequest;
import com.bocclottery.net.MobileMergeService.MobileLoginAndExecuteMemberActionRequest;
import com.bocclottery.net.PublicGiftService.GetAllActRequest;
import com.bocclottery.net.action.ActionRequestImpl;
import com.bocclottery.utils.DesUtils;
import com.bocclottery.utils.JackRexUtil;
import com.bocclottery.utils.JackRexUtil.JackReRules;
import com.bocclottery.utils.JackUtils;

public class NetConnectTest extends AndroidTestCase {
	final String TAG = "UNIT_TEST";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	private String test(int apiId) throws Exception {
		ActionRequestImpl ari = null;
		String result = null;
		
//memberId:161050;exchangeId:3200941;actId:2;username:ceshi1;password:123456;realname:测试1;cardNo:3302
		switch (apiId) {
		case 0:
//			ari = new MobileAddMemberNewRequest("jack","123456","ccc", "3302", "", result, apiId, result);
			ari = new GetAllActRequest();//获取所有活动
			break;
		case 1:
			ari = new MobileSearchGiftExchangeInfoRequest(161050, 1, 10);//中奖纪录
			break;
		case 2:
			ari = new MobileSendSmsRequest("ceshi1", "3301", "测试1", MobileSendSmsRequest.SMS_TYPE_REG);
			break;
		case 3:
			ari = new MobileGetParticipateSizeAndExchangeSizeRequest(161050);//根据用户ID查询所中的幸运奖数量和查询中奖数量
			break;
		case 4:
			ari = new GetAllInfoAndAdvertiseRequest();
			break;
			
		case 7:
			ari = new ExecuteSurveyInfoActionRequest(161050, 50);
			break;
		default://login
			ari = new MobileLoginAndExecuteMemberActionRequest("ceshi1", DesUtils.encrypt("123456"), "", 1);//"103E702E0737327C"
			break;
		}
		result = NetStrategies.doHttpRequest(ari.toHttpBody());
		if (null != ari)
			JackUtils.writeToFile(getContext(), ari.getApiName(), result);

		return result;
	}

	/**
	 * @throws Exception 
	 */
	public void testSayYes() throws Exception {
		String result = "";
		// login:26 ;
//		result = test(-1); 
		result = test(7);
		Log.i(TAG, "result=>" + result);
		// Log.i(TAG,"mtime2=>"+System.currentTimeMillis());
		assertTrue(result.contains("true"));
	}


	
	  public void testRE(){ 
		  boolean check; // check =
//	  JackRexUtil.checkRE(JackReRules.RE_RULE_EMAIL, "o@k.cn"); // check =
//	  "555d".matches("[0-9]+?"); // check =
//	  JackRexUtil.hasRE(JackReRules.RE_RULE_HAS_DIGIT,"o@k.cn44444"); check =
		  check = JackRexUtil.checkRE(JackReRules.RE_RULE_A_Z_A_Z0_9_$_SIZE,"12345123456789067890-");
//	   check = JackRexUtil.checkRE(JackRexUtil.JackReRules.RE_RULE_ONLY_DIGIT, "141");
	   assertTrue(check); 
	  }
	 
	public void testRE2(){
		String str = "123$%^abc8_9.0";
		str = str.replaceAll("[^0-9]", "");
		assertEquals(str, "123890");
	}

	public void testNetwork() {
		ConnectivityManager connManager = (ConnectivityManager) MyApplication
				.app().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connManager.getActiveNetworkInfo();
		Log.i(TAG, info.getType() + "+" + info.getTypeName());
	}
	
	
	
	public void calDpPx(){
		int a = JackUtils.px2dip(mContext, 260);
		Log.i(TAG, "p2d:"+a);
		int b = JackUtils.dip2px(mContext, 20);
		Log.i(TAG, "d2p:"+b);
		assertNotSame(a|b, 0);
	}
	public void calDpPxMany(){
		int aa[] = new int[]{105,60,45};
		for(int a : aa){
			int b = JackUtils.px2dip(mContext, a);
			Log.i(TAG, a+":p2d:"+b);
			
		}
	}
	
}
