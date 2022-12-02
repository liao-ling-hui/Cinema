package com.hndysf.service;

import java.util.ArrayList;
import java.util.List;

import com.hndysf.dao.HallDao;
import com.hndysf.entity.Hall;
import com.hndysf.entity.User;

public class HallService {
	
	private HallDao hdao=new HallDao();
	
	//根据放映厅名称查询放映厅id
		public Hall findHallByName(String name) {
			Hall h=new Hall();
			try {
				h=hdao.findHallByName(name);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return h;
		}
			
		
		//查询所有放映厅信息
		public List<Hall> findAllHall(){
			List<Hall> list_hall=new ArrayList<Hall>();
			try {
				list_hall=hdao.findAllHall();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_hall;
		}
}
