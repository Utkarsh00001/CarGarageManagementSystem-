package com.guarage.repository.www;

import java.sql.SQLException;
import java.util.Scanner;

import com.guarage.configue.www.DatabaseHelper;
import com.guarage.model.www.VehicleModel;

public class VehicleRepo extends DatabaseHelper {
	Scanner sc = new Scanner(System.in);

	public boolean addVehicle(VehicleModel vmodel) {
		try {
			ps = con.prepareStatement("insert into vehicles values ('0',?,?,?,?,?)");
			ps.setInt(1, vmodel.getCustomer_id());
			ps.setString(2, vmodel.getLicensePlate());
			ps.setString(3, vmodel.getMake());
			ps.setString(4, vmodel.getModel());
			ps.setInt(5, vmodel.getYear());
			int condition = ps.executeUpdate();
			return condition > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("issue is:   " + ex);
			return false;
		}
	}

	public VehicleModel getVehicleByPlate(String licensePlate) {
		VehicleModel vmodel = new VehicleModel();
		try {
			ps = con.prepareStatement("select *from vehicles where license_plate = ?");
			ps.setString(1, licensePlate);
			rs = ps.executeQuery();
			while (rs.next()) {
				vmodel.setVehicle_id(rs.getInt(1));
				vmodel.setCustomer_id(rs.getInt(2));
				vmodel.setLicensePlate(rs.getString(3));
				vmodel.setMake(rs.getString(4));
				vmodel.setModel(rs.getString(5));
				vmodel.setYear(rs.getInt(6));
			}
		} catch (Exception ex) {
			System.out.println("error is" + ex);
		}
		return vmodel;
	}

	public boolean updateVehicalesByEmail(String email) {
		try {
			ps = con.prepareStatement("UPDATE vehicles v " + "JOIN customer c ON v.cust_id = c.cust_id "
					+ "SET v.make = ?, v.model = ?, v.year = ?,v.license_plate = ? " + "WHERE c.email = ?");
			System.out.println("enter the Vehicle Brand name:");
			String Bname = sc.next();
			ps.setString(1, Bname);
			System.out.println("enter the Vehicle Model:");
			String model = sc.next();
			ps.setString(2, model);
			System.out.println("enter the Year:");
			int year = sc.nextInt();
			ps.setInt(3, year);
			System.out.println("enter the Vehicle Number:");
			String vnumber = sc.next();
			ps.setString(4, vnumber);
			ps.setString(5, email);
			int b = ps.executeUpdate();
			return (b > 0) ? true : false;

		} catch (SQLException ex) {
			System.out.println("exception is: " + ex);
			return false;
		}
	}
	public void getVehicleDetailsByItsEmail(String email) {	
		try {
			ps = con.prepareStatement("SELECT c.name,v.license_plate,v.make,v.model,v.year\r\n"
					+ "from\r\n"
					+ "    customer c\r\n"
					+ "JOIN \r\n"
					+ "    vehicles v ON c.cust_id = v.cust_id\r\n"
					+ "WHERE \r\n"
					+ "    c.email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			int count1 = 0;
			while(rs.next()) {
				if (count1 == 0) {
				System.out.println("Name: " + rs.getString("name"));
				}
				  System.out.println("License Plate: " + rs.getString("license_plate"));
		             System.out.println("Make: " + rs.getString("make"));
		             System.out.println("Model: " + rs.getString("model"));
		             System.out.println("year: " + rs.getInt("year"));
		             System.out.println(".................................................................");
		             count1++;
			}
					} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

}
