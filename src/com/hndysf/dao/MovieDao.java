package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hndysf.entity.Cateogory;
import com.hndysf.entity.Hall;
import com.hndysf.entity.Movie;

public class MovieDao extends BaseDao {

	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//首页显示电影
	public List<Object[]> findAllMovie(){
		List<Object[]> list_movie=new ArrayList<Object[]>();
		try {
			conn=this.getConn();
			String sql="select m.*,h.hall_name,c.category_name from movie m,hall h,category c where m.category_id=c.category_id and m.hall_id=h.hall_id";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] m=new Object[16];
				m[0]=rs.getInt("m.movie_id");
				m[1]=rs.getString("m.movie_name");
				m[2]=rs.getString("m.movie_director");
				m[3]=rs.getString("m.movie_actor");
				m[4]=rs.getString("m.movie_sorce");
				m[5]=rs.getString("h.hall_name");
				m[6]=rs.getString("c.category_name");
				m[7]=rs.getString("m.movie_release_date");
				m[8]=rs.getString("m.movie_descrption");
				m[9]=rs.getString("m.movie_duration");
				m[10]=rs.getString("m.movie_add_time");
				m[11]=rs.getInt("m.movie_price");
				m[12]=rs.getString("m.movie_img");
				m[13]=rs.getString("m.movie_radio");
				m[14]=rs.getString("m.movie_pic1");
				m[15]=rs.getString("m.movie_pic2");
				list_movie.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list_movie;
	}
	
