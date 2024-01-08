package com.divs.persistence;

import com.divs.model.Student;

public interface IStudentDao {
	
public String addStudent(Student s);
	
	public Student searchStudent(int sid);
	
	
	
	public String deleteStudent(int sid);

	public String updateStudent(Student student);
	

}
