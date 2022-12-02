package com.hndysf.entity;

public class TicketBeanHead {
	private String movie_duration;//片长
	private String hall_category;//放映厅类型
	private String cinema_name;
	private String movie_name;
	
	public TicketBeanHead() {}

	

	public TicketBeanHead(String movie_duration, String hall_category, String cinema_name, String movie_name) {
		super();
		this.movie_duration = movie_duration;
		this.hall_category = hall_category;
		this.cinema_name = cinema_name;
		this.movie_name = movie_name;
	}



	public String getMovie_duration() {
		return movie_duration;
	}

	public void setMovie_duration(String movie_duration) {
		this.movie_duration = movie_duration;
	}

	public String getHall_category() {
		return hall_category;
	}

	public void setHall_category(String hall_category) {
		this.hall_category = hall_category;
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
	
	

}
