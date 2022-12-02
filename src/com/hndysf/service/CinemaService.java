package com.hndysf.service;

import java.util.ArrayList;
import java.util.List;

import com.hndysf.dao.CinemaDao;
import com.hndysf.entity.Cateogory;
import com.hndysf.entity.Cinema;

public class CinemaService {

	private CinemaDao cDao=new CinemaDao();
	
	//显示所有附近影院
		public List<Cinema> findAllCinema() {
			List<Cinema> list_cinema=new ArrayList<Cinema>();
			try {
				list_cinema=cDao.findAllCinema();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_cinema;
		}
		
		
		//通过影片id显示影院信息
		public List<Object[]> findCinemaById(int movie_id){
			List<Object[]> list=new ArrayList<Object[]>();
			try {
				list=cDao.findCinemaById(movie_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		
		//查询所有类型
		public List<Cateogory> findAllCategory(){
			List<Cateogory> list_cate=new ArrayList<Cateogory>();
			try {
				list_cate=cDao.findAllCategory();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_cate;
		}
		
		

//		//添加
		public int findCinemaByTheater(Cinema c) {
			int count=0;
			try {
				count=cDao.findCinemaByTheater(c);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
}
