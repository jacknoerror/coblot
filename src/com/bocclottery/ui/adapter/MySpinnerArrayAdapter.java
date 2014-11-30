package com.bocclottery.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.bocclottery.R;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * @author taotao
 *
 */
public class MySpinnerArrayAdapter extends ArrayAdapter<String> {
//	private List<String> jiList;
	List<String> placeList;
	public MySpinnerArrayAdapter(Context context
			, List<String> list) {
		super(context, R.layout.textview_spinner, new ArrayList<String>());
		setDropDownViewResource(android.R.layout.select_dialog_item);
		this.placeList = list;
		for(String p:placeList){
			add(p);
		}
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return placeList.size();
	}


	@Override
	public long getItemId(int arg0) {
		return arg0;
	}
}
