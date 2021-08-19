<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JJBB Info</title>
<link href="assets/css/info.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<jsp:include page="../includes/header.jsp" />
	
	<!-- section --> <!-- https://www.w3schools.com/howto/howto_css_flip_card.asp --> <!-- https://getbootstrap.com/docs/4.0/components/card/ -->
	<div class="row">
		<div class="col-sm-6">
			<!-- 소개 -->
			<div class="card" style="background-color: #4E4C49">
				<div class="card-body">
					<div class="card-title">
						<!-- <h2>JJBB 스터디 룸</h2> -->
						<img alt="JJBB" src="assets/img/JJBB.png" style="height: 380px; width: 600px; margin-right: 50px">
					</div> 
					<div class="card-text">
						<p class="p_style">적절한 소음이 허용된 스터디 룸</p>
						<p class="p_style">회의에 적합한 스터디 룸</p>
						<p class="p_style">장시간 사용이 가능한 스터디 룸</p>
						<br>
						<p class="p_style2">스터디 룸 최대 6인 사용 가능</p>
						<p class="p_style2">음료, 간식 무료 제공</p>
						<p class="p_style2">휴대폰 충전기, 무릎 담요, 독서대 사용 가능</p>
						<p class="p_style2">오전 9시 ~ 오후 10시 예약 가능</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="card" style="background-color: #4E4C49">
				<!-- 요금 안내 -->
				<div class="card-body">
					<div class="card-title">
						<!-- <h2>요금 안내</h2> -->
						<img alt="JJBB" src="assets/img/cash.png" style="height: 380px; width: 600px; margin-right: 50px">
					</div> 
					<div class="card-text">
						<table class="table" style="margin-left: 40px; color: white">
							<thead style="background-color: #BC9A75">
								<tr>
									<th scope="col">시간</th>
									<th scope="col">요금</th>
									<th scope="col">음료</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>2시간</td>
									<td>2900원</td>
									<td>1잔 무료</td>
								</tr>
								<tr>
									<td>4시간</td>
									<td>4900원</td>
									<td>2잔 무료</td>
								</tr>
								<tr>
									<td>6시간</td>
									<td>6900원</td>
									<td>3잔 무료</td>
								</tr>
								<tr>
									<td>8시간</td>
									<td>8900원</td>
									<td>4잔 무료</td>
								</tr>
								<tr>
									<td>10시간</td>
									<td>10900원</td>
									<td>5잔 무료</td>
								</tr>
								<tr>
									<td>시간 연장</td>
									<td>1900원</td>
									<td>음료 제공 X</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="card text-center" style="background-color: #4E4C49">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" src="assets/img/bg1.png" alt="First slide" height="600px" width="800px">
					<div class="carousel-caption d-none d-md-block">
						<h2>Room A</h2>
						<h4>#탁_트인_공간&nbsp;&nbsp;&nbsp;&nbsp;#자유로운_분위기&nbsp;&nbsp;&nbsp;&nbsp;#미팅_가능한_큰_룸</h4>
					</div>
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="assets/img/bg2.png" alt="Second slide" height="600px" width="800px">
					<div class="carousel-caption d-none d-md-block">
						<h2>Room B</h2>
						<h4>#다양한_좌석_겸비&nbsp;&nbsp;&nbsp;&nbsp;#도서관을_느끼고_싶다면</h4>
					</div>
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="assets/img/main_img.png" alt="Third slide" height="600px" width="800px">
					<div class="carousel-caption d-none d-md-block">
						<h2>Room C</h2>
						<h4>#프라이빗한_분위기&nbsp;&nbsp;&nbsp;&nbsp;#적절한_공부_적절한_휴식</h4>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> 
			<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next"> 
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	
	<div class="card text-center">
	<!-- 이용 안내 -->
		<div class="card-body2">
			<div class="card-text2" style="background-color: #4E4C49">
				<img alt="이용 안내" src="assets/img/user_info.jpg" style="height: 400px; width: 80%">
			</div>
		</div>
	</div>
	
	<div class="card text-center" style="height: 200px">
		<!-- 코로나 관련 -->
		<div class="card-body2">
			<div class="card-text2">
				<!-- <br>
				<p>JJBB 스터디 룸은 코로나 방역을 위해 매일 두 번 소독을 진행하고 있습니다.</p>
				<p>고객 여러분께서도 마스크 착용과 입실 전 손 소독 당부드립니다.</p>
				<p>이를 지키지 않을 경우 과태료가 부가될 수 있음을 알려드립니다.</p> -->
				<img alt="코로나" src="assets/img/covid.png" style="height: 200px" width="100%">
			</div>
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
	
	<script>
		var slideIndex = 1;
		showDivs(slideIndex);
		
		function plusDivs(n) {
		  showDivs(slideIndex += n);
		}
		
		function showDivs(n) {
		  var i;
		  var x = document.getElementsByClassName("mySlides");
		  if (n > x.length) {slideIndex = 1}    
		  if (n < 1) {slideIndex = x.length} ;
		  for (i = 0; i < x.length; i++) {
		     x[i].style.display = "none";  
		  }
		  x[slideIndex-1].style.display = "block";  
		}
	</script>
</body>
</html>