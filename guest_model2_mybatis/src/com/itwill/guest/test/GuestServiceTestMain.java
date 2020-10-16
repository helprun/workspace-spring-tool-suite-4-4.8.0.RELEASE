package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestServiceTestMain {
	public static void main(String[] args) throws Exception{
		GuestService guestService=new GuestService();
		System.out.println(guestService.selectAll());
//		System.out.println(guestService.selectByNo(1));
//		System.out.println(guestService.deleteGuest(102));
//		System.out.println(guestService.selectByNo(102));
//		System.out.println(guestService.insertGuest(new Guest(0, "매퍼", null, "이메일", "홈피", "제목", "내용")));
		System.out.println(guestService.updateGuest(new Guest(105, "매퍼수정", null, "이메일수정", "홈피수정", "제목수정", "내용수정")));
		System.out.println(guestService.selectAll());
	}
}