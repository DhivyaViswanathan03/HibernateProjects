package com.divs.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.divs.model.Employee;
import com.divs.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertApp {
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		String id;
		try {
		    session=new HibernateUtil().getSession();
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				
				Employee e=new Employee();
				e.setEid(101);
				e.setEname("divs");
				e.setEaddress("namakkal");
				
				e.setFriends(List.of("priya","reka","mouli"));
				e.setMobiles(Set.of(999888777L,888777666L,999777555L));
				e.setAccounts(Map.of("ICICI",1234L,"SBI",3456L,"HDFC",2313L));
				session.save(e);
				flag=true;
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Objects saved into DB..");
			}else {
				transaction.rollback();
				System.out.println("Objects not saved in DB");
			}
			session.close();
			
		}

	}
}
