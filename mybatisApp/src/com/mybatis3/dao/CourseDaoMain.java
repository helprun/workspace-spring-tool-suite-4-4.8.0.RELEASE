package com.mybatis3.dao;

public class CourseDaoMain {

	public static void main(String[] args) {
		CourseDao courseDao = new CourseDao();
		System.out.println("-----------findCoursesByTutorId----------");
		System.out.println(courseDao.findCourseByIdWithStudents(1));
		System.out.println("---------------findCourses-------------");
		System.out.println(courseDao.findCourseByIdWithStudentsAndAddr(1));
		
		
		
		
		
	}

}
