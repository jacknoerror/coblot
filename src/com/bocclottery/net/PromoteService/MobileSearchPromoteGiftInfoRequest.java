package com.bocclottery.net.PromoteService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/** 获取促销礼券列表
 * @author 作者 gaozhenyu
 */
public class MobileSearchPromoteGiftInfoRequest implements ActionRequestImpl {

	Integer	pageNo	;//页码
	Integer	pageSize	;//大小

	public MobileSearchPromoteGiftInfoRequest(Integer pageNo, Integer pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_PROMOTE_PROMOTE_SERVICE_MOBILE_SEARCH_PROMOTE_GIFT_INFO;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("pageNo",""+pageNo);
		halfway.put("pageSize",""+pageSize);
		return halfway;
	}

}
