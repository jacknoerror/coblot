package com.qfc.yft;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.AndroidTestCase;
import android.util.Log;

import com.bocclottery.MyApplication;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;
import com.bocclottery.utils.JackUtils;
import com.qfc.yft.util.JackRexUtil;
import com.qfc.yft.util.JackRexUtil.JackReRules;

public class NetConnectTest extends AndroidTestCase {
	final String TAG = "UNIT_TEST";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	private String test(int apiId) throws SocketTimeoutException,
			UnknownHostException, IOException {
		ActionRequestImpl ari = null;
		String result = null;

		
		switch (apiId) {
		case 0:
//			ari = new GetProductForMotion1Req(162153);
			break;
		default://login
//			ari = new PointVerifyForIMReq("ydspipad1", "333333a");
			break;
		}
		result = NetStrategies.doHttpRequest(ari.toHttpBody());
		if (null != ari)
			JackUtils.writeToFile(getContext(), ari.getApiName(), result);

		return result;
	}

	/**
	 * @throws SocketTimeoutException
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void testSayYes() throws SocketTimeoutException,UnknownHostException, IOException {
		String result = "";

		// login:26 ;
		result = test(3);
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
