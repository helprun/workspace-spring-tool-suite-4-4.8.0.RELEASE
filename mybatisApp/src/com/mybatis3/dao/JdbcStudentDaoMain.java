package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class JdbcStudentDaoMain {

	public static void main(String[] args) {
		JdbcStudentDao jdbcStudentDao = new JdbcStudentDao();
		System.out.println("----findStudentById---");
		Student existingStudent = jdbcStudentDao.findStudentById(1);
		System.out.println(">>> "+existingStudent);
		System.out.println("----createStudent---");
		long ts = System.currentTimeMillis();// For creating unique student
		Student newStudent = new Student(0000, "student_" + ts, "student_" + ts + "@gmail.com", new Date());
		jdbcStudentDao.createStudent(newStudent);
		System.out.println(">>>"+newStudent);
		
		System.out.println("----updateStudent---");
		int updateStudId = 4;
		Student updateStudent = jdbcStudentDao.findStudentById(updateStudId);
		ts = System.currentTimeMillis();// For creating unique student email
		updateStudent.setEmail("student_" + ts + "@gmail.com");
		jdbcStudentDao.updateStudent(updateStudent);
		System.out.println(">>>"+updateStudent);

	}

}
