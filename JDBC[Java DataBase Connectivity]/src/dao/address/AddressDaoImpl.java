package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import dao.common.ConnectionFactory;

public class AddressDaoImpl implements AddressDao {
	
	@Override
	public int create(Address insertAddress) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.INSERT);
		pstmt.setString(1, insertAddress.getId());
		pstmt.setString(2, insertAddress.getName());
		pstmt.setString(3, insertAddress.getPhone());
		pstmt.setString(4, insertAddress.getAddress());
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return insertRowCount;
	}
			
	@Override
	public int delete(int no) throws Exception{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.DELETE);
		pstmt.setInt(1, no);
		int deleteRowCount  = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return deleteRowCount;
	}
	
	@Override
	public int update(Address updateAddress) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.UPDATE);
		pstmt.setString(1, updateAddress.getId());
		pstmt.setString(2, updateAddress.getName());
		pstmt.setString(3, updateAddress.getPhone());
		pstmt.setString(4, updateAddress.getAddress());
		pstmt.setInt(5, updateAddress.getNo());
		int updateRowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return updateRowCount;
	}
 	
	
	@Override
	public Address selectByNo(int no) throws Exception{
		Connection con = ConnectionFactory.getConnection();
		Address returnAddress = null;
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.SELECTBYNO);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			returnAddress = new Address(rs.getInt("no"),
										rs.getString("id"),
										rs.getString("name"),
										rs.getString("phone"),
										rs.getString("address"));

		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return returnAddress;
	}
	
	@Override
	public ArrayList<Address> selectAll() throws Exception{
		Connection con = ConnectionFactory.getConnection();
		ArrayList<Address> addressList = new ArrayList<Address>();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.SELECTALL);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			addressList.add(new Address(rs.getInt("no"),
										rs.getString("id"),
										rs.getString("name"),
										rs.getString("phone"),
										rs.getString("address")));

		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return addressList;
		
	}
}
