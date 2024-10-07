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
	
	
	@Override
	public List<Customer> getCustomersByBillAmountRange(double start, double end) {
		
		// create stored procedure sql objt
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_CUSTOMERS_BY_BILLAMT_RANGE", Customer.class);
		
		//set PL/SQL param 
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR);
		
		//link method param values to PL/SQL params
		query.setParameter(1, start);
		query.setParameter(2, end);
		
		//get the records
		List<Customer> list = query.getResultList();
		
		return list;
	}
	
	
	
}
