<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#main_logo{
		width: 200px;
		height: 50px;
  		top: 16px;
  		left: 15px;
 		z-index: 2;}

	.clearfix{margin-bottom: 50px;}
	
	
</style>
</head>
<body>
<div id="whole">
	<div id="header">
		<h1><a href="${pageContext.request.contextPath}/home"><img id="main_logo" src="${pageContext.request.contextPath}/home/assets/logos/main_logo.png"></a></h1>
	</div>
	
	
	
		
		<nav class="navbar navbar-fixed-top">
   	      <ul class="clearfix">
   	         <li><a href="${cp }/home">홈</a></li>
   	          <li><a href="${cp }/user/join">회원가입</a></li> 
   	          <li><a href="${cp }/movieBooking/home">예매하기</a></li>
			  <c:choose> 
					<c:when test="${empty sessionScope.id_pk }">
									
								 	
						<li><a href="${cp }/user/login.jsp">로그인</a></li>
					</c:when>
					<c:otherwise> 	
						<li><a href="${cp }/user/logout.jsp?id_pk=${sessionScope.id_pk }">로그아웃</a></li>
						<li><a href="${cp }/mypage?id_pk=${sessionScope.id_pk }">마이페이지</a></li> 
					</c:otherwise>
			</c:choose>
   	      </ul>
   	      <a id="pull" href="#">Menu</a>
   	  </nav>
	
</div>	
</body>
</html>