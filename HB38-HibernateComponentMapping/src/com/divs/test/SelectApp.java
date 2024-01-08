package com.divs.test;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;

import com.divs.model.Address;
import com.divs.model.StudentInfo;
import com.divs.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SelectApp {
	@SuppressWarnings({ "static-access", "unchecked" })
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
				
				Query query=session.createQuery("from com.divs.model.StudentInfo where address.cityName=:city");
				query.setParameter("city", "namakkal");
				List<StudentInfo> studentInfo=query.getResultList();
			studentInfo.forEach(System.out::println);
				
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}
}
