package dao.address;

import java.util.ArrayList;

public interface AddressDao {

	int create(Address insertAddress) throws Exception;

	int delete(int no) throws Exception;

	int update(Address updateAddress) throws Exception;

	Address selectByNo(int no) throws Exception;

	ArrayList<Address> selectAll() throws Exception;

}