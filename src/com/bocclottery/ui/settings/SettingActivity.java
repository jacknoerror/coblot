package com.bocclottery.ui.settings;

import com.bocclottery.R;
import com.bocclottery.ui.JackWindowTitleManager;
import com.bocclottery.ui.JackWindowTitleManager.JackTitleConst;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingActivity extends Activity {
	
	private JackWindowTitleManager jwtMana;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_setting);
		jwtMana = new JackWindowTitleManager(this);
		jwtMana.initBackBtn();
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_MIDTEXT, getString(R.string.title_set));
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT1, false);
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT2, false);
		jwtMana.initBackBtn();
		
		((TextView)findViewById(R.id.include_set_1).findViewById(R.id.tv_linkbar)).setText("如何注册");
		((TextView)findViewById(R.id.include_set_2).findViewById(R.id.tv_linkbar)).setText("如何登录");
		((TextView)findViewById(R.id.include_set_3).findViewById(R.id.tv_linkbar)).setText("如何找回用户名及找回密码");
		((TextView)findViewById(R.id.include_set_4).findViewById(R.id.tv_linkbar)).setText("关于我们");
		
	}
	
}
