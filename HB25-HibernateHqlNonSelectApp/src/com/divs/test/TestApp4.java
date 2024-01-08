package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class TestApp4 {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
				session=HibernateUtil.getSession(session);
			    if(session!=null) {
			    
					
					Query<Integer> query = session.createQuery("select price from com.divs.model.Product where pname in(:prod1 ,:prod2)");
			    	
			    	query.setParameter("prod1", "priya");
			    	query.setParameter("prod2", "divs");
//			    	List<Integer> list = query.list();
			    	List<Integer> list = query.getResultList();
			    	System.out.println("PRICE");
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


