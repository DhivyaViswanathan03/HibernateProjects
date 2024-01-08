package com.divs.test;

import java.util.List;

import com.divs.model.Insurancepolicy;
import com.divs.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class SelectApp {
	private static Session session=null;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			session=HibernateUtil.getSession();
			Query<Insurancepolicy> query=session.createQuery("from com.divs.model.Insurancepolicy");
			List<Insurancepolicy> policies=query.getResultList();
			policies.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
