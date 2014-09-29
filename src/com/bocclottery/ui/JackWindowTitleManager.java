package com.bocclottery.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bocclottery.R;
import com.bocclottery.utils.JackUtils;

/**
 * (1) requestWindowFeature()要在setContentView()之前调用；
 * (2) 设置各种Feature，是具有排它性的，一旦设置，后续不可更改为别的类型；
 * @author taotao
 * @Date 2014-9-15
 */
public class JackWindowTitleManager {
	final String TAG = getClass().getSimpleName();
	
	Activity mActivity;

	public interface JackTitleConst {
		public static final int CUSTOMTITLE_ID_BACK = R.id.title_leftimg;
		public static final int CUSTOMTITLE_ID_RIGHT1 = R.id.title_rightimg1;
		public static final int CUSTOMTITLE_ID_RIGHT2 = R.id.title_rightimg2;
		public static final int CUSTOMTITLE_ID_MIDTEXT = R.id.title_midtext;
	}

	private ActionBar actionBar;


	public JackWindowTitleManager(Activity mActivity) {
		super();
		this.mActivity = mActivity;
		if(null==mActivity)return;
		actionBar = mActivity.getActionBar();
		actionBar.setCustomView(R.layout.layout_title);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
	}

	public void initBackBtn(){
		setComponent(R.id.title_leftimg, R.drawable.btn_back);
		setComponent(R.id.title_leftimg, true);
		setComponent(R.id.title_leftimg, new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(null!=mActivity){
					mActivity.finish();
				}
				
			}
		});
	}
	public void initRightCoupleBtns(){
		View.OnClickListener listener = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case JackTitleConst.CUSTOMTITLE_ID_RIGHT1:
					MyPortal.goSet(mActivity);
					break;
				case JackTitleConst.CUSTOMTITLE_ID_RIGHT2:
					MyPortal.goFAQ(mActivity);
					break;

				default:
					break;
				}
			}
		};
		setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT1, listener);
		setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT2, listener);
	}
	
	/**
	 * TODO
	 * 分类？工厂？封装?
	 */
	
	/**
	 * 
	 */
	public void setComponent(int id, boolean show){
		try{
			actionBar.getCustomView().findViewById(id).setVisibility(show?View.VISIBLE:View.INVISIBLE);
		}catch(Exception e){
			Log.e(TAG, "titleView exception");
		}
	}
	public void setComponent(int id, String text){
		try{
			TextView tv = (TextView)actionBar.getCustomView().findViewById(id);
			tv.setText(text);
		}catch(Exception e){
			Log.e(TAG, "titleView exception");
		}
	}
	
	public void setComponent(int id,View.OnClickListener listener) {
		try{
			View view = actionBar.getCustomView().findViewById(id);
			view.setOnClickListener(listener);
			if(null!=listener) view.setVisibility(View.VISIBLE);
		}catch(Exception e){
			Log.e(TAG, "titleView exception");
		}
	}
	public void setComponent(int id, int resId) {
		try{
			ImageView img = (ImageView) actionBar.getCustomView().findViewById(id);
			img.setImageResource(resId);
			if(resId>0) img.setVisibility(View.VISIBLE);
		}catch(Exception e){
			Log.e(TAG, "titleView exception");
		}
	}

	public void addRight(View view){
		try{
			ViewGroup vg = (ViewGroup) actionBar.getCustomView().findViewById(R.id.layout_title_right);
			vg.addView(view);
		}catch(Exception e){
			Log.e(TAG, "titleView exception");
		}
	}
	
	/**
	 * 一个带标题Activity的快捷生成方式
	 * @param activity
	 * @param layoutId
	 * @param title
	 * @return
	 */
	public static JackWindowTitleManager myWifeChildrenAndHouse(Activity activity, int layoutId,String title){
		if(null==activity) return null;
		activity.setContentView(layoutId);
		
		JackWindowTitleManager jwtMana = new JackWindowTitleManager(activity);
		jwtMana.initBackBtn();
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_MIDTEXT, title);
		
		return jwtMana;
	}
	/**
	 * 返回标题中的默认按钮
	 * @return
	 * @throws NotFoundException
	 */
	public static Button getCommonBtn(Context context,String text) throws NotFoundException {
		Button tBtn = new Button(context);
		tBtn.setBackgroundResource(R.drawable.btn_yellow);
		tBtn.setTextColor(context.getResources().getColor(android.R.color.black));
		tBtn.setText(text);
		tBtn.setPadding(0, 0, 0, 0);
		tBtn.setTextSize( TypedValue.COMPLEX_UNIT_SP,12);
		LayoutParams params = new LayoutParams(JackUtils.dip2px(context, 52), JackUtils.dip2px(context, 26));
		tBtn.setLayoutParams(params );
		return tBtn;
	}
	
//	protected View getTitleView(){
//		return ((ViewGroup)mActivity.getWindow().
//				  findViewById(android.R.id.title_container));
//	}
}
