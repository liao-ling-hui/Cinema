package com.hndysf.servlet.client;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hndysf.entity.Hall;
import com.hndysf.entity.Order;
import com.hndysf.entity.Schedule;
import com.hndysf.entity.Seat;
import com.hndysf.entity.User;
import com.hndysf.service.HallService;
import com.hndysf.service.OrderService;
import com.hndysf.service.ScheduleService;
import com.hndysf.service.SeatService;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/CreateSeatServlet")
public class CreateSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSeatServlet() {
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
		
		String sched=request.getParameter("schedule_id");
		int schedule_id=Integer.parseInt(sched);
		String movie_name=request.getParameter("movie_name");//影片名
		String cinema_name=request.getParameter("cinema_name");//影院名
		String hall_name=request.getParameter("hall_name");//放映厅名称
		String date=request.getParameter("data");
		String f=request.getParameter("fare");
		double fare=Double.parseDouble(f);
		System.out.println("schedule_id="+schedule_id+"movie_name="+movie_name+"cinema_name="+cinema_name+"hall_name="+hall_name);
		String total_price=request.getParameter("total_price");//总价
		String tickects_num=request.getParameter("tickects_num");//购买票数
		String seats=request.getParameter("seats_chose");//座位信息
		System.out.println("seats="+seats);
		String reg="\\D";
		String seat=seats.replaceAll(reg,"");
		System.out.println("seat="+seat);
		int num=Integer.parseInt(seat);
		System.out.println("s="+num);
		
		//根据放映厅名称查询编号
		HallService hService =new HallService();
		Hall h=hService.findHallByName(hall_name);
		int hall_id=h.getHall_id();
		System.out.println("hall_id="+hall_id);
		
		//获取当前预定电影票用户
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		//根据排片id获取排片信息
		ScheduleService sch_service = new ScheduleService();
		Schedule schedule=sch_service.findScheduleById(schedule_id);
		
		//生成六位数的随机数
		 Random r = new Random();
		int pwd_num=r.nextInt(900000)+100000;
		
	
		//生成订单
		String order_id=UUID.randomUUID().toString();
		System.out.println("order_id="+order_id);
		Order  order=new Order();
		order.setOrder_id(order_id);
		order.setOrder_state(1);
		order.setOrder_total_price(Integer.parseInt(total_price));
		order.setOrder_count(Integer.parseInt(tickects_num));
		order.setUser(user);
		order.setSee_time(date);
		order.setSchedule_id(schedule_id);
		order.setPwd_num(pwd_num);
		//订单的信息
		OrderService order_service=new OrderService();
		int count=order_service.addOrder(order);
		if(count>0) {
			System.out.println("order_count="+count);
		}
		
	
		
		int num1,num2;
		while(num!=0) {
			num1=num%100;
			num2=num/100;
			num=num2;
			int rows=num1/10;
			int cols=num1%10;
			System.out.println("num="+num+"num1="+num1+"num2="+num2);
			System.out.println("rows="+rows+"cols="+cols);
			//插入座位信息
			Seat seat_info=new Seat();
			seat_info.setRows(rows);
			seat_info.setCols(cols);
			seat_info.setState(1);
			seat_info.setUser_id(user.getUser_id());
			seat_info.setCinema_name(cinema_name);
			seat_info.setMovie_name(movie_name);
			seat_info.setOrder_id(order_id);
			seat_info.setHall_id(hall_id);
			SeatService sService=new SeatService();
			int seat_count=0;
			try {
				seat_count=sService.addSeat(seat_info);
				if(seat_count>0) {
					System.out.println("seat_count="+seat_count);
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	
		}
		
		//预定详情页面,传编号
		HttpSession order_id_session=request.getSession();
		order_id_session.setAttribute("order_id", order_id);
		order_id_session.setAttribute("seats", seats);
		
		//request.getRequestDispatcher("/client/paySuccess.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/client/paySuccess.jsp");
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
