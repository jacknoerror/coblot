package com.bocclottery.net.action;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.DialogInterface;

import com.bocclottery.MyApplication;
import com.bocclottery.data.NetConst;
import com.bocclottery.data.MyData;
import com.bocclottery.ui.MyPortal;
import com.bocclottery.utils.JackUtils;

public class ActionStrategies implements NetConst {

	public static Object getResultTrueObject(String result) throws JSONException {
		JSONObject job = new JSONObject(result);
		if (job.optBoolean(RESULT_SIGN)) {
			return job.opt(RESULT_OBJECT);
		} else {
			showErrMsg(result);
		}
		return null;
	}


	/**
	 * @param result
	 * @throws JSONException
	 */
	public static void showErrMsg(String result) throws JSONException {
		JSONObject job = new JSONObject(result);
		if(job.optString("errorCode").equals("E00005")){
			showRelogin();
		}
		
		String errMsg = new JSONObject(result).optString(RESULT_ERROR_MSG);
		if(errMsg.contains("ϵͳ����")&&errMsg.length()>35) errMsg = "�Բ��������������";//0716 0728 0807
		if(!errMsg.isEmpty())JackUtils.showToast(MyApplication.app(), errMsg);
	}


	/**
	 * 
	 */
	public static void showRelogin() {
		try{
			
			final Activity activity = (Activity) MyData.data().getTabHost().getContext();
			JackUtils.showDialog(activity, "����δ��¼����Ҫ���µ�¼", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
//							MyPortal.goStartLogin(activity);
							//TODO
							JackUtils.showToast(activity, "actionstrategry");
							
						}
					});
		}catch(Exception e){
			JackUtils.showToast(MyApplication.app(), "����δ��¼����Ҫ���µ�¼");
		}
	}
	

	public static JSONObject getResultObject(String result) throws JSONException {
		Object obj = getResultTrueObject(result);
		if(null!=obj){
			if(obj instanceof JSONObject) return (JSONObject)obj;
		}
//		Log.e("ACTTAG", "resultJob nil");
		return null;
	}
	public static JSONArray getResultArray(String result) throws JSONException {
		Object obj = getResultTrueObject(result);
		if(null!=obj){
			if(obj instanceof JSONArray) return (JSONArray)obj;
		}
		return null;
	}
	public static String getResultString(String result) throws JSONException {
		Object obj = getResultTrueObject(result);
		if(null!=obj){
			if(obj instanceof String) return (String)obj;
		}
		return null;
	}
	public static boolean getResultBoolean(String result) throws JSONException {
		return new JSONObject(result).optBoolean(RESULT_OBJECT);
	}
}
