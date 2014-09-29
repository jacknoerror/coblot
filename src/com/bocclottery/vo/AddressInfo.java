package com.bocclottery.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class AddressInfo extends JsonImport{
//	{"phone":"123","address":"123","defaultSign":1,"zipcode":"310007","memberId":33058,"contact":"wlr","addressId":31051}
	
	private int addressId;// 		��ַID
	private Integer memberId;
	private String addressName;// 		�û���ϸ��ַ
	private String phone;// 			�û���ϵ�绰
	private String zipcode;// 		��������
	private String contact;// 		�ջ�������
	private boolean defaultSign ;//	�Ƿ���ΪĬ�ϱ��
	
	public AddressInfo() {
		addressName="";
		phone="";
		zipcode="";
		contact="";
	}
	
	public AddressInfo(JSONObject jsonObject) {
		super(jsonObject);
	}

	@Override
	public void initJackJson(JSONObject job) throws JSONException {
			
			if(job.has("addressId")) setAddressId(job.getInt("addressId"));
			if(job.has("memberId")) setMemberId(job.optInt("memberId"));//
			if(job.has("address")) setAddressName(job.getString("address"));
			if(job.has("phone")) setPhone(job.getString("phone"));
			if(job.has("zipcode")) setZipcode(job.getString("zipcode"));
			if(job.has("contact")) setContact(job.getString("contact"));
			if(job.has("defaultSign")) setDefaultSign(job.getInt("defaultSign")==1?true:false);

		
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String address) {
		this.addressName = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public boolean isDefaultSign() {
		return defaultSign;
	}
	public void setDefaultSign(boolean defaultSign) {
		this.defaultSign = defaultSign;
	}
	public int  getDefaultSign() {
		return defaultSign?1:0;
	}
	
}
