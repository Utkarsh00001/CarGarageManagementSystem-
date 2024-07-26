package com.guarage.model.www;

public class BillModel {
	private int billId;
	public BillModel() {
		super();
	}
	public BillModel(int billId, int servId, int custId, double total_ammount, double discount_applied,
			double final_ammount) {
		super();
		this.billId = billId;
		this.servId = servId;
		this.custId = custId;
		this.total_ammount = total_ammount;
		this.discount_applied = discount_applied;
		this.final_ammount = final_ammount;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getServId() {
		return servId;
	}
	public void setServId(int servId) {
		this.servId = servId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public double getTotal_ammount() {
		return total_ammount;
	}
	public void setTotal_ammount(double total_ammount) {
		this.total_ammount = total_ammount;
	}
	public double getDiscount_applied() {
		return discount_applied;
	}
	public void setDiscount_applied(double discount_applied) {
		this.discount_applied = discount_applied;
	}
	public double getFinal_ammount() {
		return final_ammount;
	}
	public void setFinal_ammount(double final_ammount) {
		this.final_ammount = final_ammount;
	}
	private int servId;
	private int custId;
	private double total_ammount;
	private double discount_applied;
	private double final_ammount;
}
