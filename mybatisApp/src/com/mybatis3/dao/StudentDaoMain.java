package com.mybatis3.dao;

import java.util.Date;
import java.util.HashMap;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		
		System.out.println("-------findStudentById-------");
		System.out.println(studentDao.findStudentById(3));
		
		System.out.println("---------findAllStudents---------");
		System.out.println(studentDao.findAllStudents());
		System.out.println("-------findStudentByIdMap-------");
		
		System.out.println("-------findStudentByIdResultMap-------");
		System.out.println(studentDao.findStudentByIdResultMap(1));
		
		System.out.println("---------insertStudent(Dto)--------------");
		//Student student1 = new Student(8000, "김팔천", "eight@gmail.com", new Date());
//		System.out.println("### " + studentDao.insertStudent(student1));
		
		System.out.println("---------insertStudentBySequence1---------");
		Student student2 = new Student(null, "시퀀스1", "seq1@gmail.com", new Date());
//		System.out.println(studentDao.insertStudentBySequence1(student2));
		System.out.println("insert PK -->" + student2.getStudId());
		
		System.out.println("---------insertStudentBySequence2---------");
		Student student3 = new Student(null, "시퀀스2", "seq2@gmail.com", new Date());
		System.out.println(studentDao.insertStudentBySequence2(student3));
		System.out.println("isnert PK -->" + student3.getStudId());
		
		System.out.println("---------updateStudent-------------------");
		Student updateStudent = studentDao.findStudentById(1);
		updateStudent.setName("변경2");
		updateStudent.setEmail("change2@gmail.com");
		updateStudent.setDob(new Date());
//		System.out.println("###" + studentDao.updateStudent(updateStudent));
		
		System.out.println("---------delete Student------------------");
		System.out.println("### " + studentDao.deleteStudentById(Integer.valueOf(11)));
		System.out.println("###2 " + studentDao.deleteStudentByName("김팔천"));
		System.out.println("###3 " + studentDao.deleteStudentByNameLike("시퀀스"));
		
		System.out.println("---------findStudentByIdWithAddress----------");
		System.out.println("###4 " + studentDao.findStudentByIdWithAddress(4));
		
		System.out.println("###5 " + studentDao.findStudentByIdWithCourses(1));
		System.out.println("###6 " + studentDao.findStudentByIdWithCoursesAndAddr(1));
		System.out.println("------------findStudentNameList-------------");
		System.out.println("### " + studentDao.findStudentNameList());
		System.out.println("------------findStudentNameById-------------");
		System.out.println("### " + studentDao.findStudentNameById(1));
		
		System.out.println("------------findStudentByIdMap-------------");
		System.out.println("### " + studentDao.findStudentByIdMap(1));
		System.out.println("------------findStudentByIdMapList-------------");
		System.out.println("### " + studentDao.findAllStudentsMapList());
		System.out.println("---------updateStudentParameterMap(parameter Map)----");
		HashMap studentMap = new HashMap();
		studentMap.put("studId", 1);
		studentMap.put("name", "유노윤호");
		studentMap.put("email", "youNo@gmail.com");
		studentMap.put("dob", new Date());
		System.out.println("### " + studentDao.updateStudentParamMap(studentMap));
		
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)----");
		HashMap rangeMap = new HashMap();
		rangeMap.put("startNo", 1);
		rangeMap.put("endNo", 3);
		System.out.println("### " + studentDao.findStudentByIdRangeParamMap(rangeMap));
		
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)----");
		Student firstStudent = new Student(1);
		Student secondStudent = new Student(3);
		Student thirdStudent = new Student(5);
		HashMap threeStudentMap = new HashMap();
		threeStudentMap.put("first", firstStudent);
		threeStudentMap.put("second", secondStudent);
		threeStudentMap.put("third", thirdStudent);
		System.out.println("### " + studentDao.findStudentThreeParamMap(threeStudentMap));
		
		
		System.out.println("------------findAllStudentsMap-------------");
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");

	}
}
