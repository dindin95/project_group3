package com.g3.dto;

import java.util.Date;

public class LoginDTO {

	private String m_id;
	private String m_pwd;
	private String m_name;
	private String m_phone;
	private Date m_date;
	private int m_leval;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public Date getM_date() {
		return m_date;
	}
	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}
	public int getM_leval() {
		return m_leval;
	}
	public void setM_leval(int m_leval) {
		this.m_leval = m_leval;
	}
}
