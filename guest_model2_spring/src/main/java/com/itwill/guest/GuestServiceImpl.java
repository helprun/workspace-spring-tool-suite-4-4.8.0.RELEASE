package com.itwill.guest;

import java.util.ArrayList;

public class GuestServiceImpl implements GuestService {
	private GuestDao guestDao;
	public GuestServiceImpl() throws Exception {
		System.out.println("### GuestServiceImpl: 기본생성자 호출");
	}
	
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("### GuestServiceImpl.setGuestDao("+guestDao+") 메쏘드 호출");
		this.guestDao = guestDao;
	}

	/*
	 * Create
	 */
	@Override
	public int insertGuest(Guest guest) throws Exception{
		return guestDao.insertGuest(guest);
	}
	/*
	 * Read
	 */
	@Override
	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}
	@Override
	public ArrayList<Guest> selectAll() throws Exception{
		return guestDao.selectAll();
	}
	/*
	 * Update
	 */
	@Override
	public int updateGuest(Guest guest) throws Exception{
		return guestDao.updateGuest(guest);
	}
	/*
	 * Delete
	 */
	@Override
	public int deleteGuest(int no) throws Exception{
		return guestDao.deleteGuest(no);
	}
}
