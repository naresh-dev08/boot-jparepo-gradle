package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.entity.PhoneNumber;
import com.nt.repository.ICustomerRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("otmService")
public class OToMOperationServiceImpl implements IOToMOperationService {

	@Autowired
	private ICustomerRepository custRepo;

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Override
	public void saveDataUsingCustomer() {
		// Prepare data
		// parent
		Customer cust = new Customer("Raghu", "Hyd");
		// child
		PhoneNumber phoneNo1 = new PhoneNumber(9705520647L, "Personal", "Airtel");
		PhoneNumber phoneNo2 = new PhoneNumber(9705566284L, "Office", "BSNL");
		// Link childs to parent and vice-versa
		Set<PhoneNumber> phonesSet = new HashSet<PhoneNumber>();
		phonesSet.add(phoneNo1);
		phonesSet.add(phoneNo2);
		phoneNo1.setCustomer(cust);
		phoneNo2.setCustomer(cust);// parent is linked wi
		cust.setPhones(phonesSet); // childs are linked with parent

		// save data using parent obj
		int idVal = custRepo.save(cust).getCid();

		System.out.println("Customer obj and their objs are saved with the id value :: " + idVal);
	}

	@Override
	public void saveDataUsingPhoneNumber() {
		// Prepare data
		// parent
		Customer cust = new Customer("Vanesh", "Mumbai");
		// child
		PhoneNumber phoneNo1 = new PhoneNumber(9705520667L, "Personal", "Idea");
		PhoneNumber phoneNo2 = new PhoneNumber(9705566246L, "Office", "Jio");
		// Link childs to parent and vice-versa
		Set<PhoneNumber> phonesSet = new HashSet<PhoneNumber>();
		phonesSet.add(phoneNo1);
		phonesSet.add(phoneNo2);
		phoneNo1.setCustomer(cust);
		phoneNo2.setCustomer(cust);// parent is linked wi
		cust.setPhones(phonesSet); // childs are linked with parent

		// save data using childs obj
		int idVal1 = phoneRepo.save(phoneNo1).getRegno();
		int idVal2 = phoneRepo.save(phoneNo2).getRegno();

		System.out.println("Phone obj and their objs are saved with the id value :: " + idVal1 + "....." + idVal2);
	}

	@Override
	public void getDataUsingCustomer() {
		
		List<Customer> list = custRepo.findAll();
		list.forEach(cust -> {
			System.out.println("=================================");
			System.out.println("Parent:: "+cust);
			Set<PhoneNumber> childs = cust.getPhones();
			childs.forEach(ph -> {
				System.out.println("Childs:: "+ph);
			});
		});

	}

	@Override
	public void getDataUsingPhoneNumber() {
		List<PhoneNumber> list = phoneRepo.findAll();
		list.forEach(ph -> {
			System.out.println("Child:: "+ph);
			//get parents
			/*Customer cust = ph.getCustomer();
			System.out.println("Parent:: "+cust);*/
			System.out.println("=========================================");
		});
		
	}

	@Override
	public void deleteDataUsingCustomer(int id) {
		///load the parent obj
		Optional<Customer> opt = custRepo.findById(id);
		if (opt.isPresent()) {
			//get parent obj
			Customer cust = opt.get();
			//delete parent and the associated childs
			custRepo.delete(cust);
			System.out.println("Parents and childs are deleted");
		}else {
			System.out.println("Parent is not found");
		}
		
		
	}

}// class
