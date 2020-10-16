package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Properties;

public class StatementMain {

	public static void main(String[] args) throws Exception{
		Properties dbProperties = new Properties();
		dbProperties.load(
				StatementMain.class.getResourceAsStream("../basic/db.properties"));
		
		String driverClass = dbProperties.getProperty("driverClass");
		String url = dbProperties.getProperty("url");
		String user = dbProperties.getProperty("user");
		String password = dbProperties.getProperty("password");
		String selectSql = "select * from emp";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user, password);
		Statement stmt = con.createStatement();
		/*
		 * ResultSet의 행의수를 제한
		 */
		stmt.setMaxRows(5);
		ResultSet rs = stmt.executeQuery(selectSql);
		while (rs.next()) {
			System.out.println(rs.getInt("EMPNO") + "\t" + 
								rs.getString("ENAME") + "\t" +
								rs.getString("JOB") + "\t" + 
								rs.getDouble("SAL"));
			
		}
		rs.close();
		System.out.println("\n" + "-------------sal desc---------------");
		
		String selectSql2 = "select * from emp order by sal desc";
		ResultSet rs2 = stmt.executeQuery(selectSql2);
		while (rs2.next()) {
			System.out.println(rs2.getInt("EMPNO") + "\t" + 
								rs2.getString("ENAME") + "\t" +
								rs2.getString("JOB") + "\t" + 
								rs2.getDouble("SAL"));
			
		}
		rs2.close();
		
		
		String insertSql = "insert into emp "
				+ "values(9998, 'JAMES', 'MANAGER', null, "
				+ "TO_DATE('2020/05/20','YYYY/MM/DD'), 6000, NULL, 30)";
		String updateSql = "update emp set sal = 6789.89 where empno >= 7369 and empno <= 7600";
		String deleteSql = "delete emp where empno = 8888";
		
		try {
			int insertRowCount = stmt.executeUpdate(insertSql);
			System.out.println(insertRowCount + " 행이 추가");
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("catch >>> 이미 존재하는 사번입니다");
		}
		
		int updateRowCount = stmt.executeUpdate(updateSql);
		System.out.println(updateRowCount + " 행이 수정");
		int deleteRowCount = stmt.executeUpdate(deleteSql);
		System.out.println(deleteRowCount + " 행이 삭제");
		
		/*
		 * 행의 수 제한 제거
		 */
		System.out.println("------------setMaxRows(0)[행의수제한제거]-------------");
		stmt.setMaxRows(0);
		ResultSet rs3 = stmt.executeQuery(selectSql);
		while (rs3.next()) {
			System.out.println(rs3.getInt("EMPNO") + "\t" + 
								rs3.getString("ENAME") + "\t" +
								rs3.getString("JOB") + "\t" + 
								rs3.getDouble("SAL"));
			
		}
		rs3.close();
		stmt.close();
		con.close();
	}

}
