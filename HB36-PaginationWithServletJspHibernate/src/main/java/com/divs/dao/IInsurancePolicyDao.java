package com.divs.dao;

import java.util.List;

import com.divs.model.InsurancePolicy;

public interface IInsurancePolicyDao {

	public Long getTotalRecords();

	public List<InsurancePolicy> getPageData(int pageSize, int startPos);

	

}
