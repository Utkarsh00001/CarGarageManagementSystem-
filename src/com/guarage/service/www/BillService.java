package com.guarage.service.www;

import java.sql.SQLException;
import java.time.LocalDate;

import com.guarage.repository.www.BillRepo;

public class BillService {
		BillRepo brepo = new BillRepo();

		public boolean addBills(String email, String number, LocalDate date) {
			return brepo.addBills(email,number,date);
		}
		public void getAllBills() {
			brepo.getAllBills();
		}

		public void getBills(String email, String number, LocalDate date) {
			try {
				brepo.getBill(email,number,date);
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}

		public void getBillByDate(LocalDate date) {
			brepo.getBillByDate(date);
		}

		public void getBillByDate(LocalDate stdate, String edate) {
			brepo.displayBillBetnDates(stdate,edate);
		}
}