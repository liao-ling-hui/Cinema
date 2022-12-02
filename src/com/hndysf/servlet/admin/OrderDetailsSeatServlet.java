package com.hndysf.servlet.admin;

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
 * Servlet implementation class OrderDetailsSeatServlet
 */
@WebServlet("/OrderDetailsSeatServlet")
public class OrderDetailsSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailsSeatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String order_id=request.getParameter("order_id");
		System.out.println("order_id="+order_id);
		OrderService service=new OrderService();
		List<Object> list=new ArrayList<Object>();
		try {
			list=service.findOrderDeatailsByOrderId(order_id);
			System.out.println("order_details="+list.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("orderDeatils", list);
		
		request.getRequestDispatcher("/admin/order/order_details.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+ "/admin/order/order_details.jsp");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
