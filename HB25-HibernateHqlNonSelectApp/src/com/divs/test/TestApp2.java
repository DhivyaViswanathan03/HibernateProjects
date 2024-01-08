package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class TestApp2 {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
	
		try {
				session=HibernateUtil.getSession(session);
			    if(session!=null) {
			    
					Query<Product> query = session.createQuery("from com.divs.model.Product where pname in(:prod1 ,:prod2)");
			    	
			    	query.setParameter("prod1", "priya");
			    	query.setParameter("prod2", "divs");
			    	List<Product> list = query.list();
			    	
			    	list.forEach(System.out::println);
			    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			session.close();
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}

	
}


