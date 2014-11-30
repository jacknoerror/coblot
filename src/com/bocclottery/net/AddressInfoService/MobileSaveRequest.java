package com.bocclottery.net.AddressInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 保存地址
 * 
 * @author 作者 gaozhenyu
 */
public class MobileSaveRequest implements ActionRequestImpl {

	Integer addressId; // 地址ID
	Integer memberId; // 用户ID
	String address; // 地址
	String phone; // 电话
	String zipcode; // 邮编
	String contact; // 收货人
	Integer defaultSign; // 默认标记

	public MobileSaveRequest(Integer addressId, Integer memberId,
			String address, String phone, String zipcode, String contact,
			Integer defaultSign) {
		super();
		this.addressId = addressId;
		this.memberId = memberId;
		this.address = address;
		this.phone = phone;
		this.zipcode = zipcode;
		this.contact = contact;
		this.defaultSign = defaultSign;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_ADDRESS_INFO_SERVICE_MOBILE_SAVE;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("addressId", "" + addressId);
		halfway.put("memberId", "" + memberId);
		halfway.put("address", "" + address);
		halfway.put("phone", "" + phone);
		halfway.put("zipcode", "" + zipcode);
		halfway.put("contact", "" + contact);
		halfway.put("defaultSign", "" + defaultSign);
		return halfway;
	}

}
