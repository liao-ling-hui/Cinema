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

import com.hndysf.entity.Movie;
import com.hndysf.service.MovieService;

/**
 * Servlet implementation class UpdateBeforeCheckServlet
 */
@WebServlet("/UpdateBeforeCheckServlet")
public class UpdateBeforeCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBeforeCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int movie_id=Integer.parseInt(request.getParameter("movie_id"));
		System.out.println("movie_id="+movie_id);
		
		//通过影片id查询影片信息
		MovieService service=new MovieService();
		List<Movie> list=new ArrayList<Movie>();
		try {
			list=service.MovieById(movie_id);
			System.out.println("list="+list.get(0).getMovie_duration());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("Movie", list);
		response.sendRedirect(request.getContextPath()+ "/admin/movie/movie_update.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
