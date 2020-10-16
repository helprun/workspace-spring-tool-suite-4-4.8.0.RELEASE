package dao.address.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDao1 {
	String driverClass="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user="javapython4";
	String password="javapython4";
	
	String insertSql = "insert into address values(address_no_seq.nextVal, 'testId', '권순수', '456-1234', '서울시 강남구')";
	String deleteSql = "delete address where no = 11";
	String updateSql = "update address set id = 'updatedId', name = '수정', phone = '999-9999', address = '캐나다 토론토' where no = 9";
	String selectByNoSql = "select * from address where no = 5";
	String selectAllSql = "select * from address";
	/*
	Dao(Data Access Object)
	 - Address들의 데이터를 저장하고있는 Address 테이블에
	   CRUD(Create, Read, Update, Delete) 작업을 할수있는
	   단위메쏘드를 가지고있는 클래스
	 - AddressService객체의 요청(메쏘드호출)을 받아서 
	   Data Access(DB)에 관련된 단위기능(CRUD)을
	   수행하는 객체
	 */
	
	public void create() throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(rowCount + " 행이 추가되었습니다.");
		stmt.close();
		con.close();
	}
	public void delete() throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(rowCount + " 행이 삭제되었습니다");
		stmt.close();
		con.close();
	}
	public void update() throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(rowCount + " 행이 업데이트 되었습니다");
		stmt.close();
		con.close();
	}
	public void selectByNo() throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
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
	public void selectAll() throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
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
