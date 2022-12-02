package com.hndysf.servlet.admin;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.entity.Movie;
import com.hndysf.entity.Order;
import com.hndysf.entity.Seat;
import com.hndysf.service.MovieService;
import com.hndysf.service.OrderService;
import com.hndysf.service.SeatService;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
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
		
		//获取数据
		int mvoie_id=Integer.parseInt(request.getParameter("movie_id"));
		int schedule_id=Integer.parseInt(request.getParameter("schedule_id"));
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		String cinema_name=request.getParameter("cinema_id");
		int hall_id=Integer.parseInt(request.getParameter("hall_id"));
		int category_id=Integer.parseInt(request.getParameter("category_id"));
		double order_total_price=Double.parseDouble(request.getParameter("order_total_price"));
		int order_count=Integer.parseInt(request.getParameter("order_count"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		int cols=Integer.parseInt(request.getParameter("cols"));
		String see_time=request.getParameter("see_time");
		System.out.println("movie_id="+mvoie_id);
		System.out.println("see_time="+see_time);
		String order_id=UUID.randomUUID().toString();
		Random r = new Random();
		
		//订单插入
				Order o=new Order();
				o.setOrder_id(order_id);
				o.setOrder_state(1);
				o.setOrder_total_price(order_total_price);
				o.setOrder_count(order_count);
				o.setUser_id(user_id);
				o.setSee_time(see_time);
				o.setSchedule_id(schedule_id);
				o.setPwd_num(r.nextInt(900000)+100000);
				
				OrderService oservice=new OrderService();
				int order_num=oservice.addOrderAdmin(o);
				System.out.println("order_num="+order_num);
		
		//座位插入
		Seat s=new Seat();
		s.setRows(rows);;
		s.setCols(cols);
		s.setState(1);
		s.setUser_id(user_id);
		s.setOrder_id(order_id);
		s.setHall_id(hall_id);
		
		//通过影片id查询
		MovieService mservice=new MovieService();
		Movie m=new Movie();
		m=mservice.findNameById(mvoie_id);
		
		s.setMovie_name(m.getMovie_name());
		s.setCinema_name(cinema_name);
		
		SeatService sservice=new SeatService();
		int seat_count=sservice.addSeat(s);
		
		
	
		response.sendRedirect(request.getContextPath()+"/AllOrderInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
