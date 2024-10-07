package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;


@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public String registerCustomer(Customer cust) {
		
		int idVal  = custRepo.save(cust).getCid();
		return "Customer is saved with idValue ::"+idVal;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return custRepo.findAll();
	}
	
	
	
	
	
}
