package com.bocclottery.net.MemberInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * �޸�����
 * 
 * @author ���� gaozhenyu
 */
public class MobileChangePasswordRequest implements ActionRequestImpl {

	Integer memberId;// �û�ID
	String oldPassword;// ԭ����
	String newPassword;// ������

	public MobileChangePasswordRequest(Integer memberId, String oldPassword,
			String newPassword) {
		super();
		this.memberId = memberId;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_MOBILE_CHANGE_PASSWORD;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId", "" + memberId);
		halfway.put("oldPassword", "" + oldPassword);
		halfway.put("newPassword", "" + newPassword);
		return halfway;
	}

}
