package com.bocclottery.net.MemberInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 找回密码接口
 * 
 * @author 作者 gaozhenyu
 */
public class MobileFindPasswordRequest implements ActionRequestImpl {

	String userName;// 用户名
	String password;// 密码
	String validCode;// 验证码

	public MobileFindPasswordRequest(String userName, String password,
			String validCode) {
		super();
		this.userName = userName;
		this.password = password;
		this.validCode = validCode;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_MOBILE_FIND_PASSWORD;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("userName", "" + userName);
		halfway.put("password", "" + password);
		halfway.put("validCode", "" + validCode);
		return halfway;
	}

}
