package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.divs.model.InsurancePolicy;
import com.divs.util.HibernateUtil;

public class SelectApp3 {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		session=HibernateUtil.getSession(session);
		
		NativeQuery<Object[]> policy = session.createSQLQuery("select pname,ptenure,ptype from insurancepolicy where ptenure>=:min and ptenure<=:max");
		policy.setParameter("min", 11);
		policy.setParameter("max", 22);
		
		//policy.addEntity(InsurancePolicy.class);
		
		//binding datatypes
		policy.addScalar("pname",StandardBasicTypes.STRING);
		policy.addScalar("ptenure",StandardBasicTypes.INTEGER);
		policy.addScalar("ptype",StandardBasicTypes.STRING);

		//executing to get the result
		List<Object[]> policies=policy.getResultList();
		
		
		policies.forEach(row->{
			for(Object obj:row) {
				System.out.print(obj+"\t");
			}
			System.out.println();
		});
	}

}
