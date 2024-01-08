package com.divs.service;

import java.util.List;

import com.divs.dto.InsurancePolicyDto;

public interface IInsurancePolicyService {
	
	public Long fetchPageCount(int pageSize);
	
	public List<InsurancePolicyDto> fetchPageData(int pageSize,int pageNo);

}
