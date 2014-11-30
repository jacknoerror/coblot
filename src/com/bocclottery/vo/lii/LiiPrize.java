package com.bocclottery.vo.lii;

import org.json.JSONException;
import org.json.JSONObject;

import com.bocclottery.ui.custom.list.MspJsonItem;
import com.bocclottery.vo.DateJson;

/**
 * 所中奖品
 * @author taotao
 * @Date 2014-10-14
 */
public class LiiPrize extends MspJsonItem {

	/*
	 * { "exchangeStatus": 0, "giftTime": { "date": 26, "day": 5, "hours": 15,
	 * "minutes": 53, "month": 8, "nanos": 0, "seconds": 54, "time":
	 * 1411718034000, "timezoneOffset": -480, "year": 114 }, "giftName":
	 * "肯德基电子套餐券", "giftLevel": "欢乐幸运奖", "expressCode": null, "exchangeId":
	 * 160045001 }
	 */
	int exchangeStatus;
	DateJson giftTime;
	String giftName;
	String giftLevel;
	String expressCode;
	long exchangeId;

	@Override
	public void initJackJson(JSONObject job) throws JSONException {
		exchangeStatus = job.optInt("exchangeStatus");
		giftTime = new DateJson(job.optJSONObject("giftTime"));
		giftName = job.optString("giftName");
		giftLevel = job.optString("giftLevel");
		expressCode = job.optString("expressCode");
		exchangeId = job.optLong("exchangeId");

	}

}
