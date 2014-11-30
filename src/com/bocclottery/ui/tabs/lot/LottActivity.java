package com.bocclottery.ui.tabs.lot;

import com.bocclottery.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LottActivity extends Activity {
	ImageView egg1,egg2,egg3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lott);
		initViews();
		
	}

	/**
	 * 
	 */
	public void initViews() {
//		LinearLayout mLayout= (LinearLayout) this.findViewById(R.id.layout_inscrl_lott);
		egg1 = (ImageView)this.findViewById(R.id.img_egg1);
		egg2 = (ImageView)this.findViewById(R.id.img_egg2);
		egg3 = (ImageView)this.findViewById(R.id.img_egg3);
		
	}
}
