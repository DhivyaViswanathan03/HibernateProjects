package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.divs.model.Student;

public class TestApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		SessionFactory sessionFactory=null;
		Configuration configuration=null;
		
		boolean flag=false;
		try {
		    configuration=new Configuration();
		    configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		    configuration.setProperty("hibernate.connection.url", "jdbc:mysql:///divs");
		    configuration.setProperty("hibernate.connection.username", "root");
		    configuration.setProperty("hibernate.connection.password", "Welcome@123");
		    configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		    configuration.setProperty("hibernate.show_sql", "true");
		    configuration.setProperty("hibernate.format_sql", "true");
		    configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		    //configuration.configure();
		    configuration.addAnnotatedClass(Student.class);
		    sessionFactory=configuration.buildSessionFactory();
		    session=sessionFactory.openSession();
		    if(session!=null) {
			
			Student student=session.get(Student.class, 12);
			
			if(student!=null) {
			System.out.println("Student Record :: "+student);
			}
				sessionFactory.close();
				session.close();
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	}


