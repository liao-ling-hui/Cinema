package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hndysf.entity.Hall;

public class HallDao extends BaseDao {
	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//根据放映厅名称查询放映厅id
	public Hall findHallByName(String name) {
		Hall h=new Hall();
		try {
			conn=this.getConn();
			String sql="select * from hall where `hall_name`=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				h.setHall_id(rs.getInt("hall_id"));
				h.setHall_name(rs.getString("hall_name"));
				h.setHall_seat_count(rs.getInt("hall_seat_count"));
				h.setHall_category(rs.getString("hall_category"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return h;
	}
	
	
	//查询所有放映厅信息
	public List<Hall> findAllHall(){
		List<Hall> list_hall=new ArrayList<Hall>();
		try {
			conn=this.getConn();
			String sql="select * from hall";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Hall h=new Hall();
				h.setHall_id(rs.getInt("hall_id"));
				h.setHall_name(rs.getString("hall_name"));
				h.setHall_seat_count(rs.getInt("hall_seat_count"));
				h.setHall_category(rs.getString("hall_category"));
				list_hall.add(h);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_hall;
	}
}
