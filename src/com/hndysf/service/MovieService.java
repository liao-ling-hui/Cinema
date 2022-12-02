package com.hndysf.service;

import java.util.ArrayList;
import java.util.List;

import com.hndysf.dao.MovieDao;
import com.hndysf.entity.Movie;

public class MovieService {

	private MovieDao mDao=new MovieDao();
	
	//主页显示电影
	public List<Object[]> findAllMovie(){
		List<Object[]> list_movie=new ArrayList<Object[]>();
		try {
			list_movie=mDao.findAllMovie();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_movie;
	}
	
	//通过id读取电影信息
	public List<Object[]> findMovieById(int id){
		List<Object[]> list=new ArrayList<Object[]>();
		try {
			list=mDao.findMovieByid(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//通过name获取影片编号
		public Movie findIdByName(String name) {
			Movie movie=new Movie();
			try {
				movie=mDao.findIdByName(name);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return movie;
		}
		
		
		public Movie findNameById(int movie_id) {
			Movie movie=new Movie();
			try {
				movie=mDao.findNameById(movie_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return movie;
		}
		
		
		
		
		//后台方法
		
		

		//查询所有电影信息
		public List<Object> findMovieAll(){
			List<Object> list=new ArrayList<Object>();
			try {
				list=mDao.findMovieAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		//模糊查询
		public List<Object> SearchLikeMovie(String search_name){
			List<Object> search_list=new ArrayList<Object>();
			try {
				search_list=mDao.SearchLikeMovie(search_name);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return search_list;
			}
		
		
		
		//添加影片信息
		public int addMovie(Movie movie) {
			int count=0;
			try {
				count=mDao.addMovie(movie);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		
		//通过id查询影片信息
		public List<Movie> MovieById(int movie_id){
			List<Movie> list=new ArrayList<Movie>();
			try {
				list=mDao.MovieById(movie_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		//通过影片编号修改价格
		public int updatePrice(Movie m) {
			int count=0;
			try {
				count=mDao.updatePrice(m);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		
		//通过id删除影片
		public int delete(int movie_id) {
			int count=0;
			try {
				count=mDao.delete(movie_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		//读取电影名和编号
		public List<Movie> findMovieAndId() {
			List<Movie> list_movie=new ArrayList<Movie>();
			try {
				list_movie=mDao.findMovieAndId();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_movie;
		}
}
