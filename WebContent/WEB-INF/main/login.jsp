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
    
    
<script>

	$().ready(function() {

		$("#modal_show").click(function() {
			$("#loginModal").modal("show");
		});


		/* $("#close_modal").click(function() {
			$("#exampleModals").modal("hide");
		});
		 */	
		
	
	//로그인 버튼 눌렀을 경우
		$("#btn").click(function() {
			
			var m_id = $('#id').val();
			var m_pwd = $('#m_pwd').val();
			
			if ($('#id').val() == 0 || $('#pwd').val() == 0) {
				alert("ID 또는 패스워드를 입력해주세요");
			} else {
				$.ajax({
					type : 'post'
					, url : '${pageContext.request.contextPath}/main/login.jsp' //http://localhost:8080/project_group3/login.do
					, data : {
						m_id : m_id,
						m_pwd : m_pwd,
						}
					, success : function(data) {
							console(data);
							
							location.href = '${pageContext.request.contextPath}/main/main.do';
					}
					, error : function(data) {
						console.log("로그인 실패");
						$('loginModal').modal('show');
					}
				});
			}
		});
	});
</script>	  


</head>

<jsp:include page="../includes/header.jsp" />


<body class="login-page sidebar-collapse">
<%
// 세션값 가져오기
String m_id = (String) session.getAttribute("m_id"); // Object 타입이므로 다운캐스팅

System.out.print("login.jsp  " + m_id);

%>  
  <!-- ??안타는듯..? -->
  <c:if test="${m_id !=null }">
  	location.href="main.do";
  </c:if>
  
  <!-- 로그인  -->
  <div class="page-header clear-filter" filter-color="orange">
    <div class="content">
      <div class="container">
        <div class="col-md-4 ml-auto mr-auto">
          <div class="card card-login card-plain">
            
            <form class="form" action="loginResult.do" method="post">
            
              <div class="card-header text-center">
                <div class="logo-container">
                </div>
              </div>
              <div class="card-body">
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="아이디" id="m_id" name="m_id">
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons text_caps-small"></i>
                    </span>
                  </div>
                  <input type="password" placeholder=비밀번호 class="form-control" id="m_pwd" name="m_pwd"/>
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

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" id="modal_show" >
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	아이디 또는 비밀번호를 잘못 입력하셨습니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">OK</button>
      </div>
    </div>
  </div>
</div>
    
    
</body>

<jsp:include page="../includes/footer.jsp" />


</html>