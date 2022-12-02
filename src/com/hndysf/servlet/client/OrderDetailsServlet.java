package com.hndysf.servlet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hndysf.service.OrderService;

/**
 * Servlet implementation class OrderDetailsServlet
 */
@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailsServlet() {
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
		
		//获取订单编号
		String order_id=request.getParameter("order_id");
		//获取座位信息
		String seats=request.getParameter("seats");
		System.out.println("order_id="+order_id+"seats="+seats);
		
		//根据编号查询
		OrderService service=new OrderService();
		List<Object> order_list=new ArrayList<Object>();
		try {
			order_list=service.findOrderByOrderId(order_id);
			if(order_list!=null) {
				System.out.println("order_list=");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("order_list", order_list);
		
		response.sendRedirect(request.getContextPath()+"/client/orderdetails.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
