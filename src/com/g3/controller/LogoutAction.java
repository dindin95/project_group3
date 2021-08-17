package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;


public class LogoutAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		HttpSession session = request.getSession(); //세션정보를 가지고 와서 
		session.invalidate(); //기존의 세션 데이터를 모두 삭제
		
		
		Forward f = new Forward();
		f.setForward(false);
		f.setPath("main.do");
		
		return f;
	}

}
