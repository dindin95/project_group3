package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.BookingDTO;
import com.g3.dto.TimeDTO;
import com.g3.service.BookingService;

public class BookingInsertAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String m_id = request.getParameter("m_id");
		int bo_room = Integer.parseInt(request.getParameter("bo_room"));
		String bo_date = request.getParameter("bo_date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		int bo_persons = Integer.parseInt(request.getParameter("bo_persons"));
		
		TimeDTO time = new TimeDTO();
		BookingDTO Booking = new BookingDTO();
		
		Booking.setM_id(m_id);
		time.setBo_room(bo_room);
		Booking.setBo_date(bo_date);
		time.setStartTime(startTime);
		time.setEndTime(endTime);
		Booking.setBo_persons(bo_persons);
		
		BookingService service = new BookingService();
		int result = service.insertBooking(time, Booking);
		
		request.setAttribute("result", result);
		
		Forward f = new Forward();
		f.setForward(true);
		f.setPath("WEB-INF/booking/bookingInsert.jsp");
		
		return f;
	}

}
