package com.hndysf.servlet.client;

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
 * Servlet implementation class MovieDetailServlet
 */
@WebServlet("/MovieDetailServlet")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDetailServlet() {
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
		
		//response.sendRedirect(request.getContextPath()+"/client/details.jsp");
		
		//获取id
		String id=request.getParameter("id");
		int movie_id=Integer.valueOf(id);
		System.out.println("id="+id);
		
		MovieService service=new MovieService();
		List<Object[]> list=new ArrayList<Object[]>();
		try {
			list=service.findMovieById(movie_id);
			if(list!=null) {
				System.out.println("list="+list);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("movie_list", list);
		request.getRequestDispatcher("/client/details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
