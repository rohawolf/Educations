/**
 * 
 */
package com.roha.user.dao;

/**
 * the Factory class that has responsablity of make instance of UserDao class
 * @author Roha Park
 *
 */
public class DaoFactory {
	public UserDao userDao() {
		//when using connectionMaker of 'D' company
		ConnectionMaker connectionMaker = new DConnectionMaker();		
		
		//when using connectionMaker of 'N' company
		//ConnectionMaker connectionMaker = new NConnectionMaker();
		
		UserDao userDao = new UserDao(connectionMaker);
		return userDao;
	}
}
