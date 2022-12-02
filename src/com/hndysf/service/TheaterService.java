package com.hndysf.service;

import java.util.ArrayList;
import java.util.List;

import com.hndysf.dao.TheaterDao;
import com.hndysf.entity.Theater;

public class TheaterService {
	
	private TheaterDao tdao=new TheaterDao();
	
	//查询所有
		public List<Theater> findAllTheater(){
			 List<Theater> list_theater=new ArrayList<Theater>();
			 try {
				list_theater=tdao.findAllTheater();
			 }catch(Exception e ) {
				 e.printStackTrace();
			 }
			 return list_theater;
		}

		
		//通过id查询影院信息
		public Theater findCinemaByTheater(int theater_id) {
			Theater t=new Theater();
			try {
			t=tdao.findCinemaByTheater(theater_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return t;
		}
}
