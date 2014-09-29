package com.bocclottery.ui.tabs.coupon;

import com.bocclottery.R;
import com.bocclottery.ui.HubActivity;
import com.bocclottery.ui.JackWindowTitleManager;
import com.bocclottery.ui.MyPortal;
import com.bocclottery.ui.JackWindowTitleManager.JackTitleConst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class CouponDetailActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coupondetail);
		
		JackWindowTitleManager jwtMana = new JackWindowTitleManager(this);
		jwtMana.initBackBtn();
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_MIDTEXT, getString(R.string.title_coupondetail));
		jwtMana.initRightCoupleBtns();
		
	}
}
