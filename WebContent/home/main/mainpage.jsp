<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.liInsert a{margin-right:10px;}
	
   
	#search input#searchBox{width: 200px; height: 30px; border-radius: 10px; 
                 			outline: none; font-size: 13px; margin-top: 5px;}
	
	#logo{
		width: 200px;
		height: 50px;
  		top: 16px;
  		left: 15px;
 		z-index: 2;
	}
	
</style>
</head>
<body>
<div id="whole">
	<div id="header">
		<h1><a href="${pageContext.request.contextPath}/home"><img id="logo" src="${cp }/home/assets/imgs/LOGO.PNG"></a></h1>
		
		<div id="search">
		<a href="${pageContext.request.contextPath}/test">
			<input type="search" id="searchBox" placeholder=" 배우,감독,제목을 검색하세요">
		</a>
	</div>		
	
		<!-- test -->
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
	  <!-- /test -->	
		
		
	
		<ul>
		<c:if test="${sessionScope.id_pk =='admin' }">
			<li class="liInsert">
				<a href="${cp }/mInsert">영화 추가</a>
				<a href="${cp }/mList">영화 목록</a>
				<a href="${cp }/aInsert">배우,감독 추가</a>
				<a href="${cp }/aList">배우 목록</a>
				<a href="${cp }/directorsList">감독 목록</a>
			</li>
		</c:if>
		</ul>
	<div id="search">
		<a href="${pageContext.request.contextPath}/test">
			<input type="search" id="searchBox" placeholder=" 배우,감독,제목을 검색하세요">
		</a>
	</div>		
	</div>
</div>
</body>
</html>