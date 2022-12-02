package com.hndysf.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.entity.Order;
import com.hndysf.service.OrderService;

/**
 * Servlet implementation class SearchOrderByUser
 */
@WebServlet("/SearchOrderByUser")
public class SearchOrderByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderByUser() {
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
		
		String user_name=request.getParameter("user_name");
		System.out.println("search_name="+user_name);
		
		OrderService service=new OrderService();
		List<Order> list_order=new ArrayList<Order>();
		try {
			list_order=service.findOrderByUser(user_name);
			System.out.println("list_order="+list_order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list_order", list_order);
		request.getRequestDispatcher("/admin/order/order.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+ "/admin/order/order.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
