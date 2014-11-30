package com.bocclottery.net.MemberInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 注册或找回密码发送短信接口
 * 短信类型0 注册时发送 1 找回密码时发送2找回用户名
 * @author 作者 gaozhenyu
 */
public class MobileSendSmsRequest implements ActionRequestImpl {
	public static final int SMS_TYPE_REG = 0;
	public static final int SMS_TYPE_FDP = 1;
	public static final int SMS_TYPE_FDU = 2;

	String userName;// 用户名
	String userCardNo;// 身份证号
	String realName;// 真实姓名
	Integer smsType;// 短信类型0 注册时发送 1 找回密码时发送2找回用户名

	public MobileSendSmsRequest(String userName, String userCardNo,
			String realName, Integer smsType) {
		super();
		this.userName = userName;
		this.userCardNo = userCardNo;
		this.realName = realName;
		this.smsType = smsType;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_MEMBER_INFO_SERVICE_MOBILE_SEND_SMS;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("userName", "" + userName);
		halfway.put("userCardNo", "" + userCardNo);
		halfway.put("realName", "" + realName);
		halfway.put("smsType", "" + smsType);
		return halfway;
	}

}
