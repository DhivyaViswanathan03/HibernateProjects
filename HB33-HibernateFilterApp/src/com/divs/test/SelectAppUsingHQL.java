package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.divs.model.BankAccount;
import com.divs.util.HibernateUtil;

public class SelectAppUsingHQL {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_BY_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");
			Query<BankAccount> query=session.createQuery("from com.divs.model.BankAccount where balance>=:amt");
			query.setParameter("amt", 25000.0f);
			
			List<BankAccount> accounts=query.list();
			
			accounts.forEach(System.out::println);
			
			session.disableFilter("FILTER_BANK_ACCOUNT_BY_STATUS");
			
			Query<BankAccount> query1=session.createQuery("from com.divs.model.BankAccount where balance>=:amt");
			query1.setParameter("amt", 30000.0f);
			
			List<BankAccount> accounts1=query1.list();
			
			accounts1.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
