package com.itwill.guest;

import java.util.ArrayList;

public interface GuestService {

	/*
	 * Create
	 */
	int insertGuest(Guest guest) throws Exception;

	/*
	 * Read
	 */
	Guest selectByNo(int no) throws Exception;

	ArrayList<Guest> selectAll() throws Exception;

	/*
	 * Update
	 */
	int updateGuest(Guest guest) throws Exception;

	/*
	 * Delete
	 */
	int deleteGuest(int no) throws Exception;

}