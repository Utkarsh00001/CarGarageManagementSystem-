package com.guarage.model.www;

public class CustModel {
	int cust_id;
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public CustModel() {
		super();
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getEmail() {
		return email;
	}
	
	public CustModel(int cust_id, String custName, String email, String address, int count_list) {
		super();
		this.cust_id = cust_id;
		CustName = custName;
		this.email = email;
		Address = address;
		this.count_list = count_list;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getCount_list() {
		return count_list;
	}
	public void setCount_list(int count_list) {
		this.count_list = count_list;
	}
	String CustName;
	String email;
	String Address;
	int count_list;
}
