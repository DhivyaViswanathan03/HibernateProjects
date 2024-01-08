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
		    	
		    	Insurancepolicy policy3=session.get(Insurancepolicy.class, 1L);
		    	System.out.println(policy3);
		    	System.out.println("................");
		    	
		    	session.evict(policy1);
		    	
		    	Insurancepolicy policy4=session.get(Insurancepolicy.class, 1L);
		    	System.out.println(policy4);
		    	System.out.println("................");
		    	
		    	Insurancepolicy policy5=session.get(Insurancepolicy.class, 1L);
		    	System.out.println(policy5);
		    	System.out.println("................");
		    	
		    	
		    	
		    	Insurancepolicy policy6=session.get(Insurancepolicy.class, 2L);
		    	System.out.println(policy6);
		    	System.out.println("................");
		    	
		    	Insurancepolicy policy7=session.get(Insurancepolicy.class, 2L);
		    	System.out.println(policy7);
		    	System.out.println("................");
		    	
		    	session.clear();
		    	
		    	Insurancepolicy policy8=session.get(Insurancepolicy.class, 1L);
		    	System.out.println(policy8);
		    	System.out.println("................");
		    	
		    	Insurancepolicy policy9=session.get(Insurancepolicy.class, 2L);
		    	System.out.println(policy9);
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


