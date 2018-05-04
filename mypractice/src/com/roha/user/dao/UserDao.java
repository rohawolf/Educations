/**
 * 
 */
package com.roha.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.roha.user.domain.User;

/**
 * @author Roha Park
 *
 */
public class UserDao {	
	private ConnectionMaker connectionMaker;
	public UserDao() {
		connectionMaker = new DConnectionMaker();
	}
	public void add(User user) throws ClassNotFoundException, SQLException {		
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement(
			"INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {		
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement(
			"SELECT * FROM users WHERE id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
 		UserDao dao = new UserDao();
 		
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

