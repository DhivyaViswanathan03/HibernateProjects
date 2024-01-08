package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class MergeRecordApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Student std1=null;
		Student std2=null;
		Student std3=null;
		try {
			
			
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				std1=session.get(Student.class, 1);
				System.out.println("After loading ::"+std1);
				std2=new Student();
				std2.setSid(1);
				std2.setSname("dhivya");
				std2.setSage(32);
				std2.setSddress("dharmapuri");
				
				
				
				std3=(Student)session.merge(std2);
				flag=true;
				
				System.out.println(std1.hashCode()+">>>"+std2.hashCode()+">>>"+std3.hashCode());
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("After saving::"+std3);
			}else {
				transaction.rollback();
			}
		}

	}

	}


