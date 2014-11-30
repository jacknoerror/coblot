package com.bocclottery.net.AddressInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * �����ַ
 * 
 * @author ���� gaozhenyu
 */
public class MobileSaveRequest implements ActionRequestImpl {

	Integer addressId; // ��ַID
	Integer memberId; // �û�ID
	String address; // ��ַ
	String phone; // �绰
	String zipcode; // �ʱ�
	String contact; // �ջ���
	Integer defaultSign; // Ĭ�ϱ��

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
