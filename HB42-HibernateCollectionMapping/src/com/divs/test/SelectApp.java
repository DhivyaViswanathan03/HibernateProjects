package com.divs.test;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;

import com.divs.model.Employee;
import com.divs.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SelectApp {
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws IOException {
		Session session=null;
		
		
		try {
		    session=new HibernateUtil().getSession();
		    if(session!=null) {
		    	Query query=session.createQuery("from com.divs.model.Employee");
		    	List<Employee> emps=query.getResultList();
		    	emps.forEach(System.out::println);
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
