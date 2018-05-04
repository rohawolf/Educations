/**
 * 
 */
package com.javateam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		private static final MemberDAOImpl instance = new MemberDAOImpl();		
		public static MemberDAOImpl getInstance() {
			return Singleton.instance;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#connect()
	 */
	@Override
	public Connection connect() { //throws Exception {
		
		//Driver properties
		final String driver = "oracle.jdbc.OracleDriver";			//JDBC Driver for Oracle
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";	//Connection URL
		final String userid = "oraclejava";
		final String userpw = "oraclejava";
				
		Connection con = null;	//initializing
		
		try {
			Class.forName(driver);	//search for JDBC Driver for Oracle
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
		return con;
	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#close(java.sql.ResultSet, java.sql.PreparedStatement, java.sql.Connection)
	 */
	@Override
	public void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.javateam.member.dao.MemberDAO#insertMember(com.javateam.member.vo.MemberVO)
	 */
	@Override
	public void insertMember(MemberVO member) throws Exception {
		// TODO Auto-generated method stub

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
