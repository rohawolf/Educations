/**
 * 
 */
package com.roha.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * the Factory class that has responsablity of make instance of UserDao class
 * @author Roha Park
 *
 */
@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao() {		
		return new UserDao(connectionMaker());
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
