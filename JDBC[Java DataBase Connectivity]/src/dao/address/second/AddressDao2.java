package dao.address.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDao2 {
	String driverClass="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user="javapython4";
	String password="javapython4";
	
	String insertSql = "";
	String deleteSql = "";
	String updateSql = "";
	String selectByNoSql = "";
	String selectAllSql = "";
			
	public void create(String tableName, String id, String name, String phone, String address) throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		insertSql = 
				"insert into " + tableName + " values(address_no_seq.nextval,'" + id + "'," + "'"+ name + "'," + "'" + phone + "'," + "'" + address + "')";
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(rowCount + " 행이 추가되었습니다.");
		stmt.close();
		con.close();
	}
	public void delete(String tableName, int no) throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		deleteSql = "delete "  + tableName + " where no = " + no;
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(rowCount + " 행이 삭제되었습니다");
		stmt.close();
		con.close();
	}
	public void update(String tableName, String id, String name, String phone, String address, int no) throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		updateSql = 
				"update " + tableName + " set id = " + "'" + id + "'," + "name = '" + name + "'," + "phone = '" + phone + "'," + "address = '" + address + "' where no = " + no;
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(rowCount + " 행이 업데이트 되었습니다");
		stmt.close();
		con.close();
	}
	public void selectByNo(String tableName, int pkNo) throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		selectByNoSql = "select * from " + tableName + " where no = " + pkNo;
		ResultSet rs = stmt.executeQuery(selectByNoSql);
		if (rs.next()) {
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + "\t" + id + "\t" + name + "\t" + phone + "\t" + address);
		}
		rs.close();
		stmt.close();
		con.close();
	}
	public void selectAll(String tableName) throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		selectAllSql = "select * from " + tableName;
		ResultSet rs = stmt.executeQuery(selectAllSql);
		while(rs.next()) {
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + "\t" + id + "\t" + name + "\t" + phone + "\t" + address);
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
