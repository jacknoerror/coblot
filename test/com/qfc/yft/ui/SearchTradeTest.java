package com.qfc.yft.ui;


import android.content.Intent;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;

import com.bocclottery.data.MyData;
import com.bocclottery.ui.tabs.account.AddressManageActivity;
import com.bocclottery.ui.tabs.account.SearchTradeActivity;
import com.qfc.yft.data.TestConst;

public class SearchTradeTest extends ActivityInstrumentationTestCase2<SearchTradeActivity> {

	public SearchTradeTest(){
		super(SearchTradeActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityIntent(new Intent());
	}
	@Override
	public void setActivityIntent(Intent i) {
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		super.setActivityIntent(i);
	}
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAvailable() {
		assertNotNull(getActivity());
		SystemClock.sleep(1000*60);
	}
	
}
