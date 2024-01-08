package com.divs.service;

import java.util.ArrayList;
import java.util.List;

import com.divs.dao.IInsurancePolicyDao;
import com.divs.dao.InsurancePolicyDaoImpl;
import com.divs.dto.InsurancePolicyDto;
import com.divs.model.InsurancePolicy;

public class InsurancePolicyServiceImpl implements IInsurancePolicyService {
	private IInsurancePolicyDao dao=null;
	
	public InsurancePolicyServiceImpl(){
		dao=new InsurancePolicyDaoImpl();
	}

	@Override
	public Long fetchPageCount(int pageSize) {
		Long totalRecords=dao.getTotalRecords();
		Long noOfPages=totalRecords/pageSize;
		if(totalRecords %pageSize!=0) {
			noOfPages++;
		}
		return noOfPages;
	}

	@Override
	public List<InsurancePolicyDto> fetchPageData(int pageSize, int pageNo) {
		int startPos=0;
		startPos=(pageNo*pageSize)-pageSize;
		List<InsurancePolicy> entities=dao.getPageData(pageSize,startPos);
		List<InsurancePolicyDto> list=new ArrayList<InsurancePolicyDto>();
		entities.forEach(entity->{
			InsurancePolicyDto dto=new InsurancePolicyDto();
			dto.setPid(entity.getPid());
			dto.setPname(entity.getPname());
			dto.setPtenure(entity.getPtenure());
			dto.setPtype(entity.getPtype());
			list.add(dto);
		});
		return list;
	}
	

}
