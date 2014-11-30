package com.bocclottery.net.GiftInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 获得该用户在该活动下的所有剩余次数
 * @author taotao
 * @Date 2014-10-14
 */
public class GetLeftNumMapRequest implements ActionRequestImpl {
	Integer	memberId	;//用户ID
	Integer	actId	;//活动ID

	public GetLeftNumMapRequest(Integer memberId, Integer actId) {
		super();
		this.memberId = memberId;
		this.actId = actId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_GIFT_INFO_SERVICE_GET_LEFT_NUM_MAP;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId",""+memberId);
		halfway.put("actId",""+actId);
		return halfway;
	}

}
