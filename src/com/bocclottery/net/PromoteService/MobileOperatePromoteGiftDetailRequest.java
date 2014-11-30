package com.bocclottery.net.PromoteService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/** 操作礼券详细信息
 * @author 作者 gaozhenyu
 */
public class MobileOperatePromoteGiftDetailRequest implements ActionRequestImpl {

	Integer	exchangeId;//	明细ID
	Integer	memberId;//	用户ID
	Integer	operateType;//	操作类型0为deteal 1为sendSms

	public MobileOperatePromoteGiftDetailRequest(Integer exchangeId,
			Integer memberId, Integer operateType) {
		super();
		this.exchangeId = exchangeId;
		this.memberId = memberId;
		this.operateType = operateType;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_PROMOTE_PROMOTE_SERVICE_MOBILE_OPERATE_PROMOTE_GIFT_DETAIL;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("exchangeId",""+exchangeId);
		halfway.put("memberId",""+memberId);
		halfway.put("operateType",""+operateType);
		return null;
	}

}
