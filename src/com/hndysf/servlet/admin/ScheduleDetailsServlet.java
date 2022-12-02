package com.hndysf.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.service.ScheduleService;

/**
 * Servlet implementation class ScheduleDetailsServlet
 */
@WebServlet("/ScheduleDetailsServlet")
public class ScheduleDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleDetailsServlet() {
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
		
		int schedule_id=Integer.parseInt(request.getParameter("schedule_id"));
		System.out.println("schedule_id="+schedule_id);
		
		ScheduleService service=new ScheduleService();
		List<Object> list=new ArrayList<Object>();
		try {
			list=service.findScheduleByIdAdmin(schedule_id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("scheduleDetails", list);
		request.getRequestDispatcher("/admin/schedule/schedule_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
