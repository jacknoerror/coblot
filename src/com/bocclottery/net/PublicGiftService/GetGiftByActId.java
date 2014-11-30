package com.bocclottery.net.PublicGiftService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 获取该活动奖品信息
 * 
 * @author taotao
 * @Date 2014-10-13
 */
public class GetGiftByActId implements ActionRequestImpl {

	Integer actId;// 活动ID

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_PUBLIC_GIFT_SERVICE_GET_GIFT_BY_ACT_ID;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("actId", "" + actId);
		return halfway;
	}

}
