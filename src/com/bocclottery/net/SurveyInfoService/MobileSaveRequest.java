package com.bocclottery.net.SurveyInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * ��������ʾ�
 * 
 * @author ���� gaozhenyu
 */
public class MobileSaveRequest implements ActionRequestImpl {

	Integer surveyId;// �����ʾ�ID
	Integer memberId;// �û�ID
	String surveyContent;// ��������
	String currentIp;// ��ǰIP

	public MobileSaveRequest(Integer surveyId, Integer memberId,
			String surveyContent, String currentIp) {
		super();
		this.surveyId = surveyId;
		this.memberId = memberId;
		this.surveyContent = surveyContent;
		this.currentIp = currentIp;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_SURVEY_SURVEY_INFO_SERVICE_MOBILE_SAVE;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("surveyId", "" + surveyId);
		halfway.put("memberId", "" + memberId);
		halfway.put("surveyContent", "" + surveyContent);
		halfway.put("currentIp", "" + currentIp);
		return halfway;
	}

}
