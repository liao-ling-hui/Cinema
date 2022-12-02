package com.hndysf.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hndysf.entity.Movie;
import com.hndysf.service.MovieService;

/**
 * Servlet implementation class UpdateMovieServlet
 */
@WebServlet("/UpdateMovieServlet")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int  movie_price=Integer.parseInt(request.getParameter("movie_price"));
		int movie_id=Integer.parseInt(request.getParameter("movie_id"));
		System.out.println("movie_price="+movie_price);
		
		Movie m=new Movie();
		m.setMovie_id(movie_id);
		m.setMovie_price(movie_price);
		
		MovieService service=new MovieService();
		int count=0;
		try {
			count=service.updatePrice(m);
			if(count>0) {
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath()+ "/AllMovieInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
