package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class TestApp {
	
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			
			Criteria criteria = session.createCriteria(Product.class);
			List<Product> products=criteria.list();
			products.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
