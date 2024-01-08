package com.divs.service;

import com.divs.model.Student;

public interface IStudentService {
	
	public String addStudent(Student s);
	
	public Student searchStudent(int sid);
	
	public String updateStudent(Student s);
	
	public String deleteStudent(int sid);
	

}
