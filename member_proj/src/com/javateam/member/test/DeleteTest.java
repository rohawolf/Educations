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
		
		// 2. call deleteMember() method
		dao.deleteMember("guro1234");
	}

}
