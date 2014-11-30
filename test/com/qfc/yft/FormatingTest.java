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
		final String jsonStr = "{\"actEnroll\":1,\"actEnrollInfo\":\"[{name:'����',engname:'name',desc:'����������'},{name:'����',engname:'age',desc:'��������������'}]\",\"actModel\":1,\"receiveWay\":\"���н�Ʒ��ʵ������ڴ��°�ָ����ַ�ʼģ�������ȯ����ϵͳ��ʱ���Ͷ������ֿ���Ԥ���ֻ����С�\",\"enrollEndTime\":{\"date\":30,\"day\":3,\"hours\":0,\"minutes\":0,\"month\":6,\"nanos\":0,\"seconds\":0,\"time\":1406649600000,\"timezoneOffset\":-480,\"year\":114},\"actContent\":\"���������ÿ����ѵ��ʽ����199Ԫ�����ɵ�¼��վ���������齱��Ӯȡ���Ʒ�����������޳�20�Ρ�\",\"isDelete\":0,\"modTime\":{\"date\":28,\"day\":4,\"hours\":14,\"minutes\":34,\"month\":7,\"nanos\":0,\"seconds\":51,\"time\":1409207691000,\"timezoneOffset\":-480,\"year\":114},\"actIndex\":1,\"actRecommend\":1,\"actStatus\":1,\"actObject\":\"���㽭ʡ��(��������)���ÿ��ֿ���(�������������ǿ�)\",\"actName\":\"���ÿ����ѳ齱\",\"actId\":1,\"actEndTime\":{\"date\":9,\"day\":3,\"hours\":0,\"minutes\":0,\"month\":2,\"nanos\":0,\"seconds\":0,\"time\":1457452800000,\"timezoneOffset\":-480,\"year\":116},\"actLimitNum\":0,\"actRule\":\"���޳ֿ��˱��˵�¼�齱��<br>\r\n��ڼ䣬�ֿ����ѵ��ʽ����199Ԫ��5�������պ�ɵ�½��վ���������齱�����ʽ����޳�1�Σ����������޳�20�Σ�<br>\r\n���³齱���ᱣ��������15��24ʱ��������ͬ�Զ������������ٲ���齱��<br>\r\nÿ�ڽ�Ʒ����Ϊֹ����ÿ�ڽ�Ʒ���ཫ����ʵ��������е�������������վ����Ϊ׼��\",\"isSpecial\":0,\"actStartTime\":{\"date\":11,\"day\":5,\"hours\":0,\"minutes\":0,\"month\":0,\"nanos\":0,\"seconds\":0,\"time\":1357833600000,\"timezoneOffset\":-480,\"year\":113},\"enrollStartTime\":{\"date\":15,\"day\":2,\"hours\":0,\"minutes\":0,\"month\":6,\"nanos\":0,\"seconds\":0,\"time\":1405353600000,\"timezoneOffset\":-480,\"year\":114},\"modMember\":\"admin\",\"actImages\":\"/images/common/actImage/act_img_1.jpg\",\"addMember\":\"admin\",\"modelPath\":\"gift/specialTemplate/act199.ftl\",\"modIp\":\"192.168.199.105\",\"addIp\":\"127.0.0.1\",\"isShow\":1,\"addTime\":{\"date\":10,\"day\":4,\"hours\":14,\"minutes\":39,\"month\":0,\"nanos\":0,\"seconds\":49,\"time\":1357799989000,\"timezoneOffset\":-480,\"year\":113}}";
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
