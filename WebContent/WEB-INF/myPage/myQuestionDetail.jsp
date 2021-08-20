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
  
  <!-- =========댓글 테이블====================== -->
       		<!-- ======댓글 테이블 ================= -->
			<table class="table" style="height: 100px">
			<thead>
				<tr class="text-">댓글</tr>
				</thead>
				<tbody >
					<tr class="table table-bordered" id="replyList">
					

					</tr>
					
				</tbody>

					
					
			</table>
			
			<form method="post" action="answerAdd.do">
			<input type="hidden" name="qno" value="${dto.q_no }">
			<textarea class="form-control"  placeholder="댓글 입력하세요" name="answer" id="answerBox" maxlength="2048" rows="500" cols="500" style="max-height: 50px"> </textarea>
			<button class="btn btn-primary btn-round" type="submit">댓글등록</button>
		
		</form>
		</div>
  </div>
    
  
  
  
<!-- 버튼 생성 -->
			<div class="row text-center" style="width: 100%">
				<div style="width: 100%; float:none; margin:0 auto" >
					<input type="button" class="btn btn-primary" onclick="location.href='myQuestionDelete.do?q_no=<%=dto.getQ_no() %>'" value="삭제">
					<input type="submit" class="btn btn-primary" onclick="location.href='myQuestionModify.do?q_no=<%=dto.getQ_no() %>'" value="수정">
					<input type="button" class="btn btn-primary" onclick="location.href='myQuestion.do?m_id=<%=dto.getM_id() %>'" value="목록">
				</div>
			</div>
			
			<% } else{ %>
				<script>
					alert("사용자의 글이 아니므로 상세 볼 수 없습니다.");
					location.href = "myQuestion.do";
				</script>
			<%} %>
			
			
<script>
$(document).ready(function(){

	
	let q_qno =${dto.q_no};

	
	$.ajax({
		
	url:'answerView.data'
   ,method:'post'
   ,data:{'q_no':q_qno}
   ,dataType:'json'
   ,success : function(data){
	   console.log('성공');
	   
	   $.each(data,function(index,item){

   let result =" ";
   result +="<td>"+ item.a_content+"<br>";
   result +="<br><br><style='text-align: right, font-size: small'>"+ item.a_writeDate + "<br>작성자" + item.m_id;
   result+="<button class='btn btn-primary btn-sm' onclick=answerRemove("+item.a_no+ ","+item.q_no+")>삭제</button>";
   result+="</td>";
   
   
   $('#replyList').append(result);
   
	   
	   });
	
  
   },error:function(xhr){
	   console.log('실패');
	   console.log(xhr);
   }
	
	});
	
	
	
});


function answerRemove(a_no,q_no){
	 console.log(a_no);
	   console.log(q_no);
	  
	   location.href="answerRemove.do?a_no="+a_no+"&q_no="+q_no;
}

</script>			
<jsp:include page="../includes/footer.jsp" />

</body>


</html>



