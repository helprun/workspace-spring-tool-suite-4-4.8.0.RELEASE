package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestDaoImplMyBatis;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDaoImplMyBatis();
//		guestDao.deleteGuest(52);
//		System.out.println(guestDao.selectAll());
//		System.out.println("1.insert");
		System.out.println(guestDao
				.updateGuest(
						new Guest(62, "이름수정", null, "이메일수정", "홈페이지수정", "타이틀수정", "내용수정")));
//		
//		Guest guest=guestDao.selectByNo(4);
//		System.out.println(guest);
//		guest.setGuest_name("김변경");
//		System.out.println("2.update");
//		System.out.println(guestDao.updateGuest(guest));
	}	

}
