package com.hndysf.servlet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.entity.Cinema;
import com.hndysf.entity.Movie;
import com.hndysf.service.CinemaService;
import com.hndysf.service.MovieService;

/**
 * Servlet implementation class ShowCinemaServlet
 */
@WebServlet("/ShowCinemaServlet")
public class ShowCinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCinemaServlet() {
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
		
		//获取影片名
		String cinema=request.getParameter("name");
		System.out.println("cinema="+cinema);
		
		
		
		CinemaService service=new CinemaService();
		MovieService mService=new MovieService();
		List<Object[]> list=new ArrayList<Object[]>();
		try {
			//通过影片名获取影片id
			Movie movie=mService.findIdByName(cinema);
			System.out.println("movie_id="+movie.getMovie_id());
			
			//通过影片id查询影院，并显示影院信息
			list=service.findCinemaById(movie.getMovie_id());
			System.out.println("list="+list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("name", cinema);
		request.setAttribute("list_cinema", list);
		request.getRequestDispatcher("/client/film_cinema.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
