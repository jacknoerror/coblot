package com.bocclottery.net.MemberInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 用户消耗幸运奖换取奖品
 * 
 * @author 作者 gaozhenyu
 */
public class AddExchangeGiftRequest implements ActionRequestImpl {
	Integer actId;// 活动Id
	Integer memberId;// 用户ID

	public AddExchangeGiftRequest(Integer actId, Integer memberId) {
		super();
		this.actId = actId;
		this.memberId = memberId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_ADD_EXCHANGE_GIFT;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("actId", "" + actId);
		halfway.put("memberId", "" + memberId);
		return halfway;
	}

}
