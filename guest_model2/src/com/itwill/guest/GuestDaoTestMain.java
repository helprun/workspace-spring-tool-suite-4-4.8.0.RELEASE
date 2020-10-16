package com.itwill.guest;


public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDaoImpl();
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
