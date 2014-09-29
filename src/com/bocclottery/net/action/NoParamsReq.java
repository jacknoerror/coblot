package com.bocclottery.net.action;

import java.util.Map;

import com.bocclottery.net.NetStrategies;

public abstract class NoParamsReq implements ActionRequestImpl {

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));

	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		return halfway;
	}

}
