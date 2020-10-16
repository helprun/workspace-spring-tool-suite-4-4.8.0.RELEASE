package com.itwill3.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImplMyBatis implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	public static final String NAMESPACE = 
			"com/itwill3/dao/user/mapper/UserMapper.";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int create(User user) throws Exception {
		int insertRowCount = sqlSession.insert(NAMESPACE + "insertUser", user);  
		return insertRowCount;
	}

	@Override
	public int update(User user) throws Exception {
		int updateRowCount = sqlSession.update(NAMESPACE + "updateUser", user);
		return updateRowCount;
	}

	@Override
	public int remove(String userId) throws Exception {
		int deleteRowCount = sqlSession.delete(NAMESPACE + "deleteUser", userId);
		return deleteRowCount;
	}

	@Override
	public User findUser(String userId) throws Exception {
		User findUser = sqlSession.selectOne(NAMESPACE + "findUserById", userId);
		return findUser;
	}

	@Override
	public List<User> findUserList() throws Exception {
		List<User> users = sqlSession.selectList(NAMESPACE + "findAllUsers");
		return users;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		boolean isExistUser = false;
		int userCount = sqlSession.selectOne(NAMESPACE + "existedUser", userId);
		if (userCount == 1) {
			isExistUser = true;
		}
		return isExistUser;
	}

}
