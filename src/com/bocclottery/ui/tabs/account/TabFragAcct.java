package com.bocclottery.ui.tabs.account;

import android.view.View;
import android.widget.TextView;

import com.bocclottery.R;
import com.bocclottery.data.MyData;
import com.bocclottery.ui.ContentAbstractFragment;
import com.bocclottery.ui.MyPortal;
import com.bocclottery.vo.MemberInfo;

public class TabFragAcct extends ContentAbstractFragment implements View.OnClickListener{

	private MemberInfo me;

	@Override
	public int getLayoutRid() {
		return R.layout.fragment_tabs_account;
	}

	@Override
	public void initView() {
		me = MyData.data().getMe();
		if(null==me){
			MyPortal.goLogin(getActivity());
		}
		
		
	}
	@Override
	public void onResume() {
		super.onResume();
		if(null==me){
			refreshUserStatus();
		}
	}

	private void refreshUserStatus() {
		// TODO Auto-generated method stub
		View bar1 = mView.findViewById(R.id.include_acct_1);
		View bar2 = mView.findViewById(R.id.include_acct_2);
		View bar3 = mView.findViewById(R.id.include_acct_3);
		View bar4 = mView.findViewById(R.id.include_acct_4);
		View bar5 = mView.findViewById(R.id.include_acct_5);
		View bar6 = mView.findViewById(R.id.include_acct_6);
		((TextView) bar1.findViewById(R.id.tv_linkbar)).setText("中奖查询");
		((TextView) bar2.findViewById(R.id.tv_linkbar)).setText("交易查询");
		((TextView) bar3.findViewById(R.id.tv_linkbar)).setText("我的百宝箱");
		((TextView) bar4.findViewById(R.id.tv_linkbar)).setText("地址管理");
		((TextView) bar5.findViewById(R.id.tv_linkbar)).setText("修改密码");
		((TextView) bar6.findViewById(R.id.tv_linkbar)).setText("退出账户");
		bar1.setOnClickListener(this);
		bar2.setOnClickListener(this);
		bar3.setOnClickListener(this);
		bar4.setOnClickListener(this);
		bar5.setOnClickListener(this);
		bar6.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.include_acct_1:
			
			break;
		case R.id.include_acct_2:
			MyPortal.justGo(getActivity(), SearchTradeActivity.class);
			break;
		case R.id.include_acct_3:
			
			break;
		case R.id.include_acct_4:
			
			break;
		case R.id.include_acct_5:
			
			break;
		case R.id.include_acct_6:
			
			break;

		default:
			break;
		}
		
	}

}
