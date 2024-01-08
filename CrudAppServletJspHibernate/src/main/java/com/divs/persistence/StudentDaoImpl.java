package com.divs.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divs.model.Student;
import com.divs.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {
	Session session = HibernateUtil.getSession();
	Transaction tran = null;
	boolean flag = false;

	@SuppressWarnings("finally")
	@Override
	public String addStudent(Student s) {
		tran = session.beginTransaction();
		try {
			session.save(s);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tran.commit();
				return "success";
			} else {
				tran.rollback();
				return "failure";
			}
		}

	}

	@Override
	public Student searchStudent(int sid) {
		return session.get(Student.class, sid);

	}

	@SuppressWarnings("finally")
	@Override
	public String updateStudent(Student student) {
		tran = session.beginTransaction();
		try {
			session.merge(student);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tran.commit();
				return "success";
			} else {
				tran.rollback();
				return "failure";
			}
		}

	}

	@SuppressWarnings("finally")
	@Override
	public String deleteStudent(int sid) {
		tran = session.beginTransaction();
		Student student = searchStudent(sid);
		if (student != null) {
			try {

				session.delete(student);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (flag) {
					tran.commit();
					return "success";
				} else {
					tran.rollback();
					return "failed";
				}
			}
		} else {
			return "not found";
		}
	}

}
