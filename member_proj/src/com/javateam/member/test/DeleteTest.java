/**
 * 
 */
package com.javateam.member.test;

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;

/**
 * MemberDAOImpl.deleteMember() Unit Test
 * @author Roha Park
 *
 */
public class DeleteTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 1. get DAO instance
		MemberDAO dao = MemberDAOImpl.getInstance();
		
		// 2. check there is member who has id as parameter.
		dao.hasMember("abc456", "123123");	// id doesn't exists.
		dao.hasMember("abc123", "123123");	// id exists, but wrong pw.
		dao.hasMember("abc123", "1234"); 	// id, pw are all correct.
		
		// 3. call deleteMember() method
		//dao.deleteMember("guro1234");
	}

}
