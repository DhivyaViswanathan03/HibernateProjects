package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class TestApp5 {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		int id=3;
		try {
				session=HibernateUtil.getSession(session);
			    if(session!=null) {
			    
					
					Query<Product> query = session.createQuery("from com.divs.model.Product where pid=:id");
			    	
			    	query.setParameter("id", id);
			    	
			    	List<Product> products = query.list();
			    	System.out.println(products.size());
			    	if(!products.isEmpty()) {
			    		System.out.println(products.get(0));
			    	}else {
			    		System.out.println("Not found for given id::"+id);
			    	}
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


