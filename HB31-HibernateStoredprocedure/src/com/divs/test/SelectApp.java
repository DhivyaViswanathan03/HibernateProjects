package com.divs.test;

import java.io.IOException;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;

import com.divs.model.Product;
import com.divs.util.HibernateUtil;

public class SelectApp {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		Session session=null;
		try {
			session=HibernateUtil.getSession(session);
			String pname1="priya";
			String pname2="divs";
			
			ProcedureCall procedure = session.createStoredProcedureCall("GET_PRODUCT_BY_NAME",Product.class);
			procedure.registerParameter(1, String.class, ParameterMode.IN).bindValue(pname1);
			procedure.registerParameter(2, String.class, ParameterMode.IN).bindValue(pname2);
			
			List<Product> products=procedure.getResultList();
			
			products.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
