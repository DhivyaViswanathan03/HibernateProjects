package com.divs.service;

import com.divs.model.Student;

public interface IStudentService {
	
	public String save(String name,int age,String address);
	
	public Student findById(int sid);
	
	public String updateById(int sid,String name,int age,String address);
	
	public String deleteById(int sid);
	

}
