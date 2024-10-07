package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.IBankManagementService;


@Component
public class VersioningAndTimeStampTestRunner implements CommandLineRunner {

	@Autowired
	private IBankManagementService bankService;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*//save the obj
		try {
			BankAccount account = new BankAccount("Suresh", 90000.0, 74653242L);
			String msg = bankService.createBankAccount(account);
			System.out.println(msg);
		}catch (Exception e) {
		  e.printStackTrace();
		}*/
		
		
		//Load and update the obj
		try {
			String msg = bankService.updateAccountMobileNumber(10000000L, 9775520663L);
			System.out.println(msg);
			BankAccount account = bankService.getAccountDetailsByAcNo(10000000L);
			System.out.println("Account creaated on: "+account.getCreationTime()+", Lastly updated on: "+account.getLastUpdationTime()+", updated for: "+account.getUpdateCount()+" times");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}//run()

}//class
