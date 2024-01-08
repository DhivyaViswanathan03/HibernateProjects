package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.divs.util.HibernateUtil;

public class SelectApp {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		session=HibernateUtil.getSession(session);
		
		NativeQuery<Object[]> policy = session.getNamedNativeQuery("SELECT_QUERY");
		policy.setParameter(1, "monthly");
		

		List<Object[]> policies=policy.getResultList();
		
		System.out.println("PID\tPNAME\tPTENURE\tPTYPE");
		policies.forEach(row->{
			for(Object obj:row) {
				System.out.print(obj+"\t");
			}
			System.out.println();
		});
	}

}
