package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hndysf.entity.Theater;

public class TheaterDao extends BaseDao {

	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//查询所有
	public List<Theater> findAllTheater(){
		 List<Theater> list_theater=new ArrayList<Theater>();
		 try {
			 conn=this.getConn();
			 String sql="select * from theater";
			 ps=conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 Theater t=new Theater();
				 t.setTheater_id(rs.getInt("theater_id"));
				 t.setTheater_name(rs.getString("theater_name"));
				 list_theater.add(t);
			 }
		 }catch(Exception e ) {
			 e.printStackTrace();
		 }
		 return list_theater;
	}
	
	
	//通过id查询影院信息
	public Theater findCinemaByTheater(int theater_id) {
		Theater t=new Theater();
		try {
			conn=this.getConn();
			String sql="select * from theater where theater_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, theater_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				 t.setTheater_id(rs.getInt("theater_id"));
				 t.setTheater_name(rs.getString("theater_name"));
				 t.setCinema_address(rs.getString("cinema_address"));
				 t.setCinema_recent_times(rs.getString("cinema_recent_times"));
				 t.setCinema_fare(rs.getInt("cinema_fare"));
				 t.setCinema_distance(rs.getString("cinema_distance"));
				 t.setCinema_business(rs.getString("cinema_business"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
