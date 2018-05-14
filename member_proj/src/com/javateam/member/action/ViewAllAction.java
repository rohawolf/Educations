package com.javateam.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;

/**
 * Servlet implementation class ViewAllAction
 */
@WebServlet("/viewAll.do")
public class ViewAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
					throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		//PrintWriter out = response.getWriter();
		
		MemberDAO dao = MemberDAOImpl.getInstance();
		try {
			
			// List<MemberVO> members = dao.getAllMembers();
			// request.setAttribute("members", members);
			request.setAttribute("members", dao.getAllMembers());
			request.getRequestDispatcher("viewAllMembersJSTL.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) 
					throws ServletException, IOException {
		doGet(request, response);
	}

}
