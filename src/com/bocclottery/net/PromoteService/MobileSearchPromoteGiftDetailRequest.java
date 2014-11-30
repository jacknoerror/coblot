package com.bocclottery.net.PromoteService;

import java.util.Map;

import com.bocclottery.data.NetConst;
import com.bocclottery.net.NetStrategies;
import com.bocclottery.net.action.ActionRequestImpl;

/**
 * ��ȡ�û��Ĵ�����ȯ�б�
 * 
 * @author ���� gaozhenyu
 */
public class MobileSearchPromoteGiftDetailRequest implements ActionRequestImpl {
	Integer memberId;// �û�ID
	Integer pageNo;// ҳ��
	Integer pageSize;// ��С

	public MobileSearchPromoteGiftDetailRequest(Integer memberId,
			Integer pageNo, Integer pageSize) {
		super();
		this.memberId = memberId;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	@Override
	public String getApiName() {
		return NetConst.APINAME_COM_MOBILE_ZJBOC_CJ_PROMOTE_PROMOTE_SERVICE_MOBILE_SEARCH_PROMOTE_GIFT_DETAIL;
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
