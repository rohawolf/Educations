/**
 * 
 */
package com.javateam.member.dao;

import java.util.List;

import com.javateam.member.vo.MemberVO;

/**
 * DAO (Data Access Object) : CRUD methods
 * @author Roha Park
 *
 */
public interface MemberDAO {
	// Singleton Pattern : for Security
	// MemberDAO dao = MemberDAOImpl.getInstance();
	
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
	
	/**
	 * check whether the input data is a member or not
	 * @param id
	 * @param pw
	 * @return
	 * @throws Exception
	 */
	String hasMember(String id, String pw) throws Exception;
	
}
