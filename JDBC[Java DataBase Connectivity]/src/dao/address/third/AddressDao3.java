package dao.address.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import dao.address.Address;

public class AddressDao3 {
	String driverClass = "";
	String url = "";
	String user = "";
	String password = "";
	
//	NO      NOT NULL NUMBER(4)     
//	ID               VARCHAR2(20)  
//	NAME             VARCHAR2(50)  
//	PHONE            VARCHAR2(50)  
//	ADDRESS          VARCHAR2(100) 
	public AddressDao3() throws Exception {
		Properties dbProperties = new Properties();
		dbProperties.load(AddressDao3.class.getResourceAsStream("../../basic/db.properties"));
		driverClass = dbProperties.getProperty("driverClass");
		url = dbProperties.getProperty("url");
		user = dbProperties.getProperty("user");
		password = dbProperties.getProperty("password");
	}
	
	public int create(Address insertAddress) throws Exception {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		String insertSql = 
			"insert into address values(address_no_seq.nextval, ?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1, insertAddress.getId());
		pstmt.setString(2, insertAddress.getName());
		pstmt.setString(3, insertAddress.getPhone());
		pstmt.setString(4, insertAddress.getAddress());
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return insertRowCount;
	}
			
	public int delete(int no) throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		String deleteSql = "delete address where no = ?";
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int deleteRowCount  = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return deleteRowCount;
	}
	
	public int update(Address updateAddress) throws Exception {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		String updateSql = "update address set id = ?, name = ?, phone = ?, address =? where no = ?";
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, updateAddress.getId());
		pstmt.setString(2, updateAddress.getName());
		pstmt.setString(3, updateAddress.getPhone());
		pstmt.setString(4, updateAddress.getAddress());
		pstmt.setInt(5, updateAddress.getNo());
		int updateRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return updateRowCount;
	}
 	
	
	public Address selectByNo(int no) throws Exception{
		Address returnAddress = null;
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		String selectByNoSql = "select * from address where no = ?";
		PreparedStatement pstmt = con.prepareStatement(selectByNoSql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			returnAddress = new Address(rs.getInt("no"),
										rs.getString("id"),
										rs.getString("name"),
										rs.getString("phone"),
										rs.getString("address"));
//			returnAddress.setNo(rs.getInt("no"));
//			returnAddress.setId(rs.getString("id"));
//			returnAddress.setName(rs.getString("name"));
//			returnAddress.setPhone(rs.getString("phone"));
//			returnAddress.setAddress(rs.getString("address"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return returnAddress;
	}
	
	public ArrayList<Address> selectAll() throws Exception{
		ArrayList<Address> addressList = new ArrayList<Address>();
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		String selectAllSql = "select * from address";
		PreparedStatement pstmt = con.prepareStatement(selectAllSql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			addressList.add(new Address(rs.getInt("no"),
										rs.getString("id"),
										rs.getString("name"),
										rs.getString("phone"),
										rs.getString("address")));
//			Address tempAddress = new Address();
//			tempAddress.setNo(rs.getInt("no"));
//			tempAddress.setId(rs.getString("id"));
//			tempAddress.setName(rs.getString("name"));
//			tempAddress.setPhone(rs.getString("phone"));
//			tempAddress.setAddress(rs.getString("address"));
//			addressList.add(tempAddress);
		}
		rs.close();
		pstmt.close();
		con.close();
		return addressList;
		
	}
}
