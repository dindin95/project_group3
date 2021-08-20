package com.g3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.g3.dto.BookingDTO;
import com.g3.dto.BookingTimeDTO;
import com.g3.service.BookingService;

/**
 * Servlet implementation class BookingTimeServlet
 */
@WebServlet("/booking.data")
public class BookingTimeServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public BookingTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doRep(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doRep(request, response);
   }

   private void doRep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("utf-8");
      response.setContentType("application/json;charset=utf-8");
      response.setContentType("utf-8");
      
      int bo_room = Integer.parseInt(request.getParameter("bo_room"));
      String bo_date = request.getParameter("bo_date");
      
      BookingService service = new BookingService();
      
      List<BookingTimeDTO> dto = service.getBookingTime(bo_room, bo_date);
      
      PrintWriter out = response.getWriter();
      
      JSONArray jsonArray = new JSONArray();
      
      for(BookingTimeDTO item:dto) {
         JSONObject data = new JSONObject();
         data.put("bo_room", item.getBo_room());
         data.put("bo_date", item.getBo_date().toString());
         data.put("startTime", item.getStartTime());
         data.put("endTime", item.getEndTime());
         data.put("time_check", item.getTime_check());
         jsonArray.add(data);
      }
      
      out.print(jsonArray);
      
   }
}