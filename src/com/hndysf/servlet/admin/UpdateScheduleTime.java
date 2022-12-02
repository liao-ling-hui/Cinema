package com.hndysf.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.service.ScheduleService;

/**
 * Servlet implementation class UpdateScheduleTime
 */
@WebServlet("/UpdateScheduleTime")
public class UpdateScheduleTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateScheduleTime() {
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
		
		int schedule_id=Integer.parseInt(request.getParameter("schedule_id"));
		String start_time=request.getParameter("start_time");
		String end_time=request.getParameter("end_time");
		double fare=Double.parseDouble(request.getParameter("fare"));
		System.out.println("upadat_schedule_id="+schedule_id);
		
		ScheduleService service=new ScheduleService();
		try {
			int count=service.updateSchedule(schedule_id, fare, start_time, end_time);
			if(count>0) {
				System.out.println("修改成功！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+ "/AllScheduleInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
