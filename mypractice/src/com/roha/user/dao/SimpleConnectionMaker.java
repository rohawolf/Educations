/**
 * 
 */
package com.roha.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * separated DB connection class
 * @author Roha Park
 *
 */
public class SimpleConnectionMaker {
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		// Driver properties for DB Connection of 'N' company
		final String driver = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String DBid = "roha";
		final String DBpw = "roha";
				
		Class.forName(driver);
		Connection c = DriverManager.getConnection(url, DBid, DBpw);
			
		return c;
	}
}
