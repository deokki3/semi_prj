<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>MovieBooking/main.html</title>

<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/movieBooking/assets/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/movieBooking/assets/css/style.css">

<!-- 웹 폰트 -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">

</head>
<body>

<div>
	<jsp:include page="header.jsp"/>
</div>
	<!-- start of banner -->
	<section id="banner">
		<h2 class="ir_so">최신 영화 소식</h2>
		<div class="slider"></div>
		<img src="${pageContext.request.contextPath}/movieBooking/assets/img/main_slider01.jpg" alt="베스와 베라">
	</section>
	<!-- end of banner -->
	
	<script src="assets/js/jquery.min_1.12.4.js"></script>
	<script src="assets/js/modernizr-custom.js"></script>
	<script src="assets/js/ie-checker.js"></script>
</body>
</html>