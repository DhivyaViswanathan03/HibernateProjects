package com.divs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class UpdateOperation2 {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		int id=15;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			Student student=session.get(Student.class, id);
			if(transaction!=null) {
				if(student!=null) {
					student.setSage(32);
		            session.update(student);
				flag=true;
			}
				else {
					System.out.println("Record not available for given id::"+id);
				}
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
