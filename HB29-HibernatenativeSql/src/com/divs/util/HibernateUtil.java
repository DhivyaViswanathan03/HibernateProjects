package com.divs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.divs.model.InsurancePolicy;

public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory=new Configuration().configure()
				.addAnnotatedClass(InsurancePolicy.class)
				.buildSessionFactory();
	}
	
	public static Session getSession(Session session) {
		if (session == null)
		session=sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory !=null) {
			sessionFactory.close();
		}
	}

}
