package com.bocclottery.ui.tabs.main;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.bocclottery.R;
import com.bocclottery.ui.ContentAbstractFragment;

public class TabFragMain extends ContentAbstractFragment {

	@Override
	public int getLayoutRid() {
		return R.layout.fragment_tabs_main;
	}

	@Override
	public void initView() {
		
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		// TODO Auto-generated method stub
		if(!hidden){
			Log.i("NOW", "main onHiddenChanged");
		}
		super.onHiddenChanged(hidden);
	}
}
