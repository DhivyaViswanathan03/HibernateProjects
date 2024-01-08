package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.divs.model.Student;

public class TestApp {
	
	public static void main(String args[]) throws IOException {
		//1.INFORM JVN TO ACTIVATE HIBERNATE
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml").buildSessionFactory();
		//2.CREATING A SESSION FACTORY OBJECT TO HOLD MANY OTHER OBJECT REQUIRED FOR HIBERNATE
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//3.USING SESSION FACTORY OBJECT ,GET ONLY ONE SESSION OBJECT
		//TO PERFORM OUR PERSISTENCE LOGIC
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student s=new Student();
		s.setSid(1);
		s.setSname("dhivya");
		s.setSage(20);
		s.setSddress("eriyur");
		
		
		//PERFORM PERSISTENCE LOGIC USING POJO/MODEL
		session.save(s);
		
		System.in.read();
		
		//Commit the operation base don result
		transaction.commit();
		
		
		session.close();
		
		sessionFactory.close();
		
		
		
		
	}

}
