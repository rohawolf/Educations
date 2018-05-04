/**
 * 
 */
package com.javateam.member.test;

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;
import com.javateam.member.vo.MemberVO;

/**
 * MemberDAOImpl.insertMember(MemberVO) Unit Test
 * @author Roha Park
 *
 */
public class InsertTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 1. input infomations of a member
		/*
		 * MemberVO member1 = new MemberVO();
		 * member1.setId("guro1234); ...
		 * 
		 * or
		 */
		MemberVO member1 = new MemberVO("guro1234",
										"12345678",
										"장길산",
										"서울 구로구 대림동");
		MemberVO member2 = member1;
		
		// 2. get DAO instance
		MemberDAO dao = MemberDAOImpl.getInstance();
		
		// 3. call DAO method ( insertMember() )
		dao.insertMember(member1);
		dao.insertMember(member2);
	}

}
