package com.bocclottery.net.ActInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 *  �����ӿ�
 * @author ���� gaozhenyu
 */
public class ExecuteEnrollActionRequest implements ActionRequestImpl {

	Integer	memberId;//	�û�Id
	Integer	actId;//	�Id
	public ExecuteEnrollActionRequest(Integer memberId, Integer actId) {
		super();
		this.memberId = memberId;
		this.actId = actId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_EXECUTE_ENROLL_ACTION;
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
