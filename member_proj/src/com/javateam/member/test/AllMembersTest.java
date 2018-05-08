/**
 * 
 */
package com.javateam.member.test;

import java.util.List;

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;
import com.javateam.member.vo.MemberVO;

/**
 * MemberDAOImpl.getAllMembers(), getMember(String id), and isMember(String id) Unit Test
 * @author Roha Park
 */
public class AllMembersTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 1. get DAO instance
		MemberDAO dao = MemberDAOImpl.getInstance();
		
		// 2. call DAO method + get results
		List<MemberVO> members = dao.getAllMembers();
		
		// 3. print result
		System.out.println("=== getAllMembers() Test ===");
		for(MemberVO member : members) {
			System.out.println(member);			
		}
		
		/*
		 * OR (2 + 3 together)
		 * for(MemberVO member : dao.getAllMembers()) {
		 * 		System.out.println(member)
		 * }
		 */
		
		// 4. getMember(String id) test
		System.out.println("\n=== getMember(String id) Test ===");
		System.out.println(dao.getMember("guro1234"));
		
		// 5. getMember(String id) test
		System.out.println("\n=== isMember(String id) Test ===");
		System.out.println(dao.isMember("guro1234"));
		System.out.println(dao.isMember("abc123"));
		System.out.println(dao.isMember("oracle1234"));
	}

}
