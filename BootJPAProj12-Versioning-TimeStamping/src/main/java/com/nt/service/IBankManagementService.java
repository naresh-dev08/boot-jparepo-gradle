package com.nt.service;

import com.nt.entity.BankAccount;

public interface IBankManagementService {
	
	public String createBankAccount(BankAccount account);
	public String updateAccountMobileNumber(Long acno, Long newMobileNo);
	public BankAccount getAccountDetailsByAcNo(long acno);

}
