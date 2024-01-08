package com.divs.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.InsurancePolicy;
import com.divs.util.HibernateUtil;

public class InsertRecordApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Integer id=null;
		
		
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();

			try {
				if(transaction!=null) {
					
					InsurancePolicy isurancePolicy=new InsurancePolicy();
					isurancePolicy.setPname("MONEY");
					isurancePolicy.setPtype("yearly");
					isurancePolicy.setPtenure(5);
					
					id=(Integer) session.save(isurancePolicy);
				     flag=true;
			
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
}


