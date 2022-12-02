package com.hndysf.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hndysf.entity.Movie;
import com.hndysf.entity.Order;
import com.hndysf.service.MovieService;
import com.hndysf.service.OrderService;

/**
 * Servlet implementation class AllOrderInfoServlet
 */
@WebServlet("/AllOrderInfoServlet")
public class AllOrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllOrderInfoServlet() {
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
		
		OrderService service=new OrderService();
		List<Order> list_order=new ArrayList<Order>();
		try {
			list_order=service.findAllOrder();
			System.out.println("list_order="+list_order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("list_order", list_order);
		request.getRequestDispatcher("/admin/order/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
