package com.bocclottery.net.ActInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/** 
 * 获奖活动信息接口
 * @author 作者 gaozhenyu
 */
public class MobileGetRequest implements ActionRequestImpl {

	Integer	actId;//	活动Id
	
	public MobileGetRequest(Integer actId) {
		super();
		this.actId = actId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_MOBILE_GET;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("actId",""+actId);
		return halfway;
	}

}
