package com.itwill3.dao.user.mapper;

import java.util.List;

import com.itwill3.dao.user.User;

public interface UserMapper {
	/*
	<delete id="deleteUser" parameterType="java.lang.String">
		delete userinfo where userid = #{userId}
	</delete>
	 */
	public List<User> findAllUsers();
	
	public User findUserById(String userId);
	
	public int existedUser(String userId);
	
	public int insertUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(String userId);
}
