package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class TestApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;

		try {
				session=HibernateUtil.getSession(session);
			    if(session!=null) {
			    	
			    	Query<Product> query = session.createQuery("from com.divs.model.Product");
			    	
			    	List<Product> list = query.list();
			    	
			    	list.forEach(System.out::println);
			    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}

	
}


