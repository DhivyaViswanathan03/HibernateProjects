package com.divs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.divs.model.PersonInfo;

public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory=new Configuration().configure()
				.addAnnotatedClass(PersonInfo.class)
				.buildSessionFactory();
	}
	
	public Session getSession(Session session) {
		if (session == null)
		session=sessionFactory.openSession();
		return session;
	}
	
	public void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	
	public void closeSessionFactory() {
		if(sessionFactory !=null) {
			sessionFactory.close();
		}
	}

}
