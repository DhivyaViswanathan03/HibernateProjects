package com.divs.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao{
	
	
	Session session=new HibernateUtil().getSession();
	
	@Override
	public String save(String name, int age, String address)  {
		Boolean flag=false;
		String status="";
		Transaction trans=session.beginTransaction();
		try {
			if(trans!=null) {
				Student s=new Student();
				s.setSname(name);
				s.setSage(age);
				s.setSddress(address);
				
				session.save(s);
				flag=true;
			}
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				trans.commit();
				status= "success";
			}else {
				trans.rollback();
				status= "failure";
			}
		}
		
		return status;
	}

	@Override
	public Student findById(int sid) {
    Student s=session.get(Student.class, sid);
    if(s!=null) {
	 return s;
     }else {
    	  return null; 
      }	
	}

	@Override
	public String updateById(int sid, String name, int age, String address) {
		Transaction trans=session.beginTransaction();
		Boolean flag=false;
		String status="";
		try {
			if(trans!=null) {
				Student s=new Student();
				s.setSid(sid);
				s.setSname(name);
				s.setSage(age);
				s.setSddress(address);
				
				session.merge(s);
				flag=true;
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				trans.commit();
				status= "success";
			}else {
				trans.rollback();
				status= "failed";
			}
		}
		return status;
	}

	@Override
	public String deleteById(int sid) {
		Student s=findById(sid);
		Boolean flag=false;
		String status="";
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			if(trans!=null) {
				if(s!=null) {
					session.delete(s);
					flag=true;
				}
			}
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			if(flag) {
				trans.commit();
				status= "success";
			}else {
				trans.rollback();
				status= "not found";
			}
		}

		return status;
	}

}
