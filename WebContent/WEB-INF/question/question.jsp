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

<c:set var="list" value="${requestScope.list}"></c:set>

<c:set var="currpage" value="${requestScope.currpage}"></c:set>
<c:set  var="datacount" value="${requestScope.datacount }"></c:set>
<c:set var="startblock" value="${requestScope.startblock }"></c:set>
<c:set var="endblock" value="${requestScope.endblock }"></c:set>
<c:set var="totalpage" value="${requestScope.totalpage }"></c:set>
<c:set var="search" value="${requestScope.search }"></c:set>
<c:set var="searchtxt" value="${requestScope.searchtxt }"></c:set>

<div class="container">
<button type="button" class="btn btn-secondary pull-right" disabled>글쓰기</button></div>

<br>
<div class="container">
<div class="search">
<form method="get" action="question.do">
  <select name="search" class="form-control-sm">
     <option value="q_title">제목</option>
     <option value="q_content">내용</option>
  </select>
  <input type="text" name="searchtxt" class="form-control-sm">
  <input type="submit" class="btn btn-secondary" value="검색">
</form>
</div>
</div>

<br>
<div class="container">
	<table class="table table-hover">
	  <thead><tr><th>번호</th>
	  		<th>제목</th>
	  		<th>내용</th>
	  		<th>회원아이디</th>
	  		<th>작성일</th></tr></thead>
	  <tbody>
	    <c:forEach var="item" items="${list }">
	      <tr><td><c:out value="${item.q_no}"></c:out></td>
	      <td><a href="questiondetail.do?q_no=${item.q_no }"><c:out value="${item.q_title }"/></a></td>
	      <td><c:out value="${item.q_content }"/></td>
	      <td><c:out value="${item.m_id }"/></td>
	      <td><c:out value="${item.q_writedate }"/></td></tr>
	    </c:forEach>
	  </tbody>
	</table>
</div>

<ul class="pagination justify-content-center">
<div class="page1">
 <c:if test="${startblock>=1 }">
    <a href="question.do?curr=${currpage-1}&search=${search}&searchtxt=${searchtxt}"><<</a>
 </c:if>
</div>

<div class="page2">
<c:forEach var="index" begin="${startblock }" end="${endblock }">
  <c:if test="${currpage==index }">
     <c:out value="${index }"></c:out>
  </c:if>
  <c:if test="${currpage!=index }">
      <a href="question.do?curr=${index}&search=${search}&searchtxt=${searchtxt }">${index}</a> 
  </c:if>
</c:forEach>
</div>

<div class="page3">
<c:if test="${endblock<totalpage}">
  <a href="question.do?curr=${currpage+1 }&search=${search}&searchtxt=${searchtxt}">>></a>
</c:if>
</div>
</ul>

<jsp:include page="../includes/footer.jsp" />

</body>


</html>



