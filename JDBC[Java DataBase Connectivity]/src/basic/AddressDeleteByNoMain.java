package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class AddressDeleteByNoMain {

	public static void main(String[] args) throws Exception{
		/*************** 설정파일로부터 접속 *******************/
//		String driverClass=oracle.jdbc.OracleDriver
//		String url=jdbc:oracle:thin:@182.237.126.19:1521:XE
//		String user=javapython4
//		String password=javapython4
		Properties dbProperties = new Properties();
		dbProperties.load(
				JDBCFlowMain.class.getResourceAsStream("db.properties"));
		
		String driverClass = dbProperties.getProperty("driverClass");
		String url = dbProperties.getProperty("url");
		String user = dbProperties.getProperty("user");
		String password = dbProperties.getProperty("password");
		
		String deleteSql = 
				"delete address where no = 3";
		
		Class.forName(driverClass);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(rowCount + " 행 delete");
		
		stmt.close();
		con.close();
	}

}
