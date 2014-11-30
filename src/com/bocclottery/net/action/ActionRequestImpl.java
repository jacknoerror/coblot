package com.bocclottery.net.action;

import java.util.Map;

import com.bocclottery.data.NetConst;



public interface ActionRequestImpl extends NetConst{
	
	public String getApiName();
	/**
	 * NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())))
	 * @return
	 */
	public String toHttpBody();
	/**
	 * halfway.put("",""+xx);
	 * @param halfway
	 * @return halfway
	 */
	public Map<String, String> halfwayParamMap(Map<String,String> halfway);
}
