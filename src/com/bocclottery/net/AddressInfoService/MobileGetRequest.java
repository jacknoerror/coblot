package com.bocclottery.net.AddressInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/** 获取地址信息
 * @author 作者 gaozhenyu
 */
public class MobileGetRequest implements ActionRequestImpl {

	Integer	memberId;	//用户ID
	Integer	addressId;	//地址ID

	public MobileGetRequest(Integer memberId, Integer addressId) {
		super();
		this.memberId = memberId;
		this.addressId = addressId;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_MEMBER_ADDRESS_INFO_SERVICE_MOBILE_GET;
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
