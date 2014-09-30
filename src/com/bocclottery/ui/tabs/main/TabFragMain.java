package com.bocclottery.ui.tabs.main;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bocclottery.R;
import com.bocclottery.data.Const;
import com.bocclottery.ui.ContentAbstractFragment;
import com.bocclottery.ui.custom.getter.ViewPagerGetter;

public class TabFragMain extends ContentAbstractFragment {

	

	private ViewPagerGetter vpg;

	@Override
	public int getLayoutRid() {
		return R.layout.fragment_tabs_main;
	}

	@Override
	public void initView() {
		
		
		vpg = new ViewPagerGetter(getActivity());
		String[] neatProductImgArray = new String[]{"http://img.qfc.cn/upload/01/galary/40/61/1104108.png","http://img.qfc.cn/upload/01/galary/90/56/1104192.jpg","http://img.qfc.cn/upload/01/galary/c6/be/1104369.jpg"};
		vpg.init((ViewPager)mView.findViewById(R.id.viewpager_main), (LinearLayout) mView.findViewById(R.id.layout_spots_main), neatProductImgArray);
		
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
