<%@page import="com.g3.comm.Forward"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />

 
 <!-- css  -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assets/css/now-ui-kit.css?v=1.3.0" rel="stylesheet" />
  <!-- modal 사용시 필요 -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    
</head>

<jsp:include page="../includes/header.jsp" />


<body class="login-page sidebar-collapse">
<%
// 세션값 가져오기
String m_id = (String) session.getAttribute("m_id"); // Object 타입이므로 다운캐스팅

String Msg = (String) session.getAttribute("Msg"); // Object 타입이므로 다운캐스팅

if(Msg == null){
	Msg = "";
}

%>  


  <!-- 로그인  -->
  <div class="page-header clear-filter" filter-color="orange">
    <div class="content">
      <div class="container">
        <div class="col-md-4 ml-auto mr-auto">
          <div class="card card-login card-plain">
            
            <form class="form" action="loginResult.do" method="post" name="frm">
            
              <div class="card-header text-center">
                <div class="logo-container">
                </div>
              </div>
              <div class="card-body">
                  <div id="errMsg" style="width: 100%"> <%=Msg %> </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="아이디" id="m_id" name="m_id" required="required">
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons text_caps-small"></i>
                    </span>
                  </div>
                  <input type="password" placeholder=비밀번호 class="form-control" id="m_pwd" name="m_pwd" required="required"/>
                </div>
              </div>
              
              <div class="card-footer text-center">
                <input type="submit" value="로그인"  href="#pablo" class="btn btn-primary btn-round btn-lg btn-block" id="btn"> 
                
                <div class="pull-right">
                  <h6>
                    <a href="#pablo" class="link">아직 회원이 아니신가요? "회원가입창 연결 "</a>	<br>
                  </h6>
                </div>
                <div class="pull-right">
                  <h6>
                    <a href="#pablo" class="link">아이디 ㅣ 비밀번호찾기 링트 연결!!</a>	<br>
                  </h6>
                </div>
                </div>

            </form>
            </div>
          </div>
        </div>
      </div>
    </div>

</body>



<jsp:include page="../includes/footer.jsp" />


</html>