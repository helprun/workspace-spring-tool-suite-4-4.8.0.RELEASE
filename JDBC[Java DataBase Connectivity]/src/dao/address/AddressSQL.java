package dao.address;

public class AddressSQL {
	public static final String INSERT= 
			"insert into address values(address_no_seq.nextval, ?,?,?,?)";
	public static final String DELETE= "delete address where no = ?";
	public static final String UPDATE= "update address set id = ?, name = ?, phone = ?, address =? where no = ?";
	public static final String SELECTBYNO= "select * from address where no = ?";
	public static final String SELECTALL = "select * from address";
}
