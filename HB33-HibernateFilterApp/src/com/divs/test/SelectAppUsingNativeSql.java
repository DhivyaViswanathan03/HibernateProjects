package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.divs.model.BankAccount;
import com.divs.util.HibernateUtil;

public class SelectAppUsingNativeSql {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_BY_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");
			
			NativeQuery<BankAccount> nQuery=session.createSQLQuery("select * from bankaccount where balance>=:amt");
			nQuery.setParameter("amt", 30000.0f);
			
			nQuery.addEntity(BankAccount.class);
			
			List<BankAccount> accounts=nQuery.list();
			
			accounts.forEach(System.out::println);
			
			session.disableFilter("FILTER_BANK_ACCOUNT_BY_STATUS");
			
			NativeQuery<BankAccount> query1=session.createSQLQuery("select * from bankaccount where balance>=:amt");
			query1.setParameter("amt", 30000.0f);
			query1.addEntity(BankAccount.class);
			
			List<BankAccount> accounts1=query1.list();
			
			accounts1.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
