package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	
	public StudentDao() {
		InputStream mybatisConfigInputStream;
		try {
			mybatisConfigInputStream =
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			sqlSessionFactory = ssfb.build(mybatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ INSERT @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public int insertStudent(Student student) {
		/*
		 * <<sqlSessionFactory.openSession(true)>>
		 * true	:	autocommit ture
		 * 			sqlSession.close() 하면 자동으로 commit
		 * false:	autocommit ture
		 * 			sqlSession.commit()
		 * 			sqlSession.close() commit후 close
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true); 
		int insertRowCount = sqlSession.insert(NAMESPACE + "insertStudent", student);
		sqlSession.close();
		return insertRowCount;
	}
	public int insertStudentBySequence1(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false); 
		int insertRowCount = sqlSession.insert(NAMESPACE + "insertStudentBySequence1", student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	public int insertStudentBySequence2(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false); 
		int insertRowCount = sqlSession.insert(NAMESPACE + "insertStudentBySequence2", student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ DELETE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE + "deleteStudentById", studId);
		sqlSession.close();
		return deleteRowCount;
	}
	public int deleteStudentByName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE + "deleteStudentByName", name);
		sqlSession.close();
		return deleteRowCount;
	}
	public int deleteStudentByNameLike(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE + "deleteStudentByNameLike", name);
		sqlSession.close();
		return deleteRowCount;
	}
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ UPDATE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public int updateStudent(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/* 1. openSession()
		 * default --> auto commit false
		 * 반드시 commit을 호출해야함
		 * 
		 * 2.openSession(true)
		 * auto commit true
		 * close()시 자동 commit
		 */
		int updateRowCount = sqlSession.update(NAMESPACE + "updateStudent", student);
//		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}
	public int updateStudentParamMap(Map studentMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int updateRowCount = sqlSession.update(NAMESPACE + "updateStudentParamMap", studentMap);
		sqlSession.close();
		return updateRowCount;
	}
	
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SELECT[MAP] @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public HashMap findStudentByIdMap(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		HashMap findStudentMap = 
				sqlSession.selectOne(NAMESPACE + "findStudentByIdMap",studId);
		sqlSession.close();
		return findStudentMap;
	}
	
	public List<HashMap> findAllStudentsMapList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<HashMap> studentMapList = 
				sqlSession.selectList(NAMESPACE + "findAllStudentsMapList");
		sqlSession.close();
		return studentMapList;
	} 
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SELECT[ETC] @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public List<String> findStudentNameList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<String> nameList = sqlSession.selectList(NAMESPACE + "findStudentNameList");
		sqlSession.close();
		return nameList;
	}
	public String findStudentNameById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String name = sqlSession.selectOne(NAMESPACE + "findStudentNameById", studId);
		sqlSession.close();
		return name;
	}
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SELECT[JOIN] @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student findStudent = 
				sqlSession.selectOne(NAMESPACE + "findStudentByIdWithAddress",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	public Student findStudentByIdWithCourses(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student findStudent = 
				sqlSession.selectOne(NAMESPACE + "findStudentByIdWithCourses",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	
	public Student findStudentByIdWithCoursesAndAddr(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student findStudent = 
				sqlSession.selectOne(NAMESPACE + "findStudentByIdWithCoursesAndAddr",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SELECT @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student findStudent = 
				sqlSession.selectOne(NAMESPACE + "findStudentByIdResultMap",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student findStudent = 
				sqlSession.selectOne(NAMESPACE + "findStudentById",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	
	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> studentList = 
				sqlSession.selectList(NAMESPACE + "findAllStudents");
		sqlSession.close();
		return studentList;
	} 
	
	public List<Student> findStudentByIdRangeParamMap(Map rangeMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> studentList = 
				sqlSession.selectList(NAMESPACE + "findStudentByIdRangeParamMap", rangeMap);
		sqlSession.close();
		return studentList;
	} 
	public List<Student> findStudentThreeParamMap(Map threeStudentMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> studentList = 
				sqlSession.selectList(NAMESPACE + "findStudentThreeParamMap", threeStudentMap);
		sqlSession.close();
		return studentList;
	} 
	
	
}












