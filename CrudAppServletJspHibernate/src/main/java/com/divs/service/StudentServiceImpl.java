package com.divs.service;

import com.divs.daoFactory.StudentDaoFactory;
import com.divs.model.Student;
import com.divs.persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService{
   private  IStudentDao studentDao;

	@Override
	public String addStudent(Student s) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(s);
		
	}

	@Override
	public Student searchStudent(int sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student s) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(s);
		
	}

	@Override
	public String deleteStudent(int sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}

}
