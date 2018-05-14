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

/**
 * Servlet implementation class DeleteAction
 */
@WebServlet("/delete.do")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
								throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) 
								throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String msg = "";		
		String id = request.getParameter("id") == null ? "" : request.getParameter("id");
		String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw");		
			
		MemberDAO dao = MemberDAOImpl.getInstance();
		try {
			msg = dao.hasMember(id, pw);
			switch (msg) {
			
			case "회원입니다.":
				out.print("<script>alert('" + id + " 삭제 성공.');</script>");
				dao.deleteMember(id);
				break;
				
			case "존재하지 않는 ID입니다.":
				request.setAttribute("id_msg", msg);
				request.getRequestDispatcher("deleteMember.jsp").forward(request, response);
				break;
				
			case "패스워드가 틀렸습니다.":
				request.setAttribute("pw_msg", msg);
				request.getRequestDispatcher("deleteMember.jsp").forward(request, response);
				break;
				
			}				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}	
}
