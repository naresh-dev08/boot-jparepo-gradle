package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOToMOperationService;

@Component
public class OToMAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IOToMOperationService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			//save the data using parent
			//service.saveDataUsingCustomer();
			
			//save the data using Child
			//service.saveDataUsingPhoneNumber();
			
			//Load the data using parent
			service.getDataUsingCustomer();
			
			//Load the data using Child
			//service.getDataUsingPhoneNumber();
			
			// delete data using parent
			//service.deleteDataUsingCustomer(102);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
