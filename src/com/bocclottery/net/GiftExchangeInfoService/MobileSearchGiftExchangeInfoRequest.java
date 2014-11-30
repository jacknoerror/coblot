package com.bocclottery.net.GiftExchangeInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 查找用户中奖记录
 * 
 * @author 作者 gaozhenyu
 */
public class MobileSearchGiftExchangeInfoRequest implements ActionRequestImpl {

	Integer memberId;// 用户Id
	Integer pageNo;// 页码
	Integer pageSize;// 页面大小

	public MobileSearchGiftExchangeInfoRequest(Integer memberId,
			Integer pageNo, Integer pageSize) {
		super();
		this.memberId = memberId;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_GIFT_EXCHANGE_INFO_SERVICE_MOBILE_SEARCH_GIFT_EXCHANGE_INFO;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies
				.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId", "" + memberId);
		halfway.put("pageNo", "" + pageNo);
		halfway.put("pageSize", "" + pageSize);
		return halfway;
	}
}
