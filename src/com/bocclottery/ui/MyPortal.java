package com.bocclottery.ui;

import com.bocclottery.ui.settings.FAQActivity;
import com.bocclottery.ui.settings.SettingActivity;
import com.bocclottery.ui.tabs.account.LoginActivity;

import android.content.Context;
import android.content.Intent;

public class MyPortal {
	@SuppressWarnings("rawtypes")
	public static void justGo(Context context, Class clazz) {
		Intent intent = new Intent();
		intent.setClass(context, clazz);
		context.startActivity(intent);
	}
	public static void goFAQ(Context context){
		justGo(context, FAQActivity.class);
	}
	public static void goSet(Context context){
		justGo(context, SettingActivity.class);
	}
	public static void goLogin(Context context) {
		justGo(context, LoginActivity.class);
		
	}
}
