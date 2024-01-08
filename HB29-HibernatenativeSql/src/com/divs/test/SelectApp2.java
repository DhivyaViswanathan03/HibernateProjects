package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.divs.model.InsurancePolicy;
import com.divs.util.HibernateUtil;

public class SelectApp2 {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		session=HibernateUtil.getSession(session);
		
		NativeQuery<InsurancePolicy> policy = session.createSQLQuery("select * from insurancepolicy where ptenure>=? and ptenure<=?");
		policy.setParameter(1, 11);
		policy.setParameter(2, 22);
		
		policy.addEntity(InsurancePolicy.class);

		//executing to get the result
		List<InsurancePolicy> policies=policy.getResultList();
		
		
		policies.forEach(System.out::println);
	}

}
