package com.hndysf.servlet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.service.OrderService;

/**
 * Servlet implementation class FindUserOrder
 */
@WebServlet("/FindUserOrder")
public class FindUserOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserOrder() {
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
		
		int user_id=Integer.parseInt(request.getParameter("user_id"));
	
		//根据用户编号查询订单
		OrderService oService=new OrderService();
		List<Object> list_user_order=new ArrayList<Object>() ;
		try {
			list_user_order=oService.findOrderByUserId(user_id);
			if(list_user_order!=null) {
				System.out.println("list_user_order="+list_user_order);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list_user_order", list_user_order);
		request.getRequestDispatcher("/client/myInfo/myOrder.jsp").forward(request, response);
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
