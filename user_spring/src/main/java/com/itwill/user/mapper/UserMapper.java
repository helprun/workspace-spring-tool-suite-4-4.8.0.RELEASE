package com.itwill.user.mapper;

import java.util.List;

import com.itwill.user.User;

public interface UserMapper {
	public List<User> findAllUsers();

	public User findUserById(String userId);

	public int existedUser(String userId);
	
	public int insertUser(User user);
	
	public int updateUser(User user);

	public int deleteUser(String userId);
}
