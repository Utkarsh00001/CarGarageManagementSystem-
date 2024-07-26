package com.guarage.repository.www;

import java.sql.Date;

import com.guarage.configue.www.DatabaseHelper;
import com.guarage.model.www.ServiceModel;

public class ServiceRepo extends DatabaseHelper{

	public boolean addService(ServiceModel smodel) {
		
		try {
		ps = con.prepareStatement("insert into services values ('0',?,?,?,?)");
		ps.setInt(1, smodel.getVid());
		ps.setDate(2, Date.valueOf(smodel.getLc()));
		ps.setString(3, smodel.getDesc());
		ps.setDouble(4, smodel.getServ_charges());
		int val = ps.executeUpdate();
		return (val>0)?true:false;
		}catch(Exception ex) {
			System.out.println("error is "+ex);
			return false;
		}
	}
}
