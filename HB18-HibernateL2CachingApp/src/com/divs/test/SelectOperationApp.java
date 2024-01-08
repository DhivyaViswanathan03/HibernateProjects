package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Insurancepolicy;
import com.divs.util.HibernateUtil;

public class SelectOperationApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Long id=1L;
		Transaction trans=null;
		Boolean flag=false;

		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	Insurancepolicy policy1=session.get(Insurancepolicy.class, 1L);
		    	System.out.println(policy1);
		    	System.out.println("................");
		    	
		    	Insurancepolicy policy2=session.get(Insurancepolicy.class, 1L);
		    	System.out.println(policy2);
		    	System.out.println("................");

		    	
		    	session.evict(policy1);
		    	
		    	Insurancepolicy policy3=session.get(Insurancepolicy.class, 1L);
		    	System.out.println(policy3);
		    	System.out.println("................");
		    	
		    	session.clear();
		    	
		    	Thread.sleep(20000);
		    	
		    	System.out.println();
		    	
		    	Insurancepolicy policy4=session.get(Insurancepolicy.class, 1L);
		    	System.out.println(policy4);
		    	System.out.println("................");
		    	
		    	
		    	
		    	
		    	
		    }
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			session.close();
			
		}

	}

	}


