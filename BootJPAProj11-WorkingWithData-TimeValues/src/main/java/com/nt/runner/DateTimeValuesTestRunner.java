package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class DateTimeValuesTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;

	@Override
	public void run(String... args) throws Exception {

		/*try {
		
			Customer cust = new Customer();
		
			cust.setBillamt(32686.5f);
			cust.setCadd("Mysore");
			cust.setCname("Vamshi");
			cust.setDob(LocalDateTime.of(1993, 04, 14, 05, 10, 06));
			cust.setDop(LocalDate.now());
			cust.setTop(LocalTime.now());
		
			// save the obj
			String msg = custService.registerCustomer(cust);
			System.out.println(msg);
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		try {
		
		 custService.getAllCustomers().forEach(System.out::println);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// method

}// class
