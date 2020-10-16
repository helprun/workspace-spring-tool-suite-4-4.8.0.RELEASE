package com.itwill.guest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


/*
 * Connection객체생성과 해제 작업을 전담하는클래스
 */
public class ConnectionFactory {
	
	private ConnectionFactory() {
		
	}
	
	public static Connection getConnection() throws Exception{
		
		Properties dbProperties=new Properties();
		dbProperties.load(
				ConnectionFactory.class.getResourceAsStream("db.properties"));
		String driverClass=dbProperties.getProperty("driverClass");
		String url=dbProperties.getProperty("url");
		String user=dbProperties.getProperty("user");
		String password=dbProperties.getProperty("password");
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
	
	public static void releaseConnection(Connection con) throws Exception{
		con.close();
	}
	
	
}
