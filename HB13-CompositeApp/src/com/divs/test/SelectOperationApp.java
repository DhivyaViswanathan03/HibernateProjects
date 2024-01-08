package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.ProgrammerProjId;
import com.divs.model.ProgrammerProjInfo;
import com.divs.util.HibernateUtil;

public class SelectOperationApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	ProgrammerProjId id=new ProgrammerProjId();
		    	id.setPid(100);
		    	id.setProjId(503);
			
		    	ProgrammerProjInfo pinfo=session.get(ProgrammerProjInfo.class, id);
				 if(pinfo!=null)
				System.out.println("The project info is::"+pinfo);
				 else
					 System.out.println("The record not found for given ID is::"+id);
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			
		}

	}

	}


