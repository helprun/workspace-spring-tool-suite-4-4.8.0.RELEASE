package com.itwill.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwill.user.mapper.UserMapper;

/*
 사용자관리에서 데이타베이스와의 작업을 전담하는 클래스
 USERINFO 테이블에 사용자를 추가,삭제,검색,수정등의 작업을한다.
 */
public class UserDaoImpl implements UserDao {
	private UserMapper userMapper;
	
	public UserDaoImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	@Override
	public int create(User user) throws Exception {
		int insertRowCount = userMapper.insertUser(user);
		return insertRowCount;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	@Override
	public int update(User user) throws Exception {
		int updateRowCount = userMapper.updateUser(user);
		return updateRowCount;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	@Override
	public int remove(String userId) throws Exception {
		int removeRowCount = userMapper.deleteUser(userId);
		return removeRowCount;
	}

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	@Override
	public User findUser(String userId) throws Exception {
		User findUser = userMapper.findUserById(userId);
		return findUser;
	}

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	@Override
	public ArrayList<User> findUserList() throws Exception {
		ArrayList<User> findUserList = (ArrayList<User>) userMapper.findAllUsers();
		return findUserList;
	}

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	@Override
	public boolean existedUser(String userId) throws Exception {
		boolean isExist = false;
		int userCount = userMapper.existedUser(userId);
		if (userCount == 1) {
			isExist = true;
		}
		return isExist;
	}

}
