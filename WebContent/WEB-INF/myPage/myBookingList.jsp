<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/question.css">
</head>
<body>

<jsp:include page="../includes/header.jsp" />

<%
// 세션값 가져오기
String m_id = (String) session.getAttribute("m_id"); // Object 타입이므로 다운캐스팅

%>

<c:set var="list" value="${requestScope.list}"></c:set>

<c:set var="currpage" value="${requestScope.currpage}"></c:set>
<c:set  var="datacount" value="${requestScope.datacount }"></c:set>
<c:set var="startblock" value="${requestScope.startblock }"></c:set>
<c:set var="endblock" value="${requestScope.endblock }"></c:set>
<c:set var="totalpage" value="${requestScope.totalpage }"></c:set>

<div class="container">
	<table class="table table-hover">
	  <thead>
	   		<tr>
		   		<th>번호</th>
		  		<th>예약 일자</th>
		  		<th>예약 시간</th>
		  		<th>룸</th>
		  		<th><input type="button" value="삭제"></th>
	  		</tr>
	  </thead>
	  
	  
	</table>
</div>

<jsp:include page="../includes/footer.jsp" />

</body>


</html>



