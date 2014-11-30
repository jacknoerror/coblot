package com.bocclottery.net.MobileMergeService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 获取用户信息
 * @author taotao
 * @Date 2014-10-14
 */
public class MobileGetMemberNewRequest implements ActionRequestImpl {

	Integer	memberId	;//用户Id
	String	currentIp	;//当前Ip

	
	public MobileGetMemberNewRequest(Integer memberId, String currentIp) {
		super();
		this.memberId = memberId;
		this.currentIp = currentIp;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_MOBILE_GET_MEMBER_NEW;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId",""+memberId);
		halfway.put("currentIp",""+currentIp);
		return halfway;
	}

}
