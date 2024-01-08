package com.divs.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Product;
import com.divs.util.MsqlHibernateUtilDB1;
import com.divs.util.MsqlHibernateUtilDB2;

public class TransferDaoImpl implements ITransferDao {

	@SuppressWarnings("finally")
	@Override
	public String transferById(int pid) {
		Session mysqlDb1Session=null;
		Session mysqlDb2Session=null;
		boolean flag=false;
		Transaction trans=null;
		Integer id=0;
		mysqlDb1Session=MsqlHibernateUtilDB1.getSession();
		
		
		Product p=mysqlDb1Session.get(Product.class, pid);
		if(p == null) {
			return "Record not available for copying..";
		}else {
			mysqlDb2Session=MsqlHibernateUtilDB2.getSession();
			
			try {
				trans=mysqlDb2Session.beginTransaction();
				id=(Integer)mysqlDb2Session.save(p);
				flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(flag) {
					trans.commit();
					return "Object saved into db2 with ID::"+id;
				}else {
					trans.rollback();
					return "Object not saved into db2 with given id::"+id;
				}
			}
		}
		
		
	}

}