	//通过id找影片信息
	public  List<Object[]> findMovieByid(int id){
		List<Object[]> list=new ArrayList<Object[]>();
		try {
			conn=this.getConn();
			String sql="select m.*,c.category_name from movie m,category c where m.category_id=c.category_id and movie_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] m=new Object[16];
				m[0]=rs.getInt("m.movie_id");
				m[1]=rs.getString("m.movie_name");
				m[2]=rs.getString("m.movie_director");
				m[3]=rs.getString("m.movie_actor");
				m[4]=rs.getString("m.movie_sorce");
				m[5]=rs.getString("m.hall_id");
				m[6]=rs.getString("c.category_name");
				m[7]=rs.getString("m.movie_release_date");
				m[8]=rs.getString("m.movie_descrption");
				m[9]=rs.getString("m.movie_duration");
				m[10]=rs.getString("m.movie_add_time");
				m[11]=rs.getInt("m.movie_price");
				m[12]=rs.getString("m.movie_img");
				m[13]=rs.getString("m.movie_radio");
				m[14]=rs.getString("m.movie_pic1");
				m[15]=rs.getString("m.movie_pic2");
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}
	
	//通过name获取影片编号
	public Movie findIdByName(String name) {
		Movie movie=new Movie();
		try {
			conn=this.getConn();
			String sql="select * from movie where movie_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				movie.setMovie_id(rs.getInt("movie_id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return movie;
		
	}
	
	
	
	public Movie findNameById(int movie_id) {
		Movie movie=new Movie();
		try {
			conn=this.getConn();
			String sql="select * from movie where movie_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				movie.setMovie_id(rs.getInt("movie_id"));
				movie.setMovie_name(rs.getString("movie_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return movie;
	}
	
	
	//后台方法
	
	
	//查询所有电影信息
	public List<Object> findMovieAll(){
		List<Object> list=new ArrayList<Object>();
		try {
			conn=this.getConn();
			String sql="select  m.*,h.hall_category,c.category_name from movie m,hall h,category c where "
					+ "m.hall_id=h.hall_id and m.category_id=c.category_id";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] obj=new Object[15];
				obj[0]=rs.getInt("m.movie_id");
				obj[1]=rs.getString("m.movie_name");
				obj[2]=rs.getString("m.movie_director");
				obj[3]=rs.getString("m.movie_actor");
				obj[4]=rs.getString("m.movie_sorce");
				obj[5]=rs.getString("h.hall_category");
				obj[6]=rs.getString("c.category_name");
				obj[7]=rs.getString("m.movie_release_date");
				obj[8]=rs.getString("m.movie_descrption");
				obj[9]=rs.getString("m.movie_duration");
				obj[10]=rs.getString("m.movie_add_time");
				obj[11]=rs.getString("m.movie_price");
				obj[12]=rs.getString("m.movie_img");
				obj[13]=rs.getString("m.movie_pic1");
				obj[14]=rs.getString("m.movie_pic2");
				list.add(obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}
	
	
	//模糊查询
	public List<Object> SearchLikeMovie(String search_name){
		List<Object> search_list=new ArrayList<Object>();
		try {
			conn=this.getConn();
			String sql="select  m.*,h.hall_category,c.category_name from movie m,hall h,category c where "
					+ "m.hall_id=h.hall_id and m.category_id=c.category_id and m.movie_name like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+search_name+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] obj=new Object[15];
				obj[0]=rs.getInt("m.movie_id");
				obj[1]=rs.getString("m.movie_name");
				obj[2]=rs.getString("m.movie_director");
				obj[3]=rs.getString("m.movie_actor");
				obj[4]=rs.getString("m.movie_sorce");
				obj[5]=rs.getString("h.hall_category");
				obj[6]=rs.getString("c.category_name");
				obj[7]=rs.getString("m.movie_release_date");
				obj[8]=rs.getString("m.movie_descrption");
				obj[9]=rs.getString("m.movie_duration");
				obj[10]=rs.getString("m.movie_add_time");
				obj[11]=rs.getString("m.movie_price");
				obj[12]=rs.getString("m.movie_img");
				obj[13]=rs.getString("m.movie_pic1");
				obj[14]=rs.getString("m.movie_pic2");
				search_list.add(obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return search_list;
	}
	
	
	//添加影片信息
	public int addMovie(Movie movie) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="insert into movie(`movie_name`, `movie_director`, `movie_actor`, `movie_sorce`, `hall_id`, `category_id`, `movie_release_date`, `movie_descrption`, "
					+ "`movie_duration`, `movie_price`, `movie_img`,`movie_pic1`, `movie_pic2`) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, movie.getMovie_name());
			ps.setString(2, movie.getMovie_director());
			ps.setString(3, movie.getMovie_actor());
			ps.setDouble(4, movie.getMovie_sorce());
			ps.setInt(5, movie.getHall_id());
			ps.setInt(6, movie.getCategory_id());
			ps.setString(7, movie.getMovie_release_date());
			ps.setString(8, movie.getMovie_descrption());
			ps.setString(9, movie.getMovie_duration());
			ps.setInt(10, movie.getMovie_price());
			ps.setString(11, movie.getMovie_img());
			ps.setString(12, movie.getMovie_pic1());
			ps.setString(13, movie.getMovie_pic2());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//通过id查询影片信息
	public List<Movie> MovieById(int movie_id){
		List<Movie> list=new ArrayList<Movie>();
		Movie m=null;
		Hall h=null;
		Cateogory c=null;
		try {
			conn=this.getConn();
			String sql="select m.*,h.*,c.* from movie m,hall h,category c where "
					+ "m.hall_id=h.hall_id and m.category_id=c.category_id and m.movie_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				m=new Movie();
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
				
				
				list.add(m);
				
				h=new Hall();
				h.setHall_id(rs.getInt("h.hall_id"));
				h.setHall_name(rs.getString("h.hall_name"));
				h.setHall_seat_count(rs.getInt("h.hall_seat_count"));
				h.setHall_category(rs.getString("h.hall_category"));
				m.setHall(h);
				
				c=new Cateogory();
				c.setCategory_id(rs.getInt("c.category_id"));
				c.setCategory_name(rs.getString("c.category_name"));
				m.setCategory(c);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//通过影片编号修改价格
	public int updatePrice(Movie m) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="update movie set movie_price=? where movie_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getMovie_price());
			ps.setInt(2, m.getMovie_id());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//通过id删除影片
	public int delete(int movie_id) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="delete from movie where movie_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie_id);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	//读取电影名和编号
	public List<Movie> findMovieAndId() {
		List<Movie> list_movie=new ArrayList<Movie>();
		try {
			conn=this.getConn();
			String sql="select * from movie";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Movie m=new Movie();
				m.setMovie_id(rs.getInt("movie_id"));
				m.setMovie_name(rs.getString("movie_name"));
				list_movie.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_movie;
	}
}
