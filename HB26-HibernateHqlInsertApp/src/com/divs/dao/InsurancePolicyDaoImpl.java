package com.divs.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.divs.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements IInsurancePolicyDao {
private static final String HQL_TRANSFER_POLICY=
"insert into com.divs.model.InsurancePremiumPolicy(pid,pname,ptype,ptenure)select i.pid,i.pname,i.ptype,i.ptenure from com.divs.model.InsurancePolicy as i where i.ptenure>=:min";
	@Override
	public String transerPolicy(Integer tenure) {
		Session session=null;
		Transaction tran=null;
		boolean flag=false;
		
		int transferedResult=0;
		String message="";
		try {
			session=HibernateUtil.getSession(session);
			tran=session.beginTransaction();
			Query query=session.createQuery(HQL_TRANSFER_POLICY);
			query.setParameter("min", tenure);
			transferedResult = query.executeUpdate();
			
			flag=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				tran.commit();
				message= "no of rows affected::"+transferedResult;
			}else {
				tran.rollback();
				message= "failed";
			}
			
		}
		
		return message;
	}

}
