package dao.guest;

import java.util.ArrayList;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		GuestDao guestDao = new GuestDaoImpl();
		System.out.println("------------insertGuest-----------");
		guestDao.insertGuest(new Guest(0, "권순수", "", "akiratksk@hotmail.com", 
				"없음", "아 자바 어렵다", "나만 그런거 아니지?"));
		guestDao.insertGuest(new Guest(0, "권순빈", "", "eads@hotmail.com", 
				"없음", "헤헷", "다이스키"));
		
		System.out.println("------------selectAll-----------");
		ArrayList<Guest> guestList = guestDao.selectAll();
		for (Guest guest : guestList) {
			System.out.println(guest);
		}
		System.out.println();
		
		System.out.println("------------selectByNo-----------");
		System.out.println(guestDao.selectByNo(1));
		
		System.out.println("------------updateGuest-----------");
		int count = guestDao.updateGuest(new Guest(6, "임성엽", null, "syLim@gmail.com", "없음", "강릉커피", "존맛탱"));
		System.out.println(count + " 행 업데이트");
		
		System.out.println("------------deleteGuest-----------");
		count = guestDao.deleteGuest(7);
		System.out.println(count + " 행 삭제");
		
	}

}
