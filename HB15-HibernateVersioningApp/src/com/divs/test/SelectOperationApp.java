package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.MobileCustomer;
import com.divs.util.HibernateUtil;

public class SelectOperationApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Integer id=1;
		Transaction trans=null;
		Boolean flag=false;
		MobileCustomer cus=null;
		
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	 cus = session.get(MobileCustomer.class, id);
		    	System.out.println("Before updation is:"+cus);
		    	trans=session.beginTransaction();
		    	if(cus!=null) {
		    		cus.setRingTone("java java..");
		    		session.update(cus);
		    		flag=true;
		    	}else {
		    		System.out.println("Object not founf for given id::"+id);
		    	}
		    	
		    }
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				trans.commit();
				System.out.println("After updation is::"+cus);
			}
			session.close();
			
		}

	}

	}


