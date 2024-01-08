package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.divs.model.BankAccount;
import com.divs.util.HibernateUtil;

public class SoftDeletionApp {
	
	
	@SuppressWarnings({ "unchecked", "null" })
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction tran=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession(session);
			tran=session.beginTransaction();
			
			BankAccount b=new BankAccount();
			b.setAccNo(234);
			
			session.delete(b);
			flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				tran.commit();
				System.out.println("Soft deletion done");
			}else {
				tran.rollback();
				System.out.println("failed");
			}
		}

	}

}
