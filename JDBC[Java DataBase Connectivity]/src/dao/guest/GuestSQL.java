package dao.guest;

public class GuestSQL {
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
	public static final String GUEST_INSERT="insert into guest values(guest_no_seq.nextval, ?, sysdate, ?,?,?,?)";
	public static final String GUEST_DELETE="delete guest where guest_no = ?";
	public static final String GUEST_UPDATE="update guest set guest_name = ?, guest_email = ?, guest_homepage = ?,"
			+ "guest_title = ?, guest_content = ? where guest_no = ?";
	public static final String GUEST_SELECT_NO="select * from guest where guest_no = ?";
	public static final String GUEST_SELECT_ALL="select * from guest";
}
