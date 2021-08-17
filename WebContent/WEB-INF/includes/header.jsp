<!--

=========================================================
* Now UI Kit - v1.3.0
=========================================================

* Product Page: https://www.creative-tim.com/product/now-ui-kit
* Copyright 2019 Creative Tim (http://www.creative-tim.com)
* Licensed under MIT (https://github.com/creativetimofficial/now-ui-kit/blob/master/LICENSE.md)

* Designed by www.invisionapp.com Coded by www.creative-tim.com

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>JJBB Study Room</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<!-- CSS Files -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/now-ui-kit.css?v=1.3.0" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="assets/demo/demo.css" rel="stylesheet" />
</head>

<style>
	/* .navbar .navbar-brand{
	      text-transform: lowercase;
	        font-size: $font-size-small;
	        padding-top: $padding-base-vertical;
	        padding-bottom: $padding-base-vertical;
	        line-height: $line-height-nav-link;
	} */
	.navbar .navbar-nav .nav-linkid:not (.btn ) {
		text-transform: lowercase;
		font-size: 0.7142em;
		padding: 0.5rem 0.7rem;
		line-height: 1.625rem;
	}
</style>


<body class="landing-page sidebar-collapse">

<%
	// 세션값 가져오기
	String m_id = (String) session.getAttribute("m_id"); // Object 타입이므로 다운캐스팅
%>


	<!-- Navbar -->
	<nav
		class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent "
		color-on-scroll="400">
		<div class="container">
			<div class="dropdown button-dropdown">
				<a href="#pablo" class="dropdown-toggle" id="navbarDropdown" data-toggle="dropdown">
					<span class="button-bar"></span> 
					<span class="button-bar"></span>
					<span class="button-bar"></span>
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" style="font-size: 15px" href="info.do">소개</a>
					<a class="dropdown-item" style="font-size: 15px" href="#">룸 예약 현황</a> 
					<a class="dropdown-item" style="font-size: 15px" href="booking.do">룸 예약</a> 
					<a class="dropdown-item" style="font-size: 15px" href="#">QnA</a>
				</div>
			</div>
			<div class="navbar-translate">
				<a class="navbar-brand" style="font-size: 20px" href="main.do">JJBB Study Room</a>
				<button class="navbar-toggler navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-bar top-bar"></span> 
					<span class="navbar-toggler-bar middle-bar"></span> 
					<span class="navbar-toggler-bar bottom-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse justify-content-end" id="navigation" data-nav-image="assets/img/blurred-image-1.jpg">
				<ul class="navbar-nav">
					<div id="wrap">
						<c:if test="${sessionScope.m_id==null }">
							<li class="nav-item"><a class="nav-link" style="font-size: 20px" href="login.do">LOGIN</a></li>
							<li class="nav-item"><a class="nav-link" style="font-size: 20px" href="#">SIGN UP</a></li>
						</c:if>
						<c:if test="${sessionScope.m_id != null }">
							<li class="nav-item"><a class="nav-linkid" style="font-size: 20px" href="myPage.do"><%=m_id%>님</a></li>
							<li class="nav-item"><a class="nav-link" style="font-size: 20px" href="logout.do">LOGOUT</a></li>
						</c:if>
					</div>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<div class="wrapper">
		<div class="page-header page-header-small">
			<div class="page-header-image" data-parallax="true" style="background-image: url('assets/img/main_img.PNG');"></div>
			<div class="content-center"></div>
		</div>
	</div>