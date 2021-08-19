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
			alert("예약에 실패했습니다. 다시 시도해주세요.");
			location.href = "booking.do";
		</script>
<%	
	}
%>
</body>
</html>