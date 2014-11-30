package com.qfc.yft;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.test.AndroidTestCase;
import android.util.Log;

import com.bocclottery.utils.JackUtils;
import com.qfc.yft.util.HandleStrings;


public class FormatingTest extends AndroidTestCase {
	private final String TAG  = "UNIT_TEST";

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	public void fromJsonstrToCode() throws JSONException{
		convertJsonToCode();
		String result = HandleStrings.readAndConvert3(mContext);
		assertNotNull(result);
		Log.i(TAG, result);
	}
	
	public void convertJsonToCode() throws JSONException{
		final String jsonStr = "{\"actEnroll\":1,\"actEnrollInfo\":\"[{name:'姓名',engname:'name',desc:'请输入姓名'},{name:'年龄',engname:'age',desc:'请输入您的年龄'}]\",\"actModel\":1,\"receiveWay\":\"抽中奖品，实物类均于次月按指定地址邮寄，电子礼券类由系统即时发送短信至持卡人预留手机号中。\",\"enrollEndTime\":{\"date\":30,\"day\":3,\"hours\":0,\"minutes\":0,\"month\":6,\"nanos\":0,\"seconds\":0,\"time\":1406649600000,\"timezoneOffset\":-480,\"year\":114},\"actContent\":\"持中行信用卡消费单笔金额满199元，即可登录网站进行自助抽奖，赢取丰厚奖品，单卡单月限抽20次。\",\"isDelete\":0,\"modTime\":{\"date\":28,\"day\":4,\"hours\":14,\"minutes\":34,\"month\":7,\"nanos\":0,\"seconds\":51,\"time\":1409207691000,\"timezoneOffset\":-480,\"year\":114},\"actIndex\":1,\"actRecommend\":1,\"actStatus\":1,\"actObject\":\"限浙江省内(除宁波外)信用卡持卡人(含中银卡、长城卡)\",\"actName\":\"信用卡消费抽奖\",\"actId\":1,\"actEndTime\":{\"date\":9,\"day\":3,\"hours\":0,\"minutes\":0,\"month\":2,\"nanos\":0,\"seconds\":0,\"time\":1457452800000,\"timezoneOffset\":-480,\"year\":116},\"actLimitNum\":0,\"actRule\":\"仅限持卡人本人登录抽奖；<br>\r\n活动期间，持卡消费单笔金额满199元，5个工作日后可登陆网站参与自助抽奖，单笔交易限抽1次，单卡单月限抽20次；<br>\r\n当月抽奖机会保留至次月15日24时，过期视同自动放弃，不能再参与抽奖；<br>\r\n每期奖品抽完为止，且每期奖品种类将根据实际情况进行调整，详情以网站公布为准；\",\"isSpecial\":0,\"actStartTime\":{\"date\":11,\"day\":5,\"hours\":0,\"minutes\":0,\"month\":0,\"nanos\":0,\"seconds\":0,\"time\":1357833600000,\"timezoneOffset\":-480,\"year\":113},\"enrollStartTime\":{\"date\":15,\"day\":2,\"hours\":0,\"minutes\":0,\"month\":6,\"nanos\":0,\"seconds\":0,\"time\":1405353600000,\"timezoneOffset\":-480,\"year\":114},\"modMember\":\"admin\",\"actImages\":\"/images/common/actImage/act_img_1.jpg\",\"addMember\":\"admin\",\"modelPath\":\"gift/specialTemplate/act199.ftl\",\"modIp\":\"192.168.199.105\",\"addIp\":\"127.0.0.1\",\"isShow\":1,\"addTime\":{\"date\":10,\"day\":4,\"hours\":14,\"minutes\":39,\"month\":0,\"nanos\":0,\"seconds\":49,\"time\":1357799989000,\"timezoneOffset\":-480,\"year\":113}}";
		JSONObject job = new JSONObject(jsonStr);
		Iterator<String> it = job.keys();
		StringBuffer sb = new StringBuffer();
		while(it.hasNext()){
			String name = it.next();
			String line = String.format("private String %s;", name);
			sb.append(line);
//			write(name);
		}
//		Log.i(TAG, sb.toString());
		JackUtils.writeToSomeWhere(mContext, sb.toString());
	}

	/**
	 * @param name
	 */
	private void write(String name) {
		JackUtils.writeToFile(getContext(), "Format", name);
	}
	
	
}
