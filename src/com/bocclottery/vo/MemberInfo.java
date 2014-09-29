package com.bocclottery.vo;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MemberInfo extends JsonImport{
	/*
	 * {"userName":"test9","memberId":33058,"realName":"test9","userCardNo":"100009","registUser":"admin",
	 * "registIp":"192.168.1.1","registType":0,
	 * "addresses":[{"phone":"123","address":"123","defaultSign":1,"zipcode":"310007","memberId":33058,"contact":"wlr","addressId":31051},{"phone":"wlr","address":"wlr","defaultSign":0,"zipcode":"310012","memberId":33058,"contact":"wlr","addressId":29050},{"phone":"15858173770","address":"wlr_eidt2","defaultSign":0,"zipcode":"310012","memberId":33058,"contact":"tttt","addressId":27051}],
	 * "password":"PC4OSX9BRP2459393D75A6AB9F22D323392C67F5C2DBA6058A314491DAB226E5AB1ECD4B14","mobileNo":"13666642825",
	 * "registTime":{"date":13,"day":1,"hours":11,"minutes":13,"month":4,"nanos":0,"seconds":35,"time":1368414815000,"timezoneOffset":-480,"year":113}}
	 */
	
	private Integer memberId;	//�û�ID `
	private String userName;	//�û���
	private String password;	//���� `
	private String realName;	//��ʵ����
	private String userCardNo;	//�û�֤������
	private String mobileNo;	//�ֻ����� `
	private DateJson registTime;	//ע��ʱ��
	private String registIp;	//ע��IP
	private String registUser;	//ע���û��ĺ�̨�û�
	private Integer registType;	//ע�����ͣ�Ĭ��0,��̨ע�� 1
	
	private int leftNum;
	private Set<AddressInfo> addresses = new HashSet<AddressInfo>();	//�ջ���ַ
	
	@Override
	public void initJackJson(JSONObject job) throws JSONException {
		if(job.has("memberId")) setMemberId(job.getInt("memberId"));
		if(job.has("userName")) setUserName(job.getString("userName"));
		if(job.has("password")) setPassword(job.getString("password"));
		if(job.has("realName")) setRealName(job.getString("realName"));
		if(job.has("userCardNo")) setUserCardNo(job.getString("userCardNo"));
		if(job.has("mobileNo")) setMobileNo(job.getString("mobileNo"));
		if(job.has("registTime")) setRegistTime(new DateJson(job.getJSONObject("registTime")));
		if(job.has("registIp")) setRegistIp(job.getString("registIp"));
		if(job.has("registUser")) setRegistUser(job.getString("registUser"));
		if(job.has("registType")) setRegistType(job.getInt("registType"));
		if(job.has("leftNum")) leftNum = job.getInt("leftNum");
		if(job.has("addresses")){
			JSONArray jar = job.getJSONArray("addresses");
			for(int i=0;i<jar.length();i++){
				addresses.add(new AddressInfo(jar.getJSONObject(i)));
			}
		}
	}

	public final int getLeftNum() {
		return leftNum;
	}

	public final void setLeftNum(int leftNum) {
		this.leftNum = leftNum;
	}

	public Integer getMemberId() {
		return memberId;
	}
	
	public final DateJson getRegistTime() {
		return registTime;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getRealName() {
		return realName;
	}

	public String getUserCardNo() {
		return userCardNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}


	public String getRegistIp() {
		return registIp;
	}

	public String getRegistUser() {
		return registUser;
	}

	public Integer getRegistType() {
		return registType;
	}

	


	public final Set<AddressInfo> getAddresses() {
		return addresses;
	}

	public final void setAddresses(Set<AddressInfo> addresses) {
		this.addresses = addresses;
	}

	public void setMemberId(Integer memberId) {this.memberId = memberId;}
	public final void setRegistTime(DateJson registTime) {
		this.registTime = registTime;
	}

	public void setUserName(String userName) {this.userName = userName;}
	public void setPassword(String password) {this.password = password;}
	public void setRealName(String realName) {this.realName = realName;}
	public void setUserCardNo(String userCardNo) {this.userCardNo = userCardNo;}
	public void setMobileNo(String mobileNo) {this.mobileNo = mobileNo;}
	public void setRegistIp(String registIp) {this.registIp = registIp;}
	public void setRegistUser(String registUser) {this.registUser = registUser;}
	public void setRegistType(Integer registType) {this.registType = registType;}

}
