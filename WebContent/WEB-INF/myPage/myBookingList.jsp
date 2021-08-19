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


<form action="mybookingDelete.do" method="post">
	<div class="container">
		<table class="table table-hover">
		  <thead>
		   		<tr>
			   		<th>번호</th>
			  		<th>예약 일자</th>
			  		<th>예약 시간</th>
			  		<th>룸</th>
		  		</tr>
		  </thead>
		  <c:forEach var="item" items="${list }">
			       <td><c:out value="${item.bo_no }"/></td>

			      <td><c:out value="${item.bo_date }"/></td>
			      <td><c:out value="${item.time }"/></td>
			      
			     	<c:if test="${item.bo_room == 1 }">
				               <td><c:out value="Room A"></c:out></td>
					</c:if>
			     	<c:if test="${item.bo_room == 2 }">
				               <td><c:out value="Room B"></c:out></td>
					</c:if>
			     	<c:if test="${item.bo_room == 3 }">
				               <td><c:out value="Room C"></c:out></td>
					</c:if>
			      
		    	  <td><a href="mybookingDelete.do?bo_no=${item.bo_no }" class="btn btn-primary btn-round btn-lg" style="height: 20px;display: inline-block;line-height: 0;" >    삭제    </a></td>
		    	</tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
	
	<ul class="pagination justify-content-center">
	<div class="page1">
	 <c:if test="${startblock>1 }">
	    <a href="myBookingList.do?curr=${currpage-1}"><<</a>
	 </c:if>
	</div>
	
	<div class="page2">
	<c:forEach var="index" begin="${startblock }" end="${endblock }">
	  <c:if test="${currpage==index }">
	     <c:out value="${index }"></c:out>
	  </c:if>
	  <c:if test="${currpage!=index }">
	      <a href="myBookingList.do?curr=${index}">${index}</a> 
	  </c:if>
	</c:forEach>
	</div>
	
	<div class="page3">
	<c:if test="${endblock<totalpage}">
	  <a href="myBookingList.do?curr=${currpage+1 }">>></a>
	</c:if>
	</div>
	</ul>
</form>

<jsp:include page="../includes/footer.jsp" />

</body>


</html>
