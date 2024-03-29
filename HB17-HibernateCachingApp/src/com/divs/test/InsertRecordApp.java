package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Insurancepolicy;
import com.divs.util.HibernateUtil;

public class InsertRecordApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Long id=null;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
			
				Insurancepolicy in=new Insurancepolicy();
				
				in.setPolicyName("HDFC");
				in.setPolicyType("MONEY BANK");
				
				id=(Long)session.save(in);
				flag=true;
				}
		    }
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Object ID is::: "+id);
			}else {
				transaction.rollback();
			}
			session.close();
			
		}

	}

	}


