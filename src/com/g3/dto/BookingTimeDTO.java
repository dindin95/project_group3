package com.g3.dto;

public class BookingTimeDTO {
	private int bo_room;
	private String bo_date;
	private int startTime;
	private int endTime;
	private int time_check;
	
	public int getBo_room() {
		return bo_room;
	}
	public void setBo_room(int bo_room) {
		this.bo_room = bo_room;
	}
	public String getBo_date() {
		return bo_date;
	}
	public void setBo_date(String bo_date) {
		this.bo_date = bo_date;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getTime_check() {
		return time_check;
	}
	public void setTime_check(int time_check) {
		this.time_check = time_check;
	}
	
	
}
