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
 * Servlet implementation class UpdatePwdOrSexServlet
 */
@WebServlet("/UpdatePwdOrSexServlet")
public class UpdatePwdOrSexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdOrSexServlet() {
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
		//获取输入的密码或性别
		String pwd=request.getParameter("pwd");
		String sex=request.getParameter("sex");
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		System.out.println("pwd="+pwd+"sex="+sex+"user_id="+user_id);
		
		String info="修改成功！";
		UserService uService=new UserService();
		try {
			int count=uService.updatePwdOrSexById(pwd, sex,user_id);
			if(count>0) {
				System.out.println("count="+count);
				request.getRequestDispatcher("/client/login.jsp").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/client/myInfo/myAccount.jsp");
				//response.getWriter().print("<script>alert(" + info + ");window.location='ToBaseInfoServlet'; </script>");
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
