/**
 * 
 */
package com.javateam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javateam.member.vo.MemberVO;

/**
 * DAO (Data Access Object) : CRUD methods
 * @author Roha Park
 *
 */
public interface MemberDAO {
	// Singleton Pattern : for Security
	// MemberDAO dao = MemberDAOImpl.getInstance();
	
	// DB connection & close => 향후 분리
	/**
	 * connect DB
	 * @return DB Connection Object
	 * @throws Exception
	 */
	Connection connect() throws Exception;
	
	/**
	 * disconnect DB & return resources
	 * @param rs		DB query result Set object
	 * @param pstmt		DB query object
	 * @param con		DB connection object
	 * @throws Exception
	 */
	void close(ResultSet rs,
			   PreparedStatement pstmt,
			   Connection con) throws Exception;
	/**
	 * insert member informations ( CRUD - C : create)
	 * @param member	member information object ( MemberVO instance)
	 * @throws Exception
	 */
	void insertMember(MemberVO member) throws Exception;
	
	/**
	 * modify & update member informations ( CRUD - U : Update)
	 * @param member	member information object ( MemberVO instance)
	 * @throws Exception
	 */
	void updateMember(MemberVO member) throws Exception;
	
}
