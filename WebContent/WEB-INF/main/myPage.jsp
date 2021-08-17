<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

 <!-- css  -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assets/css/now-ui-kit.css?v=1.3.0" rel="stylesheet" />

<jsp:include page="../includes/header.jsp" />

<style>
.phsize{
	height: 250px
}

.bt{
	margin-left: 350px;
}
 .bt2{
	margin-left: 20px;
	font-size: 1em;
    border-radius: 0.25rem;
    padding: 15px 48px;
    width: 300px
}
</style>

<body class="profile-page sidebar-collapse">

<%
// 세션값 가져오기
String m_id = (String) session.getAttribute("m_id"); // Object 타입이므로 다운캐스팅

%>

  <div class="wrapper">
  	<div class="phsize">
    <div class="page-header clear-filter page-header-small" filter-color="orange">
      <div class="page-header-image" data-parallax="true" style="background-image:url('../assets/img/bg5.jpg');">
      </div>
      <div class="container">
        <h3 class="title"><%=m_id %>님</h3>
          </div>
        </div>
      </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="button-container">
        	<div class="bt">
        		<div class="bt2">
		          <a href="myPageList.do" class="btn btn-primary btn-round btn-lg">   내정보 보기 </a>	<br>
		          <a href="#button" class="btn btn-primary btn-round btn-lg">  내정보 수정  </a>	<br>
		          <a href="#button" class="btn btn-primary btn-round btn-lg">   예약  현황   </a>		<br>
		          <a href="#button" class="btn btn-primary btn-round btn-lg">문의글 작성 내역</a>		<br>
		        </div>
		          <a href="#button" class="btn btn-primary btn-round btn-lg">    로그아웃    </a>		
		          <a href="#button" class="btn btn-primary btn-round btn-lg">    회원탈퇴    </a>
	        </div>
        </div>
    </div>
  </div>
</body>


</body>

<jsp:include page="../includes/footer.jsp" />

</html>