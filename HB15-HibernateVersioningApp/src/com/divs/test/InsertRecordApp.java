package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.MobileCustomer;
import com.divs.util.HibernateUtil;

public class InsertRecordApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Integer id=null;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				MobileCustomer cus=new MobileCustomer();
				cus.setcMobileNo(9578773697L);
				cus.setCusName("dhivya");
				cus.setRingTone("hello hello..");
				
				
				id=(Integer)session.save(cus);
				
				
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


