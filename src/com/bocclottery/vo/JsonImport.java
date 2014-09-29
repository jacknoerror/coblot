package com.bocclottery.vo;

import org.json.JSONObject;

import com.bocclottery.ui.custom.list.ListItemImpl;

/**
 * ����Ҫ�γ�JsonObj��JackJson ����Ĭ�Ϸ���
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
