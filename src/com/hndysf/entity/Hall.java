package com.hndysf.entity;

public class Hall {
	private int hall_id;
	private String hall_name;
	private int hall_seat_count;
	private String hall_category;
	
	public Hall() {}

	public Hall(int hall_id, String hall_name, int hall_seat_count, String hall_category) {
		super();
		this.hall_id = hall_id;
		this.hall_name = hall_name;
		this.hall_seat_count = hall_seat_count;
		this.hall_category = hall_category;
	}

	public int getHall_id() {
		return hall_id;
	}

	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}

	public String getHall_name() {
		return hall_name;
	}

	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}

	public int getHall_seat_count() {
		return hall_seat_count;
	}

	public void setHall_seat_count(int hall_seat_count) {
		this.hall_seat_count = hall_seat_count;
	}

	public String getHall_category() {
		return hall_category;
	}

	public void setHall_category(String hall_category) {
		this.hall_category = hall_category;
	}
	
	
	
}
