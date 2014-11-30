package com.bocclottery.net.ActInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/** 
 * 获取调查问卷信息
 * @author 作者 gaozhenyu
 */
public class ExecuteSurveyInfoActionRequest implements ActionRequestImpl {
	
	Integer	memberId;	//用户ID
	Integer	surveyId;	//调查问卷ID

	public ExecuteSurveyInfoActionRequest(Integer memberId, Integer surveyId) {
		super();
		this.memberId = memberId;
		this.surveyId = surveyId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_EXECUTE_SURVEY_INFO_ACTION;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId",""+memberId);
		halfway.put("surveyId",""+surveyId);
		return halfway;
	}

}
