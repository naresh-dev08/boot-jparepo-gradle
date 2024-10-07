package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface ICustomerMgmtService {
	
	List<Customer> getCustomersByBillAmountRange(double start, double end);
    
}
