package com.hndysf.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.service.SeatService;

/**
 * Servlet implementation class UpdateSeatInfoServlet
 */
@WebServlet("/UpdateSeatInfoServlet")
public class UpdateSeatInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSeatInfoServlet() {
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
		
		int seat_id=Integer.parseInt(request.getParameter("seat_id"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		int cols=Integer.parseInt(request.getParameter("cols"));
		
		System.out.println("seat_id="+seat_id+"rows="+rows);
		SeatService service=new SeatService();
		int count=0;
		try {
			count=service.updateSeatInfo(rows, cols, seat_id);
			System.out.println("count="+count);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+ "/AllOrderInfoServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
