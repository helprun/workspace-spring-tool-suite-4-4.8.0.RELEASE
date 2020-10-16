package com.itwill.guest;

import java.util.ArrayList;

public class GuestService {
	private GuestDao guestDao;
	public GuestService() throws Exception {
		guestDao=new GuestDaoImpl();
	}
	/*
	 * Create
	 */
	public int insertGuest(Guest guest) throws Exception{
		return guestDao.insertGuest(guest);
	}
	/*
	 * Read
	 */
	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}
	public ArrayList<Guest> selectAll() throws Exception{
		return guestDao.selectAll();
	}
	/*
	 * Update
	 */
	public int updateGuest(Guest guest) throws Exception{
		return guestDao.updateGuest(guest);
	}
	/*
	 * Delete
	 */
	public int deleteGuest(int no) throws Exception{
		return guestDao.deleteGuest(no);
	}
}
