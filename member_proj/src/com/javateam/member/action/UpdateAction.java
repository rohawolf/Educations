/**
 * 
 */
package com.javateam.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;
import com.javateam.member.vo.MemberVO;

/**
 * Servlet implementation class UpdateAction
 * @author Roha Park
 *
 */
@WebServlet("/Update.do")
public class UpdateAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	@Override
	protected void doGet(HttpServletRequest req, 
					     HttpServletResponse resp) 
					    		 throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = resp.getWriter();
		
		if (req.getParameter("id") == null) {
			out.print("회원 아이디를 입력하십시오!");
		} else {
			String id = req.getParameter("id").trim();
			MemberDAO dao = MemberDAOImpl.getInstance();
			MemberVO member = null;
			
			try {
				member = dao.getMember(id);
				System.out.println(member);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// load member on session
			HttpSession session = req.getSession();
			session.setAttribute("member", member);
			
			//forward with session data => updateMember.jsp
			req.getRequestDispatcher("updateMember.jsp").forward(req, resp);
		}		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	@Override
	protected void doPost(HttpServletRequest req, 
						  HttpServletResponse resp) 
								  throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
