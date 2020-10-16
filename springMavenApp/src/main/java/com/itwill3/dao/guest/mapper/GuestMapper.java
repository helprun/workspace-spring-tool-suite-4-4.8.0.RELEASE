package com.itwill3.dao.guest.mapper;

import java.util.List;

import com.itwill3.dao.guest.Guest;

public interface GuestMapper {
	
	public List<Guest> selectAll();
	
	public Guest selectByNo(Integer guest_no);
	
	
	public int deleteGuest(Integer guest_no);
	

	public Integer insertGuest(Guest guest);
//	 <update id="updateGuest" parameterType="com.itwill.guest.Guest">
//	 	update guest set guest_name= #{guest_name},
//              guest_email= #{guest_email},
//              guest_homepage=#{guest_homepage},
//              guest_title=#{guest_title},
//              guest_content=#{guest_content}
//		where guest_no = #{guest_no}
//	 </update>
	public int updateGuest(Guest guest);
}
