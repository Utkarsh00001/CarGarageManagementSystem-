package com.guarage.model.www;

import java.sql.Date;
import java.time.LocalDate;

public class ServiceModel {
	private int vid;
	private int sid;
	public ServiceModel() {
	
	}
	LocalDate lc;
	public ServiceModel(int vid, int sid, LocalDate lc, String desc, double serv_charges) {
		this.vid = vid;
		this.sid = sid;
		this.lc = lc;
		this.desc = desc;
		this.serv_charges = serv_charges;
	}
	public LocalDate getLc() {
		return lc;
	}
	public void setLc(LocalDate lc) {
		this.lc = lc;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getServ_charges() {
		return serv_charges;
	}
	public void setServ_charges(double serv_charges) {
		this.serv_charges = serv_charges;
	}
	private Date date;
	private String desc;
	private double serv_charges;
}
