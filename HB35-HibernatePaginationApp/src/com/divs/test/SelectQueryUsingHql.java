package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.divs.model.InsurancePolicy;
import com.divs.util.HibernateUtil;

public class SelectQueryUsingHql {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			
			Query<InsurancePolicy> query=session.createQuery("from com.divs.model.InsurancePolicy");
			
			
			query.setFirstResult(1);
			query.setMaxResults(2);
			
			List<InsurancePolicy> policies=query.list();
			
			policies.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
