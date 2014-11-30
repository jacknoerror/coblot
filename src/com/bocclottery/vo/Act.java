package com.bocclottery.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class Act extends JsonImport {
	private String actEnroll;
	private String actModel;
	private String actEnrollInfo;
	private String actContent;
	private String enrollEndTime;
	private String receiveWay;
	private String isDelete;
	private String actIndex;
	private String modTime;
	private String actStatus;
	private String actRecommend;
	private String actObject;
	private String actName;
	private String actId;
	private String actEndTime;
	private String actLimitNum;
	private String isSpecial;
	private String actRule;
	private String actStartTime;
	private String enrollStartTime;
	private String modMember;
	private String actImages;
	private String addMember;
	private String modIp;
	private String modelPath;
	private String addIp;
	private String addTime;
	private String isShow;
	

	@Override
	public void initJackJson(JSONObject job) throws JSONException {
		if(job.has("actEnroll")) actEnroll = job.getString("actEnroll");
		if(job.has("actModel")) actModel = job.getString("actModel");
		if(job.has("actEnrollInfo")) actEnrollInfo = job.getString("actEnrollInfo");
		if(job.has("actContent")) actContent = job.getString("actContent");
		if(job.has("enrollEndTime")) enrollEndTime = job.getString("enrollEndTime");
		if(job.has("receiveWay")) receiveWay = job.getString("receiveWay");
		if(job.has("isDelete")) isDelete = job.getString("isDelete");
		if(job.has("actIndex")) actIndex = job.getString("actIndex");
		if(job.has("modTime")) modTime = job.getString("modTime");
		if(job.has("actStatus")) actStatus = job.getString("actStatus");
		if(job.has("actRecommend")) actRecommend = job.getString("actRecommend");

	}

}
