package com.hndysf.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.entity.Schedule;
import com.hndysf.service.ScheduleService;

/**
 * Servlet implementation class AllScheduleInfoServlet
 */
@WebServlet("/AllScheduleInfoServlet")
public class AllScheduleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllScheduleInfoServlet() {
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
		ScheduleService service=new ScheduleService();
		List<Schedule> list_schedule=new ArrayList<Schedule>();
		try {
			list_schedule=service.findAllSchedule();
			System.out.println("list_schedule="+list_schedule);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list_schedule", list_schedule);
		request.getRequestDispatcher("/admin/schedule/schedule.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
