package com.divs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class GetApp {

	public static void main(String[] args) {
		Session session=null;
		int id=13;
		
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	
		    	Student student=session.get(Student.class, id);
		    	if(student!=null) {
		    		System.out.println(student);
		    	}else {
		    		System.out.println("Record not found for given id::"+id);
		    	}
			
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
