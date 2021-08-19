<%@page import="com.g3.dto.QuestionDTO"%>
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
   
   <%
   	QuestionDTO dto = (QuestionDTO)request.getAttribute("dto");
   %>
   
   <%
   		String m_id = (String) session.getAttribute("m_id");
   %>
   
   <%
		if(m_id.equals(dto.getM_id())) {%>
   
   <br>
     <!-- 게시물 내용 출력  -->
     <div class="container my-1">
     	<div class="row">
     		<table class="table">
     			
     				<tr class="table-active">
     					<th scope="col" style="width:60%" ><%=dto.getQ_title() %></th>
     					<td scope="col" style="width:10%" ><%=dto.getM_id() %></td>
     					<td scope="col" style="width:30%" ><%=dto.getQ_writedate() %></td>	
     				</tr>
     				
     		</table>
     		
     		<table class="table" style="height:500px">
     			<tr class="table table-bordered">
     				<td><c:out value="${dto.q_content }"></c:out></td>
     			</tr>
     		</table>
     </div>
  </div>
  
<!-- 버튼 생성 -->
			<div class="row text-center" style="width: 100%">
				<div style="width: 100%; float:none; margin:0 auto" >
					<input type="button" class="btn btn-primary" onclick="location.href='questiondelete.do?q_no=<%=dto.getQ_no() %>'" value="삭제">
					<input type="submit" class="btn btn-primary" onclick="location.href='questionmodify.do?q_no=<%=dto.getQ_no() %>'" value="수정">
					<input type="button" class="btn btn-primary" onclick="location.href='question.do'" value="목록">
				</div>
			</div>
			
			<% } else{ %>
				<script>
					alert("사용자의 글이 아니므로 상세 볼 수 없습니다.");
					location.href = "question.do";
				</script>
			<%} %>
			
<jsp:include page="../includes/footer.jsp" />

</body>


</html>



