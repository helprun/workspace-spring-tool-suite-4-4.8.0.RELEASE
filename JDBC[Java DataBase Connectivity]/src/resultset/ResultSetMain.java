package resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.common.ConnectionFactory;

public class ResultSetMain {

	public static void main(String[] args) throws Exception {
		/*		
		이름         널?       유형            
		---------- -------- ------------- 
		NO         NOT NULL NUMBER(7)     
		NAME                VARCHAR2(50)  
		SHORT_DESC          VARCHAR2(255) 
		PRICE               NUMBER(10,3)  
		IPGO_DATE           DATE   
		*/
		String selectSql = "select no, name, price, short_desc, ipgo_date from s_product";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		System.out.println("----------rs.get타입(컬럼이름)---------");
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			do {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String short_desc = rs.getString("short_desc");
				double price = rs.getDouble("price");
				Date ipgo_date = rs.getDate("ipgo_date");
				System.out.println(no + "\t" + name + "\t" +  price + "\t" +  short_desc + "\t" + price + "\t" + ipgo_date);
			} while (rs.next());
		} else {
			System.out.println("상품없다...");
		}
		rs.close();
		
		System.out.println("----------rs.get타입(컬럼index)---------");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			String short_desc = rs.getString(4);
			Date ipgo_date = rs.getDate(5);
			System.out.println(no + "\t" + name + "\t" +  price + "\t" +  short_desc + "\t" + price + "\t" + ipgo_date);
		}
		rs.close();
		
		System.out.println("----------rs.getString(컬럼이름)---------");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String no = rs.getString("no");
			String name = rs.getString("name");
			String price = rs.getString("price");
			String short_desc = rs.getString("short_desc");
			String ipgo_date = rs.getString("ipgo_date");
			System.out.println(no + "\t" + name + "\t" +  price + "\t" +  short_desc + "\t" + price + "\t" + ipgo_date);
		}
		rs.close();
		
		System.out.println("----------rs.getObject(컬럼이름)---------");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Object no = rs.getObject("no");
			Object name = rs.getObject("name");
			Object price = rs.getObject("price");
			Object short_desc = rs.getObject("short_desc");
			Object ipgo_date = rs.getObject("ipgo_date");
			System.out.println(no + "\t" + name + "\t" +  price + "\t" +  short_desc + "\t" + price + "\t" + ipgo_date);
		}
		rs.beforeFirst();
//		전방향 전용 결과 집합에 부적합한 작업이 수행되었습니다 : beforeFirst
		rs.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
