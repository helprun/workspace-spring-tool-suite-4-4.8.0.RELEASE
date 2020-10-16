package com.itwill3.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill3.dao.user.mapper.UserMapper;

@Repository("userDaoImplMyBatisMapperInterface")
public class UserDaoImplMyBatisMapperInterface implements UserDao {
	@Autowired
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int create(User user) throws Exception {
		int insertRowCount = userMapper.insertUser(user);
		return insertRowCount;
	}

	@Override
	public int update(User user) throws Exception {
		int updateRowCount = userMapper.updateUser(user);
		return updateRowCount;
	}

	@Override
	public int remove(String userId) throws Exception {
		int deleteRowCount = userMapper.deleteUser(userId);
		return deleteRowCount;
	}

	@Override
	public User findUser(String userId) throws Exception {
		User findUser = userMapper.findUserById(userId);
		return findUser;
	}

	@Override
	public List<User> findUserList() throws Exception {
		List<User> users = (List<User>) userMapper.findAllUsers();
		return users;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		boolean isExistUser = false;
		int userCount = userMapper.existedUser(userId);
		if (userCount == 1) {
			isExistUser = true;
		}
		return isExistUser;
	}

}
