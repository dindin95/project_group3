package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.g3.dto.BookingDTO;
import com.g3.dto.BookingTimeDTO;
import com.g3.dto.TimeDTO;

public class BookingDAO {
   
   //예약하기(time 테이블)
   public int insertTime(Connection conn, TimeDTO time) {
      StringBuilder sql = new StringBuilder();
      sql.append("   insert into time_g3 ( bo_room, startTime, endTime, time_check )   ");
      sql.append("   values( ?, ?, ?, ? )                                			   ");
      
      int result = 0;
      
      try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
         
         pstmt.setInt(1, time.getBo_room());
         pstmt.setInt(2, time.getStartTime());
         pstmt.setInt(3, time.getEndTime());
         pstmt.setInt(4, 1); //예약이 되었으면 1 삽입
         
         result = pstmt.executeUpdate();
         
         System.out.println("insertTime result : " + result);
         
      } catch(SQLException e) {
         System.out.println(e);
         
      }
      
      return result;
   }
   
   //selectTime 메서드 리턴 값을 int로 잡아서 그 값을 insertBooking에 넘겨주기
   public int selectTime(Connection conn, TimeDTO time) {
      StringBuilder sql = new StringBuilder();
      sql.append("   select t_no      ");
      sql.append("   from time_g3     ");
      
      int timeResult = 0;
      
      try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
         ResultSet rs = pstmt.executeQuery();
      ){
         while(rs.next()) {
            timeResult = rs.getInt(1);
         }
         
      } catch(SQLException e) {
         System.out.println(e);
         
      }

      return timeResult;
   } 

   
   //예약하기(booking 테이블)
   public int insertBooking(Connection conn, BookingDTO booking, int timeResult) {
      StringBuilder sql = new StringBuilder();
      sql.append("   insert into booking_g3 ( bo_date, m_id, bo_persons, t_no )   ");
      sql.append("   values( ?, ?, ?, ? )                                         ");
      
      int result = 0;
      
      try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
         
         pstmt.setString(1, booking.getBo_date());
         pstmt.setString(2, booking.getM_id());
         pstmt.setInt(3, booking.getBo_persons()); 
         pstmt.setInt(4, timeResult);
         
         result = pstmt.executeUpdate();
         
         System.out.println("insertBooking result : " + result);
         
      } catch(SQLException e) {
         System.out.println(e);
         
      }
      
      return result;
   }

   //예약 불가능한 시간 보여주기
   public List<BookingTimeDTO> getBookingTime(Connection conn, int bo_room, String bo_date) {
      // TODO Auto-generated method stub
      
      StringBuilder sql = new StringBuilder();
      sql.append("    select									");
      sql.append("           bo_room							");
      sql.append("           ,bo_date							");
      sql.append("           ,startTime							");
      sql.append("           ,endTime							");
      sql.append("           ,time_check						");
      sql.append("    from booking_g3 join time_g3				");
      sql.append("       on booking_g3.t_no = time_g3.t_no		");
      sql.append("   where bo_room = ?							");
      sql.append("   and bo_date = ?							");
      
      List<BookingTimeDTO> list = new ArrayList<BookingTimeDTO>();
      ResultSet rs = null;
      
      try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
         pstmt.setInt(1, bo_room);
         pstmt.setString(2, bo_date);
         
         rs = pstmt.executeQuery();
         while(rs.next()) {
            BookingTimeDTO dto = new BookingTimeDTO();
            
            dto.setBo_room(rs.getInt("bo_room"));
            dto.setBo_date(rs.getString("bo_date"));
            dto.setStartTime(rs.getInt("startTime"));
            dto.setEndTime(rs.getInt("endTime"));
            dto.setTime_check(rs.getInt("time_check"));
            
            list.add(dto);
         }
         
      } catch (SQLException e) {
         System.out.println(e);
         
      }
      
      return list;
   }


}