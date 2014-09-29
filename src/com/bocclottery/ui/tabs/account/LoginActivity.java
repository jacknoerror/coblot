package com.bocclottery.ui.tabs.account;

import com.bocclottery.R;
import com.bocclottery.data.MyData;
import com.bocclottery.ui.JackWindowTitleManager;
import com.bocclottery.ui.MyPortal;
import com.bocclottery.ui.JackWindowTitleManager.JackTitleConst;
import com.bocclottery.vo.MemberInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		JackWindowTitleManager.myWifeChildrenAndHouse(this, R.layout.activity_login, getString(R.string.title_login));
		
		findViewById(R.id.btn_gologin).setOnClickListener(this);
		findViewById(R.id.tv_forgotname).setOnClickListener(this);
		findViewById(R.id.tv_forgotpwd).setOnClickListener(this);
		findViewById(R.id.tv_goregist).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_gologin:
			//TODO
			MemberInfo memberInfo = new MemberInfo();
			MyData.data().setUser(memberInfo );
			finish();
			break;
		case R.id.tv_forgotname:
			MyPortal.justGo(this, FindNameActivity.class);
			break;
		case R.id.tv_forgotpwd:
			MyPortal.justGo(this, FindPasswordActivity.class);
			break;
		case R.id.tv_goregist:
			MyPortal.justGo(this, RegisterActivity.class);
			break;
		default:
			break;
		}
		
	}
}
