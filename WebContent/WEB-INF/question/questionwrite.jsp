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

<!-- 세션값 가져오기 -->
<%
String m_id = (String) session.getAttribute("m_id");
%>


<br>
   <!-- 게시판 글쓰기 양식 영역 시작 -->
	<div class="container">
			<form method="post" action="questionwriteresult.do">
			
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
						<tr>
							<td><input type="text" class="form-control" placeholder="제목을 입력하세요" name="q_title" id="q_title" maxlength="50" ></td>
							<td><input type="text" name="m_id"  style="border:none; background:transparent; text-align:right; size=5 "  required readonly="readonly" value="<%=m_id%>">님</td>
							
						</tr>
				</table>
				
				<table class="table" style="text-align: center; border: 1px solid #dddddd">	
						<tr>
							<td><textarea class="form-control" placeholder="   내용을 입력하세요" name="q_content" id="q_content" maxlength="2048" rows="500" cols="500" style="max-height: 800px"></textarea></td>
						</tr>
				</table>
				
				
				<!-- 버튼 생성 -->
			<div class="row text-center" style="width: 100%">
				<div style="width: 100%; float:none; margin:0 auto" >
					<input type="button" class="btn btn-primary" onclick="location.href='question.do'" value="취소">
					<input type="submit" class="btn btn-primary" value="글쓰기">
					<input type="button" class="btn btn-primary" onclick="location.href='question.do'" value="목록">
				</div>
			</div>
				
			</form>
	</div>
	<!-- 게시판 글쓰기 양식 영역 끝 -->
     
 

<jsp:include page="../includes/footer.jsp" />

</body>


</html>



