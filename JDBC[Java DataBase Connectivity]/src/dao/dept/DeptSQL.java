package dao.dept;

public class DeptSQL {
	public static final String INSERT= "insert into dept values(?,?,?)";
	public static final String SELECTBYNO= "select * from dept where deptno = ?";
	public static final String SELECTALL= "select * from dept";
}
