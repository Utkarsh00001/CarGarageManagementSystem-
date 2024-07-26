package com.guarage.repository.www;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import com.guarage.configue.www.DatabaseHelper;

public class BillRepo extends DatabaseHelper{

	public boolean addBills(String email, String number, LocalDate date) 
	{
			try {
				String sql = "{CALL InsertBillForCustomer(?, ?, ?)}";
	            java.sql.CallableStatement cst = con.prepareCall(sql);
				cst.setString(1, email);
				cst.setString(2, number);
				cst.setDate(3, Date.valueOf(date));
				boolean b = cst.execute();
				if (!b)
					return true;
				else
					return false;
			} catch (SQLException e) {
				System.out.println("there is some connection issues....");
				System.out.println();
				return false;
			}
	}
	public void getAllBills() {
		try {
			ps = con.prepareStatement("select c.name,c.email,c.address,v.make,v.model,v.license_plate,\r\n"
					+ "   s.service_date,\r\n"
					+ "   s.description as service_decription,\r\n"
					+ "    b.total_amount,b.discount_applied,b.final_amount\r\n"
					+ "    from customer c\r\n"
					+ "    join vehicles v on c.cust_id = v.cust_id\r\n"
					+ "    join services s on v.vehicle_id = s.vehicle_id\r\n"
					+ "    join bills b on s.service_id = b.service_id"
					);
			rs = ps.executeQuery();
			while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Make: " + rs.getString("make"));
                System.out.println("Model: " + rs.getString("model"));
                System.out.println("License Plate: " + rs.getString("license_plate"));
                System.out.println("Service Date: " + rs.getDate("service_date"));
                System.out.println("Service Description: " + rs.getString("service_decription"));
                System.out.println("total Charges: " + rs.getBigDecimal("total_amount"));
                System.out.println("discount applied:  " + rs.getBigDecimal("discount_applied"));
                System.out.println("final ammount:  " + rs.getBigDecimal("final_amount"));
                System.out.println("...........................................................................................");
				}
		} catch (SQLException e) {
			System.out.println("error is:"+e);
		}
		
	}

	public void getBill(String email, String number, LocalDate date) throws SQLException {
		String procedureCall = "{CALL GetCustomerBillDetails(?, ?, ?)}";
        CallableStatement cs = con.prepareCall(procedureCall) ;
            cs.setString(1, email);
            cs.setString(2, number);
            cs.setDate(3, Date.valueOf(date));
            ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    System.out.println("=============================================================");
                    System.out.println("|                     Customer Bill Details                 |");
                    System.out.println("=============================================================");
                    System.out.printf("| %-20s : %-40s |\n", "Name", rs.getString("name"));
                    System.out.printf("| %-20s : %-40s |\n", "Email", rs.getString("email"));
                    System.out.printf("| %-20s : %-40s |\n", "Address", rs.getString("address"));
                    System.out.printf("| %-20s : %-40s |\n", "Make", rs.getString("make"));
                    System.out.printf("| %-20s : %-40s |\n", "Model", rs.getString("model"));
                    System.out.printf("| %-20s : %-40s |\n", "License Plate", rs.getString("license_plate"));
                    System.out.printf("| %-20s : %-40s |\n", "Service Date", rs.getDate("service_date"));
                    System.out.printf("| %-20s : %-40s |\n", "Service Description", rs.getString("service_description"));
                    System.out.printf("| %-20s : %-40s |\n", "Total Charges", rs.getBigDecimal("total_amount"));
                    System.out.printf("| %-20s : %-40s |\n", "Discount Applied", rs.getBigDecimal("discount_applied"));
                    System.out.printf("| %-20s : %-40s |\n", "Final Amount", rs.getBigDecimal("final_amount"));
                    System.out.println("=============================================================");
                } 
	}

	public void getBillByDate(LocalDate date) {
		try {
			ps = con.prepareStatement("SELECT   c.name, c.email,c.address,v.license_plate,v.make,v.model,b.total_amount, b.discount_applied, b.final_amount\r\n"
					+ "from\r\n"
					+ "    customer c\r\n"
					+ "JOIN \r\n"
					+ "    vehicles v ON c.cust_id = v.cust_id\r\n"
					+ "JOIN \r\n"
					+ "    services s ON v.vehicle_id = s.vehicle_id\r\n"
					+ "JOIN \r\n"
					+ "    bills b ON s.service_id = b.service_id\r\n"
					+ "WHERE \r\n"
					+ "    s.service_date=?"
					);
			ps.setDate(1, Date.valueOf(date));
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("customer bill details:");
				 System.out.println("Name: " + rs.getString("name"));
	             System.out.println("Email: " + rs.getString("email"));
	             System.out.println("Address: " + rs.getString("address"));
	             System.out.println("License Plate: " + rs.getString("license_plate"));
	             System.out.println("Make: " + rs.getString("make"));
	             System.out.println("Model: " + rs.getString("model"));
	             System.out.println("total Charges: " + rs.getBigDecimal("total_amount"));
	             System.out.println("discount applied:  " + rs.getBigDecimal("discount_applied"));
	             System.out.println("final ammount:  " + rs.getBigDecimal("final_amount"));
	             System.out.println("....................................................................................................................");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

	public void displayBillBetnDates(LocalDate stdate, String edate) {
		try {
			ps = con.prepareStatement("SELECT   c.name, c.email,c.address,v.license_plate,v.make,v.model,b.total_amount, b.discount_applied, b.final_amount\r\n"
					+ "from\r\n"
					+ "    customer c\r\n"
					+ "JOIN \r\n"
					+ "    vehicles v ON c.cust_id = v.cust_id\r\n"
					+ "JOIN \r\n"
					+ "    services s ON v.vehicle_id = s.vehicle_id\r\n"
					+ "JOIN \r\n"
					+ "    bills b ON s.service_id = b.service_id\r\n"
					+ "WHERE \r\n"
					+ "    s.service_date BETWEEN ? AND ?"
					);
			ps.setDate(1, Date.valueOf(stdate));
			ps.setDate(2, Date.valueOf(edate));
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("customer bill details:");
				 System.out.println("Name: " + rs.getString("name"));
	             System.out.println("Email: " + rs.getString("email"));
	             System.out.println("Address: " + rs.getString("address"));
	             System.out.println("License Plate: " + rs.getString("license_plate"));
	             System.out.println("Make: " + rs.getString("make"));
	             System.out.println("Model: " + rs.getString("model"));
	             System.out.println("total Charges: " + rs.getBigDecimal("total_amount"));
	             System.out.println("discount applied:  " + rs.getBigDecimal("discount_applied"));
	             System.out.println("final ammount:  " + rs.getBigDecimal("final_amount"));
	             System.out.println("....................................................................................................................");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
