/**
 * 
 */
package com.roha.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ex)
 * getConnection() implementation of 'D' company
 * @author Roha Park
 *
 */
public class DUserDao extends UserDao {
	
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Driver properties for DB Connection of 'N' company
		final String driver = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String DBid = "d";
		final String DBpw = "d";
		
		Class.forName(driver);
		Connection D = DriverManager.getConnection(url, DBid, DBpw);
		
		// something more code..
		
		return D;
	}

}
