<%@page import="com.g3.service.QuestionService"%>
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

<%
	QuestionDTO dto = (QuestionDTO) request.getAttribute("dto");
%>

<!-- 세션값 가져오기 -->
<%
	String m_id = (String) session.getAttribute("m_id");
%>

<%
	if(m_id.equals(dto.getM_id())) {%>

<br>
   <!-- 게시판 글쓰기 양식 영역 시작 -->
	<div class="container">
			<form method="post" action="myQuestionModifyResult.do">
			
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
						<tr>
							<td><input type="text" name="q_no"  style="border:none; background:transparent; text-align:right" size=2   required readonly="readonly" value="<%=dto.getQ_no() %>"></td>
							<td><input type="text" class="form-control" name="q_title" id="q_title" maxlength="50" value="<%=dto.getQ_title() %>" ></td>
							<td><input type="text" name="m_id"  style="border:none; background:transparent; text-align:right" size=2   required readonly="readonly" value="<%=dto.getM_id() %>">님</td>
						</tr>
				</table>
				
				<table class="table" style="text-align: center; border: 1px solid #dddddd">	
						<tr>
							<td><textarea class="form-control" name="q_content" id="q_content" maxlength="2048" rows="500" cols="500" style="max-height: 800px"><%=dto.getQ_content() %></textarea></td>
						</tr>
				</table>
		
				<!-- 버튼 생성 -->
			<div class="row text-center" style="width: 100%">
				<div style="width: 100%; float:none; margin:0 auto" >
					<input type="button" class="btn btn-primary" onclick="location.href='myQuestion.do?m_id=<%=dto.getM_id() %>'" value="취소">
					<input type="submit" class="btn btn-primary" value="등록">
					<input type="button" class="btn btn-primary" onclick="location.href='myQuestion.do?m_id=<%=dto.getM_id() %>'" value="목록">
				</div>
			</div>
				
			</form>
			
			<% } else{ %>
				<script>
					alert("사용자의 글이 아니므로 수정을 할 수 없습니다.");
					location.href = "myQuestion.do";
				</script>
			<%} %>
	</div>
	<!-- 게시판 글쓰기 양식 영역 끝 -->
<jsp:include page="../includes/footer.jsp" />

</body>
</html>



