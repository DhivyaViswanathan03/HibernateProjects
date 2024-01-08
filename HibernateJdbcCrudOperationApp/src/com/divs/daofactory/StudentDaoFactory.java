package com.divs.daofactory;

import com.divs.dao.IStudentDao;
import com.divs.dao.StudentDaoImpl;

public class StudentDaoFactory {
	
	private StudentDaoFactory() {
		
	}
	
    private static IStudentDao studentDao=null;
    
    public static IStudentDao getStudentDao() {
    	if(studentDao==null) {
    		studentDao=new StudentDaoImpl();
    	}
    	return studentDao;
    }

}
