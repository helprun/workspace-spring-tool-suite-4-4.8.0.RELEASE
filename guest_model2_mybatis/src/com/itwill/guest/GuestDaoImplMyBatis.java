package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestDaoImplMyBatis implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = 
			"com.itwill.guest.mapper.GuestMapper.";
	
	public GuestDaoImplMyBatis() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			sqlSessionFactory=ssfb.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount = sqlSession.insert(NAMESPACE + "insertGuest", guest);
		sqlSession.close();
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Guest findGuest = sqlSession.selectOne(NAMESPACE + "selectByNo", no);
		sqlSession.close();
		return findGuest;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Guest> resultList = sqlSession.selectList(NAMESPACE + "selectAll");
		ArrayList<Guest> guestList = (ArrayList<Guest>) resultList;
		sqlSession.close();
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateRowCount = sqlSession.update(NAMESPACE + "updateGuest", guest);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteRowCount = sqlSession.delete(NAMESPACE + "deleteGuest", no); 
		sqlSession.commit();
		sqlSession.close();
		return deleteRowCount;
	}

}
