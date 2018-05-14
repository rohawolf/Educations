package com.javateam.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;
import com.javateam.member.vo.MemberVO;

/**
 * Servlet implementation class ViewMemberAction
 */
@WebServlet("/viewMember.do")
public class ViewMemberAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMemberAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException{
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (request.getParameter("id") == null) {
			out.print("<script>alert('회원 아이디를 입력하십시오.');</script>");
		}		
		else {
			String id = request.getParameter("id").trim();
			MemberDAO dao = MemberDAOImpl.getInstance();
			MemberVO member = null;
			try {
				member = dao.getMember(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 회원정보 -> jsp : 인자화
			// 1) 각 정보 인자화
			/*
			request.setAttribute("id", member.getId());
			request.setAttribute("pw", member.getPw());
			request.setAttribute("name", member.getName());
			request.setAttribute("address", member.getAddress());
			request.setAttribute("joindate", member.getJoindate());
			*/
			// 2) 통째로 인자화
			request.setAttribute("member", member);
			
			// viewMember.jsp로 포워딩
			request.getRequestDispatcher("viewMember.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
