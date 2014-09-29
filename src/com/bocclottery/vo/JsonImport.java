package com.bocclottery.vo;

import org.json.JSONObject;

import com.bocclottery.ui.custom.list.ListItemImpl;

/**
 * 不需要形成JsonObj的JackJson 给予默认方法
 * @author taotao
 *
 */
public abstract class JsonImport extends JackJson implements ListItemImpl {

	JSONObject jliJob;
	
	public JsonImport(){
	}
	public JsonImport(JSONObject job){
		super(job);
		jliJob=job;
	}
	
	@Override
	public JSONObject toJsonObj() {
		return null!=jliJob?jliJob:new JSONObject();
	}


}
