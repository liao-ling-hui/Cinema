package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hndysf.entity.ChooseBaseBean;
import com.hndysf.entity.Cinema;
import com.hndysf.entity.Hall;
import com.hndysf.entity.Movie;
import com.hndysf.entity.Schedule;
import com.hndysf.entity.Theater;
import com.hndysf.entity.TicketBeanHead;

public class ScheduleDao extends BaseDao {
	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//根据影院编号进行改影院的排片
	public List<Object[]> findScheduleByCinemaId(int cinema_id,int movie_id){
		List<Object[]> list=new ArrayList<Object[]>();
		try {
			conn=this.getConn();
			String sql="select s.*,h.hall_name,h.hall_category,m.movie_duration from `schedule` s,theater t,hall h,movie m where s.theater_id=t.theater_id and  "
					+ "s.hall_id=h.hall_id and m.movie_id=s.movie_id and t.theater_id=? and  s.movie_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cinema_id);
			ps.setInt(2, movie_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] s=new Object[8];
				s[0]=rs.getInt("s.schedule_id");
				s[1]=rs.getString("h.hall_name");
				s[2]=rs.getString("h.hall_category");
				s[3]=rs.getString("m.movie_duration");
				s[4]=rs.getString("s.start_time");
				s[5]=rs.getString("s.end_time");
				s[6]=rs.getString("s.fare");
				s[7]=rs.getString("s.theater_id");
				list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}
	
	//返回排片头部
	public TicketBeanHead findTicketBeanById(int c_id,int movie_id) {
		TicketBeanHead bean=new TicketBeanHead();
		try {
			conn=this.getConn();
			String sql="select m.movie_duration,h.hall_category,c.cinema_name,m.movie_name from hall h,movie m,cinema c "
					+ "where c.movie_id=m.movie_id and m.hall_id=h.hall_id and c.theater_id=? and m.movie_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, c_id);
			ps.setInt(2, movie_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				bean.setMovie_duration(rs.getString("m.movie_duration"));
				bean.setHall_category(rs.getString("h.hall_category"));
				bean.setCinema_name(rs.getString("c.cinema_name"));
				bean.setMovie_name(rs.getString("m.movie_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return bean;
	}
	
	//预定右侧基本信息
	public ChooseBaseBean findBaseInfo(int schedule_id) {
		ChooseBaseBean chBase=new ChooseBaseBean();
		try {
			conn=this.getConn();
			String sql="SELECT m.movie_name,s.start_time,m.movie_duration,h.hall_name,h.hall_category,s.fare,t.theater_name,s.end_time,m.movie_img"
					+ " FROM schedule s,movie m,hall h,theater t where s.theater_id=t.theater_id and s.movie_id=m.movie_id and "
					+ "s.hall_id=h.hall_id and s.schedule_id=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, schedule_id);
		rs=ps.executeQuery();
		while(rs.next()) {
			chBase.setMovie_name(rs.getString("m.movie_name"));
			chBase.setMovie_durtion(rs.getString("m.movie_duration"));
			chBase.setStart_time(rs.getString("s.start_time"));
			chBase.setEnd_time(rs.getString("s.end_time"));
			chBase.setHall_name(rs.getString("h.hall_name"));
			chBase.setHall_category(rs.getString("h.hall_category"));
			chBase.setFare(rs.getDouble("s.fare"));
			chBase.setCinema_name(rs.getString("t.theater_name"));
			chBase.setMovie_img(rs.getString("m.movie_img"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return chBase;
	}
	
	
	//根据排片 编号查询排片信息
	public Schedule findScheduleById(int schedule_id) {
		Schedule s=new Schedule();
		try {
			conn=this.getConn();
			String sql="select * from schedule where schedule_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, schedule_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				s.setSchedule_id(rs.getInt("schedule_id"));
				s.setHall_id(rs.getInt("hall_id"));
				s.setMovie_id(rs.getInt("movie_id"));
				s.setStart_time(rs.getString("start_time"));
				s.setEnd_time(rs.getString("end_time"));
				s.setFare(rs.getDouble("fare"));
				s.setCinema_id(rs.getInt("cinema_id"));
				s.setTheater_id(rs.getInt("theater_id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	//排片列表
	public List<Schedule> findSchedule(){
		List<Schedule> list_sch=new ArrayList<Schedule>();
		try {
			conn=this.getConn();
			String sql="select * from schedule";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Schedule s=new Schedule();
				s.setSchedule_id(rs.getInt("schedule_id"));
				s.setHall_id(rs.getInt("hall_id"));
				s.setMovie_id(rs.getInt("movie_id"));
				s.setStart_time(rs.getString("start_time"));
				s.setEnd_time(rs.getString("end_time"));
				s.setFare(rs.getDouble("fare"));
				s.setCinema_id(rs.getInt("cinema_id"));
				list_sch.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_sch;
	}
	
	
	//后台功能
	
	
	//查询所有的信息
	public List<Schedule> findAllSchedule(){
		List<Schedule> list_schedule=new ArrayList<Schedule>();
		try {
			conn=this.getConn();
			String sql="select s.*,h.*,t.*,m.* from `schedule` s,hall h,movie m,theater t where s.hall_id=h.hall_id and s.movie_id=m.movie_id and s.theater_id=t.theater_id";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Schedule s=new Schedule();
				s.setSchedule_id(rs.getInt("schedule_id"));
				s.setCinema_id(rs.getInt("cinema_id"));
				s.setHall_id(rs.getInt("hall_id"));
				s.setMovie_id(rs.getInt("movie_id"));
				s.setStart_time(rs.getString("start_time"));
				s.setEnd_time(rs.getString("end_time"));
				s.setFare(rs.getDouble("fare"));
				list_schedule.add(s);
				
				Hall h=new Hall();
				h.setHall_id(rs.getInt("hall_id"));
				h.setHall_name(rs.getString("hall_name"));
				h.setHall_seat_count(rs.getInt("hall_seat_count"));
				h.setHall_category(rs.getString("hall_category"));
				s.setHall(h);
				
				Movie m=new Movie();
				m.setMovie_id(rs.getInt("m.movie_id"));
				m.setMovie_name(rs.getString("m.movie_name"));
				m.setMovie_director(rs.getString("m.movie_director"));
				m.setMovie_actor(rs.getString("m.movie_actor"));
				m.setMovie_sorce(rs.getDouble("m.movie_sorce"));
				m.setHall_id(rs.getInt("m.hall_id"));
				m.setCategory_id(rs.getInt("m.category_id"));
				m.setMovie_release_date(rs.getString("m.movie_release_date"));
				m.setMovie_descrption(rs.getString("m.movie_descrption"));
				m.setMovie_duration(rs.getString("m.movie_duration"));
				m.setMovie_add_time(rs.getDate("m.movie_add_time"));
				m.setMovie_price(rs.getInt("m.movie_price"));
				m.setMovie_img(rs.getString("m.movie_img"));
				m.setMovie_pic1(rs.getString("m.movie_pic1"));
				m.setMovie_pic2(rs.getString("m.movie_pic2"));
				s.setMovie(m);
				
//				Cinema c=new Cinema();
//				c.setCinema_id(rs.getInt("cinema_id"));
//				c.setCinema_name(rs.getString("cinema_name"));
//				c.setTheater_id(rs.getInt("theater_id"));
//				c.setCinema_address(rs.getString("cinema_address"));
//				c.setCinema_fare(rs.getInt("cinema_fare"));
//				c.setCinema_distance(rs.getString("cinema_distance"));
//				c.setCinema_recent_times(rs.getString("cinema_recent_times"));
//				c.setCinema_business(rs.getString("cinema_business"));
//				c.setMovie_id(rs.getInt("movie_id"));
//				s.setCinema(c);
				
				Theater t=new Theater();
				t.setTheater_id(rs.getInt("theater_id"));
				t.setTheater_name(rs.getString("theater_name"));
				s.setTheater(t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_schedule;
	}
	
	
	//新增排片
	public int addSchedule(Schedule s) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="INSERT INTO `schedule`(`hall_id`, `movie_id`, `start_time`, `end_time`, `fare`,`theater_id`) VALUES (?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, s.getHall_id());
			ps.setInt(2, s.getMovie_id());
			ps.setString(3, s.getStart_time());
			ps.setString(4, s.getEnd_time());
			ps.setDouble(5,s.getFare());
			ps.setInt(6, s.getTheater_id());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	//修改排片信息
	public int updateSchedule(int schedule_id,double fare,String start_time,String end_time) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="update `schedule` set `fare` = ? ,`start_time`=?,`end_time`=?  where `schedule_id` = ?";
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, fare);
			ps.setString(2, start_time);
			ps.setString(3, end_time);
			ps.setInt(4, schedule_id);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	//删除排片
	public void deleteScheduleById(int schedule_id) {
		List<Schedule> list_schedule=new ArrayList<Schedule>();
		try {
			conn=this.getConn();
			String sql="delete from schedule where schedule_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, schedule_id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//根据电影模糊查询
	public List<Schedule> search(String start_time){
		List<Schedule> list_schedule=new ArrayList<Schedule>();
		try {
			conn=this.getConn();
			String sql="select s.*,h.*,t.*,m.* from `schedule` s,hall h,movie m,theater t where s.hall_id=h.hall_id and "
					+ "s.movie_id=m.movie_id and s.theater_id=t.theater_id and s.start_time like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+start_time+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				Schedule s=new Schedule();
				s.setSchedule_id(rs.getInt("schedule_id"));
				s.setCinema_id(rs.getInt("cinema_id"));
				s.setHall_id(rs.getInt("hall_id"));
				s.setMovie_id(rs.getInt("movie_id"));
				s.setStart_time(rs.getString("start_time"));
				s.setEnd_time(rs.getString("end_time"));
				s.setFare(rs.getDouble("fare"));
				list_schedule.add(s);
				
				Hall h=new Hall();
				h.setHall_id(rs.getInt("hall_id"));
				h.setHall_name(rs.getString("hall_name"));
				h.setHall_seat_count(rs.getInt("hall_seat_count"));
				h.setHall_category(rs.getString("hall_category"));
				s.setHall(h);
				
				Movie m=new Movie();
				m.setMovie_id(rs.getInt("m.movie_id"));
				m.setMovie_name(rs.getString("m.movie_name"));
				m.setMovie_director(rs.getString("m.movie_director"));
				m.setMovie_actor(rs.getString("m.movie_actor"));
				m.setMovie_sorce(rs.getDouble("m.movie_sorce"));
				m.setHall_id(rs.getInt("m.hall_id"));
				m.setCategory_id(rs.getInt("m.category_id"));
				m.setMovie_release_date(rs.getString("m.movie_release_date"));
				m.setMovie_descrption(rs.getString("m.movie_descrption"));
				m.setMovie_duration(rs.getString("m.movie_duration"));
				m.setMovie_add_time(rs.getDate("m.movie_add_time"));
				m.setMovie_price(rs.getInt("m.movie_price"));
				m.setMovie_img(rs.getString("m.movie_img"));
				m.setMovie_pic1(rs.getString("m.movie_pic1"));
				m.setMovie_pic2(rs.getString("m.movie_pic2"));
				s.setMovie(m);
				
//	
				
				Theater t=new Theater();
				t.setTheater_id(rs.getInt("theater_id"));
				t.setTheater_name(rs.getString("theater_name"));
				s.setTheater(t);
			}
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
			conn=this.getConn();
			String sql="select s.schedule_id,h.hall_name,m.movie_name,t.theater_name,s.fare,s.start_time,s.end_time from "
					+ "`schedule` s,hall h,movie m,theater t where s.hall_id=h.hall_id and "
					+ "s.movie_id=m.movie_id and s.theater_id=t.theater_id and s.schedule_id=?;";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, schedule_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] o=new Object[7];
				o[0]=rs.getInt("s.schedule_id");
				o[1]=rs.getString("h.hall_name");
				o[2]=rs.getString("m.movie_name");
				o[3]=rs.getString("t.theater_name");
				o[4]=rs.getString("s.fare");
				o[5]=rs.getString("s.start_time");
				o[6]=rs.getString("s.end_time");
				list.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
