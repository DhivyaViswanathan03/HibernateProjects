package com.divs.test;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.Session;

import com.divs.model.JobSeeker;
import com.divs.util.HibernateUtil;

public class SelectOperationApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Integer id=1;
		JobSeeker seeker=null;
		
		try {
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
		    	seeker=session.get(JobSeeker.class, id);
		    	
		    	if(seeker !=null) {
		    		
		    		seeker.getjId();
		    		seeker.getjName();
		    		seeker.getjAddr();
		    		
		    		try(FileOutputStream fos=new FileOutputStream("./store/divs.jpg");
		    				FileWriter fw=new FileWriter("./store/resume.txt")){
		    			fos.write(seeker.getPhoto());
		    			fw.write(seeker.getResume());
		    			
		    		}
		    	}else {
		    		System.out.println("Object not found for given id::"+id);
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


