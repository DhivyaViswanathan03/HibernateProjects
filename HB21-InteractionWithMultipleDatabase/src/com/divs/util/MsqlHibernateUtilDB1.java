package com.divs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.divs.model.Product;

public class MsqlHibernateUtilDB1 {
	private static SessionFactory sessionFactory=null;
	
	private static Session session = null;

	
	static {
		sessionFactory=new Configuration().configure("com/divs/cfg/Mysql-hibernate-db1.cfg.xml")
				.addAnnotatedClass(Product.class).buildSessionFactory();
	}
	
	public static Session getSession() {
		if(session==null) {
			session=sessionFactory.openSession();
		}
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
	
	public static void startup() {
		System.out.println("HibernateUtil.startup()....");
	}

}
