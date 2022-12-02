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
 * Servlet implementation class AllMovieInfoServlet
 */
@WebServlet("/AllMovieInfoServlet")
public class AllMovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMovieInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MovieService service=new MovieService();
		List<Object> list=new ArrayList<Object>();
		try {
			list=service.findMovieAll();
			if(list!=null) {
				System.out.println("admin_movie_list="+list);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("admin_movie_list", list);
		request.getRequestDispatcher("/admin/movie/movie.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
