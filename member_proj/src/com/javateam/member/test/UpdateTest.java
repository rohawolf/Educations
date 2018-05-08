/**
 * 
 */
package com.javateam.member.test;

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;
import com.javateam.member.vo.MemberVO;

/**
 * MemberDAOImpl.updateMember(MemberVO) Unit Test
 * @author Roha Park
 */
public class UpdateTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 1. Create infomations of a member to update
		MemberVO member = new MemberVO();
		member.setId("guro1234");
		member.setPw("11111111");
		member.setName("임나연");
		member.setAddress("서울 관악구 신림동");
		
		// 2. get DAO instance
		MemberDAO dao = MemberDAOImpl.getInstance();
		
		// 3. call DAO method ( insertMember() )
		dao.updateMember(member);	

	}

}
