package com.bocclottery.net.MobileMergeService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 用户注册
 * @author taotao
 * @Date 2014-10-14
 */
public class MobileAddMemberNewRequest implements ActionRequestImpl {

	String	userName	;//用户名
	String	password	;//密码
	String	realName	;//真实姓名
	String	userCardNo	;//证件号
	String	currentIp	;//当前Ip
	String	validCode	;//验证码
	Integer	loginType	;//登录类型
	String	inviteCode	;//邀请码

	
	public MobileAddMemberNewRequest(String userName, String password,
			String realName, String userCardNo, String currentIp,
			String validCode, Integer loginType, String inviteCode) {
		super();
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.userCardNo = userCardNo;
		this.currentIp = currentIp;
		this.validCode = validCode;
		this.loginType = loginType;
		this.inviteCode = inviteCode;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_MOBILE_MERGE_SERVICE_MOBILE_ADD_MEMBER_NEW;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("userName",""+userName);
		halfway.put("password",""+password);
		halfway.put("realName",""+realName);
		halfway.put("userCardNo",""+userCardNo);
		halfway.put("currentIp",""+currentIp);
		halfway.put("validCode",""+validCode);
		halfway.put("loginType",""+loginType);
		halfway.put("inviteCode",""+inviteCode);
		return halfway;
	}

}
