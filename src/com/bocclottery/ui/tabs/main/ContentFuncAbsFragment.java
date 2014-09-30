package com.bocclottery.ui.tabs.main;

import com.bocclottery.ui.JackAbsFragment;

public abstract class ContentFuncAbsFragment extends JackAbsFragment {
	
	protected void onSelectedByViewPager() {////0415 seems useless.consider manually launching?
//		Log.i(TAG, "onSelectedByViewPager");
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {//not working 
		// TODO Auto-generated method stub
		super.onHiddenChanged(hidden);
	}
}
