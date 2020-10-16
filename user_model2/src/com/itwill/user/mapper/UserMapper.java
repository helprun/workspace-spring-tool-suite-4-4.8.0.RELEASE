package com.itwill.user.mapper;

import java.util.List;

import com.itwill.user.User;

public interface UserMapper {
//	<select id="findAllUsers" resultType="com.itwill.user.User">
//	select userid,password,name,email from userinfo	
//</select>
	public List<User> findAllUsers();
//	<select id="findUserById" parameterType="java.lang.String" resultType="com.itwill.user.User">
//	select userid,password,name,email from userinfo	where userid = #{userId}
//</select>
	public User findUserById(String userId);
//	<select id= "existedUser" parameterType="java.lang.String"
//	 		resultType="_int">
//		select count(*) cnt from userinfo where userid= #{userId}	
//	</select>
	public int existedUser(String userId);
//	<insert id="insertUser" parameterType="com.itwill.user.User">
//	insert into userinfo values(#{userId}, #{password}, #{name}, #{email})
//</insert>
	public int insertUser(User user);
//	<update id="updateUser" parameterType="com.itwill.user.User">
//	update userinfo set password = #{password}, name = #{name}, email = #{email} where userid = #{userId}
//</update>
	public int updateUser(User user);
//	<delete id="deleteUser" parameterType="java.lang.String">
//	delete userinfo where userid = #{userId}
//</delete>
	public int deleteUser(String userId);
}
