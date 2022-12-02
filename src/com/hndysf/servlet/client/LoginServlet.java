package com.hndysf.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hndysf.entity.Admin;
import com.hndysf.entity.User;
import com.hndysf.service.AdminService;
import com.hndysf.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String password=request.getParameter("password");
		
		String ph = "^[1][3578]\\d{9}$";//手机号登录
		
		System.out.println("name="+name+"password="+password);
		
		UserService uService=new UserService();
		User u=new User();
		AdminService aService=new AdminService();
		Admin admin=new Admin();
		String info="";
		HttpSession session=request.getSession();
		User user_exist=uService.isExist(name);
		//System.out.println(user_exist.getUser_name());
		try {
			if(name.matches(ph)) {
				u=uService.login_phone(name, password);//这里的name 代表手机号
			}else {
				u=uService.login_name(name, password);
			}
			
				
			if(name.equals("admin")) {
				admin=aService.loginAdmin(name, password);
				
				if(!password.equals(admin.getPassword())) {
					info="'管理员密码错误'";
					session.setAttribute("info", info);
					response.getWriter().print("<script>alert(" + info + ");window.location='ToLoginServlet'; </script>");
				}else {
					session.setAttribute("admin", admin);
					response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
					Cookie cookie=new Cookie("JSESSIONID",session.getId());
					cookie.setMaxAge(60*30);
					cookie.setPath("/Cinema");
					response.addCookie(cookie);
				}
				
				
				
			}else if(!name.equals(user_exist.getUser_name())){
					info="'用户不存在'";
				
				session.setAttribute("info", info);
				response.getWriter().print("<script>alert(" + info + ");window.location='ToRegisterServlet'; </script>");
			}else {
				if(!password.equals(u.getUser_password())) {
					info="'用户密码错误'";
					session.setAttribute("info", info);
					response.getWriter().print("<script>alert(" + info + ");window.location='ToLoginServlet'; </script>");
				}else {
					request.getSession().setAttribute("user", u);
					response.sendRedirect(request.getContextPath()+"/index.jsp");
					Cookie cookie=new Cookie("JSESSIONID",session.getId());
					cookie.setMaxAge(60*30);
					cookie.setPath("/Cinema");
					response.addCookie(cookie);
				}
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
