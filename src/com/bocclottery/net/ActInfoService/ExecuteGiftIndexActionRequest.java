package com.bocclottery.net.ActInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 *  �����û�ID�ͻID��ȡ���Ϣ����Ʒ��Ϣ��ʣ��齱����
 * @author ���� gaozhenyu
 */
public class ExecuteGiftIndexActionRequest implements ActionRequestImpl {

	Integer	memberId;//	�û�Id
	Integer	actId;//	�Id
	
	public ExecuteGiftIndexActionRequest(Integer memberId, Integer actId) {
		super();
		this.memberId = memberId;
		this.actId = actId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_EXECUTE_GIFT_INDEX_ACTION;
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
