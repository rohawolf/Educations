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

import com.javateam.member.dao.MemberDAO;
import com.javateam.member.dao.MemberDAOImpl;
import com.javateam.member.util.RegexUtil;
import com.javateam.member.vo.MemberVO;

/**
 * Servlet implemetation class UpdateProcAction
 * @author Roha Park
 *
 */
@WebServlet("/updateProc.do")
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
		
		int flag = 0;
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
		}  else {
           
            newPw = req.getParameter("new_pw").trim();
            newPw2 = req.getParameter("new_pw2").trim();
           
            // 신규 패쓰워드/확인 동일성 여부
            if (!newPw.equals(newPw2)) {
                req.setAttribute("pw_msg", "신규 패스워드가 일치하지 않습니다.");// 회원가입 페이지로 돌아감(forward)
                flag--;
            } else {
                flag++;
            }
           
            // 폼점검 : 패쓰워드
            if (!RegexUtil.isValidRegex("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,20}", newPw) ||
                !RegexUtil.isValidRegex("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,20}", newPw2))
            {
                req.setAttribute("pw_msg",
                            "패쓰워드는 특수문자,대/소문자,숫자가 1자 이상 들어가면서 8~20자로 입력하세요.");
                flag--;
            } else {
                flag++;
            }
       
        } // 패쓰워드 if
       
        String name = req.getParameter("name").trim();
       
        // 폼점검 : 이름
        // 기존 이름과의 동일성, regex 폼점검
        if (name.equals("") ||
           !RegexUtil.isValidRegex("[가-힣]{2,25}", name)) {
           
            req.setAttribute("name_msg",
                                 "이름은 2자 이상 한글로 입력하십시오.");
            flag--;
        } else {
            flag++;
        } // 이름 if
       
        System.out.println("flag="+flag);
       
        if (flag<1) {
            req.getRequestDispatcher("updateMember.jsp").forward(req, resp);
        }
       
        if (flag>=1) {
            // 폼점검 후 필드값, 폼점검 플래그 출력
            out.print("-------------------------------------<br>");
            out.print("폼점검 플래그 : "+flag+"<br>");
            out.print("신규 패쓰워드 : " + newPw+"<br>");
            out.print("이름 : "+name);
           
            MemberDAO dao = MemberDAOImpl.getInstance();
           
            // 기존 정보 입력-1) HttpSession session = request.getSession();
            MemberVO member = new MemberVO();
            // 기존 정보 입력-1) member = (MemberVO)session.getAttribute("member");
            // 기존 정보 입력-2)
            try {
            	member = dao.getMember(req.getParameter("id"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
           
            // 갱신(수정) 정보 입력
            // member.setPw();
           
           
            try {
            	dao.updateMember(member);
            } catch (Exception e) {
                e.printStackTrace();
            } //
        }
	}
}
