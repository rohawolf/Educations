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
 * DAO (Data Access Object) : CRUD methods ( + connection & return resources)
 * @author Roha Park
 *
 */
public interface MemberDAO {
	// Singleton Pattern : for Security
	// MemberDAO dao = MemberDAOImpl.getInstance();
	
	// DB connection & close => Later, it would be separated.
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
	
	// CRUD methods
	/**
	 * insert member informations ( CRUD - C : create)
	 * @param member	member information object ( MemberVO instance)
	 * @throws Exception
	 */
	void insertMember(MemberVO member) throws Exception;
	
	/**
	 * get 'all' informations of members (CRUD - R : Read)
	 * @return List<MemberVO>
	 * @throws Exception
	 */
	List<MemberVO> getAllMembers() throws Exception;
	
	/**
	 * get 'a' informations of member (CRUD - R : Read)
	 * @param id        	id (primary key of member table)
	 * @return MemberVO		the instance of the member which has id as parameter 'id'		
	 * @throws Exception
	 */
	MemberVO getMember(String id) throws Exception;
	
	/**
	 * modify & update member informations (CRUD - U : Update)
	 * @param member	member information object ( MemberVO instance)
	 * @throws Exception
	 */
	void updateMember(MemberVO member) throws Exception;
	
	/**
	 * delete the member which has id as parameter 'id' (CRUD - D : Delete)
	 * @param id			id (primary key of member table)
	 * @throws Exception
	 */
	void deleteMember(String id) throws Exception;
	
	/**
	 * check whether the member who has id as the value of String parameter exists. 
	 * @param id
	 * @return boolean
	 * @throws Exception
	 */
	boolean isMember(String id) throws Exception;
	
}
