package com.hndysf.entity;

public class ChooseBaseBean {
	private String movie_name;//影片名
	private String movie_durtion;//影片时长
	private String start_time;
	private String end_time;
	private String hall_name;//放映厅名
	private String hall_category;//放映厅类型
	private double fare;
	private String cinema_name;//影院名
	private String movie_img;
	
	public ChooseBaseBean() {}

	public ChooseBaseBean(String movie_name, String movie_durtion, String start_time, String end_time, String hall_name,
			String hall_category, double fare,String cinema_name,String movie_img) {
		super();
		this.movie_name = movie_name;
		this.movie_durtion = movie_durtion;
		this.start_time = start_time;
		this.end_time = end_time;
		this.hall_name = hall_name;
		this.hall_category = hall_category;
		this.fare = fare;
		this.cinema_name=cinema_name;
		this.movie_img=movie_img;
	}

	
	
	public String getMovie_img() {
		return movie_img;
	}

	public void setMovie_img(String movie_img) {
		this.movie_img = movie_img;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getMovie_durtion() {
		return movie_durtion;
	}

	public void setMovie_durtion(String movie_durtion) {
		this.movie_durtion = movie_durtion;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getHall_name() {
		return hall_name;
	}

	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}

	public String getHall_category() {
		return hall_category;
	}

	public void setHall_category(String hall_category) {
		this.hall_category = hall_category;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getCinema_name() {
		return cinema_name;
	}

	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	
	
}
