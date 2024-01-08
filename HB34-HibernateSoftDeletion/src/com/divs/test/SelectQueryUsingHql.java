package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.divs.model.BankAccount;
import com.divs.util.HibernateUtil;

public class SelectQueryUsingHql {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			
			Query<BankAccount> query=session.createQuery("from com.divs.model.BankAccount");
			List<BankAccount> accounts=query.getResultList();
			
			accounts.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
