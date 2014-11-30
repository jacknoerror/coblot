package com.bocclottery.net.EnrollInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/** 
 * 保存用户报名接口
 * @author 作者 gaozhenyu
 */
public class MobileSaveRequest implements ActionRequestImpl {

	Integer	actId;	//活动ID
	Integer	memberId;	//用户ID
	String	enrollContent;	//报名内容

	public MobileSaveRequest(Integer actId, Integer memberId,
			String enrollContent) {
		super();
		this.actId = actId;
		this.memberId = memberId;
		this.enrollContent = enrollContent;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ENROLL_INFO_SERVICE_MOBILE_SAVE;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("actId",""+actId);
		halfway.put("memberId",""+memberId);
		halfway.put("enrollContent",""+enrollContent);
		return halfway;
	}

}
