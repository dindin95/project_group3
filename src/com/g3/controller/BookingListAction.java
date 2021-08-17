package com.g3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.BookingListDTO;
import com.g3.service.BookingListService;




public class BookingListAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		BookingListService  service = BookingListService.getService();
	
		List<BookingListDTO> list = service.getList();
		
		request.setAttribute("list", list);


		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/calender/bookingList.jsp");

		return forward;
	}

}
