package com.itwill.guest.test;

import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestServiceTestMain {
	public static void main(String[] args) throws Exception{
		GuestService guestService=new GuestServiceImpl();
		System.out.println(guestService.selectAll());
		System.out.println(guestService.selectByNo(1));
	}
}