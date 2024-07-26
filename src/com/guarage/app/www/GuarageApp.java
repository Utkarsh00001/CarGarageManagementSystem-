package com.guarage.app.www;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.guarage.model.www.CustModel;
import com.guarage.model.www.ServiceModel;
import com.guarage.model.www.VehicleModel;
import com.guarage.service.www.BillService;
import com.guarage.service.www.CustService;
import com.guarage.service.www.ServicingService;
import com.guarage.service.www.VehicleServices;

public class GuarageApp {
	static Scanner scan = new Scanner(System.in);
	public static ServicingService ss = new ServicingService();
	public static VehicleServices vs = new VehicleServices();
	public static BillService bs = new BillService();

	public static VehicleModel addVehicle(int id) {
		VehicleModel vmodel = new VehicleModel();
		System.out.println("enter the vehicle details:");
		System.out.println();
		vmodel.setCustomer_id(id);
		System.out.println("enter the vehicle passing number:");
		String licenPlate = scan.next();
		vmodel.setLicensePlate(licenPlate);
		System.out.println("enter the brand name of the vehicle:");
		licenPlate = scan.next();
		vmodel.setMake(licenPlate);
		System.out.println("enter the model of the vehicle:");
		licenPlate = scan.next();
		vmodel.setModel(licenPlate);
		System.out.println("enter the manufacturing year:");
		id = scan.nextInt();
		vmodel.setYear(id);
		boolean check = vs.addVehicle(vmodel);
		if (check == true) {
			System.out.println("vehicle added successfully");
		} else {
			System.out.println("some problem is there to add the vehicle");
		}
		return vmodel;
	}

	public static void addServicing(int vid) {
		System.out.println("enter the servicing details of the vehicle:");
		System.out.println("enter the date of the servicing (yyyy-MM-dd):");
		String sdate = scan.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(sdate, formatter);
		System.out.println("enter the servicing discription:");
		String desc = scan.next();
		System.out.println("enter the servicing charges:");
		double charges = scan.nextDouble();
		ServiceModel smodel = new ServiceModel();
		smodel.setLc(date);
		smodel.setDesc(desc);
		smodel.setServ_charges(charges);
		smodel.setVid(vid);
		boolean b = ss.addNewService(smodel);
		if (b == true) {
			System.out.println("service is added successfully");
		} else {
			System.out.println("service not added because of some issues");
		}
	}

	public static void addBills() {
		System.out.println("enter the customer email ");
		String email = scan.next();
		System.out.println("enter the vehicle number ");
		String number = scan.next();
		System.out.println("enter the date of the servicing in the form  of yyyy-MM-dd");
		String sdate = scan.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(sdate, formatter);
		boolean b = bs.addBills(email, number, date);
		if (b == true) {
			System.out.println("bill is added in the database");
		} else {
			System.out.println("there is some issues with respect to the connection");
		}
	}

	public static void bills() {
		System.out.println("enter the customer email ");
		String email = scan.next();
		System.out.println("enter the vehicle number ");
		String number = scan.next();
		System.out.println("enter the date of the servicing in the form  of yyyy-MM-dd");
		String sdate = scan.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(sdate, formatter);
		bs.getBills(email, number, date);

	}

