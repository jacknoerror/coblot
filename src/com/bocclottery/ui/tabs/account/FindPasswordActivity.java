package com.bocclottery.ui.tabs.account;

import com.bocclottery.R;
import com.bocclottery.ui.JackWindowTitleManager;
import com.bocclottery.ui.JackWindowTitleManager.JackTitleConst;

import android.app.Activity;
import android.os.Bundle;

public class FindPasswordActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		JackWindowTitleManager.myWifeChildrenAndHouse(this, R.layout.activity_findpwd, getString(R.string.title_findpwd));
	}
}
