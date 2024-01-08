package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.ProgrammerProjId;
import com.divs.model.ProgrammerProjInfo;
import com.divs.util.HibernateUtil;

public class InsertRecordApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		ProgrammerProjId id=null;
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				ProgrammerProjId pid=new ProgrammerProjId();
				pid.setPid(100);
				pid.setProjId(502);
				 ProgrammerProjInfo pInfo=new ProgrammerProjInfo();
				 pInfo.setId(pid);
				 pInfo.setDepNo(11);
				 pInfo.setpName("IPL");
				 pInfo.setProjName("AUS");
				 
				id= (ProgrammerProjId)session.save(pInfo);
				
				flag=true;
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Student id is::: "+id);
			}else {
				transaction.rollback();
			}
			session.close();
			
		}

	}

	}


