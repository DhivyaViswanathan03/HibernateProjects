package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class DeleteOperation2 {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		int id=13;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	Student s=session.get(Student.class, id);
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				if(s!=null) {
					session.delete(s);
					flag=true;
				}else {
					System.out.println("Record not found for deletion..");
				}
				
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}

	}

	}


