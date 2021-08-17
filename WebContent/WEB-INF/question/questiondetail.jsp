<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<jsp:include page="../includes/header.jsp" />

<c:set var="dto" value="${requestScope.dto }"></c:set>
   
   <br>
     <!-- 게시물 내용 출력  -->
     <div class="container my-1">
     	<div class="row">
     		<table class="table">
     			
     				<tr class="table-active">
     					<th scope="col" style="width:60%" ><c:out value="${dto.q_title }"></c:out></th>
     					<td scope="col" style="width:10%" ><c:out value="${dto.m_id }"></c:out></td>
     					<td scope="col" style="width:30%" ><c:out value="${dto.q_writedate }"></c:out></td>	
     				</tr>
     				
     		</table>
     		
     		<table class="table" style="height:500px">
     			<tr class="table table-bordered">
     				<td><c:out value="${dto.q_content }"></c:out></td>
     			</tr>
     		</table>
     </div>
  </div>
  
<div class="row text-center" style="width: 100%">
  	 <div style="width: 100%; float:none; margin:0 auto" >
		<button type="button" class="btn btn-secondary" style="width: 10%">삭제</button>
		<button type="button" class="btn btn-secondary" style="width: 10%">수정</button>
		<button type="button" class="btn btn-secondary" style="width: 10%" onclick="location.href='question.do'">목록</button>
	</div>
</div>

<jsp:include page="../includes/footer.jsp" />

</body>


</html>



