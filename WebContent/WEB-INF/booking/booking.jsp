<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	// 세션값 가져오기
	String m_id = (String) session.getAttribute("m_id"); // Object 타입이므로 다운캐스팅
%>
	
	<!-- section -->
	<div id="section">
		<form action="bookingInsert.do" method="post">
			<div class="container">
		    	<label for="id"><b>아이디</b></label>
		    	<input type="text" name="m_id" required readonly="readonly" value="<%=m_id%>" style="font-size: 20px">
		    	<hr>
		
				<div class="choice">
				    <label><b>룸 선택</b></label>
			    	<br>
			    	<input type="radio" name="bo_room" id="RoomA" value="1" checked>
		            <label for="RoomA" class="room">Room A</label>
		            <input type="radio" name="bo_room" id="RoomB" value="2">
		            <label for="RoomB" class="room">Room B</label>
		            <input type="radio" name="bo_room" id="RoomC" value="3">
		            <label for="RoomC" class="room">Room C</label>
			    </div>
			    <hr>
			    
			    <div class="choice">
				    <label><b>날짜 선택</b></label>
				    <br>
				    <input type="date" name="bo_date">
			    </div>
			    <hr>
			    
			    <div class="choice">
			    	<label><b>시간 선택</b></label>
			    	<br>
			    	<select name="startTime" id="startTime" class="time">
			    		<option value=""> 시작시간 </option>
	                    <option value="9">09:00</option>
	                    <option value="10">10:00</option>
	                    <option value="11">11:00</option>
	                    <option value="12">12:00</option>
	                    <option value="13">13:00</option>
	                    <option value="14">14:00</option>
	                    <option value="15">15:00</option>
	                    <option value="16">16:00</option>
	                    <option value="17">17:00</option>
	                    <option value="18">18:00</option>
	                    <option value="19">19:00</option>
	                    <option value="20">20:00</option>
	                    <option value="21">21:00</option>
	                    <option value="22">22:00</option>
                	</select>
                	<select name="endTime" id="endTime" class="time">
			    		<option value=""> 종료시간 </option>
	                    <option value="9">09:00</option>
	                    <option value="10">10:00</option>
	                    <option value="11">11:00</option>
	                    <option value="12">12:00</option>
	                    <option value="13">13:00</option>
	                    <option value="14">14:00</option>
	                    <option value="15">15:00</option>
	                    <option value="16">16:00</option>
	                    <option value="17">17:00</option>
	                    <option value="18">18:00</option>
	                    <option value="19">19:00</option>
	                    <option value="20">20:00</option>
	                    <option value="21">21:00</option>
	                    <option value="22">22:00</option>
                	</select>
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
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>