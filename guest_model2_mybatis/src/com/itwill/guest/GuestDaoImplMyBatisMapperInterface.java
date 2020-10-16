package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatisMapperInterface implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	public GuestDaoImplMyBatisMapperInterface() {
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
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int insertRowCount = guestMapper.insertGuest(guest);
		sqlSession.close();
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return sqlSessionFactory.openSession().getMapper(GuestMapper.class).selectByNo(no);
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		List<Guest> guestList = guestMapper.selectAll();
		ArrayList<Guest> guests = (ArrayList<Guest>) guestList;
		return guests;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int updateRowCount = guestMapper.updateGuest(guest);
		sqlSession.close();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int deleteRowCount = guestMapper.deleteGuest(no);
		sqlSession.close();
		return deleteRowCount;
	}

}
