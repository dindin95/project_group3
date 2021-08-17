package com.g3.dto;

public class QuestionDTO {
	private int q_no;
	private String q_title;
	private String q_content;
	private String m_id;
	private String q_writedate;
	
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getQ_writedate() {
		return q_writedate;
	}
	public void setQ_writedate(String q_writedate) {
		this.q_writedate = q_writedate;
	}
}
