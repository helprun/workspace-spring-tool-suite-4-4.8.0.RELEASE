package dao.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.common.ConnectionFactory;



public class GuestDaoImpl implements GuestDao{
	/*
	이름             널?       유형             
	-------------- -------- -------------- 
	GUEST_NO       NOT NULL NUMBER(10)     
	GUEST_NAME     NOT NULL VARCHAR2(10)   
	GUEST_DATE     NOT NULL DATE           
	GUEST_EMAIL             VARCHAR2(50)   
	GUEST_HOMEPAGE          VARCHAR2(50)   
	GUEST_TITLE    NOT NULL VARCHAR2(100)  
	GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
	 */
	public GuestDaoImpl() throws Exception{
		
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest returnGuest = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_NO);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			returnGuest = new Guest(rs.getInt(1), 
					rs.getString(2), rs.getString(3), 
					rs.getNString(4), rs.getString(5), 
					rs.getString(6), rs.getString(7));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return returnGuest;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			guestList.add(new Guest(rs.getInt(1), 
					rs.getString(2), rs.getString(3), 
					rs.getNString(4), rs.getString(5), 
					rs.getString(6), rs.getString(7)));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		pstmt.setInt(6, guest.getGuest_no());
		int updatedRowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return updatedRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, no);
		int deletedRowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return deletedRowCount;
	}

}
