package com.divs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.divs.model.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	
	private static Session session = null;

	
	static {
		sessionFactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}
	
	public Session getSession() {
		if(session==null) {
			session=sessionFactory.openSession();
		}
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
	
	public static void startup() {
		System.out.println("HibernateUtil.startup()....");
	}

}
