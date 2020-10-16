package com.itwill.guest;
public class GuestServiceTestMain {
	public static void main(String[] args) throws Exception{
		GuestService guestService=new GuestService();
		System.out.println(guestService.selectAll());
		System.out.println(guestService.selectByNo(1));
	}
}