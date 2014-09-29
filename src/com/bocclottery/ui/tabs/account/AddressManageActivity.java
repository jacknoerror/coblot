package com.bocclottery.ui.tabs.account;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bocclottery.R;
import com.bocclottery.ui.JackWindowTitleManager;

public class AddressManageActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		JackWindowTitleManager jwtMana = JackWindowTitleManager.myWifeChildrenAndHouse(this, R.layout.activity_addrmanage, getString(R.string.title_addrmana));
		Button tBtn = JackWindowTitleManager.getCommonBtn(this,"±£ ´æ");
		tBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		jwtMana.addRight(tBtn);
	}

	
	
}
