package com.guarage.model.www;

public class VehicleModel {
	int vehicle_id;

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public VehicleModel() {

	}

	public VehicleModel(int vehicle_id, int customer_id, String licensePlate, String make, String model, int year) {
		this.vehicle_id = vehicle_id;
		this.customer_id = customer_id;
		this.licensePlate = licensePlate;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	int customer_id;
	String licensePlate;
	String make;
	String model;
	int year;

}
