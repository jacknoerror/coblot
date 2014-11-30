package com.bocclottery.net.SurveyInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * ��ȡ�����ʾ���Ϣ
 * 
 * @author ���� gaozhenyu
 */
public class MobileGetRequest implements ActionRequestImpl {
	Integer surveyId;// �����ʾ�ID

	public MobileGetRequest(Integer surveyId) {
		super();
		this.surveyId = surveyId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_SURVEY_SURVEY_INFO_SERVICE_MOBILE_GET;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("surveyId", "" + surveyId);
		return halfway;
	}

}
