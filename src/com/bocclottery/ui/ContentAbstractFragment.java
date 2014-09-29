package com.bocclottery.ui;

import java.util.Random;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TabHost;


public abstract class ContentAbstractFragment extends JackAbsFragment {

	
	private ImageView titleImg;
	private ImageView backBtn;
	private ImageView imgLogo;

	protected void hideSoftKeyboard() {
		InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getActivity().getCurrentFocus()
				.getWindowToken(), InputMethodManager.SHOW_FORCED);
	}

//	protected void setTitleImg(int rid) {
//		if (null == titleImg)
//			titleImg = (ImageView) mView.findViewById(R.id.img_title);
//		if (null != titleImg) {
//			titleImg.setImageResource(rid);
//		}
//	}

//	protected void initBackBtn() {
//		if (null == backBtn)
//			backBtn = (ImageView) mView.findViewById(R.id.btn_title_back);
//		if (null != backBtn) {
//			backBtn.setVisibility(View.VISIBLE);
//			backBtn.setOnClickListener(new View.OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					TabHost th = PLData.data().getTabHost();
//					Log.e(TAG, (th == null) + ":onclick nil");
//					if (null != th) {
//						th.setCurrentTab(0);
//					}
//				}
//			});
//		}
//	}

//	protected void initLogo() {
//		if (null == imgLogo)
//			imgLogo = (ImageView) mView.findViewById(R.id.img_title_logo);
//		if (null != imgLogo) {
//			imgLogo.setVisibility(View.VISIBLE);
//		}
//	}

//	protected CustomAlertDialog ad;
//
//	protected CustomAlertDialog showAlertDialog(Context context, String title,
//			String msg, View.OnClickListener positiveListener,
//			View.OnClickListener negativeListener, String positiveBtnMsg,
//			String negativeBtnMsg, CustomDialogStyle style) {
//		ad = new CustomAlertDialog(context);
//		if (style == null)
//			style = CustomDialogStyle.YELLOW;
//		ad.setStyle(style);
//		if (null != title)
//			ad.setTitle(title);
//		if (null != msg)
//			ad.setMessage(msg);
//		View.OnClickListener defaultListener = CustomAlertDialog
//				.getDefaultOnClickListener(ad);
//		if (null != positiveBtnMsg) {
//			if (null == positiveListener) {
//				positiveListener = defaultListener;
//			}
//			ad.setNegativeButton(R.id.dialog_btn_positive, positiveBtnMsg,
//					positiveListener);
//		}
//		if (null != negativeBtnMsg) {
//			if (null == negativeListener) {
//				negativeListener = defaultListener;
//			}
//			ad.setNegativeButton(R.id.dialog_btn_negative, negativeBtnMsg,
//					negativeListener);
//		}
//		return ad;
//	}

//	protected void showAlertDialog(Context context, String msg) {
//		showAlertDialog(context, null, msg, null, null, "È· ¶¨", null, null);
//	}
}
