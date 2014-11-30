package com.bocclottery.net.GiftExchangeInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/** 
 * 给用户发送电子礼券短信
 * @author 作者 gaozhenyu
 */
public class MobileSendMessageRequest implements ActionRequestImpl {

	Integer	memberId;	//用户ID
	Integer	exchangeId;	//中奖记录ID

	public MobileSendMessageRequest(Integer memberId, Integer exchangeId) {
		super();
		this.memberId = memberId;
		this.exchangeId = exchangeId;
	}
	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_GIFT_EXCHANGE_INFO_SERVICE_MOBILE_SEND_MESSAGE;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}


	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId",""+memberId);
		halfway.put("exchangeId",""+exchangeId);
		return halfway;
	}

}
