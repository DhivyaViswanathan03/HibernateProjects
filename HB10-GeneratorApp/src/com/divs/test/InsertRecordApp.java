package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.divs.model.StudentTable;
import com.divs.util.HibernateUtil;

public class InsertRecordApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Integer id;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				StudentTable s=new StudentTable();
				s.setSage(39);
				s.setSddress("Kaleri");
				s.setSname("priya");
				
				id=(Integer)session.save(s);
				System.out.println("Student id is::: "+id);
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
			session.close();
			
		}

	}

	}


