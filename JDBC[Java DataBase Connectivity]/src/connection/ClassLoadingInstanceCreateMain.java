package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class ClassLoadingInstanceCreateMain {

	public static void main(String[] args) throws Exception {
		/*
		StrongDriver strongDriver = new StrongDriver();
		DriverManager.registerDriver(strongDriver);
		Connection con = DriverManager.getConnection("jdbc:strong:...");
		*/
		/*
		Class driverClazz = Class.forName("connection.StrongDriver");
		Driver driver = (Driver) driverClazz.newInstance(); //기본생성자호출
		DriverManager.deregisterDriver(driver);
		Connection con = DriverManager.getConnection("","","");
		 */
		Class.forName("connection.StrongDriver");
//		Connection con = DriverManager.getConnection("","","");
	}

}
