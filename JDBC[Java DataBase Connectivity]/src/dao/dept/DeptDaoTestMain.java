package dao.dept;

import java.util.List;

public class DeptDaoTestMain {

	public static void main(String[] args) throws Exception {
		DeptDao deptDao = new DeptDaoImpl();
		deptDao.insert(new Dept(60, "ForeignBiz", "서울"));
		Dept dept1 = deptDao.selectByNo(60);
		System.out.println(dept1);
		System.out.println();
		List deptList = deptDao.selectByAll();
		for (Object object : deptList) {
			System.out.println(object);
		}
	}

}
