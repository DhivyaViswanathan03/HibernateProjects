package com.divs.dao;

import com.divs.model.Student;

public interface IStudentDao {
	
public String save(String name,int age,String address);
	
	public Student findById(int sid);
	
	public String updateById(int sid,String name,int age,String address);
	
	public String deleteById(int sid);
	

}
