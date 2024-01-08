package com.divs.service;

import com.divs.dao.IStudentDao;
import com.divs.daofactory.StudentDaoFactory;
import com.divs.model.Student;

public class StudentServiceImpl implements IStudentService{
   private  IStudentDao studentDao;

	@Override
	public String save(String name, int age, String address) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.save(name, age, address);
		
	}

	@Override
	public Student findById(int sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.findById(sid);
	}

	@Override
	public String updateById(int sid, String name, int age, String address) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.updateById(sid, name, age, address);
		
	}

	@Override
	public String deleteById(int sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(sid);
	}

}
