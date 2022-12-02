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

import com.hndysf.entity.Cateogory;
import com.hndysf.entity.Cinema;
import com.hndysf.entity.Hall;
import com.hndysf.entity.Movie;
import com.hndysf.entity.Schedule;
import com.hndysf.entity.User;
import com.hndysf.service.CinemaService;
import com.hndysf.service.HallService;
import com.hndysf.service.MovieService;
import com.hndysf.service.ScheduleService;
import com.hndysf.service.UserService;

/**
 * Servlet implementation class GeneralServlet
 */
@WebServlet("/GeneralServlet")
public class GeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneralServlet() {
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
		
		MovieService mservice=new MovieService();
		List<Movie> list_movie=new ArrayList<Movie>();
		list_movie=mservice.findMovieAndId();
		
		UserService uservice=new UserService();
		List<User> list_user=new ArrayList<User>();
		list_user=uservice.findUser();
		
		
		ScheduleService sService = new ScheduleService();
		List<Schedule> list_sch=new ArrayList<Schedule>();
		list_sch=sService.findSchedule();
		
		
		CinemaService cService=new CinemaService();
		List<Cinema> list_cinema=new ArrayList<Cinema>();
		list_cinema=cService.findAllCinema();
		
		System.out.println("list_cinema="+list_cinema);
		List<Cateogory> list_cate=new ArrayList<Cateogory>();
		list_cate=cService.findAllCategory();
		
		HallService hService=new HallService();
		List<Hall> list_hall=new ArrayList<Hall>();
		list_hall=hService.findAllHall();
		
		
		
		
		HttpSession session=request.getSession();
		session.setAttribute("movie", list_movie);
		session.setAttribute("user", list_user);
		session.setAttribute("schedule", list_sch);
		session.setAttribute("cinema", list_cinema);
		session.setAttribute("hall", list_hall);
		session.setAttribute("category", list_cate);
		
		request.getRequestDispatcher("/admin/order/order_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
