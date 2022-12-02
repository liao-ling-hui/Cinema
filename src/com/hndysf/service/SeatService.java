package com.hndysf.service;

import java.util.ArrayList;

import java.util.List;

import com.hndysf.dao.SeatDao;
import com.hndysf.entity.Seat;

public class SeatService {

	private SeatDao sDao = new SeatDao();

	// 渲染座位行和列
	public List<Seat> ShowRowAndCol(String cinema_name, int hall_id, String movie_name) {
		List<Seat> s_list = new ArrayList<Seat>();
		try {
			s_list = sDao.ShowRowAndCol(cinema_name, hall_id, movie_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s_list;
	}

	// 添加座位信息
	public int addSeat(Seat seat_info) {
		int count = 0;
		try {
			count = sDao.addSeat(seat_info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// 根据订单编号查询订单信息
	public List<Seat> findSeatByOrderId(String order_id,int user_id) {
		List<Seat> seat = new ArrayList<Seat>();
		try {
			seat = sDao.findSeatByOrderId(order_id,user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seat;
	}

	// 修改座位
	public int updateSeatInfo(int rows, int cols, int seat_id) {
		int count = 0;
		try {
			count = sDao.updateSeatInfo(rows, cols, seat_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
