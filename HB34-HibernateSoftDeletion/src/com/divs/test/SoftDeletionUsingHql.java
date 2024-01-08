package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.divs.model.BankAccount;
import com.divs.util.HibernateUtil;

public class SoftDeletionUsingHql {
	
	
	@SuppressWarnings({ "unchecked", "null" })
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction tran=null;
		boolean flag=false;
		int rowAffected=0;
		try {
			session=HibernateUtil.getSession(session);
			tran=session.beginTransaction();
			
			Query query=session.createQuery("DELETE from com.divs.model.BankAccount where accNo=:accno");
			query.setParameter("accno", 467);
			
			rowAffected=query.executeUpdate();
			flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				tran.commit();
				System.out.println("no of rows affected is::"+rowAffected);
			}else {
				tran.rollback();
				System.out.println("failed");
			}
		}

	}

}
