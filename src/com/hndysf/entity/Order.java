package com.hndysf.entity;

import java.util.Date;
import java.util.UUID;

public class Order {
	private String order_id;
	private Date order_time;
	private int order_state;
	private double order_total_price;
	private User user;
	private int user_id;
	private int order_count;
	private String see_time;
	private int schedule_id;
	private int pwd_num;
	
	
	private Schedule schedule;
	
	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}

	
	
	
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getPwd_num() {
		return pwd_num;
	}

	public void setPwd_num(int pwd_num) {
		this.pwd_num = pwd_num;
	}

	public Order() {}

	public Order(String order_id, Date order_time, int order_state, double order_total_price, User user, int user_id,
			int order_count, String see_time,int schedule_id,int pwd_num,Schedule schedule) {
		super();
		this.order_id = order_id;
		this.order_time = order_time;
		this.order_state = order_state;
		this.order_total_price = order_total_price;
		this.user = user;
		this.user_id = user_id;
		this.order_count = order_count;
		this.see_time = see_time;
		this.schedule_id=schedule_id;
		this.pwd_num=pwd_num;
		this.schedule=schedule;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public int getOrder_state() {
		return order_state;
	}

	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}

	public double getOrder_total_price() {
		return order_total_price;
	}

	public void setOrder_total_price(double order_total_price) {
		this.order_total_price = order_total_price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	public String getSee_time() {
		return see_time;
	}

	public void setSee_time(String see_time) {
		this.see_time = see_time;
	}

	

	
	
	
}
