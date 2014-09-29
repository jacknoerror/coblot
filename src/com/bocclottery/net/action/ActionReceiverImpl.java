package com.bocclottery.net.action;

import org.json.JSONException;

import android.content.Context;

import com.bocclottery.data.NetConst;


public interface ActionReceiverImpl extends NetConst{
	/**
	 * @param result
	 * @return true if no error occurs
	 * @throws JSONException
	 */
	public boolean response(String result) throws JSONException;
	/**
	 * 
	 * @return the context the loading dialog is to put, do not use applcationContext
	 */
	public Context getReceiverContext();
}
