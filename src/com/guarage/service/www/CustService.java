package com.guarage.service.www;

import com.guarage.model.www.CustModel;
import com.guarage.repository.www.CustRepo;

public class CustService {
	CustRepo crepo = new CustRepo();
	
	public boolean isaddCutstmoer(CustModel cmodel) {
		boolean b = crepo.isAddCustomer(cmodel);
		return b;
	}
	public CustModel getCustByName(String name) {
		return crepo.getCustInfoByName(name);
	}
	public CustModel getCustByEmail(String email) {
		return crepo.getCustInfoByEmail(email);
	}
	public boolean setCustCuntById(CustModel cmodel) {
		boolean b = crepo.setCustCount(cmodel);
		return b;
	}
	public boolean deleteCustBysName(String email) {
		return crepo.deleteCustByName(email);
	}
	public boolean updateCustomerByName(String email) {
		return crepo.updateCustomerByName(email);
	}
	public void viewAllcustomer() {
		crepo.viewAllCustomers();
	}
	public void showMonthWiseCount() {
		crepo.showMonthWiseCount();
		
	}

}
