package com.bocclottery.net.action;

import android.content.Context;

public abstract class ActAbsSthRcv implements ActionReceiverImpl {

	Context context;

	public ActAbsSthRcv(Context context) {
		this.context = context;
	}
	
	@Override
	public Context getReceiverContext() {
		return context;
	}
}
