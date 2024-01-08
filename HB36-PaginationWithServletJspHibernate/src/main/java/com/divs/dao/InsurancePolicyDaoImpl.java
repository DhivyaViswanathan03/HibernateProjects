package com.divs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.divs.model.InsurancePolicy;
import com.divs.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements IInsurancePolicyDao{
	
	Session session=HibernateUtil.getSession();

	@SuppressWarnings("rawtypes")
	@Override
	public Long getTotalRecords() {
		Long count=0L;
		try {
			Query query = session.getNamedQuery("GET_POLICIES_COUNT");
			List policy=query.list();
			count=(Long) policy.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InsurancePolicy> getPageData(int pageSize, int startPos) {
		List<InsurancePolicy> policies=null;
		try {
			Query<InsurancePolicy> query = session.getNamedQuery("GET_ALL_POLICIES");
			query.setFirstResult(startPos);
			query.setMaxResults(pageSize);
			policies = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return policies;
			
	}

}
