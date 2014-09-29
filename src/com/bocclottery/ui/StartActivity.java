package com.bocclottery.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.bocclottery.R;
import com.bocclottery.entity.MyEvent;
import com.bocclottery.utils.JackUtils;

import de.greenrobot.event.EventBus;

public class StartActivity extends Activity {
	private Bitmap bm;
	private EventBus default1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		ImageView startImg = new ImageView(this);
		startImg.setImageResource(R.drawable.ic_account);
		startImg.setScaleType(ScaleType.CENTER_CROP);
		bm = JackUtils.getbmFromAssetsFile(getResources(), "start.jpg");
		startImg.setImageBitmap(bm);
		setContentView(startImg);
		
		default1 = EventBus.getDefault();
		default1.register(this);
		default1.post(new MyEvent("dosth"));
	}
	
	public void onEventBackgroundThread(MyEvent event) {
		if(event.equalsMsg("dosth")){
			long starttime = System.currentTimeMillis();
			// do sth XXX
			while(System.currentTimeMillis()-starttime<2000){
				
			}
			default1.post(new MyEvent("end"));
		}
	}
	public void onEventMainThread(MyEvent event) {
		if(event.equalsMsg("end")){
			Intent intent = new Intent();
			intent.setClass(this, HubActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(null!=bm&&!bm.isRecycled()) bm.recycle();
		default1.unregister(this);
	}
}
