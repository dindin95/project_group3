<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <!-- css  -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assets/css/now-ui-kit.css?v=1.3.0" rel="stylesheet" />

<jsp:include page="../includes/header.jsp" />

<style>
.phsize{
	height: 250px
}

.bt{
    margin : auto;
    padding: 20px 20px;
    border:  1px solid #f96332; 
    width: 550px;
}

.inbox{
    background-color: transparent;
    border: 1px solid #E3E3E3;
    border-radius: 30px;
    color: #2c2c2c;
    width: 360px;
	font-size: 20px;
	padding: 20px 20px;
   
}
.lebox{
	width: 140px;
	text-align: center;
	font-size: 20px;
	color: #ff6600;
	padding: 20px 20px;
}

</style>

<body class="profile-page sidebar-collapse">

<%
// 세션값 가져오기
String m_id = (String) session.getAttribute("m_id"); // Object 타입이므로 다운캐스팅

%>

<c:set var="dto" value="${requestScope.dto }"></c:set>


  <div class="wrapper">
  	<div class="phsize">
    <div class="page-header clear-filter page-header-small" filter-color="orange">
      <div class="page-header-image" data-parallax="true" style="background-image:url('../assets/img/bg5.jpg');">
      </div>
      <div class="container">
        <h3 class="title"><%=m_id %>님 회원정보</h3>
          </div>
        </div>
      </div>
      </div>
    </div>
    <div class="section">
        <div class="button-container">
        	<form action="myPageList.do" method="post">
	        	<div class="bt">
	
					<label for="m_name" class="lebox">이름</label> 
					
					<input class="inbox" readonly="readonly" type="text" name="m_name" value="<c:out value="${dto.m_name}"/>" />
	
					
					<br>
					
					<label for="m_id" class="lebox">아이디</label> 
					<input class="inbox" readonly="readonly" type="text" name="m_id" value="<c:out value="${dto.m_id}"/>" />
					
					<br>
					
					<label for="m_pwd" class="lebox">비밀번호</label> 
					<input class="inbox" readonly="readonly" type="text" name="m_pwd" value="<c:out value="${dto.m_pwd}"/>" />
	
					<br>
					
					<label for="m_phone" class="lebox">휴대폰번호</label> 
					<input class="inbox" readonly="readonly" type="text" name="m_phone" value="<c:out value="${dto.m_phone}"/>" />
					
					<br>
					
					<label for="m_date" class="lebox">가입일</label> 
					<input class="inbox" readonly="readonly" type="text" name="m_date" value="<c:out value="${dto.m_date}"/>" />
					
					<br>
	
					<a href="myPageModifyForm.do" class="btn btn-primary btn-round btn-lg" style="width: 100%"> 수정 </a>
		        </div>
	        </form>
        </div>
  </div>
</body>


</body>

<jsp:include page="../includes/footer.jsp" />

</html>