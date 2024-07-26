package com.guarage.service.www;

import com.guarage.model.www.ServiceModel;
import com.guarage.repository.www.ServiceRepo;

public class ServicingService {
	ServiceRepo srepo = new ServiceRepo();

	public boolean addNewService(ServiceModel smodel) {
		return srepo.addService(smodel);
	}
}
