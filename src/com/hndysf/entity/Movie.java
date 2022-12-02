package com.hndysf.entity;

import java.util.Date;


public class Movie {
	private int movie_id;
	private String movie_name;
	private String movie_director;
	private String movie_actor;//演员
	private Double movie_sorce;
	private int hall_id;//放映厅
	private int category_id;//放映类型 2D、3D
	private String movie_release_date;//影片上映时间
	private String movie_descrption;
	private String movie_duration;//电影时长
	private Date movie_add_time;//电影添加时间
	private int movie_price;//电影价格
	private String movie_img;//影片图片路径
	private String movie_radio;//影片视屏
	private String movie_pic1;//剧照1
	private String movie_pic2;
	
	
	private Hall hall;
	private Cateogory category;
	
	public Movie() {}

	


	


	public Movie(int movie_id, String movie_name, String movie_director, String movie_actor, Double movie_sorce,
			int hall_id, int category_id, String movie_release_date, String movie_descrption, String movie_duration,
			Date movie_add_time, int movie_price, String movie_img, String movie_radio, String movie_pic1,
			String movie_pic2, Hall hall, Cateogory category) {
		super();
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.movie_director = movie_director;
		this.movie_actor = movie_actor;
		this.movie_sorce = movie_sorce;
		this.hall_id = hall_id;
		this.category_id = category_id;
		this.movie_release_date = movie_release_date;
		this.movie_descrption = movie_descrption;
		this.movie_duration = movie_duration;
		this.movie_add_time = movie_add_time;
		this.movie_price = movie_price;
		this.movie_img = movie_img;
		this.movie_radio = movie_radio;
		this.movie_pic1 = movie_pic1;
		this.movie_pic2 = movie_pic2;
		this.hall = hall;
		this.category = category;
	}







	public String getMovie_director() {
		return movie_director;
	}







	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}







	public Double getMovie_sorce() {
		return movie_sorce;
	}







	public void setMovie_sorce(Double movie_sorce) {
		this.movie_sorce = movie_sorce;
	}







	public Hall getHall() {
		return hall;
	}




	public void setHall(Hall hall) {
		this.hall = hall;
	}




	public Cateogory getCategory() {
		return category;
	}




	public void setCategory(Cateogory category) {
		this.category = category;
	}




	public int getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}


	public String getMovie_name() {
		return movie_name;
	}


	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}


	


	public String getMovie_actor() {
		return movie_actor;
	}


	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}


	


	public int getHall_id() {
		return hall_id;
	}


	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public String getMovie_release_date() {
		return movie_release_date;
	}


	public void setMovie_release_date(String movie_release_date) {
		this.movie_release_date = movie_release_date;
	}


	public String getMovie_descrption() {
		return movie_descrption;
	}


	public void setMovie_descrption(String movie_descrption) {
		this.movie_descrption = movie_descrption;
	}


	public String getMovie_duration() {
		return movie_duration;
	}


	public void setMovie_duration(String movie_duration) {
		this.movie_duration = movie_duration;
	}


	public Date getMovie_add_time() {
		return movie_add_time;
	}


	public void setMovie_add_time(Date movie_add_time) {
		this.movie_add_time = movie_add_time;
	}


	public int getMovie_price() {
		return movie_price;
	}


	public void setMovie_price(int movie_price) {
		this.movie_price = movie_price;
	}


	public String getMovie_img() {
		return movie_img;
	}


	public void setMovie_img(String movie_img) {
		this.movie_img = movie_img;
	}

	public String getMovie_radio() {
		return movie_radio;
	}

	public void setMovie_radio(String movie_radio) {
		this.movie_radio = movie_radio;
	}




	public String getMovie_pic1() {
		return movie_pic1;
	}




	public void setMovie_pic1(String movie_pic1) {
		this.movie_pic1 = movie_pic1;
	}




	public String getMovie_pic2() {
		return movie_pic2;
	}




	public void setMovie_pic2(String movie_pic2) {
		this.movie_pic2 = movie_pic2;
	}
	
	
}
