package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception {
		AddressDao2 addressDao2 = new AddressDao2();
		System.out.println("1.insert");
		addressDao2.create("address","zet", "zet", "531-1276", "부산");
		System.out.println("2.update");
		addressDao2.update("address", "helprun", "헬프런", "489-4896", "제주도", 6);
		System.out.println("3.delete");
		addressDao2.delete("address", 24);
		System.out.println("4.selectByNo");
		addressDao2.selectByNo("address", 6);
		System.out.println("4.selectAll");
		addressDao2.selectAll("address");
	}

}
