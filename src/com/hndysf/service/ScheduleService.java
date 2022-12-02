package com.hndysf.service;

import java.util.ArrayList;
import java.util.List;

import com.hndysf.dao.ScheduleDao;
import com.hndysf.entity.ChooseBaseBean;
import com.hndysf.entity.Cinema;
import com.hndysf.entity.Hall;
import com.hndysf.entity.Movie;
import com.hndysf.entity.Schedule;
import com.hndysf.entity.TicketBeanHead;

public class ScheduleService {
	private ScheduleDao sDao = new ScheduleDao();

	// 根据影院编号进行改影院的排片
	public List<Object[]> findScheduleByCinemaId(int cinema_id, int movie_id) {
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			list = sDao.findScheduleByCinemaId(cinema_id, movie_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//返回Bean
		public TicketBeanHead findTicketBeanById(int c_id,int movie_id) {
			TicketBeanHead bean=new TicketBeanHead();
			try {
				bean=sDao.findTicketBeanById(c_id, movie_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return bean;
		}
		
		//预定右侧基本信息
		public ChooseBaseBean findBaseInfo(int schedule_id) {
			ChooseBaseBean chBase=new ChooseBaseBean();
			try {
				chBase=sDao.findBaseInfo(schedule_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
				
			return chBase;
}
		
		
		//根据排片 编号查询排片信息
		public Schedule findScheduleById(int schedule_id) {
			Schedule s=new Schedule();
			try {
				s=sDao.findScheduleById(schedule_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return s;
		}
		
		
		
		//排片列表
		public List<Schedule> findSchedule(){
			List<Schedule> list_sch=new ArrayList<Schedule>();
			try {
				list_sch=sDao.findSchedule();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_sch;
		}
		
		
		//查询所有的信息
		public List<Schedule> findAllSchedule(){
			List<Schedule> list_schedule=new ArrayList<Schedule>();
			try {
			
				list_schedule=sDao.findAllSchedule();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_schedule;
		}
		
		
		//新增排片
		public int addSchedule(Schedule s) {
			int count=0;
			try {
				count=sDao.addSchedule(s);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		
		//删除排片
		public void deleteScheduleById(int schedule_id) {
			try {
				sDao.deleteScheduleById(schedule_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//根据电影模糊查询
		public List<Schedule> search(String start_time){
			List<Schedule> list_schedule=new ArrayList<Schedule>();
			try {
				list_schedule=sDao.search(start_time);
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
			return list_schedule;
		}
		
		//根据排片编号查询排片信息
		public List<Object> findScheduleByIdAdmin(int schedule_id){
			List<Object> list=new ArrayList<Object>();
			
			try {
				list=sDao.findScheduleByIdAdmin(schedule_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		//修改排片信息
		public int updateSchedule(int schedule_id,double fare,String start_time,String end_time) {
			int count=0;
			try {
				count=sDao.updateSchedule(schedule_id, fare, start_time, end_time);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
}



