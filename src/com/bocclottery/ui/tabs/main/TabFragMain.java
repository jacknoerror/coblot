package com.bocclottery.ui.tabs.main;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bocclottery.R;
import com.bocclottery.data.Const;
import com.bocclottery.ui.ContentAbstractFragment;
import com.bocclottery.ui.adapter.MyFragmentPagerAdapter;
import com.bocclottery.ui.custom.getter.ViewPagerGetter;

public class TabFragMain extends ContentAbstractFragment implements OnClickListener, OnPageChangeListener {

	

	private static final int START_BTNID = 0x100;
	private ViewPagerGetter vpg;
	private RadioGroup mRadioGroup;
	private ViewPager mViewPager;
	private MyFragmentPagerAdapter mAdapter;
	private ImageView chosenRed;
	private float lastPos;
	private final int ANIMATION_DURATION = 300;

	@Override
	public int getLayoutRid() {
		return R.layout.fragment_tabs_main;
	}

	@Override
	public void initView() {
		
		
		vpg = new ViewPagerGetter(getActivity());
		String[] neatProductImgArray = new String[]{"http://img.qfc.cn/upload/01/galary/40/61/1104108.png","http://img.qfc.cn/upload/01/galary/90/56/1104192.jpg","http://img.qfc.cn/upload/01/galary/c6/be/1104369.jpg"};
		vpg.init((ViewPager)mView.findViewById(R.id.viewpager_main), (LinearLayout) mView.findViewById(R.id.layout_spots_main), neatProductImgArray);
		
		initSubTabs(new int[]{R.id.btn_user_rec,R.id.btn_user_prz,R.id.btn_user_rol});
		
		GestureDetector gd = new GestureDetector(getActivity(),new GestureDetector.OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				// TODO Auto-generated method stub
				Log.i(TAG, "onSingleTapUp");
				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent e) {
				// TODO Auto-generated method stub
				Log.i(TAG, "onShowPress");
			}
			
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
					float distanceY) {
				// TODO Auto-generated method stub
				Log.i(TAG, "onScroll");
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent e) {
				// TODO Auto-generated method stub
				Log.i(TAG, "onLongPress");
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
					float velocityY) {
				// TODO Auto-generated method stub
				Log.i(TAG, "onFling");
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent e) {
				// TODO Auto-generated method stub
				Log.i(TAG, "onDown");
				return false;
			}
		});
	}
	/**
	 * @param RADIOID 
	 * 
	 */
	private void initSubTabs(int[] RADIOID) {
		mRadioGroup = (RadioGroup) mView
				.findViewById(R.id.radiogroup_usercenter);
		int radio_count = RADIOID.length;
		mRadioBtns = new RadioButton[radio_count];
		for (int i = 0; i < radio_count; i++) {
			mRadioBtns[i] = (RadioButton) mView.findViewById(RADIOID[i]);
			mRadioBtns[i].setId(START_BTNID + i);
			mRadioBtns[i].setOnClickListener(this);
		}

		mViewPager = (ViewPager) mView.findViewById(R.id.viewpager_user);
		FragmentManager fm = getActivity().getSupportFragmentManager();
		List<ContentFuncAbsFragment> fragments = new ArrayList<ContentFuncAbsFragment>();
		fragments.add(new FuncPrizFrag());
		fragments.add(new FuncRecoFrag());
		fragments.add(new FuncRollFrag());
		mAdapter = new MyFragmentPagerAdapter(fm, fragments);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);
		mViewPager.setCurrentItem(0);// Ä¬ÈÏ¡£onpageselected

		chosenRed = (ImageView) mView.findViewById(R.id.img_user_red);
		FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)chosenRed.getLayoutParams();
		params.width=(int) (Const.SCREEN_WIDTH/3);
		//		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) (Const.SCREEN_WIDTH/3), 3);
		params.gravity = Gravity.BOTTOM;
		chosenRed.setLayoutParams(params);
		
		setSelect(0);
	}
	
	private final float[] POSITIONS = new float[] { Const.SCREEN_WIDTH / 3 * 0,
			Const.SCREEN_WIDTH / 3 * 1, Const.SCREEN_WIDTH / 3 * 2  };
	private RadioButton[] mRadioBtns;
	private void setSelect(int index) {
		float fromPos = lastPos, toPos = POSITIONS[index];
		Animation animation = new TranslateAnimation(fromPos, toPos, 0, 0);
		animation.setFillAfter(true);
		animation.setDuration(ANIMATION_DURATION);
		animation.setInterpolator(new DecelerateInterpolator());
		chosenRed.setAnimation(animation);
		chosenRed.startAnimation(animation);
		lastPos = toPos;

		if (null != mAdapter)
			mAdapter.getItem(index).onSelectedByViewPager();
		
		/*RadioButton selectingRB = mRadioBtns[index];
		if(null!=selectedRB) selectedRB.setSelected(false);
		selectedRB = selectingRB;
		selectedRB.setSelected(true);*/
		mRadioGroup.check(START_BTNID+index);
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

	@Override
	public void onClick(View v) {
		int index = v.getId() - START_BTNID;
		mViewPager.setCurrentItem(index, false);

		setSelect(index);
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int arg0) {
		setSelect(arg0);
	}
}
