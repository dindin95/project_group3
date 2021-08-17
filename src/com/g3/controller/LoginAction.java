package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.g3.comm.Action;
import com.g3.comm.Forward;

public class LoginAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/*
		 * Forward forward = new Forward(); forward.setForward(true);
		 * forward.setPath("/main.jsp?page=login.jsp"); return forward;
		 */
		
		System.out.println("loginAction");
		
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/main/login.jsp");

		return forward;
		
		
	}

}