package com.hndysf.servlet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hndysf.entity.ChooseBaseBean;
import com.hndysf.entity.Hall;
import com.hndysf.entity.Seat;
import com.hndysf.service.HallService;
import com.hndysf.service.ScheduleService;
import com.hndysf.service.SeatService;

/**
 * Servlet implementation class ChooseSeatServlet
 */
@WebServlet("/ChooseSeatServlet")
public class ChooseSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseSeatServlet() {
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
		
		//获取排片id
		String sched=request.getParameter("schedule_id");
		String cinema_name=request.getParameter("cinema_name");
		int schedule_id=Integer.valueOf(sched);
		System.out.println("schedule_id="+sched+"cinema_name="+cinema_name);
		String movie_name=request.getParameter("movie_name");
		
		String hall_name=request.getParameter("hall_name");
		//根据放映厅名称查询编号
		HallService hService=new HallService();
		Hall hall=hService.findHallByName(hall_name);
		int hall_id=hall.getHall_id();
		
		//右边信息的显示
		ChooseBaseBean chBase=new ChooseBaseBean();
		ScheduleService schedService=new ScheduleService();
		
		//渲染座位
		SeatService sService =new  SeatService();
		List<Seat> s_list=new ArrayList<Seat>();
		try {
			s_list=sService.ShowRowAndCol(cinema_name,hall_id,movie_name);
			chBase=schedService.findBaseInfo(schedule_id);
			System.out.println("chBase="+chBase);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("schedule_id", schedule_id);
		request.setAttribute("ch_seat", s_list);
		request.setAttribute("BaseInfo", chBase);
		request.getRequestDispatcher("/client/choose_seat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
