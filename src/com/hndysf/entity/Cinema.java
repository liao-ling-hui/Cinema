package com.hndysf.entity;

public class Cinema {
	private int cinema_id;
	private String cinema_name;
	private int theater_id;
	private String cinema_address;
	private int cinema_fare;//多少起
	private String cinema_distance;//距离
	private String cinema_recent_times;//近期时间
	private String cinema_business;//营业时间
	private int movie_id;//影片编号
	
	public Cinema() {}

	


	public Cinema(int cinema_id, String cinema_name, int theater_id, String cinema_address, int cinema_fare,
			String cinema_distance, String cinema_recent_times, String cinema_business, int movie_id) {
		super();
		this.cinema_id = cinema_id;
		this.cinema_name = cinema_name;
		this.theater_id = theater_id;
		this.cinema_address = cinema_address;
		this.cinema_fare = cinema_fare;
		this.cinema_distance = cinema_distance;
		this.cinema_recent_times = cinema_recent_times;
		this.cinema_business = cinema_business;
		this.movie_id = movie_id;
	}




	public int getCinema_id() {
		return cinema_id;
	}

	public void setCinema_id(int cinema_id) {
		this.cinema_id = cinema_id;
	}

	public String getCinema_name() {
		return cinema_name;
	}

	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
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


	public int getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}




	public int getTheater_id() {
		return theater_id;
	}




	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}




	
	
}
