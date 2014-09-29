package com.bocclottery;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.util.Log;

import com.bocclottery.data.Const;

public class MyApplication extends Application{

	static MyApplication app;
	public static MyApplication app()	{
		return app;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		app = this;
		
		initScreenData();
		
		
	}
	
	private void initScreenData(){
		DisplayMetrics dm = getResources().getDisplayMetrics();
		Const.SCREEN_WIDTH = dm.widthPixels;
		Const.SCREEN_HEIGHT= dm.heightPixels;
		Log.i("yft_app", dm.densityDpi+":dpi+=+desi:"+dm.density);
	}
	
	/**
	 * ��url������id�����·����url����Ҫ��upload/�ֶ�
	 * @param id
	 * @param url
	 * @return
	 */
	/*
	public String getPathUponUrl(int id ,String url){
		final String UPLOAD = "upload/",TITLE = "/jfcj/imgs";
		String path = "";
		if(id>0&&url!=null&&!url.isEmpty()&&url.contains(UPLOAD)){
//			path = TITLE+shopId+url.substring(url.indexOf(UPLOAD)+UPLOAD.length());
			String[] strs = url.substring(url.indexOf(UPLOAD)+UPLOAD.length()).split("/");
			if(strs.length>=3){
				path = String.format("%s/%d/%s/%s/%s", TITLE,id,strs[0],strs[1],strs[strs.length-1]);
			}
		}
		return path;
	}*/
	
	public SharedPreferences getSP(String name){
		return getSharedPreferences(name, Context.MODE_PRIVATE);
	}
}
