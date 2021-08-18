package com.g3.dto;

import java.sql.Date;

public class BookingListDTO {
//	bo_no, bo_date, m_id, bo_persons, t_no
	private int bo_no;
	private Date bo_date;
	private String m_id;
	private int bo_persons;
	private int t_no;
	
	
	public int getBo_no() {
		return bo_no;
	}
	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
	}
	public Date getBo_date() {
		return bo_date;
	}
	public void setBo_date(Date bo_date) {
		this.bo_date = bo_date;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getBo_persons() {
		return bo_persons;
	}
	public void setBo_persons(int bo_persons) {
		this.bo_persons = bo_persons;
	}
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
}
