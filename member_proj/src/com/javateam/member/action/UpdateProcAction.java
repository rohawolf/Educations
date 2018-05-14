/**
 * 
 */
package com.javateam.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * Servlet implemetation class UpdateProcAction
 * @author Roha Park
 *
 */
@WebServlet("UpdateProc.do")
public class UpdateProcAction extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProcAction() {
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
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	@Override
	protected void doPost(HttpServletRequest req, 
						  HttpServletResponse resp) 
								  throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html); charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		// print parameters
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			String value = req.getParameter(param) == null ? "인자 미전송" 
					: req.getParameter(param).trim().equals("") ? "인자 미전송" 
					: req.getParameter(param).trim();
			out.print(param + " = " + value + "<br />");
		}
		
		boolean flag = false;
		String newPw = "";
		String newPw2 = "";
		
		//check password
		if (	(req.getParameter("new_pw") == null 
				 && 
				 req.getParameter("new_pw2") == null ) 
			||
				(req.getParameter("new_pw").trim().equals("") 
				 && 
				 req.getParameter("new_pw2").trim().equals(""))
			) {			
			// 기존 패스워드 정보 유지
		}
	}
}
