package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hndysf.entity.Seat;

public class SeatDao extends BaseDao {
	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//渲染座位行和列
	public List<Seat> ShowRowAndCol(String cinema_name,int hall_id,String movie_name) {
		List<Seat> s_list=new ArrayList<Seat>();
		try {
			conn=this.getConn();
			String sql="SELECT * FROM seat where cinema_name=? and hall_id=? and movie_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,cinema_name);
			ps.setInt(2, hall_id);
			ps.setString(3, movie_name);
			rs=ps.executeQuery();
			while(rs.next()) {
				Seat s=new Seat();
				s.setSeat_id(rs.getInt("seat_id"));
				s.setRows(rs.getInt("rows"));
				s.setCols(rs.getInt("cols"));
				s.setState(rs.getInt("state"));
				s.setUser_id(rs.getInt("user_id"));
				s.setCinema_name(rs.getString("cinema_name"));
				s.setMovie_name(rs.getString("movie_name"));
				s.setHall_id(rs.getInt("hall_id"));
				s_list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return s_list;
	}
	
	//添加座位信息
	public int addSeat(Seat seat_info) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="insert into seat(`rows`, `cols`, `state`, `user_id`, `cinema_name`, `movie_name`,`order_id`,`hall_id`) values(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, seat_info.getRows());
			ps.setInt(2, seat_info.getCols());
			ps.setInt(3, seat_info.getState());
			ps.setInt(4, seat_info.getUser_id());
			ps.setString(5, seat_info.getCinema_name());
			ps.setString(6, seat_info.getMovie_name());
			ps.setString(7, seat_info.getOrder_id());
			ps.setInt(8, seat_info.getHall_id());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return count;
	}
	

	//根据订单编号查询订单信息
	public List<Seat> findSeatByOrderId(String order_id,int user_id){
		List<Seat> seat=new ArrayList<Seat>();
		try {
			conn=this.getConn();
			String sql="select * from seat s,`order` o where s.order_id=o.order_id and s.user_id=? and s.order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setString(2, order_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Seat s=new Seat();
				s.setRows(rs.getInt("rows"));
				s.setCols(rs.getInt("cols"));
				seat.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return seat;
	}
		
	
	//根据订单编号删除座位信息
	public int deleteSeatById(String order_id) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="delete from seat where order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, order_id);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	//修改座位
	public int updateSeatInfo(int rows,int cols,int seat_id) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="update seat set `rows`=?,`cols`=? where `seat_id`=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rows);
			ps.setInt(2, cols);
			ps.setInt(3, seat_id);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
			return count;
		}
}


