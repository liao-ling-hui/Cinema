package com.hndysf.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hndysf.entity.User;
import com.hndysf.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		
		User u=new User();
		u.setUser_name(name);
		u.setUser_phone(tel);
		u.setUser_password(password);
		
		UserService service=new UserService();
		HttpSession session=request.getSession();
		String info="";
		try {
			User user=service.isExist(name);
			System.out.println("user_name="+user.getUser_name());
			if(name.equals(user.getUser_name())) {
				info="'用户已存在'";
				
				session.setAttribute("info", info);
				response.getWriter().print("<script>alert(" + info + ");window.location='ToLoginServlet'; </script>");
			}else {
				int count=service.addUser(u);
				System.out.println("conut="+count);
				response.sendRedirect(request.getContextPath()+"/client/login.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
