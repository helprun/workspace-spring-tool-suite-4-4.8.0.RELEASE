package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestDaoImpl;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
//		GuestDao guestDao=new GuestDaoImplConnectionFactory();
		GuestDao guestDao = new GuestDaoImpl();
		System.out.println(guestDao.selectAll());
		System.out.println("1.insert");
		System.out.println(guestDao
				.insertGuest(
						new Guest(-9090, "이름", null, "이메일", "홈페이지", "타이틀", "내용")));
		
		Guest guest=guestDao.selectByNo(4);
		guest.setGuest_name("김변경");
		System.out.println("2.update");
		System.out.println(guestDao.updateGuest(guest));
	}	

}
