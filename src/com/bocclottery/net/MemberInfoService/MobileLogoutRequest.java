package com.bocclottery.net.MemberInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * �ǳ��ӿ�
 * 
 * @author ���� gaozhenyu
 */
public class MobileLogoutRequest implements ActionRequestImpl {

	Integer memberId;// �û�ID
	Long loginId;// ��¼ID
	Integer loginType;// ��¼����:(0:PC, 1:Android,2:apple)

	public MobileLogoutRequest(Integer memberId, Long loginId, Integer loginType) {
		super();
		this.memberId = memberId;
		this.loginId = loginId;
		this.loginType = loginType;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_MOBILE_LOGOUT;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId", "" + memberId);
		halfway.put("loginId", "" + loginId);
		halfway.put("loginType", "" + loginType);
		return halfway;
	}

}
