package com.hndysf.service;

import java.util.ArrayList;
import java.util.List;

import com.hndysf.dao.OrderDao;
import com.hndysf.dao.SeatDao;
import com.hndysf.entity.Order;
import com.hndysf.entity.Schedule;
import com.hndysf.entity.User;


public class OrderService {

	private OrderDao odao=new OrderDao();
	private SeatDao sdao=new SeatDao();

	// 新增订单记录
	public int addOrder(Order order) {
			int count=0;
			try {
				count=odao.addOrder(order);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return count;
	}
	
	
	public int addOrderAdmin(Order order) {
		int count=0;
		try {
			count=odao.addOrderAdmin(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
}
	
	

	//根据id查询订单相关信息
		public List<Object> findOrderByOrderId(String order_id){
			List<Object> order_list=new ArrayList<Object>();
			try {
				order_list=odao.findOrderByOrderId(order_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return order_list;
		}
		
		
		//根据用户id查询用户的订单信息
		public List<Object> findOrderByUserId(int user_id){
			List<Object> list_user_order=new ArrayList<Object>() ;
				try {
					list_user_order=odao.findOrderByUserId(user_id);
				}catch(Exception e) {
					e.printStackTrace();
				}
				return list_user_order;
			
		}
		
		//通过订单编号删除
		public void deleteById(String order_id) {
			try {
				//1.删除座位信息编号
				int seat_count=sdao.deleteSeatById(order_id);
				
				//2.修改订单状态为退票
				int order_count_update=odao.updateState(order_id);
				//3.删除订单信息编号
				int order_count=odao.deleteOrderByOrderId(order_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		//后台功能模块
		
		//查询全部订单信息
		public List<Order> findAllOrder(){
			List<Order> list_order=new ArrayList<Order>();
			try {
				list_order=odao.findAllOrder();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_order;
		}
		
		
		//根据订单编号查询详细信息
		public List<Object> findOrderDeatailsByOrderId(String order_id){
			List<Object> list=new ArrayList<Object>();
			try {
				list=odao.findOrderDeatailsByOrderId(order_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		//根据所属用户进行查询
		public List<Order> findOrderByUser(String user_name){
			List<Order> list_order=new ArrayList<Order>();
			try {
				list_order=odao.findOrderByUser(user_name);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_order;
		}
}
