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

import com.hndysf.entity.Cinema;
import com.hndysf.entity.Hall;
import com.hndysf.entity.Movie;
import com.hndysf.entity.Theater;
import com.hndysf.service.CinemaService;
import com.hndysf.service.HallService;
import com.hndysf.service.MovieService;
import com.hndysf.service.TheaterService;

/**
 * Servlet implementation class GeneralScheduleServlet
 */
@WebServlet("/GeneralScheduleServlet")
public class GeneralScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneralScheduleServlet() {
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
		
		CinemaService cService=new CinemaService();
		List<Cinema> list_cinema=new ArrayList<Cinema>();
		list_cinema=cService.findAllCinema();
		
		HallService hService=new HallService();
		List<Hall> list_hall=new ArrayList<Hall>();
		list_hall=hService.findAllHall();
		
		TheaterService tService=new TheaterService();
		List<Theater> t_list=tService.findAllTheater();
		
		HttpSession session=request.getSession();
		session.setAttribute("movie", list_movie);
		session.setAttribute("cinema", list_cinema);
		session.setAttribute("hall", list_hall);
		session.setAttribute("t_list", t_list);
		request.getRequestDispatcher("/admin/schedule/schedule_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
