package org.student.service;

import org.student.dao.StudentDao;
import org.student.entity.Student;

public class StudentService {
	StudentDao studentDao=new StudentDao();
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getId())) {
			studentDao.addStudent(student);
			return true;
		}else {
			return false;
		}
	}
}
