package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class TestApp3 {
	
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			
			Criteria criteria = session.createCriteria(Product.class);
			
			Criterion cond1 = Restrictions.ge("price", 20000);
			Criterion cond2=Restrictions.le("price",80000);
			
			criteria.add(cond1);
			criteria.add(cond2);
			
			Order order = Order.asc("pname");
			criteria.addOrder(order);
			
			List<Product> products=criteria.list();
			products.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
