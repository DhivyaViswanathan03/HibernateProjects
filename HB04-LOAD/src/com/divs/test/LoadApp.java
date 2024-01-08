package com.divs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		Session session=null;
		int id=99;
		
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	
		    	Student student=session.load(Student.class, id);
		    	if(student!=null) {
		    		System.out.println("student id is::"+student.getSid());
		    		System.in.read();
		    		System.out.println("student name is::"+student.getSname());
		    		System.out.println("student age is ::"+student.getSage());
		    		System.out.println("student address is ::"+student.getSddress());
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
