package com.bocclottery.ui;




import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;

import com.bocclottery.R;
import com.bocclottery.ui.JackWindowTitleManager.JackTitleConst;
import com.bocclottery.ui.common.JackFragmentTabChangedHelper;
import com.bocclottery.ui.tabs.account.TabFragAcct;
import com.bocclottery.ui.tabs.coupon.TabFragCoup;
import com.bocclottery.ui.tabs.lot.TabFragLott;
import com.bocclottery.ui.tabs.main.TabFragMain;
import com.bocclottery.utils.JackUtils;

public class HubActivity extends FragmentActivity implements OnTabChangeListener{
	final String TAG = HubActivity.class.getSimpleName();
	final int[]	ICONS = new int[]{
			R.drawable.selector_hubtab0,
			R.drawable.selector_hubtab1,
			R.drawable.selector_hubtab2,
			R.drawable.selector_hubtab3
	};
	final String[] TITLES = new String[]{"首页","抽奖","礼券","账户"
							};
	@SuppressWarnings("rawtypes")
	final Class[] CLAZZZ=new Class[]{
			TabFragMain.class,
			TabFragLott.class,
			TabFragCoup.class,
			TabFragAcct.class,
		};
	
	private TabHost mTabHost;
	
	JackFragmentTabChangedHelper jftcl;
	private JackWindowTitleManager jwtMana;
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
				
				JackUtils.showDialog(this, "确定要退出程序么？", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						/*HubActivity.this.finish();
						dialog.dismiss();
						mTabHost =null;//
						PLData.data().destroy();*///TODO
						finish();
					}
				});
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	@Override
	protected void onResume() {
		super.onResume();
	}
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
//		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.a_hub); 
//		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.layout_title);
		
		jwtMana = new JackWindowTitleManager(this);
		View.OnClickListener listener = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case JackTitleConst.CUSTOMTITLE_ID_RIGHT1:
					MyPortal.goSet(HubActivity.this);
					break;
				case JackTitleConst.CUSTOMTITLE_ID_RIGHT2:
					MyPortal.goFAQ(HubActivity.this);
					break;

				default:
					break;
				}
			}
		};
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT1, listener );
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT2, listener );
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_BACK, false);
		
		jftcl = new JackFragmentTabChangedHelper(this, R.id.realtabcontent);
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		for(int i=0;i<CLAZZZ.length;i++){
			jftcl.addTabPack(jftcl.new TabPack(ICONS[i], getTitle(i), CLAZZZ[i]));
		}
		mTabHost.setOnTabChangedListener(this);
		mTabHost.setup( );
		for(int i=0;i<CLAZZZ.length;i++){
			addTabBtn(i);
		}
		mTabHost.setCurrentTab(0);
		
//		mTabHost.getTabWidget().getChildAt(0).setVisibility(View.GONE);//
		
//		PLData.data().setTabHost(mTabHost);//TODO
	}
	
	private void addTabBtn(int index){
		if(index>=ICONS.length) return;
		View view = LayoutInflater.from(this).inflate(R.layout.layout_tab, null);
		ImageView img = (ImageView)view.findViewById(R.id.img_tab);
		img.setImageResource(ICONS[index]);
		TextView tv = (TextView)view.findViewById(R.id.tv_tab);
		
		String title=getTitle(index);
		tv.setTextColor(getResources().getColorStateList(R.color.selector_tab_textcolor));
		tv.setText(title);
		mTabHost.addTab(
				mTabHost.newTabSpec(title)
    			.setIndicator(view)
//    			.setIndicator("",getResources().getDrawable(ICONS[index]))
    			.setContent(new DummiContiFac(getBaseContext())));
		
	}
	
	private String getTitle(int index){
		if(index>=ICONS.length) return "noTitle";
//		return "title"+ICONS[index];
		return TITLES[index];
	}
	
	public class DummiContiFac implements TabContentFactory{
    	Context dcContext;
    	public DummiContiFac(Context context){
    		dcContext = context;
    	}

		@Override
		public View createTabContent(String tag) {
			return new View(dcContext);
		}
    	
    }
	

	@Override
	public void onTabChanged(String tabId) {
		if(null!=jftcl) jftcl.onTabChanged(tabId);
		if(null!=jwtMana){
			jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_MIDTEXT, tabId);
//			getActionBar().setTitle(tabId);
		}
	}
	
	
}
