package com.hndysf.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hndysf.entity.Cateogory;
import com.hndysf.entity.Cinema;

public class CinemaDao extends BaseDao {
	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//显示所有附近影院
	public List<Cinema> findAllCinema() {
		List<Cinema> list_cinema=new ArrayList<Cinema>();
		try {
			conn=this.getConn();
			String sql="select * from cinema";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cinema c=new Cinema();
				c.setCinema_id(rs.getInt("cinema_id"));
				c.setCinema_name(rs.getString("cinema_name"));
				c.setTheater_id(rs.getInt("theater_id"));
				c.setCinema_address(rs.getString("cinema_address"));
				c.setCinema_fare(rs.getInt("cinema_fare"));
				c.setCinema_distance(rs.getString("cinema_distance"));
				c.setCinema_recent_times(rs.getString("cinema_recent_times"));
				c.setCinema_business(rs.getString("cinema_business"));
				c.setMovie_id(rs.getInt("movie_id"));
				list_cinema.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_cinema;
	}
	
	
	//通过影片id显示影院信息
	public List<Object[]> findCinemaById(int movie_id){
		List<Object[]> list=new ArrayList<Object[]>();
		try {
			conn=this.getConn();
			String sql="select c.*,m.movie_id from  cinema c,movie m where m.movie_id=c.movie_id and m.movie_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] c=new Object[9];
				c[0]=rs.getInt("c.cinema_id");
				c[1]=rs.getString("c.cinema_name");
				c[2]=rs.getString("c.cinema_address");
				c[3]=rs.getString("c.cinema_fare");
				c[4]=rs.getString("c.cinema_distance");
				c[5]=rs.getString("c.cinema_recent_times");
				c[6]=rs.getString("c.cinema_business");
				c[7]=rs.getString("m.movie_id");	
				c[8]=rs.getInt("c.theater_id");
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//查询所有类型
	public List<Cateogory> findAllCategory(){
		List<Cateogory> list_cate=new ArrayList<Cateogory>();
		try {
			conn=this.getConn();
			String sql="select * from category";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cateogory c=new Cateogory();
				c.setCategory_id(rs.getInt("category_id"));
				c.setCategory_name(rs.getString("category_name"));
				list_cate.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_cate;
	}
	
	
//	//添加
	public int findCinemaByTheater(Cinema c) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="INSERT INTO `cinema`(`cinema_name`, `theater_id`,"
					+ " `cinema_address`, `cinema_fare`, `cinema_distance`, `cinema_recent_times`, `cinema_business`, `movie_id`) VALUES (?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCinema_name());
			ps.setInt(2, c.getTheater_id());
			ps.setString(3, c.getCinema_address());
			ps.setInt(4, c.getCinema_fare());
			ps.setString(5, c.getCinema_distance());
			ps.setString(6,c.getCinema_recent_times());
			ps.setString(7, c.getCinema_business());
			ps.setInt(8, c.getMovie_id());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
