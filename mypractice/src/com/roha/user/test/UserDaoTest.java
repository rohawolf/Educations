/**
 * 
 */
package com.roha.user.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.roha.user.dao.DaoFactory;
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
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoFactory.class);
		
 		UserDao dao = context.getBean("userDao", UserDao.class);
		
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
