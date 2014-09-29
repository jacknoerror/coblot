package com.qfc.yft.ui;


import android.content.Intent;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;

import com.bocclottery.data.MyData;
import com.bocclottery.ui.tabs.account.AddressManageActivity;
import com.qfc.yft.data.TestConst;

public class AddrManaTest extends ActivityInstrumentationTestCase2<AddressManageActivity> {

	public AddrManaTest(){
		super(AddressManageActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityIntent(new Intent());
	}
	@Override
	public void setActivityIntent(Intent i) {
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		i.putExtra(NetConst.EXTRAS_ALBUMFIRSTTYPE, Const.BS_GO_LOCAL);//
//		User user = new User();
//		user.setId(TestConst.userId);
//		user.setShopId(TestConst.compId);
//		MyData.data().setMe(user);
//		MyData.data().setUserCode(TestConst.usercode);
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
