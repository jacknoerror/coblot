package com.bocclottery.net.MobileMergeService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * ����齱��������ȡ�齱���������ʣ��ĳ齱����
 * @author taotao
 * @Date 2014-10-14
 */
public class MobileGiftAndGetLeftNumRequest implements ActionRequestImpl {

	Integer	actId	;//�Id
	Integer	memberId	;//�û�Id
	String	currentIp	;//��ǰIP

	
	public MobileGiftAndGetLeftNumRequest(Integer actId, Integer memberId,
			String currentIp) {
		super();
		this.actId = actId;
		this.memberId = memberId;
		this.currentIp = currentIp;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_MOBILE_GIFT_AND_GET_LEFT_NUM;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("actId",""+actId);
		halfway.put("memberId",""+memberId);
		halfway.put("currentIp",""+currentIp);
		return halfway;
	}

}
