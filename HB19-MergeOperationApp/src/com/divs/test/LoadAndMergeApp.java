package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class LoadAndMergeApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Student std=null;
		try {
			Student s=new Student();
			s.setSid(1);
			s.setSname("priyaviswa");
			s.setSage(32);
			s.setSddress("kalleri");
			
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				
				
				std=(Student)session.merge(s);
				flag=true;
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Object saved into db::"+std);
			}else {
				transaction.rollback();
			}
		}

	}

	}


