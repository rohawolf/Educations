/**
 * 
 */
package com.roha.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ex) the 'D' company implements ConnectionMaker interface 
 * @author Roha Park
 *
 */
public class DConnectionMaker implements ConnectionMaker {
	
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		// Driver properties for DB Connection of 'D' company
		final String driver = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String DBid = "roha";
		final String DBpw = "roha";
				
		Class.forName(driver);
		Connection c = DriverManager.getConnection(url, DBid, DBpw);
		
		// something other codes of 'D' company	
		
		return c;
	}
	
}
