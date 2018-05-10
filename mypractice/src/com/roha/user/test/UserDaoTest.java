/**
 * 
 */
package com.roha.user.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.roha.user.dao.DaoFactory;
import com.roha.user.dao.UserDao;

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
		
		
		DaoFactory factory = new DaoFactory();
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoFactory.class);
		/*
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
		*/
		
		UserDao dao1 = factory.userDao();
		UserDao dao2 = factory.userDao();
		
		UserDao dao3 = context.getBean("userDao", UserDao.class);
		UserDao dao4 = context.getBean("userDao", UserDao.class);
		
		// 매 호출마다  새로운 UserDao 객체 생성 후 리턴
		System.out.println(dao1);
		System.out.println(dao2);
		System.out.println(dao1 == dao2); // => false
		
		// 첫 생성 이후 호출 시 기존에 생성되어 있던 객체 리턴
		// ApplicationContext => singleton registry
		System.out.println(dao3);
		System.out.println(dao4);
		System.out.println(dao3 == dao4); // => true
		
 	}

}
