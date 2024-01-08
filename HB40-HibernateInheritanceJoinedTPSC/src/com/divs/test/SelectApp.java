package com.divs.test;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;

import com.divs.model.CardPayment;
import com.divs.model.ChequePayment;
import com.divs.model.Payment;
import com.divs.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SelectApp {
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
				
				Query query=session.createQuery("from com.divs.model.Payment");
				List<Payment> payments=query.getResultList();
				payments.forEach(System.out::println);
				
				System.out.println();
				
				Query query1=session.createQuery("from com.divs.model.CardPayment");
				List<CardPayment> payments1=query1.getResultList();
				payments1.forEach(System.out::println);
				
                System.out.println();
				
				Query query2=session.createQuery("from com.divs.model.ChequePayment");
				List<ChequePayment> payments2=query2.getResultList();
				payments2.forEach(System.out::println);
				
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
