package com.hndysf.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.entity.Cinema;
import com.hndysf.entity.Schedule;
import com.hndysf.entity.Theater;
import com.hndysf.service.CinemaService;
import com.hndysf.service.ScheduleService;
import com.hndysf.service.TheaterService;

/**
 * Servlet implementation class AddScheduleServlet
 */
@WebServlet("/AddScheduleServlet")
public class AddScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScheduleServlet() {
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
		
		int mvoie_id=Integer.parseInt(request.getParameter("movie_id"));
		int theater_id=Integer.parseInt(request.getParameter("theater_id"));
		int hall_id=Integer.parseInt(request.getParameter("hall_id"));
		double fare=Double.parseDouble(request.getParameter("fare"));
		String start_time=request.getParameter("start_time");
		String end_time=request.getParameter("end_time");
		
		Schedule s=new Schedule();
		s.setHall_id(hall_id);
		s.setMovie_id(mvoie_id);
		s.setStart_time(start_time);
		s.setEnd_time(end_time);
		s.setFare(fare);
		//s.setCinema_id(cinema_id);
		s.setTheater_id(theater_id);
		
		
		//通过theater编号读取影院信息
		TheaterService tservice=new TheaterService();
		Theater t=tservice.findCinemaByTheater(theater_id);
		
		Cinema c=new Cinema();
		c.setCinema_name(t.getTheater_name());
		c.setCinema_address(t.getCinema_address());
		c.setCinema_distance(t.getCinema_distance());
		c.setCinema_business(t.getCinema_business());
		c.setCinema_fare(t.getCinema_fare());
		c.setCinema_recent_times(t.getCinema_recent_times());
		c.setTheater_id(t.getTheater_id());
		c.setMovie_id(mvoie_id);
		CinemaService cservice=new CinemaService();
		int cinema_count=cservice.findCinemaByTheater(c);
		System.out.println("cinema_count="+cinema_count);
		
		ScheduleService service=new ScheduleService();
		try {
			int count=service.addSchedule(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		response.sendRedirect(request.getContextPath()+"/AllScheduleInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
