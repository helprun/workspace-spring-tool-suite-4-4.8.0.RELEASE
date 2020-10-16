package com.mybatis3.dao.mapper;

import java.util.List;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/*
	 인터페이스의 풀네임은 StudentMapper.xml의 namespace와 일치
	 메쏘드이름은 StudentMapper.xml 파일의 id와 일치
	 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType과 일치
	 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType과 일치
	 */
	public Student findStudentById(Integer studId);
	/*
	 * 
	 * <select id="findStudentById" 
			parameterType="java.lang.Integer"
			resultType="Student">
		select stud_id studId, name, email, dob 
		from students
		where stud_id = #{studId}
	</select>
	 */
	public List<Student> findAllStudents();
//	<select id="findAllStudents"
//			resultType="Student">
//		select stud_id studId, name, email, dob
//		from students
//	</select>
}
