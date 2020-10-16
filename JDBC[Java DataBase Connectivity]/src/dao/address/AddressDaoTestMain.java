package dao.address;

public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception {
		AddressDao addressDao = new AddressDaoImpl();
		System.out.println("1.insert");
		int insertRowCount = 
				addressDao.create(new Address("tiger", "권혁만", "234-9090", "안동"));
		System.out.println("create: " + insertRowCount);
		
		System.out.println("2.update");
		Address updateAddress = new Address(2, "uuu", "변경이름3", "920-0000", "주소변경3");
		int updateRowCount = 
				addressDao.update(updateAddress);
		System.out.println("update: " + updateRowCount);
		
		System.out.println("3.delete");
		System.out.println(addressDao.delete(19));
		
		System.out.println("4.selectByNo");
		System.out.println(addressDao.selectByNo(6));
		
		System.out.println("4.selectAll");
		for (Address address: addressDao.selectAll()) {
			System.out.println(address);
		}
	}

}
