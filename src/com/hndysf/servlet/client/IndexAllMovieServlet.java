package com.hndysf.servlet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hndysf.service.MovieService;

/**
 * Servlet implementation class IndexAllMovie
 */
@WebServlet("/IndexAllMovieServlet")
public class IndexAllMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexAllMovieServlet() {
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
		
		MovieService service=new MovieService();
		List<Object[]> list_movie=new ArrayList<Object[]>();
		try {
			list_movie=service.findAllMovie();
			if(list_movie!=null) {
				System.out.println(list_movie.get(0));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//HttpSession session=request.getSession();
		request.setAttribute("list_movie", list_movie);
		request.getRequestDispatcher("/client/index.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/client/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
