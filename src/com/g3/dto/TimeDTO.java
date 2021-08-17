package com.g3.dto;

public class TimeDTO {
//	t_no, bo_room, startTime, endTime
	
	private int t_no;
	private int bo_room;
	private String startTime;
	private String endTime;
	
	
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	public int getBo_room() {
		return bo_room;
	}
	public void setBo_room(int bo_room) {
		this.bo_room = bo_room;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
