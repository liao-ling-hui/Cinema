package com.hndysf.entity;

public class Seat {
	private int seat_id;
	private int rows;
	private int cols;
	private int state;
	private int user_id;
	private String cinema_name;
	private String movie_name;
	private String order_id;
	private int hall_id;
	
	public Seat() {}


	public int getSeat_id() {
		return seat_id;
	}


	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int c) {
		this.rows = c;
	}


	public int getCols() {
		return cols;
	}


	public void setCols(int cols) {
		this.cols = cols;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	


	public String getCinema_name() {
		return cinema_name;
	}


	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}


	public String getMovie_name() {
		return movie_name;
	}


	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}




	

	public Seat(int seat_id, int rows, int cols, int state, int user_id, String cinema_name, String movie_name, String order_id,int hall_id) {
		super();
		this.seat_id = seat_id;
		this.rows = rows;
		this.cols = cols;
		this.state = state;
		this.user_id = user_id;
		this.cinema_name = cinema_name;
		this.movie_name = movie_name;
		this.order_id = order_id;
		this.hall_id=hall_id;
	}



	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public int getHall_id() {
		return hall_id;
	}


	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}
	
	
	
}
