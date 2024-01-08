package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class DeleteApp {

	@SuppressWarnings({ "unchecked", "null" })
	public static void main(String args[]) throws IOException {
		Session session = null;
		int count = 0;
		boolean flag = false;
		Transaction tran = null;
		int id=6;

		try {
			session = HibernateUtil.getSession(session);
			if (session != null) {
				tran=session.beginTransaction();
				Query query = session
						.createQuery("DELETE FROM com.divs.model.Product  WHERE pid=:id");
				query.setParameter("id", id);
				count = query.executeUpdate();
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
             if(flag) {
            	 tran.commit();
            	 System.out.println("No of rows affected is ::"+count);
             }else {
            	 tran.rollback();
            	 System.out.println("No of rows affected is::"+count);
             }
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}

	}

}
