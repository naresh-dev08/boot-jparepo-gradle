package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;


@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private EntityManager manager;
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `p_get_CustomerDetailsByBullAmt`(IN startAmount float, IN endAmount float)
			BEGIN
			 select * from JPA_CUSTOMER_TAB where BILLAMT>=startAmount and BILLAMT<=endAmount;
			END*/
	
	
	@Override
	public List<Customer> getCustomersByBillAmountRange(double start, double end) {
		
		// create stored procedure sql objt
		StoredProcedureQuery query = manager.createStoredProcedureQuery("p_get_CustomerDetailsByBullAmt", Customer.class);
		
		//set PL/SQL param 
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		
		//link method param values to PL/SQL params
		query.setParameter(1, start);
		query.setParameter(2, end);
		
		//get the records
		List<Customer> list = query.getResultList();
		
		return list;
	}
	
	
	
}
