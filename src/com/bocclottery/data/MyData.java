package com.bocclottery.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import android.widget.TabHost;

import com.bocclottery.vo.MemberInfo;

public class MyData {
	static MyData data;
	private MyData(){};
	public static MyData data(){
		if(null==data) data=new MyData();
		return data;
	}
	
	TabHost mTabHost;
	public void setTabHost(TabHost tabHost){
		this.mTabHost = tabHost;
	}
	public TabHost getTabHost(){
		return mTabHost;
	}
	
	MemberInfo user;
	public void setUser(MemberInfo memberInfo){
		user = memberInfo;
	}
	public MemberInfo getMe(){
		return user;
	}
	
//	public void setMyAddresses(Set<AddressInfo> addressList){
//		if(null!=user&&null!=addressList)user.setAddresses(addressList);
//	}
//	public Set<AddressInfo> getMyAddresses(){
//		if(null==user) return null;
//		return user.getAddresses();
//	}
	
//	AddressInfo currentAddress;
//	public void setCurrentAddress(AddressInfo addr){
//		currentAddress = addr;
//	}
//	public AddressInfo getCurrentAddress(){
//		return currentAddress;
//	}
	
	
	public void destroy(){
		data = null;
	}
	
	String sessionKey;
	public void setSessionKey(String opt) {
		sessionKey = opt;
	}
	public String getSessionKey(){
		return sessionKey;
	}
	
	long loginId;
	public final long getLoginId() {
		return loginId;
	}
	public final void setLoginId(long loginId) {
		this.loginId = loginId;
	}
	
	long apiTimeLag;
	public final long getApiTimeLag() {
		return apiTimeLag;
	}
	public void setApiTimeLag(long parseLong) {
		this.apiTimeLag = parseLong;
		
	}
	
}
