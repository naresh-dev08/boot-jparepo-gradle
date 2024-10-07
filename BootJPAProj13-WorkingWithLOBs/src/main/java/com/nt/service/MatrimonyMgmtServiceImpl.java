package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repository.IMarriageSeeker;

@Service("marriageService")
public class MatrimonyMgmtServiceImpl implements IMatrimonyMgmtService {
	
	@Autowired
	private IMarriageSeeker marriageRepo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		long idVal = marriageRepo.save(seeker).getMid();
		return idVal +" Marriage seeker is registered";
	}

	@Override
	public MarriageSeeker getMarraigeSeekerById(long id) {
		return marriageRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}

	

	
}//class
