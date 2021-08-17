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
	}
	
	/* Style the horizontal ruler */
	hr {
	  border: 1px solid #f1f1f1;
	  margin-bottom: 25px;
	}
	
	.choice {
		margin: 30px 0px;
	}
	
	.inwon {
		margin-right: 20px;
		margin-top: 10px;
		font-size: 20px;
	}
	
	input[type=radio] {
		margin-right: 5px;
	}
	
	label {
		font-size: 20px;
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
		<form action="" method=""> <!-- post로 바꾸기 -->
			<div class="container">
		    	<label for="id"><b>아이디</b></label>
		    	<input type="text" name="id" required readonly="readonly" value="<%=m_id%>"> <!-- 채영언니한테 로그인 받기 -->
		    	<hr>
		
				<div class="choice">
				    <label><b>룸 선택</b></label><br>
				    <button id="roomA">Room A</button>
				    <button id="roomB">Room B</button>
				    <button id="roomC">Room C</button>
			    </div>
			    <hr>
		
				<div class="choice">
			    	<label><b>인원 선택</b></label>
			    	<br>
			    	<input type="radio" name="inwon" id="two" value="2명" checked> <!-- 명진언니한테 예약 데이터 어떤 식으로 들어가는 지 물어보기 value -->
		            <label for="two" class="inwon">~2명</label>
		            <input type="radio" name="inwon" id="three" value="3명">
		            <label for="three" class="inwon">3명</label>
		            <input type="radio" name="inwon" id="four" value="4명">
		            <label for="four" class="inwon">4명</label>
		            <input type="radio" name="inwon" id="five" value="5명">
		            <label for="five" class="inwon">5명</label>
		            <input type="radio" name="inwon" id="six" value="6명">
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