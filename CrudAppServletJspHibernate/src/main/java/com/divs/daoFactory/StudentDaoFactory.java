package com.divs.daoFactory;

import com.divs.persistence.IStudentDao;
import com.divs.persistence.StudentDaoImpl;

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
