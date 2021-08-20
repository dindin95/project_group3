<%@page import="com.g3.dto.BookingTimeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
   input[type=text] {
     width: 100%;
     padding: 15px;
     margin: 5px 0 22px 0;
     display: inline-block;
     border: none;
     background: #f1f1f1;
   }
   
   #section {
      margin: 30px 0px;
   }
   
   button {
     background-color: #04AA6D;
     color: white;
     padding: 14px 20px;
     margin: 8px 0;
     border: none;
     cursor: pointer;
     opacity: 0.9;
   }
   
   button:hover {
     opacity:1;
   }
   
   .booking {
     width: 100%;
     background-color: #f96332; <!-- 오렌지 색상 -->
   }
   
   /* Style the horizontal ruler */
   hr {
     border: 1px solid #f1f1f1;
     margin-bottom: 25px;
   }
   
   .choice {
      margin: 30px 0px;
   }
   
   .inwon, .room {
      margin-right: 20px;
      margin-top: 10px;
      font-size: 20px;
   }
   
   input[type=radio] {
      margin-right: 5px;
   }
   
   input[type=date] {
      margin-top: 10px;
      padding: 3px 20px;
   }
   
   label {
      font-size: 20px;
   }
   
   .time {
      padding: 5px 20px;
      margin-right: 5px;
      margin-top: 10px;
   }
</style>
</head>
<body>
   <!-- header -->
   <jsp:include page="../includes/header.jsp" /> 
   
<%
   BookingTimeDTO dto = new BookingTimeDTO();

   // 세션값 가져오기
   String m_id = (String) session.getAttribute("m_id"); // Object 타입이므로 다운캐스팅
   if(m_id == null) {
%>
   <script>
      alert("로그인 후 진행해주세요.");
      location.href = "login.do";
   </script>
<%      
   }
