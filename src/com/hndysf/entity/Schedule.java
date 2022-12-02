package com.hndysf.entity;

public class Schedule {
	private int schedule_id;
	private int hall_id;//放映厅编号
	private int movie_id;//影片编号
	private String start_time;
	private String end_time;
	private double fare;
	private int cinema_id;//影院id
	private int theater_id;
	
	private Hall hall;
	private Movie movie;
	private Cinema cinema;
	private Theater theater;
	
	
	
	
	
	public int getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Schedule() {}

	

	

	public Schedule(int schedule_id, int hall_id, int movie_id, String start_time, String end_time, double fare,
			int cinema_id, int theater_id, Hall hall, Movie movie, Cinema cinema, Theater theater) {
		super();
		this.schedule_id = schedule_id;
		this.hall_id = hall_id;
		this.movie_id = movie_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.fare = fare;
		this.cinema_id = cinema_id;
		this.theater_id = theater_id;
		this.hall = hall;
		this.movie = movie;
		this.cinema = cinema;
		this.theater = theater;
	}

	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}

	public int getHall_id() {
		return hall_id;
	}

	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
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

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public int getCinema_id() {
		return cinema_id;
	}

	public void setCinema_id(int cinema_id) {
		this.cinema_id = cinema_id;
	}
	
	
}
