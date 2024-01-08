package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class TestApp5 {
	
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			Criteria criteria = session.createCriteria(Product.class);
			ProjectionList list = Projections.projectionList();
			list.add(Projections.property("pname"));
			list.add(Projections.property("price"));
			
			criteria.setProjection(list);
			
			Criterion cond1 = Restrictions.between("price", 20000,80000);
			Criterion cond2=Restrictions.in("pname", "priya","divs","hello");
			Criterion cond3=Restrictions.ilike("pname", "k%");
			
			Criterion cond4=Restrictions.or(Restrictions.and(cond1, cond2),cond3);
			
			criteria.add(cond4);
			
			
			Order order = Order.asc("price");
			criteria.addOrder(order);
			
			List<Object[]> products=criteria.list();
			
			System.out.println("PNAME\tPRICE");
			products.forEach(row->{
				for(Object obj:row) {
				System.out.print(obj+"\t");
				}
				System.out.println();
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
