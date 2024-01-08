package com.divs.test;

import java.io.IOException;

import org.hibernate.Session;

import com.divs.model.PersonInfo;
import com.divs.util.HibernateUtil;

public class SelectOperationApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Integer id=1;
		
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	
		    	PersonInfo p=session.get(PersonInfo.class, id);
		    	if (p != null) {
					System.out.println(p);
				}else {
					System.out.println("Object not found for given ID is::"+id);
				}
		    }
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			
		}

	}

	}


