package com.bocclottery.net.ActInfoService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * 根据用户ID，信用卡ID等条件查询交易信息
 * 
 * @author 作者 gaozhenyu
 */
public class ExecuteQueryActionRequest implements ActionRequestImpl {

	Integer memberId;// 用户ID
	Integer searchCardId;// 用户卡ID
	Integer searchYear;// 年份
	Integer searchMonth;// 月份
	Integer pageNo;// 第几页

	public ExecuteQueryActionRequest(Integer memberId, Integer searchCardId,
			Integer searchYear, Integer searchMonth, Integer pageNo) {
		super();
		this.memberId = memberId;
		this.searchCardId = searchCardId;
		this.searchYear = searchYear;
		this.searchMonth = searchMonth;
		this.pageNo = pageNo;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_GIFT_ACT_INFO_SERVICE_EXECUTE_QUERY_ACTION;
	}

	@Override
	public String toHttpBody() {
		return NetStrategies.finishTheURL(halfwayParamMap(NetStrategies.getBasicParamMapInstance(getApiName())));
	}

	@Override
	public Map<String, String> halfwayParamMap(Map<String, String> halfway) {
		halfway.put("memberId",""+memberId);
		halfway.put("searchCardId",""+searchCardId);
		halfway.put("searchYear",""+searchYear);
		halfway.put("searchMonth",""+searchMonth);
		halfway.put("pageNo",""+pageNo);
		return halfway;
	}

}