%>
   
   <!-- section -->
   <div id="section">
      <form action="bookingInsert.do" method="post" onsubmit="return booking()" name="frm">
         <div class="container">
             <label for="id"><b>아이디</b></label>
             <input type="text" name="m_id" required readonly="readonly" value="<%=m_id%>" style="font-size: 20px">
             <hr>
      
            <div class="choice">
                <label><b>룸 선택</b></label>
                <br>
                	<input type="radio" name="bo_room" class="bo_room" id="RoomA" value="1" checked>
                    <label for="RoomA" class="room">Room A</label>
                    <input type="radio" name="bo_room" class="bo_room" id="RoomB" value="2">
                    <label for="RoomB" class="room">Room B</label>
                    <input type="radio" name="bo_room" class="bo_room" id="RoomC" value="3">
                    <label for="RoomC" class="room">Room C</label>
             </div>
             <hr>
             
             <div class="choice">
                <label><b>날짜 선택</b></label>
                <br>
                <input type="date" name="bo_date" id="bo_date">
             </div>
             <hr>
             
             <div class="choice">
               <input type="button" id="timeChoice" value="시간 선택" 
               		style="color: white; background-color: #f96332; padding: 10px">&nbsp;&nbsp;&nbsp;&nbsp;※ 한 타임만 선택 가능합니다.
					<table class="table" style="margin-top: 20px; width: 500px">
					<div id="hiddenDiv"></div>
						<thead>
							<tr>
								<th>시작 시간</th>
								<th>종료 시간</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td name="startTime" class="startTime" value="9">9:00</td>
								<td name="endTime" class="endTime" value="10">10:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="10">10:00</td>
								<td name="endTime" class="endTime" value="11">11:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="11">11:00</td>
								<td name="endTime" class="endTime" value="12">12:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="12">12:00</td>
								<td name="endTime" class="endTime" value="13">13:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="13">13:00</td>
								<td name="endTime" class="endTime" value="14">14:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="14">14:00</td>
								<td name="endTime" class="endTime" value="15">15:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="15">15:00</td>
								<td name="endTime" class="endTime" value="16">16:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="16">16:00</td>
								<td name="endTime" class="endTime" value="17">17:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="17">17:00</td>
								<td name="endTime" class="endTime" value="18">18:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="18">18:00</td>
								<td name="endTime" class="endTime" value="19">19:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="19">19:00</td>
								<td name="endTime" class="endTime" value="20">20:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="20">20:00</td>
								<td name="endTime" class="endTime" value="21">21:00</td>
								<td name="time_check" class="result"></td>
							</tr>
							<tr>
								<td name="startTime" class="startTime" value="21">21:00</td>
								<td name="endTime" class="endTime" value="22">22:00</td>
								<td name="time_check" class="result"></td>
							</tr>
						</tbody>
					</table>
					<br>
                <hr>
             </div>
      
            <div class="choice">
                <label><b>인원 선택</b></label>
                <br>
                <input type="radio" name="bo_persons" id="two" value="2" checked>
                  <label for="two" class="inwon">~2명</label>
                  <input type="radio" name="bo_persons" id="three" value="3">
                  <label for="three" class="inwon">3명</label>
                  <input type="radio" name="bo_persons" id="four" value="4">
                  <label for="four" class="inwon">4명</label>
                  <input type="radio" name="bo_persons" id="five" value="5">
                  <label for="five" class="inwon">5명</label>
                  <input type="radio" name="bo_persons" id="six" value="6">
                  <label for="six" class="inwon">6명</label>
               </div>
               <hr>

             <div>
                  <button type="submit" class="booking">예약하기</button>
             </div>
           </div>
      </form>
   </div>
   
   <script>
   function booking() {
	   console.log('test'); 
 		 let start = $('.ch:checked').parent().siblings('.startTime');  
 		 let end = start.next();
 		 
 		 var startTime = parseInt(start.text().substr(0,start.text().indexOf(":")));
		 var endTime = parseInt(end.text().substr(0,end.text().indexOf(":")));
		 
		 let a = $('<input>').prop({'type':'hidden', 'name':'startTime', 'value':startTime});
		 let b = $('<input>').prop({'type':'hidden', 'name':'endTime', 'value':endTime});
		 
		 $(a).appendTo('form');
		 $(b).appendTo('form');
		 
		 console.log(startTime, endTime);
		 
		 if(start.length > 1) {
			 alert("한 타임만 선택해주세요.");
		 }
		return true;
   }
   
   $(document).ready(function() {
	  $("#timeChoice").click(function() {
      
      let bo_room = $(".bo_room:checked").val(); //.bo_room에서 체크된 value만 가져 옴
      let bo_date = $("#bo_date").val(); //#bo_date에서 value를 가져 옴
      console.log(bo_room);
      console.log(bo_date);
      
         $.ajax({
            url: "http://localhost:8080/project_group3/booking.data" //url 주소로 보낸다
            ,data: {"bo_room": bo_room , "bo_date": bo_date}
            ,datatype: "json"
            ,method: "get"
            ,success: function(data) { //보낸 데이터를 가져온다
               console.log("성공: " + data);
               $('.result').empty();
               let result = "";
               
               $('.result').append('<input type="checkbox" class="ch">');
               
               //starTime
               let tarr = $('td[name="startTime"]');
               
               let json_data = $.parseJSON(data); //data를 JSON으로 형변환
      	       
               for(let i=0; i<tarr.length; i++) {
      	    	     let data = $(tarr[i]); //data : starTime의 i번째
      	    	     let d = data.text().substr(0,data.text().indexOf(":")); //d : data를 텍스트로 받고 0번째부터 데이터 텍스트의 : 앞까지 잘라냄
      	    	         
      	    	      $.each(json_data, function(index, item){
      	    	    
      	    		        if(d == item['startTime']) { //d가 startTime(ex.9)와 같다면
      	    		        	let a=$(data).siblings().find('.ch'); //data와 같은 부모를 가진 자식 중 .ch를 찾아냄
      	    		        	$(a).prop('disabled',true); //.ch에 disabled 속성 추가
      	    		        }
      	    	      });
      	    	}
      	       
      	       //endTime
      	       let tarr2 = $('td[name="endTime"]'); 
               
               let json_data2 = $.parseJSON(data);
               
      	       for(let i=0; i<tarr2.length; i++) {
      	    	     let data=  $(tarr2[i]);
      	    	     let d=data.text().substr(0,data.text().indexOf(":"));
      	    	         
      	    	      $.each(json_data, function(index, item){
      	    	    
      	    		        if(d == item['endTime']) {
      	    		        	let a=$(data).siblings().find('.ch');
      	    		        	$(a).prop('disabled',true);
      	    		        }
      	    	      });
      	    	}
             }
            ,error: function(jqxhr) {
               console.log("실패");
               console.log(jqxhr);
            }
         }); //end ajax
         
         console.log("ajax 끝!!!!!!!!!!!!!!!!!!");
         
       });
    });
	</script>
   
   <!-- footer -->
   <jsp:include page="../includes/footer.jsp" />
</body>
</html>