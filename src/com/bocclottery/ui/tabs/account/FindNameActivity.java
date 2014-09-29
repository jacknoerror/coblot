package com.bocclottery.ui.tabs.account;

import com.bocclottery.R;
import com.bocclottery.ui.JackWindowTitleManager;

import android.app.Activity;
import android.os.Bundle;

public class FindNameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		JackWindowTitleManager.myWifeChildrenAndHouse(this,R.layout.activity_findname, getString(R.string.title_findname));
		
	}
	
}
