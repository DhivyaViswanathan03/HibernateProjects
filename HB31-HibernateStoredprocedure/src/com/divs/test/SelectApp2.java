package com.divs.test;

import java.io.IOException;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class SelectApp2 {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			session=HibernateUtil.getSession(session);
			Integer pid=2;
			
			
			ProcedureCall procedure = session.createStoredProcedureCall("GET_PRODUCTS_DETAILS_BY_ID",Product.class);
			procedure.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(pid);
			procedure.registerParameter(2, String.class, ParameterMode.OUT);
			procedure.registerParameter(3, Integer.class, ParameterMode.OUT);
			procedure.registerParameter(4, Integer.class, ParameterMode.OUT);
			
			String pname=(String) procedure.getOutputParameterValue(2);
			Integer price=(Integer) procedure.getOutputParameterValue(3);
			Integer qty=(Integer) procedure.getOutputParameterValue(4);
			
			System.out.println("PNAME\tPRICE\tQTY");
			System.out.println(pname+"\t"+price+"\t"+qty);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
