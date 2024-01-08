package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.divs.model.BankAccount;
import com.divs.util.HibernateUtil;

public class SelectQuerynativeSql {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			
			NativeQuery<BankAccount> query=session.createSQLQuery("select * from bankaccount");
			
			query.addEntity(BankAccount.class);
			List<BankAccount> accounts=query.getResultList();
			
			accounts.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
