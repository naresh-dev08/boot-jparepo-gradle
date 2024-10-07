package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IMToMAssociationMgmtService;

@Component
public class MToMAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IMToMAssociationMgmtService mtomService;
	
	
	@Override
	public void run(String... args) throws Exception {
		//save data
		try {
		mtomService.saveDataUsingDoctor();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			mtomService.saveDataUsingPatient();
			}catch (Exception e) {
				e.printStackTrace();
			}*/
		/*
		try {
			mtomService.loadDataUsingDoctor();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*
		 * try { mtomService.loadDataUsingPatient(); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}

}
