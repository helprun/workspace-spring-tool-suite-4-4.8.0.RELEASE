package dao.address.third;

import dao.address.Address;

public class AddressDao3TestMain {

	public static void main(String[] args) throws Exception {
		AddressDao3 addressDao3 = new AddressDao3();
		System.out.println("1.insert");
		int insertRowCount = 
				addressDao3.create(new Address("tiger", "권혁만", "234-9090", "안동"));
		System.out.println("create: " + insertRowCount);
		
		System.out.println("2.update");
		Address updateAddress = new Address(2, "uuu", "변경이름3", "920-0000", "주소변경3");
		int updateRowCount = 
				addressDao3.update(updateAddress);
		System.out.println("update: " + updateRowCount);
		
		System.out.println("3.delete");
		System.out.println(addressDao3.delete(19));
		
		System.out.println("4.selectByNo");
		System.out.println(addressDao3.selectByNo(6));
		
		System.out.println("4.selectAll");
		for (Address address: addressDao3.selectAll()) {
			System.out.println(address);
		}
	}

}
