package com.bocclottery.net.AddressInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 *  设置默认地址
 * @author 作者 gaozhenyu
 */
public class MobileSetDefaultRequest implements ActionRequestImpl {

	Integer	memberId;//	用户ID
	Integer	addressId;//	地址ID

	
	public MobileSetDefaultRequest(Integer memberId, Integer addressId) {
		super();
		this.memberId = memberId;
		this.addressId = addressId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_ADDRESS_INFO_SERVICE_MOBILE_SET_DEFAULT;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId",""+memberId);
		halfway.put("addressId",""+addressId);
		return halfway;
	}

}
