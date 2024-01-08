package com.divs.test;

import java.io.IOException;

import com.divs.model.Address;
import com.divs.model.StudentInfo;
import com.divs.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertApp {
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		String id;
		try {
		    session=new HibernateUtil().getSession();
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				Address addr1=new Address();
				addr1.setCityName("namakkal");
				addr1.setCountryName("IN");
				addr1.setStateName("TamilNadu");
			
				StudentInfo student1=new StudentInfo();
				student1.setSname("priya");
				student1.setSage(31);
				student1.setAddress(addr1);
				
				Address addr2=new Address();
				addr2.setCityName("Dharamapuri");
				addr2.setCountryName("IN");
				addr2.setStateName("TamilNadu");
			
				StudentInfo student2=new StudentInfo();
				student2.setSname("reka");
				student2.setSage(33);
				student2.setAddress(addr2);
				
				session.save(student1);
				session.save(student2);
				flag=true;
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Objects saved into DB..");
			}else {
				transaction.rollback();
				System.out.println("Objects not saved in DB");
			}
			session.close();
			
		}

	}
}
