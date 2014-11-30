package com.bocclottery.net.MobileMergeService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 *�����û�ID��ѯ���е����˽������Ͳ�ѯ�н����� 
 * @author taotao
 * @Date 2014-10-14
 */
public class MobileGetParticipateSizeAndExchangeSizeRequest implements
		ActionRequestImpl {
	Integer	memberId	;//�û�Id

	public MobileGetParticipateSizeAndExchangeSizeRequest(Integer memberId) {
		super();
		this.memberId = memberId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_MOBILE_GET_PARTICIPATE_SIZE_AND_EXCHANGE_SIZE;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName(),2)));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId",""+memberId);
		return halfway;
	}

}
