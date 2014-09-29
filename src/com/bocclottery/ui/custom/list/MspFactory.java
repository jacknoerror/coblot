package com.bocclottery.ui.custom.list;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.bocclottery.net.action.ActionRequestImpl;
import com.bocclottery.ui.custom.list.MyJackListView.OnGetPageListener;

public class MspFactory implements MspFactoryImpl {

	ListItemImpl.Type type;

	public MspFactory(ListItemImpl.Type type) {
		this.type = type;
	}

	@Override
	public MspAdapter getNewAdapter() {
		MspAdapter adapter = null;
		switch (type) {
		case ALBUM:
			break;
		default:
			break;
		}
		return adapter;
	}

	@Override
	public MspPage getMspPage(JSONObject job) {
		if (job == null)
			return null;
		MspPage mp = new MspPage(this);
		try {
			mp.initJackJson(job);
		} catch (JSONException e) {
			Log.e("MspFactory", "msppage initjson error");
		}
		return mp;
	}

	/*
	 * set if have pages
	 */
	@Override
	public MspJsonItem getMjiInstance() {
		MspJsonItem mji = null;
		switch (type) {
		case ALBUM:
//			mji = new Album();
			break;
		default:
			break;
		}
		return mji;
	}

	/*
	 * set if have pages
	 * 
	 */
	@Override
	public OnGetPageListener getDefaultOnPageChangeListener() {
		OnGetPageListener listener = null;
		switch (type) {
		case ALBUM:
		case IP_PRODUCT_MY:
		case IP_COMPANY_MY:
		case IP_PEOPLE_MY:
		case IP_COMPANY_RECOMMEND:
			listener = new MspDefaultOnGetPageListener();
			break;
		// // already add , test it
		// break;
		default:
			break;
		}
		return listener;
	}
	
	class MspDefaultOnGetPageListener implements OnGetPageListener{

		@Override
		public void page(MyJackListView qListView, int pageNo) {
//			User me = MyData.data().getMe();
			ActionRequestImpl req = null;
			switch (type) {
				case IP_COMPANY_RECOMMEND:
//					if(null==me) return;
//					req = new SearchShopForIphoneReq(null, Const.DEFAULT_PAGESIZE, pageNo);
//					ActionBuilder.getInstance().request(req, qListView);
					break;
				default:
					break;
			}
//					 TestDataTracker.simulateConnection(qListView,req.getApiName());// delete me
			
		}
		
		
	}

}
