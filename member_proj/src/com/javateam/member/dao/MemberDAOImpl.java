/**
 * 
 */
package com.javateam.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public void insertMember(MemberVO member) throws Exception {
			// 1. connect DB
		Connection con = this.connect();
		
			// 2. construct SQL query
		StringBuilder sql = new StringBuilder("");
		sql.append("INSERT INTO member ")
		   .append("VALUES(?, ?, ?, ?, SYSDATE)");
				
			// 3. make instance executing SQL query
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		try {
			con.setAutoCommit(false); // manual commit mode on.
			
			
			// 4. SQL query parsing
			pstmt = con.prepareStatement(sql.toString());
			
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
			
			
			con.commit();
			
		} catch (SQLException e) {			
			System.out.println("Error in insertMember() : ");
			con.rollback();
			e.printStackTrace();			
		} finally {
			// 7. close all resources
			this.close(rs, pstmt, con);
		}			
	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#getAllMembers()
	 */
	@Override
	public List<MemberVO> getAllMembers() throws Exception {
			// 1. create return object & connect DB
		List<MemberVO> members = new ArrayList<>();
		Connection con = this.connect();
		
			// 2. construct SQL query
		String sql = "SELECT * FROM member" ;
				
			// 3. make instance executing SQL query
		PreparedStatement pstmt = null;
		
			// 4. make ResultSet instance
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			
			
			// 5. SQL query parsing 
			pstmt = con.prepareStatement(sql);
			
			// 6. execute SQL query & get ResultSet
			rs = pstmt.executeQuery();
			 
			// 7. get infomations to members
			/*
			 * 	1) 1 row = 1 MemberVO
			 * 
			 */
			while (rs.next()) {
				MemberVO member = new MemberVO();
				
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setAddress(rs.getString("address"));
				member.setJoindate(rs.getDate("joindate"));
				
				// OR
				/*
				 * MemberVO memeber = new MemberVO(rs.getString("id"),
				 * 								   rs.getString("pw"),
				 * 								   rs.getString("name"),
				 * 								   rs.getString("address"),
				 * 								   rs.getDate("joindate") );
				 */
				members.add(member);
			}			
			
			
			con.commit();
			
		} catch (SQLException e) {
			con.rollback();
			System.out.println("Error in getAllMembers() : ");
			e.printStackTrace();			
		} finally {
			// 8. close all resources
			this.close(rs, pstmt, con);
		}
		return members;
	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#getMember(java.lang.String)
	 */
	@Override
	public MemberVO getMember(String id) throws Exception {
			// 1. create return object & connect DB
		MemberVO member = new MemberVO();
		Connection con = this.connect();
		
			// 2. construct SQL query
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM member ")
		   .append("where id = ? ");
				
			// 3. make instance executing SQL query
		PreparedStatement pstmt = null;
		
			// 4. make ResultSet instance
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			
			
			// 5. SQL query parsing & set parameters of SQL query
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			// 6. execute SQL query & get ResultSet
			rs = pstmt.executeQuery();
			 
			// 7. get infomations to members
			
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setAddress(rs.getString("address"));
				member.setJoindate(rs.getDate("joindate"));
			}
			
			
			con.commit();
			
		} catch (SQLException e) {		
			con.rollback();
			System.out.println("Error in getMember() : ");
			e.printStackTrace();			
		} finally {
			// 8. close all resources
			this.close(rs, pstmt, con);
		}
		return member;
	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#updateMember(com.javateam.member.vo.MemberVO)
	 */
	@Override
	public void updateMember(MemberVO member) throws Exception {
			// 1. connect DB
		Connection con = this.connect();
		
			// 2. construct SQL query
		StringBuilder sql = new StringBuilder("");
		sql.append("UPDATE member SET ")
		   .append("pw = ?, ")
		   .append("name = ?, ")
		   .append("address = ? ")
		   .append("WHERE id = ?");
		
			// 3. make instance executing SQL query
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			
			
			// 4. SQL query parsing
			pstmt = con.prepareStatement(sql.toString());
			
			// 5. set parameters of SQL query
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getId());
			
			// 6. execute SQL query, messaging
			// int executeUpdate() : return the row count which had been updated.
			//					 	 In this time, it should be 1.
			if (pstmt.executeUpdate() == 1) {
				// update success. (1 row updated.)
				System.out.println("Update Successful!");
			} else {
				// no row updated.
				System.out.println("fail to update.");
			}
			
			
			con.commit();
			
		} catch (SQLException e) {	
			con.rollback();
			System.out.println("Error in updateMember() : ");
			e.printStackTrace();			
		} finally {
			// 7. close all resources
			this.close(rs, pstmt, con);
		}			
	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#deleteMember(java.lang.String)
	 */
	@Override
	public void deleteMember(String id) throws Exception {
			// 1. connect DB
		Connection con = this.connect();
		
			// 2. construct SQL query
		StringBuilder sql = new StringBuilder("");
		sql.append("DELETE FROM member ")		   
		   .append("WHERE id = ?");
		
			// 3. make instance executing SQL query
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			
			
			// 4. SQL query parsing
			pstmt = con.prepareStatement(sql.toString());
			
			// 5. set parameters of SQL query
			pstmt.setString(1, id);
			
			// 6. execute SQL query, messaging
			// int executeUpdate() : return the row count which had been updated.
			//					 	 In this time, it should be 1.
			if (pstmt.executeUpdate() == 1) {
				// update success. (1 row updated.)
				System.out.println("Delete Successful!");
			} else {
				// no row updated.
				System.out.println("fail to Delete.");
			}
			
			
			con.commit();
			
		} catch (SQLException e) {
			con.rollback();
			System.out.println("Error in deleteMember() : ");
			e.printStackTrace();			
		} finally {
			// 7. close all resources
			this.close(rs, pstmt, con);
		}				
	}
	
	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#isMember(java.lang.String)
	 */
	@Override
	public boolean isMember(String id) throws Exception {
			// 1. make result object & connect DB
		boolean result = false;
		Connection con = this.connect();
		
			// 2. construct SQL query
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM member ")
		   .append("WHERE id = ?");
		
			// 3. make instance executing SQL query
		PreparedStatement pstmt = null;
		
			// 4. make ResultSet instance
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);			
			
			
			// 5. SQL query parsing & set parameters of SQL query
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			// 6. execute SQL query & get ResultSet
			rs = pstmt.executeQuery();
			
			// 7. get result whether the member exists or not.
			result = rs.next(); // if exists, return true			
			
			
			con.commit();	
			
		} catch(SQLException e) {
			con.rollback();
			System.out.println("Error in isMember() : ");
			e.printStackTrace();
		} finally {
			this.close(rs, pstmt, con);
		}
		return result;
	}
	
	
}
