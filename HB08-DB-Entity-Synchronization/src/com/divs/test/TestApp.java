package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class TestApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		
		boolean flag=false;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			
			Student student=session.get(Student.class, 12);
			System.out.println("Record Before Updation::"+student);
			if(student!=null) {
				System.in.read();
				session.refresh(student);
				
				System.out.println("Record After updation ::"+student);
			}
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	}


