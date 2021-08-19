package com.g3.dto;

import java.sql.Date;

public class AnswerDTO {
	//a_no, q_no, a_content, a_writeDate, m_id
	private int a_no;
	private int q_no;
	private String a_content;
	private Date a_writeDate;
	private String m_id;
	
	
	
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public Date getA_writeDate() {
		return a_writeDate;
	}
	public void setA_writeDate(Date a_writeDate) {
		this.a_writeDate = a_writeDate;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
	
	
	

}
