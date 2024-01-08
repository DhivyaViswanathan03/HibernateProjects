package com.divs.controller;

import java.io.IOException;

import com.divs.dao.ITransferDao;
import com.divs.dao.TransferDaoImpl;
import com.divs.util.MsqlHibernateUtilDB1;
import com.divs.util.MsqlHibernateUtilDB2;

public class InterationWithMultpileDb {
	
	public static void main(String args[]) throws IOException {
		
		ITransferDao transfer=new TransferDaoImpl();
		System.out.println(transfer.transferById(12));
		
		MsqlHibernateUtilDB1.closeSessionFactory();
		MsqlHibernateUtilDB2.closeSessionFactory();
		
		
	}

}

