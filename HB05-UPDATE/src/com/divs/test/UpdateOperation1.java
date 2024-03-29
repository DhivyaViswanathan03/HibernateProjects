package com.divs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class UpdateOperation1 {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				Student s=new Student();
				s.setSid(99);
				s.setSname("dhivyamouli");
				s.setSage(30);
				s.setSddress("Eriyur");
				
				session.update(s);
				flag=true;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}

	}

}
