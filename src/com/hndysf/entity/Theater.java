package com.hndysf.entity;

public class Theater {
	
	private int theater_id;
	private String theater_name;
	private String cinema_address;
	private int cinema_fare;//多少起
	private String cinema_distance;//距离
	private String cinema_recent_times;//近期时间
	private String cinema_business;//营业时间
	
	public Theater() {
		
		
	}


	public String getCinema_address() {
		return cinema_address;
	}


	public void setCinema_address(String cinema_address) {
		this.cinema_address = cinema_address;
	}


	public int getCinema_fare() {
		return cinema_fare;
	}


	public void setCinema_fare(int cinema_fare) {
		this.cinema_fare = cinema_fare;
	}


	public String getCinema_distance() {
		return cinema_distance;
	}


	public void setCinema_distance(String cinema_distance) {
		this.cinema_distance = cinema_distance;
	}


	public String getCinema_recent_times() {
		return cinema_recent_times;
	}


	public void setCinema_recent_times(String cinema_recent_times) {
		this.cinema_recent_times = cinema_recent_times;
	}


	public String getCinema_business() {
		return cinema_business;
	}


	public void setCinema_business(String cinema_business) {
		this.cinema_business = cinema_business;
	}


	public Theater(int theater_id, String theater_name, String cinema_address, int cinema_fare, String cinema_distance,
			String cinema_recent_times, String cinema_business) {
		super();
		this.theater_id = theater_id;
		this.theater_name = theater_name;
		this.cinema_address = cinema_address;
		this.cinema_fare = cinema_fare;
		this.cinema_distance = cinema_distance;
		this.cinema_recent_times = cinema_recent_times;
		this.cinema_business = cinema_business;
	}


	public int getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}
	
	
	
	

}
