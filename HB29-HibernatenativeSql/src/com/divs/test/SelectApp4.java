package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.divs.model.InsurancePolicy;
import com.divs.util.HibernateUtil;

public class SelectApp4 {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		session=HibernateUtil.getSession(session);
		
		NativeQuery<String> policy = session.createSQLQuery("select pname  from insurancepolicy where ptenure>=:min and ptenure<=:max");
		policy.setParameter("min", 11);
		policy.setParameter("max", 22);
		
		//policy.addEntity(InsurancePolicy.class);
		
		

		//executing to get the result
		List<String> policies=policy.getResultList();
		
		
		policies.forEach(System.out::println);
	}

}
