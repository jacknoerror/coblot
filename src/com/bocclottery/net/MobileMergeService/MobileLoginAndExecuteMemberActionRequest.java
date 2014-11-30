package com.bocclottery.net.MobileMergeService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 登录接口
 * @author taotao
 * @Date 2014-10-14
 */
public class MobileLoginAndExecuteMemberActionRequest implements
		ActionRequestImpl {
	
	String	userName;//	用户名
	String	password	;//密码
	String	currentIp	;//当前Ip
	Integer	loginType	;//登录类型

	
	public MobileLoginAndExecuteMemberActionRequest(String userName,
			String password, String currentIp, Integer loginType) {
		super();
		this.userName = userName;
		this.password = password;
		this.currentIp = currentIp;
		this.loginType = loginType;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_MOBILE_LOGIN_AND_EXECUTE_MEMBER_ACTION
;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("userName",""+userName);
		halfway.put("password",""+password);
		halfway.put("currentIp",""+currentIp);
		halfway.put("loginType",""+loginType);
		return halfway;
	}

}
