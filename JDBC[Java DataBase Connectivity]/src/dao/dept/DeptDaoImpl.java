package dao.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.ConnectionFactory;

public class DeptDaoImpl implements DeptDao{

	@Override
	public void insert(Dept department) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.INSERT);
		pstmt.setInt(1, department.getDeptno());
		pstmt.setString(2, department.getDname());
		pstmt.setString(3, department.getLoc());
		pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
	}

	@Override
	public Dept selectByNo(int deptno) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.SELECTBYNO);
		pstmt.setInt(1, deptno);
		ResultSet rs = pstmt.executeQuery();
		Dept returnDept = null;
		if (rs.next()) {
			returnDept = new Dept(rs.getInt("deptno"),
									rs.getString("dname"), 
									rs.getString("loc"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return returnDept;
		
	}

	@Override
	public List selectByAll() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.SELECTALL);
		List deptList = new ArrayList<Dept>();
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			deptList.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return deptList;
	}

}
