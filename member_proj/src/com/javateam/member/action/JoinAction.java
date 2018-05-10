package com.javateam.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;
import com.javateam.member.util.RegexUtil;
import com.javateam.member.vo.MemberVO;

/**
 * Servlet implementation class JoinAction
 */
@WebServlet("/join.do")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("join.do: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");			
		
		MemberDAO dao = MemberDAOImpl.getInstance();
		MemberVO member = new MemberVO();
		
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));
		
		request.setAttribute("member", member);
		
		if( this.hasErrors(request) ) {
			request.getRequestDispatcher("insertMember.jsp").forward(request, response);
		}
		else {			
			try {				
				//dao.insertMember(member);				
			} catch (Exception e) {				
				e.printStackTrace();
			}			
			request.getRequestDispatcher("viewMember.jsp").forward(request, response);			
		}
					
	}
	/**
	 * Check whether Form data is on regex or not	
	 * @return boolean
	 */
	private boolean hasErrors(final HttpServletRequest request) {
		boolean flag = false;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");		
		
		String id_msg = "";
		String pw_msg = "";
		String name_msg = "";
		
		if ( !RegexUtil.isValidRegex("[a-zA-Z]{1}\\w{7,19}", id) ) {
			/*
			 	1. 아이디 정규표현식 점검
 					1) 길이(length) : 8~20
 					2) 첫자 제한: alphabet(영문)으로 시작
 					3) 한글 입력 제한 : 불가.
 					4) 제약조건 : 영문자 및 숫자만을 허용			 
			 */
			if ( id.equals("") )	id_msg = "\t- 아이디 입력 누락!";	
			else					id_msg = "\t- 잘못된 아이디를 입력했습니다!";
			flag = true;
		}
		
		if ( !RegexUtil.isValidRegex("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,20}", pw) ) {
			/*
			 	2. 암호 정규표현식 점검
					1) 길이(length) 8~20 : {8,20}
					2) 최소 1개의 숫자 포함 : (?=.*\d)
					3) 최소 1개의 특수문자 포함 : (?=.*\W)
					4) 대문자 1개 이상 포함 : (?=.*[A-Z])
					5) 소문자 1개 이상 포함 : (?=.*[a-z])
			 */
			if ( pw.equals("") )	pw_msg = "\t- 패스워드 입력 누락!";	
			else					pw_msg = "\t- 잘못된 패스워드를 입력했습니다!"	;
			flag = true;
		}
		
		if ( !RegexUtil.isValidRegex("[가-힣]{2,20}|[a-zA-Z]{2,20}\\s[a-zA-Z]{2,20}", name) ) {
			/*
			 	3. 이름 정규표현식 점검
			 		1) 한글 - '가 ~ 힣' 사이의 글자 2 ~ 20 자
			 		2) 알파벳 - 20글자 + 공백 + 20글자 형태
			 */
			if ( name.equals("") )	name_msg = "\t- 이름 입력 누락!";	
			else					name_msg = "\t- 잘못된 이름을 입력했습니다!";
			flag = true;
		}
		request.setAttribute("id_msg", id_msg);
		request.setAttribute("pw_msg", pw_msg);
		request.setAttribute("name_msg", name_msg);
		
		return	flag; 
	}
}
