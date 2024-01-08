package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.divs.model.BankAccount;
import com.divs.util.HibernateUtil;

public class SelectAppUsingCriterianApi {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			
			session=HibernateUtil.getSession(session);
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_BY_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");
			
			Criteria criteria = session.createCriteria(BankAccount.class);
			Criterion  cond1 = Restrictions.ge("balance", 30000.0f);
			
			criteria.add(cond1);
			
			List<BankAccount> accounts=criteria.list();
			accounts.forEach(System.out::println);
			
			session.disableFilter("FILTER_BANK_ACCOUNT_BY_STATUS");
			
			Criteria criteria1 = session.createCriteria(BankAccount.class);
			Criterion  cond2 = Restrictions.ge("balance", 30000.0f);
			
			criteria1.add(cond2);
			
			List<BankAccount> accounts1=criteria1.list();
			accounts1.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
