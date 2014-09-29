package com.bocclottery.ui.tabs.account;

import java.util.ArrayList;
import java.util.List;

import com.bocclottery.R;
import com.bocclottery.ui.JackWindowTitleManager;
import com.bocclottery.ui.JackWindowTitleManager.JackTitleConst;
import com.bocclottery.ui.adapter.MySpinnerArrayAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class SearchTradeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchtrade);
		JackWindowTitleManager jwtMana = new JackWindowTitleManager(this);
		jwtMana.initBackBtn();
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_MIDTEXT, getString(R.string.title_searchtrade));
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT1, R.drawable.shape_btn_cyan);
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT1, new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner_st1);
		Spinner spinner2 = (Spinner) findViewById(R.id.spinner_st2);
		Spinner spinner3 = (Spinner) findViewById(R.id.spinner_st3);
		List<String> list1=new ArrayList<String>();
		List<String> list2=new ArrayList<String>();
		List<String> list3=new ArrayList<String>();
		list1.add("2014Äê");
		list1.add("test2");
		list1.add("test3");
		list1.add("test4");
		list2.add("list2");
		list2.add("8ÔÂ");
		list2.add("list23");
		list2.add("list24");
		list3.add("list3");
		list3.add("list32");
		list3.add("6225768709991192");
		list3.add("list34");
		spinner1.setAdapter( new MySpinnerArrayAdapter(this, list1));
		spinner2.setAdapter(new MySpinnerArrayAdapter(this, list2));
		spinner3.setAdapter(new MySpinnerArrayAdapter(this, list3));
		setEli(spinner1);
		setEli(spinner2);
		setEli(spinner3);
		
	}

	/**
	 * @param spinner1
	 */
	public void setEli(Spinner spinner1) {
		try{
			TextView textview = (TextView) spinner1.findViewById(android.R.id.text1);
			textview.setEllipsize(TruncateAt.START);
		}catch(Exception e){
			e.printStackTrace();
		};
	}
}
