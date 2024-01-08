package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.BankAccount;
import com.divs.util.HibernateUtil;

public class SelectOperationApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Long id=1L;
		Transaction trans=null;
		Boolean flag=false;
		BankAccount b=null;
		
		
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	 b=session.get(BankAccount.class,id);
		    	System.out.println("Before Modification::"+b);
		    	
		    	if(b!=null) {
		    	trans=session.beginTransaction();
		    		b.setBalance(b.getBalance()+10000);
		    		
		    		session.update(b);
		    		flag=true;
		    	}else {
		    		System.out.println("Object not exists for given id::"+id);
		    		System.exit(0);
		    	}
		    	
		    }
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				trans.commit();
				System.out.println("After updation::"+b);
			}
			session.close();
			
		}

	}

	}


