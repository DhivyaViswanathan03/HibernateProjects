package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class DeleteOperation1 {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				Student s=new Student();
				s.setSid(122);
				
				session.delete(s);
				flag=true;
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


