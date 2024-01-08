package com.divs.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.JobSeeker;
import com.divs.util.HibernateUtil;

public class InsertRecordApp {
	
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Integer id=null;
		byte[] photo=null;
		char[] resume=null;
		try(FileInputStream fis=new FileInputStream("C:\\Users\\Navis\\Documents\\images\\divs.JPG")){
			photo=new byte[fis.available()];
			fis.read(photo);
		}
		try {
			File f=new File("C:\\Users\\Navis\\Documents\\images\\Namakkal.txt");
			FileReader fr=new FileReader(f);
			resume=new char[(int) f.length()];
			fr.read(resume);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		    session=new HibernateUtil().getSession(session);
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			
			
			
			try {
				if(transaction!=null) {
					JobSeeker seeker =new  JobSeeker();
					seeker.setjName("dhivya");
					seeker.setjAddr("Eriyur");
					seeker.setPhoto(photo);
				    seeker.setResume(resume);
				    
				    id=(Integer) session.save(seeker);
				     flag=true;
			
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
}


