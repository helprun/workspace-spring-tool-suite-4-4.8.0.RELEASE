package dao.address.first;

public class AddressDao1TestMain {

	public static void main(String[] args) throws Exception {
		AddressDao1 addressDao1 = new AddressDao1();
		System.out.println("1.insert");
		addressDao1.create();
		System.out.println("2.update");
		addressDao1.update();
		System.out.println("3.delete");
		addressDao1.delete();
		System.out.println("4.selectByNo");
		addressDao1.selectByNo();
		System.out.println("4.selectAll");
		addressDao1.selectAll();
	}

}
