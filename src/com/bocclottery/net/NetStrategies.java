package com.bocclottery.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Intent;
import android.util.Log;

import com.bocclottery.MyApplication;
import com.bocclottery.data.NetConst;
import com.bocclottery.data.MyData;
import com.bocclottery.utils.JackUtils;


public class NetStrategies implements NetConst{
	static final String TAG = "NetS";
	
	/**
	 * only use in test now.
	 * @param result
	 * @param params
	 * @return
	 */
	public static String doHttpRequest( String... params) throws UnknownHostException,SocketTimeoutException,IOException{
		return HttpRequestTask.doHttpRequest(_UF.getUrl(), params[0]);
	}
	
	/*public static String getCurrentUserCode(){
		return MyData.data().getUserCode();
	}
	public static String getSessionKey(){
		return MyData.data().getSessionId();
	}*/
	private static String getApiTimeStamp(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()+MyData.data().getApiTimeLag());
	}
	public static Map<String, String> getBasicParamMapInstance(String apiName,int paramAdd){
		Map<String, String> paramKV = new HashMap<String, String>();
		paramKV.put(URL_OPENAPI_APPKEY,_UF.getOPEN_API_APP_KEY());
		paramKV.put(URL_OPENAPI_BUSICODE, apiName);
		paramKV.put(URL_OPENAPI_TIMESTAMP, getApiTimeStamp());//TODO ʱ��
		String sessionKey = MyData.data().getSessionKey();
		if(null!=sessionKey&&!sessionKey.isEmpty())paramKV.put(_UF.getOPEN_API_SESSION_KEY(), sessionKey);//sessionkey
		return paramKV;
	}
	public static Map<String, String> getBasicParamMapInstance(String apiName){
		return getBasicParamMapInstance(apiName, 0);
	}
	
	public static String finishTheURL(Map<String, String> map){
		if(null==map)return "";//0418
		StringBuffer url,valid;
		url = new StringBuffer();
		valid = new StringBuffer();
		//����
		String[] arrays = new String[]{};
		arrays = map.keySet().toArray(arrays);
		Arrays.sort(arrays);
		//��ǩ
			for(String str : arrays){
				valid.append(str)
					.append(map.get(str));
					url.append(str)
						.append("=")
						.append(new String(map.get(str)))
						.append("&");
			}
		valid.append(_UF.getOPEN_API_APP_SECRET());
		Log.i(TAG, "url::"+url);
		//ƴ��
		url.append(URL_OPENAPI_VALIDCODE).append("=").append(JackUtils.getMD5(valid.toString()));
		return url.toString();
	}
	
	/**
	 * �ύ���ݵ�������
	 * @param path �ϴ�·��(ע������ʹ��localhost��127.0.0.1������·�����ԣ���Ϊ����ָ���ֻ�ģ�����������ʹ��http://www.itcast.cn��http://192.168.1.10:8080������·������)
	 * @param params ������� keyΪ������,valueΪ����ֵ
	 * @param encode ����
	 */
	public static byte[] postFromHttpClient(String path, Map<String, String> params, String encode) throws Exception{
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();//���ڴ���������
		for(Map.Entry<String, String> entry : params.entrySet()){
			formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, encode);
		HttpPost httppost = new HttpPost(path);
		httppost.setEntity(entity);
		HttpClient httpclient = new DefaultHttpClient();//�����������
		HttpResponse response = httpclient.execute(httppost);//����post����		
		return readStream(response.getEntity().getContent());
	}
	
	/**
	 * ��ȡ��
	 * @param inStream
	 * @return �ֽ�����
	 * @throws Exception
	 */
	public static byte[] readStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while( (len=inStream.read(buffer)) != -1){
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return outSteam.toByteArray();
	}
	

	
	public static void logout(){
		MyData.data().destroy();
	}


	//	private static NotificationManager nm;
	public static int notification_id = 19172439;
	
}
