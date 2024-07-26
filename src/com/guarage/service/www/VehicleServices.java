package com.guarage.service.www;

import com.guarage.model.www.VehicleModel;
import com.guarage.repository.www.VehicleRepo;

public class VehicleServices {
	VehicleRepo vrepo = new VehicleRepo();

	public boolean addVehicle(VehicleModel vmodel) {
		return vrepo.addVehicle(vmodel);
	}
	public VehicleModel getVehicleByLicenPlate(String  licensePlate) {
		return vrepo.getVehicleByPlate(licensePlate);
	}
	public boolean updateVehiclesByEmail(String email) {
		
		return vrepo.updateVehicalesByEmail(email);
	}
	public void getVehicleDetailsByItsEmail(String email) {
		vrepo.getVehicleDetailsByItsEmail(email);
	}
}
