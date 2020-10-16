package com.itwill.guest;

import java.util.ArrayList;

public class GuestServiceImpl implements GuestService {
	private GuestDao guestDao;
	public GuestServiceImpl() throws Exception {
	}
	
	public void setGuestDao(GuestDao guestDao) {
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