	public static void main(String[] args) {
		CustService cs = new CustService();
		VehicleServices vs = new VehicleServices();

		do {
			Scanner sc = new Scanner(System.in);
			int choice;
			System.out.println("1 : add new customer,vehicle and servicing informations");
			System.out.println("2 : Updtate Delete or View the customer ");
			System.out.println("3 : Update the Vehicle ");
			System.out.println("4 : add bills");
			System.out.println("5 : view all bills");
			System.out.println("6 : creat bill of customer vehicle servicing info ");
			System.out.println("7 : date wise customer lists");
			System.out.println("8 : between date wise customer bill details:");
			System.out.println("9 : show the customer wise vehicle info");
			System.out.println("10: Count the month wise customer list");
			System.out.println("0 : Exit ");
			System.out.printf("enter your choice: \t");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the customer name:");
				String name = sc.next();
				System.out.println("enter the email");
				String email = sc.next();
				System.out.println("enter the address");
				String address = sc.next();
				CustModel cmodel = new CustModel();
				cmodel.setCustName(name);
				cmodel.setEmail(email);
				cmodel.setAddress(address);

				boolean b = cs.isaddCutstmoer(cmodel);

				if (b == true) {
					System.out.println("add vehicle details");
					cmodel = cs.getCustByEmail(email);
					VehicleModel vmodel = new VehicleModel();
					vmodel = GuarageApp.addVehicle(cmodel.getCust_id());
					System.out.println("new customer has been added and its vehicle information is added");
					System.out.println("add servicing details:");
					String d = vmodel.getLicensePlate();
					vmodel = vs.getVehicleByLicenPlate(d);
					int id = vmodel.getVehicle_id();
					GuarageApp.addServicing(id);
				} else {
					System.out.println("existing customers");
					cmodel = cs.getCustByEmail(email);
					System.out.println("setting up the visinting count again");
					boolean is = cs.setCustCuntById(cmodel);
					if (is == true) {
						System.out.println("new visit count has been added");
					} else {
						System.out.println("there is some issue");
					}
					System.out.println("add vehicle details");
					VehicleModel vmodel = new VehicleModel();
					vmodel = GuarageApp.addVehicle(cmodel.getCust_id());
					System.out.println("new customer has been and its vehicle information is added");

					System.out.println("add servicing details:");
					String d = vmodel.getLicensePlate();
					vmodel = vs.getVehicleByLicenPlate(d);
					int id = vmodel.getVehicle_id();
					GuarageApp.addServicing(id);
				}
				break;

			case 2:
				
				System.out.println("1 : view customer by email");
				System.out.println("2 : delete the customer");
				System.out.println("3 : update the customer");
				System.out.println("4 : view all details of the customer:");
				System.out.println("Enter Your Choices:");
				
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("view customer");
					System.out.println("enter the email of the customer");
					email = sc.next();
					cmodel = cs.getCustByEmail(email);

					System.out.println("Id : " + cmodel.getCust_id());
					System.out.println("Name : " + cmodel.getCustName());
					System.out.println("Email : " + cmodel.getEmail());
					System.out.println("Address : " + cmodel.getAddress());
					System.out.println("Visit Count : " + cmodel.getCount_list());
					break;
				case 2:
					System.out.println("enter the email of the customer:");
					name = sc.next();
					b = cs.deleteCustBysName(name);
					if (b == true) {
						System.out.println("customer deleted successfuly");
					} else {
						System.out.println("there is some error to delete the customer");
					}
					break;
				case 3:
					System.out.println("enter the email of the customer");
					email = sc.next();
					b = cs.updateCustomerByName(email);
					if (b == true) {
						System.out.println("customer updated successfully");
					} else {
						System.out.println("theres some error to update the customer");
					}
					break;
				case 4:
					cs.viewAllcustomer();
					break;

				default:
					System.out.println("Invalid Choice............");
				}
				break;
			case 3:
				System.out.println("enter the email of the customer");
				email = sc.next();
				b = vs.updateVehiclesByEmail(email);
				if (b == true) {
					System.out.println("Vehicle updated successfully");
				} else {
					System.out.println("theres some error to update the Vehicle");
				}
				break;
			case 4:
				GuarageApp.addBills();
				break;
			case 5:
				bs.getAllBills();
				break;
			case 6:
				GuarageApp.bills();
				break;
			case 7:
				GuarageApp.betnWise();
				break;
			case 8:
				GuarageApp.betweenDate();
				break;
			case 9:
				System.out.println("enter the email: ");
				email = sc.next();
				vs.getVehicleDetailsByItsEmail(email);
				break;
			case 10:
				cs.showMonthWiseCount();
				break;
			case 0:
				System.exit(0);

			default:
				System.out.println("Invalid Choice.............");
				sc.close();
			}
		} while (true);
	}

	public static void betweenDate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the start date in form of yyyy-MM-dd:");
		String sdate = scan.next();
		System.out.println("enter the ending date in the form of yyyy-MM-dd:");
		String edate = scan.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate stdate = LocalDate.parse(sdate, formatter);
		LocalDate eddate = LocalDate.parse(edate, formatter);
		bs.getBillByDate(stdate, edate);
	}

	public static void betnWise() {
		System.out.println("enter the date in form of yyyy-MM-dd:");
		Scanner sc = new Scanner(System.in);
		String sdate = scan.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(sdate, formatter);
		bs.getBillByDate(date);
	}
}
