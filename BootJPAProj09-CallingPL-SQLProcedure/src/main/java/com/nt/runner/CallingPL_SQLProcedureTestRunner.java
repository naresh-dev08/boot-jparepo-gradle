package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class CallingPL_SQLProcedureTestRunner implements CommandLineRunner {
	
	
	@Autowired
	private ICustomerMgmtService custService;

	
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Customer> list = custService.getCustomersByBillAmountRange(25000.0, 45000.0);
		
		list.forEach(cust -> {
			System.out.println(cust);
		});
		
		
	}//method
	
	
		
}//class
