package com.bocclottery.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class JackAbsFragment extends Fragment {
	protected final String TAG 	 = getClass().getSimpleName();
	
	protected LayoutInflater mInflator;
	protected View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mInflator= inflater;
//		if(!inflate()) return null;
		inflate(container);//如果是0,也别停 0404
		initView( );
		return mView;
	}

	private boolean inflate(ViewGroup container){
		int rid = getLayoutRid();
		if(rid>0){
			mView =  mInflator.inflate(getLayoutRid(), container,false);
		}
		return rid>0;
	}
	
	/**
	 * 
	 * @return 界面资源的id。如果不需要配置，必须在initView中对mView初始化。
	 */
	public abstract int getLayoutRid() ;

	/**
	 */
	public abstract void initView() ;
}
