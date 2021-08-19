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
	margin-left: 300px;
    padding: 15px 20px;
    border:  1px solid #f96332; 
    width: 550px;
}
 .bt2{
	font-size: 1em;
    border-radius: 0.25rem;
    padding: 15px 20px;
    width: 500px;
}
</style>

<script type="text/javascript">

function memberDelete(){

    if(confirm("정말 탈퇴하시겠습니까?")){

        location.href = "memberDelete.do";
        return true;

    } else {

        return false;

    }

}

</script>

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
		          <a href="myPageList.do" class="btn btn-primary btn-round btn-lg" style="width: 100%">   내정보 보기 </a>	<br>
		          <a href="myPageModifyForm.do" class="btn btn-primary btn-round btn-lg" style="width: 100%">  내정보 수정  </a>	<br>
		          <a href="myBookingList.do" class="btn btn-primary btn-round btn-lg" style="width: 100%">   예약  현황   </a>		<br>
		          <a href="myQuestion.do" class="btn btn-primary btn-round btn-lg" style="width: 100%">문의글 작성 내역</a>		<br>
		        </div>
		          <a href="logout.do" class="btn btn-primary btn-round btn-lg" style="width: 250px">    로그아웃    </a>		
		          <a href="#" onclick="memberDelete();"class="btn btn-primary btn-round btn-lg" style="width: 250px">    회원탈퇴    </a>
	        </div>
        </div>
    </div>
  </div>
</body>


</body>

<jsp:include page="../includes/footer.jsp" />

</html>