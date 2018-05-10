/**
 * 
 */
package com.javateam.member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Utility class for DB connection, close, etc..
 * @author Roha Park
 *
 */
public class DBUtil {
	
	/**
	 * connect DB
	 * @return DB Connection Object
	 * @throws Exception
	 */
	public static Connection connect() { 
		// JDBC direct connecting
		//  Driver properties for Connection instance
		final String driver = "oracle.jdbc.OracleDriver";			//JDBC Driver for Oracle
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";	//Connection URL
		final String user = "oraclejava";
		final String password = "oraclejava";
				
		Connection con = null;	//initializing
		
		try {			
			Class.forName(driver);	//search for JDBC Driver for Oracle
			con = DriverManager.getConnection(url, user, password);			
		} 
		catch (ClassNotFoundException | SQLException e) {
			// NOTICE! : JDK 1.7 over only
			System.out.println("Error in connect() : ");
			e.printStackTrace();
		}		
		return con;
	}
	
	/**
	 * connect DB with DataSource
	 * @param  jndi (Java Naming & Directory Interface) ex)jdbc/oraclejava
	 * @return DB Connection Object
	 * @throws Exception
	 */
	public static Connection connect(String jndi) { 
		Connection con = null;		
		
		try {
			
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/" + jndi);
			con = ds.getConnection();
			
		} catch (NamingException | SQLException e) {
			System.out.println("Error in connect(jndi) : ");
			e.printStackTrace();		
		}
		
		return con;
	}
	
	/**
	 * disconnect DB & return resources
	 * @param rs		DB query result Set object
	 * @param pstmt		DB query object
	 * @param con		DB connection object
	 * @throws Exception
	 */
	public static void close(ResultSet rs, 
							 PreparedStatement pstmt, 
							 Connection con) { //throws Exception {		
		try {				
			if(rs != null)		rs.close();
			if(pstmt != null)	pstmt.close();
			if(con != null)		con.close();
		} catch (SQLException e) {
			System.out.println("Error in close() : ");
			e.printStackTrace();
		}
	}
}
