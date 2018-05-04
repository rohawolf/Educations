/**
 * 
 */
package com.roha.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ex)
 * getConnection() implementation of 'N' company
 * @author Roha Park
 *
 */
public class NUserDao extends UserDao {
	
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Driver properties for DB Connection of 'N' company
		final String driver = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String DBid = "n";
		final String DBpw = "n";
		
		Class.forName(driver);
		Connection c = DriverManager.getConnection(url, DBid, DBpw);
		
		// something more code..
		
		return c;
	}

}
