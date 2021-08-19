<%@page import="java.util.List"%>
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
					<a href="bookingTime.do" style="color: white; background-color: #f96332; padding: 10px">시간 선택</a>
					<table class="table" style="width: 500px; margin-top: 20px">
						<thead>
							<tr> 
								<th>시작 시간</th>
								<th>종료 시간</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td><input type="checkbox" style="width: 20px; height: 20px"></td>
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
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>