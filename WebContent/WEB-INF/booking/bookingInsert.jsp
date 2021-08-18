<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int result = (Integer)request.getAttribute("result");
	if(result > 0) {
%>
		<script>
			alert("예약이 완료되었습니다.");
			location.href = "booking.do";
		</script>
<%	
	} else {
%>
		<script>
			alert("입력 실패");
			location.href = "booking.do";
		</script>
<%	
	}
%>
</body>
</html>