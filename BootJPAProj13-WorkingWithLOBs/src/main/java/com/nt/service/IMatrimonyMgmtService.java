package com.nt.service;

import com.nt.entity.MarriageSeeker;

public interface IMatrimonyMgmtService {
	
	public String registerMarriageSeeker(MarriageSeeker seeker);
	public MarriageSeeker getMarraigeSeekerById(long id);
}
