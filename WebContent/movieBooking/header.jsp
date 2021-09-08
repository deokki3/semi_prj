<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/movieBooking/assets/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/movieBooking/assets/css/style.css">

<!-- start of header -->
<header id="header">
	<div class="container">
		<div class="row">
			<div class="header clearfix">
				<h1>
					<a href="${pageContext.request.contextPath}/movieBooking/index.jsp">
						<em><img
							src="${pageContext.request.contextPath}/movieBooking/assets/img/logo.png"
							alt="MEGABOX"></em> <strong><img
							src="${pageContext.request.contextPath}/movieBooking/assets/img/logo-sub.png"
							alt="LIFE THEATHER"></strong>
					</a>
				</h1>
				<nav class="nav">
					<ul class="clearfix">
						<li><a
							href="${pageContext.request.contextPath}/movieBooking/movieList">영화</a></li>
						<c:choose>
							<c:when test="${id == 'admin' }">
								<li><a href="${pageContext.request.contextPath}/admin/logout">로그아웃</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/movieBooking/admin/login/adminlogin.jsp">로그인</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</header>