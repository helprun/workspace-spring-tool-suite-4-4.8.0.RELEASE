package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.guest.mapper.GuestMapper;


public class GuestDaoImplMyBatis implements GuestDao {
	private GuestMapper guestMapper;
	//mapperInterface시에는 Mapper객체를 가지게 된다
	
	public GuestDaoImplMyBatis(GuestMapper guestMapper) {
		this.guestMapper = guestMapper;
	}
	
	@Override
	public int insertGuest(Guest guest) throws Exception {
		int insertRowCount = guestMapper.insertGuest(guest);
		return insertRowCount;
	}


	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest findGuest = guestMapper.selectByNo(no);
		return findGuest;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		List<Guest> guestList = guestMapper.selectAll();
		ArrayList<Guest> guests = (ArrayList<Guest>) guestList;
		return guests;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		int updateRowCount = guestMapper.updateGuest(guest);
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		int deleteRowCount = guestMapper.deleteGuest(no);
		return deleteRowCount;
	}

}
