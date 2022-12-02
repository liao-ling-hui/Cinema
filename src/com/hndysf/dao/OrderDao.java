package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hndysf.entity.Order;
import com.hndysf.entity.Schedule;
import com.hndysf.entity.User;

public class OrderDao extends BaseDao {
	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//新增订单记录
	public int addOrder(Order order) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="INSERT INTO `order`(`order_id`,`order_state`, `order_total_price`, `user_id`, `order_count`, `see_time`,`schedule_id`,`pwd_num`) VALUES (?,?,?,?,?,?,?,?) ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, order.getOrder_id());
			ps.setInt(2, order.getOrder_state());
			ps.setDouble(3, order.getOrder_total_price());
			ps.setInt(4, order.getUser().getUser_id());
			//ps.setInt(4, order.getUser_id());
			ps.setInt(5, order.getOrder_count());
			ps.setString(6, order.getSee_time());
			ps.setInt(7, order.getSchedule_id());
			ps.setInt(8, order.getPwd_num());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return count;
	}
	
	
	public int addOrderAdmin(Order order) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="INSERT INTO `order`(`order_id`,`order_state`, `order_total_price`, `user_id`, `order_count`, `see_time`,`schedule_id`,`pwd_num`) VALUES (?,?,?,?,?,?,?,?) ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, order.getOrder_id());
			ps.setInt(2, order.getOrder_state());
			ps.setDouble(3, order.getOrder_total_price());
			//ps.setInt(4, order.getUser().getUser_id());
			ps.setInt(4, order.getUser_id());
			ps.setInt(5, order.getOrder_count());
			ps.setString(6, order.getSee_time());
			ps.setInt(7, order.getSchedule_id());
			ps.setInt(8, order.getPwd_num());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return count;
	}
	
	//根据订单id查询订单相关信息
	public List<Object> findOrderByOrderId(String order_id){
		List<Object> order_list=new ArrayList<Object>();
		try {
			conn=this.getConn();
			String sql="select o.order_count,o.order_total_price,t.theater_name,h.hall_name,m.movie_img,s.fare,s.start_time,s.end_time,u.user_phone,m.movie_name,o.pwd_num" 
					+ "  from `order` o,`schedule` s,`hall` h,theater t,`movie` m,`user` u where o.schedule_id=s.schedule_id and s.hall_id=h.hall_id and s.theater_id=t.theater_id "
					+ "and s.movie_id=m.movie_id and o.user_id=u.user_id and  o.order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, order_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] obj=new Object[11];
				obj[0]=rs.getString("m.movie_name");
				obj[1]=rs.getString("o.order_count");
				obj[2]=rs.getString("o.order_total_price");
				obj[3]=rs.getString("t.theater_name");
				obj[4]=rs.getString("h.hall_name");
				obj[5]=rs.getString("m.movie_img");
				obj[6]=rs.getString("s.fare");
				obj[7]=rs.getString("s.start_time");
				obj[8]=rs.getString("s.end_time");
				obj[9]=rs.getString("u.user_phone");
				obj[10]=rs.getInt("o.pwd_num");
				order_list.add(obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return order_list;
	}
	
	
	//根据用户id查询用户的订单信息
	public List<Object> findOrderByUserId(int user_id){
		List<Object> list_user_order=new ArrayList<Object>() ;
			try {
				conn=this.getConn();
				String sql="select o.order_id,m.movie_name,o.see_time,s.start_time,s.end_time,t.theater_name,o.pwd_num,o.order_state,o.order_total_price "
						+ "from `order` o,`schedule` s,`user` u,movie m,theater t where o.schedule_id=s.schedule_id and o.user_id=u.user_id and "
						+ "s.movie_id=m.movie_id and s.theater_id=t.theater_id and o.user_id=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, user_id);
				rs=ps.executeQuery();
				while(rs.next()) {
					Object[] obj=new Object[9];
					obj[0]=rs.getString("o.order_id");
					obj[1]=rs.getString("m.movie_name");
					obj[2]=rs.getString("o.see_time");
					obj[3]=rs.getString("s.start_time");
					obj[4]=rs.getString("s.end_time");
					obj[5]=rs.getString("t.theater_name");
					obj[6]=rs.getString("o.pwd_num");
					obj[7]=rs.getString("o.order_state");
					obj[8]=rs.getString("o.order_total_price");
					list_user_order.add(obj);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_user_order;
		
	}
	
	
	//通过订单编号删除订单
	public int deleteOrderByOrderId(String order_id) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="delete from  `order` where order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, order_id);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	//根据订单编号修改订单状态
	public int updateState(String order_id) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="update `order` set `order_state`=? where `order_id`=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 2);
			ps.setString(2, order_id);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//后台功能模块
	
	//查询全部订单信息
	public List<Order> findAllOrder(){
		List<Order> list_order=new ArrayList<Order>();
		try {
			conn=this.getConn();
			String sql="select o.*,u.*,sch.* from `order` o,`user` u,`schedule` sch ,seat s where o.order_id=s.order_id and  o.schedule_id=sch.schedule_id and o.user_id=u.user_id";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Order o=new Order();
				o.setOrder_id(rs.getString("o.order_id"));
				o.setOrder_time(rs.getDate("o.order_time"));
				o.setOrder_state(rs.getInt("o.order_state"));
				o.setOrder_total_price(rs.getDouble("o.order_total_price"));
				o.setUser_id(rs.getInt("o.user_id"));
				o.setOrder_count(rs.getInt("o.order_count"));
				o.setSee_time(rs.getString("o.see_time"));
				o.setSchedule_id(rs.getInt("o.schedule_id"));
				o.setPwd_num(rs.getInt("o.pwd_num"));
				list_order.add(o);
				
				User u=new User();
				u.setUser_id(rs.getInt("u.user_id"));
				u.setUser_name(rs.getString("u.user_name"));
				u.setUser_password(rs.getString("u.user_password"));
				u.setUser_sex(rs.getString("u.user_sex"));
				u.setUser_phone(rs.getString("u.user_phone"));
				o.setUser(u);
				
				Schedule s=new Schedule();
				s.setSchedule_id(rs.getInt("sch.schedule_id"));
				s.setHall_id(rs.getInt("sch.hall_id"));
				s.setMovie_id(rs.getInt("sch.movie_id"));
				s.setStart_time(rs.getString("sch.start_time"));
				s.setEnd_time(rs.getString("sch.end_time"));
				s.setFare(rs.getDouble("sch.fare"));
				s.setCinema_id(rs.getInt("sch.cinema_id"));
				o.setSchedule(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_order;
	}
	
	//根据订单编号查询详细信息
	public List<Object> findOrderDeatailsByOrderId(String order_id){
		List<Object> list=new ArrayList<Object>();
		try {
			conn=this.getConn();
			String sql="select s.seat_id, s.order_id,s.cinema_name,s.movie_name,s.rows,s.cols,sch.start_time,sch.end_time,sch.fare,h.hall_name ,u.user_name from "
					+ "seat s,`order` o,`user` u,`schedule` sch,hall h where s.hall_id=h.hall_id and s.order_id=o.order_id and o.schedule_id=sch.schedule_id and "
					+ "o.user_id=u.user_id and o.order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, order_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] obj=new Object[11];
				obj[0]=rs.getInt("s.seat_id");
				obj[1]=rs.getString("s.order_id");
				obj[2]=rs.getString("s.cinema_name");
				obj[3]=rs.getString("s.movie_name");
				obj[4]=rs.getString("s.rows");
				obj[5]=rs.getString("s.cols");
				obj[6]=rs.getString("sch.start_time");
				obj[7]=rs.getString("sch.end_time");
				obj[8]=rs.getString("sch.fare");
				obj[9]=rs.getString("h.hall_name");
				obj[10]=rs.getString("u.user_name");
				list.add(obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//根据所属用户进行查询
			public List<Order> findOrderByUser(String user_name){
				List<Order> list_order=new ArrayList<Order>();
				try {
					conn=this.getConn();
					String sql="select o.*,u.*,sch.* from `order` o,`user` u,`schedule` sch ,seat s where o.order_id=s.order_id and  "
							+ "o.schedule_id=sch.schedule_id and o.user_id=u.user_id and u.user_name like ?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, "%"+user_name+"%");
					rs=ps.executeQuery();
					while(rs.next()) {
						Order o=new Order();
						o.setOrder_id(rs.getString("o.order_id"));
						o.setOrder_time(rs.getDate("o.order_time"));
						o.setOrder_state(rs.getInt("o.order_state"));
						o.setOrder_total_price(rs.getDouble("o.order_total_price"));
						o.setUser_id(rs.getInt("o.user_id"));
						o.setOrder_count(rs.getInt("o.order_count"));
						o.setSee_time(rs.getString("o.see_time"));
						o.setSchedule_id(rs.getInt("o.schedule_id"));
						o.setPwd_num(rs.getInt("o.pwd_num"));
						list_order.add(o);
						
						User u=new User();
						u.setUser_id(rs.getInt("u.user_id"));
						u.setUser_name(rs.getString("u.user_name"));
						u.setUser_password(rs.getString("u.user_password"));
						u.setUser_sex(rs.getString("u.user_sex"));
						u.setUser_phone(rs.getString("u.user_phone"));
						o.setUser(u);
						
						Schedule s=new Schedule();
						s.setSchedule_id(rs.getInt("sch.schedule_id"));
						s.setHall_id(rs.getInt("sch.hall_id"));
						s.setMovie_id(rs.getInt("sch.movie_id"));
						s.setStart_time(rs.getString("sch.start_time"));
						s.setEnd_time(rs.getString("sch.end_time"));
						s.setFare(rs.getDouble("sch.fare"));
						s.setCinema_id(rs.getInt("sch.cinema_id"));
						o.setSchedule(s);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				return list_order;
			}
	
	
}
