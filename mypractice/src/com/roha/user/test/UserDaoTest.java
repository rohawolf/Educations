/**
 * 
 */
package com.roha.user.test;

import java.sql.SQLException;

import com.roha.user.dao.ConnectionMaker;
import com.roha.user.dao.DConnectionMaker;
import com.roha.user.dao.NConnectionMaker;
import com.roha.user.dao.UserDao;
import com.roha.user.domain.User;

/**
 * UserDao Unit Test class
 * @author Roha Park
 *
 */
public class UserDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//when using connectionMaker of 'D' company
		ConnectionMaker connectionMaker = new DConnectionMaker();
		
		
		//when using connectionMaker of 'N' company
		//ConnectionMaker connectionMaker = new NConnectionMaker();
		
		UserDao dao = new UserDao(connectionMaker); 		
 		
 		User user = new User();
 		user.setId("rohawolf");
 		user.setName("Roha Park");
 		user.setPassword("roharoha");
 		
 		dao.add(user);
		System.out.println(user.getId() + " add success");
 		
 		User user2 = dao.get(user.getId());
 		System.out.println(user2.getName());
 		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " select success");
 	}

}
