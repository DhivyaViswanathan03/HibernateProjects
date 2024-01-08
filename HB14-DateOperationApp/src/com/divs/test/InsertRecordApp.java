package com.divs.test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.PersonInfo;
import com.divs.util.HibernateUtil;

public class InsertRecordApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Integer id=null;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				PersonInfo pInfo=new PersonInfo();
				pInfo.setPname("dhivya");
				pInfo.setDob(LocalDate.of(1993, 06, 30));
				pInfo.setDom(LocalDateTime.of(2021, 2, 15, 7, 30));
				pInfo.setDoj(LocalTime.of(3, 20));
				id= (Integer)session.save(pInfo);
				
				flag=true;
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Object ID is::: "+id);
			}else {
				transaction.rollback();
			}
			session.close();
			
		}

	}

	}


