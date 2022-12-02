package com.hndysf.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.service.MovieService;

/**
 * Servlet implementation class SearchMovieServlet
 */
@WebServlet("/SearchMovieServlet")
public class SearchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMovieServlet() {
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
		
		//得到关键词
		String search_name=request.getParameter("search_name");
		System.out.println("search_name="+search_name);
		
		MovieService mService=new MovieService();
		List<Object> search_list=new ArrayList<Object>();
		try {
			search_list=mService.SearchLikeMovie(search_name);
			if(search_list!=null) {
				System.out.println("search_list="+search_list);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("admin_movie_list", search_list);
		request.getRequestDispatcher("/admin/movie/movie.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/admin/movie/movie.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
