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
import com.hndysf.entity.TicketBeanHead;
import com.hndysf.service.CinemaService;
import com.hndysf.service.ScheduleService;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleServlet() {
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
		
		//获取影院id
		String c_name=request.getParameter("c_id");
		//获取影片id
		String m_id=request.getParameter("m_id");
		int movie_id=Integer.valueOf(m_id);
		int c_id=Integer.valueOf(c_name);
		System.out.println("c_id="+c_id+"movie_id="+movie_id);
		//传入影院id和影片id进行排片
		ScheduleService service=new ScheduleService();
		List<Object[]> list = new ArrayList<Object[]>();
		TicketBeanHead bean=new TicketBeanHead();
		CinemaService cService=new CinemaService();
		try {
			//根据影院id和影片id查询排片
			list=service.findScheduleByCinemaId(c_id, movie_id);
			bean=service.findTicketBeanById(c_id, movie_id);
			System.out.println("schedule_list="+list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("schedule", list);
		request.setAttribute("Tbean", bean);
		request.getRequestDispatcher("/client/tickets.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
