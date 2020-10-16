package com.mybatis3.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.text.DateFormatter;

import com.mybatis3.domain.Student;

public class StudentDaoDynamicSqlMain {

	public static void main(String[] args) throws ParseException {
		StudentDaoDynamicSql studentDaoDynamicSql = new StudentDaoDynamicSql();
		
		System.out.println("---------findStudents---------");
		Student student = new Student();
		System.out.println("### " + studentDaoDynamicSql.findStudents(student));
		student.setStudId(1);
		student.setEmail("pcm@gmail.com");
		student.setName("신혜원");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dob =dateFormat.parse("2000-01-01");
//		student.setDob(dob);
		System.out.println("### " + studentDaoDynamicSql.findStudents(student));
		
		System.out.println("---------updateStudentById---------");
		Student updateStudent = new Student();
		updateStudent.setStudId(1);
		updateStudent.setName("이름" + System.currentTimeMillis());
		updateStudent.setEmail(System.currentTimeMillis() + "@gmail.com");
//		updateStudent.setDob(new Date());
//		System.out.println("### " + studentDaoDynamicSql.updateStudentById(updateStudent));
		System.out.println("---------findStudensOrder---------");
		System.out.println("### " + studentDaoDynamicSql.findStudensOrder("stud_id"));
	}
}
