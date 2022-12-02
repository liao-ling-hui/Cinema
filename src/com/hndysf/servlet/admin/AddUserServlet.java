package com.hndysf.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.entity.User;
import com.hndysf.service.UserService;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取值
		String name=request.getParameter("user_name");
		String pwd=request.getParameter("user_pwd");
		String sex=request.getParameter("user_sex");
		String phone=request.getParameter("user_phone");
		
		
		User u=new User();
		u.setUser_name(name);
		u.setUser_password(pwd);
		u.setUser_sex(sex);
		u.setUser_phone(phone);
		
		UserService uService=new UserService();
		int count=0;
		try {
			count=uService.add_user(u);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		response.sendRedirect(request.getContextPath()+"/AllUserInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
