package com.divs.servicefactory;

import com.divs.service.IStudentService;
import com.divs.service.StudentServiceImpl;

public class StudentServiceFactory {

	private StudentServiceFactory() {
		
	}
	private static IStudentService studentService=null;
	
	public static IStudentService getStudentService(){
		if(studentService==null) {
			studentService=new StudentServiceImpl();
		}
		return studentService;
	}
}
