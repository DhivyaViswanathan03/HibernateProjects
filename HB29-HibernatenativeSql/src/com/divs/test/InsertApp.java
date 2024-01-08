package com.divs.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.divs.model.InsurancePolicy;
import com.divs.util.HibernateUtil;

public class InsertApp {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		int rowaffected=0;
		session=HibernateUtil.getSession(session);
		boolean flag=false;
		Transaction tran=null;
		try {
			tran=session.beginTransaction();
			NativeQuery<?> query = session.createSQLQuery("insert into insurancepolicy(`pname`,`ptenure`,`ptype`)values(?,?,?)");
			query.setParameter(1, "prudential");
			query.setParameter(2, 12);
			query.setParameter(3, "ICICI");
			
			rowaffected=query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				tran.commit();
				System.out.println("Row affected is::"+rowaffected);
			}else {
				tran.rollback();
				System.out.println("No rows affected..");
			}
		}
		
		
	}

}
