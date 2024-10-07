package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAccountRepository;

@Service("bankService")
public class BankAccountManagementServiceImpl implements IBankManagementService {
	
	@Autowired
	private IBankAccountRepository bankRepo;

	@Override
	public String createBankAccount(BankAccount account) {
		long acno = bankRepo.save(account).getAcNo();
		return "Bank account is opened having the account no. ::: "+acno;
	}

	@Override
	public String updateAccountMobileNumber(Long acno, Long newMobileNo) {
		//load the obj
		Optional<BankAccount> opt = bankRepo.findById(acno);
		if (opt.isPresent()) {
			BankAccount account = opt.get();
			//update the obj
			account.setMobileNo(newMobileNo);
			bankRepo.save(account);
		return acno+" Bank account is found and updated";
		} else { 
		return acno+" Bank Account not found" ;
		}
	}

	@Override
	public BankAccount getAccountDetailsByAcNo(long acno) {
		return bankRepo.getReferenceById(acno);
	}

	
}//class
