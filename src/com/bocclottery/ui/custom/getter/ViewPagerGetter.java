package com.bocclottery.ui.custom.getter;

import java.util.ArrayList;
import java.util.List;

import com.bocclottery.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;

public class ViewPagerGetter extends JackGetter implements
		ViewPager.OnPageChangeListener {
	private ViewPager mViewPager;
	private ArrayList<ImageView> spotList;

	public ViewPagerGetter(Context context) {
		super(context);
	}

	public final ViewPager getmViewPager() {
		return mViewPager;
	}

	public final ArrayList<ImageView> getSpotList() {
		return spotList;
	}

	/**
	 * 
	 */
	public void init(ViewPager viewPager, LinearLayout spotLayout,
			String[] neatProductImgArray) {
		mViewPager = viewPager;
		List<View> vList = new ArrayList<View>();
		spotList = new ArrayList<ImageView>();
		// LinearLayout spotLayout = spotLayout;
		// final String[] neatProductImgArray = getNeatProductImgArray();//
		for (String s : neatProductImgArray) {// cpProduct.getProductImg()
			ImageView img = new ImageView(mContext);
			// img.setImageDrawable(getResources().getDrawable(R.drawable.load_default));
			img.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
			img.setScaleType(ScaleType.CENTER_CROP);
			// if(!TextUtils.isEmpty(s))JackImageLoader.justSetMeImage(JackUtils.makeItUrl(s),
			// img);
			ImageLoader.getInstance().displayImage(s, img);
			vList.add(img);
			img.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// Intent intent = new Intent();
					// intent.setClass(CurProdActivity.this,
					// ViewpagerActivity.class);
					// intent.putExtra(Const.EXTRAS_SHOWPIC_PATHS,
					// neatProductImgArray);
					// startActivity(intent);
				}
			});
			// spot
			FrameLayout layoutWithImg = new FrameLayout(mContext);
			layoutWithImg.setPadding(5, 5, 5, 5);
			ImageView im = new ImageView(mContext);// (ImageView)LayoutInflater.from(this).inflate(R.layout.image_spot,
													// null);//@drawable/spot_selector
			im.setImageResource(R.drawable.spot_selector_big);
			// im.setImageResource(R.drawable.spot_selector);
			layoutWithImg.addView(im);
			spotLayout.addView(layoutWithImg);
			spotList.add(im);
		}
		setSpotSelected(0);
		if (spotList.size() <= 1)
			spotLayout.setVisibility(View.INVISIBLE);// 只有一个则不显示
		mViewPager.setAdapter(new MyPagerAdapater(vList));
		mViewPager.setOnPageChangeListener(this);
	}

	private void setSpotSelected(int index) {
		if (mViewPager == null || spotList == null || spotList.size() == 0)
			return;
		View viewSelected = (View) mViewPager.getTag();
		if (viewSelected != null) {
			viewSelected.setSelected(false);
		}
		spotList.get(index).setSelected(true);
		spotList.get(index).requestFocus();
		mViewPager.setTag(spotList.get(index));
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// 1.2.0
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int arg0) {
		if (arg0 >= spotList.size() || arg0 < 0 || spotList.size() <= 1)
			return;
		setSpotSelected(arg0);
	}

	public class MyPagerAdapater extends PagerAdapter {
		List<View> viewList;

		public MyPagerAdapater(List<View> viewList) {
			this.viewList = viewList;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getCount() {
			return this.viewList.size();
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(this.viewList.get(position));
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return position + "";
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(this.viewList.get(position));
			return this.viewList.get(position);
		}
	}
}
