/**
 * 
 */
package com.javateam.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.javateam.member.vo.MemberVO;

/**
 * DAO implementation class
 * @author Roha Park
 *
 */
public final class MemberDAOImpl implements MemberDAO {	
	
	// Singleton Pattern : for Security.
	// to make instance 'ONCE'.
	// ex) MemberDAO dao = MemberDAOImpl.getInstance();
	
	private MemberDAOImpl() {}	
	// way 1.
	// high multi-Threading cost..
	/*
	private static MemberDAOImpl instance = null;
	public final static MemberDAOImpl getInstance() {
		if (instance == null) {
			instance = new MemberDAOImpl();
		}
		return instance;
	}
	*/
	// way 2.
	private static class Singleton {
		private final static MemberDAOImpl instance = new MemberDAOImpl();		
	}
	public static MemberDAOImpl getInstance() {
		return Singleton.instance;
	}
	
	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#connect()
	 */
	@Override
	public Connection connect() { //throws Exception {
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

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#close(java.sql.ResultSet, java.sql.PreparedStatement, java.sql.Connection)
	 */
	@Override
	public void close(ResultSet rs, 
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

	/**
	 * @see com.javateam.member.dao.MemberDAO#insertMember(com.javateam.member.vo.MemberVO)
	 */
	@Override
	public void insertMember(MemberVO member) { //throws Exception {
			// 1. connect DB
		Connection con = this.connect();
		
			// 2. construct SQL query
		String sql = "INSERT INTO member "
				+ 	 "VALUES(?, ?, ?, ?, SYSDATE)";
				
			// 3. make instance executing SQL query
		PreparedStatement pstmt = null;		
		try {
			// 4. SQL query parsing
			pstmt = con.prepareStatement(sql);
			
			// 5. set parameters of SQL query
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			
			// 6. execute SQL query, messaging
			// int executeUpdate() : return the row count which had been updated.
			//					 	 In this time, it should be 1.
			if (pstmt.executeUpdate() == 1) {
				// update success. (1 row updated.)
				System.out.println("Thank you for join us, " + member.getId() + "!");
			} else {
				// no row updated.
				System.out.println("fail to join.");
			}
			
		} catch (SQLException e) {			
			System.out.println("Error in insertMember() : ");
			e.printStackTrace();			
		} finally {
			// 7. close all resources
			this.close(null, pstmt, con);
		}			
	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#getAllMembers()
	 */
	@Override
	public List<MemberVO> getAllMembers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#getMember(java.lang.String)
	 */
	@Override
	public MemberVO getMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#updateMember(com.javateam.member.vo.MemberVO)
	 */
	@Override
	public void updateMember(MemberVO member) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#deleteMember(java.lang.String)
	 */
	@Override
	public void deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub

	}

}
