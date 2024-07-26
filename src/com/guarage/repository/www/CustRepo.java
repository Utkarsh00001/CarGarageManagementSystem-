package com.guarage.repository.www;

import java.sql.SQLException;
import java.util.Scanner;

import com.guarage.configue.www.DatabaseHelper;
import com.guarage.model.www.CustModel;

public class CustRepo extends DatabaseHelper{
	Scanner sc = new Scanner(System.in);
	public boolean isAddCustomer(CustModel cmodel) {
		try {
			ps = con.prepareStatement("insert into customer values('0',?,?,?,?)");
			ps.setString(1, cmodel.getCustName());
		
			ps.setString(2,cmodel.getEmail());
			ps.setString(3,cmodel.getAddress());
			ps.setInt(4, 1);
			int value = ps.executeUpdate();
			return value>0?true:false;
		}catch(Exception exs){
			System.out.println("error is"+exs);
			return false;
		}
		
	}
	public CustModel getCustInfoByName(String name) {
		CustModel cmodel = new CustModel();
		try {
			ps = con.prepareStatement("select *from customer where name = ?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				cmodel.setCust_id(rs.getInt(1));
				cmodel.setCustName(rs.getString(2));
				cmodel.setEmail(rs.getString(3));
				cmodel.setAddress(rs.getString(4));
				//int no = rs.getInt(5);
				cmodel.setCount_list(rs.getInt(5));
			}
			
		} catch (Exception e) {
			System.out.println("error is:"+e);
		}
		return cmodel;
	}
	public boolean setCustCount(CustModel cmodel) {
		try {
			ps = con.prepareStatement("update customer set count_list = ? where cust_id = ?");
			int count = cmodel.getCount_list();
			System.out.println(count);
			++count;
			ps.setInt(1, count);
			ps.setInt(2, cmodel.getCust_id());
			
			int value = ps.executeUpdate();
			return value>0?true:false;
		}catch(Exception exs){
			System.out.println("error is"+exs);
			return false;
		}
	}
	public boolean deleteCustByName(String email) {
		try {
			ps = con.prepareStatement("delete from customer where email = ?");
			ps.setString(1, email);
			int val = ps.executeUpdate();
			return val>0?true:false;
		} catch (SQLException e) {
			System.out.println("error is:"+e);
			return false;
		}
	}
	public boolean updateCustomerByName(String email) {
		try {
			ps = con.prepareStatement("update customer set name = ?,email = ?,address = ? where email = ?");
			System.out.println("enter the name of the customer:");
			String name1 = sc.next();
			ps.setString(1, name1);
			System.out.println("enter the email of the customer");
			name1 = sc.next();
			ps.setString(2, name1);
			System.out.println("enter the address of the customer");
			name1 = sc.next();
			ps.setString(3, name1);
			ps.setString(4, email);
			int b = ps.executeUpdate();
			return (b>0)?true:false;
			
		}catch(SQLException ex) {
			System.out.println("exception is: "+ ex);
			return false;
		}
	}
	public CustModel getCustInfoByEmail(String email) {
		CustModel cmodel = new CustModel();
		try {
			ps = con.prepareStatement("select *from customer where email = ?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				cmodel.setCust_id(rs.getInt(1));
				cmodel.setCustName(rs.getString(2));
				cmodel.setEmail(rs.getString(3));
				cmodel.setAddress(rs.getString(4));
				//int no = rs.getInt(5);
				cmodel.setCount_list(rs.getInt(5));
			}
			
		} catch (Exception e) {
			System.out.println("error is:"+e);
		}
		return cmodel;
	}
	public void viewAllCustomers() {
		try {
			ps = con.prepareStatement("select c.cust_id,c.name,c.email,c.address,v.license_plate,v.make,v.model,\r\n"
					+ "   v.year,s.service_id,s.service_date,\r\n"
					+ "   s.description as service_decription,\r\n"
					+ "    s.service_charge\r\n"
					+ "    from customer c\r\n"
					+ "    join vehicles v on c.cust_id = v.cust_id\r\n"
					+ "    join services s on v.vehicle_id = s.vehicle_id;");
			rs = ps.executeQuery();
            System.out.println("ID\tName\t\tEmail\t\tAddress\t\tLicense Plate\tMake\tModel\tYear\tService ID\tService Date\tDescription\tCharge");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
  
            while (rs.next()) {
            	System.out.print( rs.getInt("cust_id")+"\t");
            	System.out.print( rs.getString("name")+"\t");
            	System.out.print(rs.getString("email")+"\t\t");
            	System.out.print(rs.getString("address")+"\t\t");
            	System.out.print( rs.getString("license_plate")+"\t");
            	System.out.print( rs.getString("make")+"\t");
            	System.out.print( rs.getString("model")+"\t");
            	System.out.print(rs.getInt("year")+"\t\t");
            	System.out.print( rs.getInt("service_id")+"\t");
            	System.out.print( rs.getDate("service_date")+"\t");
            	System.out.print( rs.getString("service_decription")+"\t");
            	System.out.print(rs.getBigDecimal("service_charge")+"\t");
            	System.out.println();
            }
		} catch (SQLException e) {
			
			System.out.println(e);
		}
	}
	public void showMonthWiseCount() {
		try {
			ps = con.prepareStatement("SELECT \r\n"
					+ "    DATE_FORMAT(s.service_date, '%m') AS service_month,\r\n"
					+ "    COUNT(DISTINCT c.cust_id) AS customer_count\r\n"
					+ "FROM \r\n"
					+ "    services s\r\n"
					+ "JOIN \r\n"
					+ "    vehicles v ON s.vehicle_id = v.vehicle_id\r\n"
					+ "JOIN \r\n"
					+ "    customer c ON v.cust_id = c.cust_id\r\n"
					+ "GROUP BY \r\n"
					+ "    service_month\r\n"
					+ "ORDER BY \r\n"
					+ "    service_month;");
			rs = ps.executeQuery();
			System.out.println("month\t count");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t   "+rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
