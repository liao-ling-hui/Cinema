package com.hndysf.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hndysf.entity.Seat;
import com.hndysf.entity.User;
import com.hndysf.service.SeatService;

/**
 * Servlet implementation class CheckSeatServlet
 */
@WebServlet("/CheckSeatServlet")
public class CheckSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckSeatServlet() {
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
		
		String order_id=request.getParameter("order_id");
		System.out.println("order_id="+order_id);
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		
		//根据订单编号查询座位信息
		SeatService service=new SeatService();
		List<Seat> seat=new ArrayList<Seat>();
		String info1="",info2="";
		try {
			seat=service.findSeatByOrderId(order_id,user.getUser_id());
			System.out.println("seat="+seat);
			
				info1=seat.get(0).getRows()+"排"+seat.get(0).getCols()+"座";
				
				info2=seat.get(1).getRows()+"排"+seat.get(1).getCols()+"座";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/client/centen/test.jsp?info1="+info1+"&info2="+info2).forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
