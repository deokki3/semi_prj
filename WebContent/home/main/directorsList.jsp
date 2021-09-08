<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#alldirectors .director{margin-top:15px; height:260px;}
	
	#dUpdateA{float:right; margin-right:5px;}
	#dDeleteA{float:right; margin-right:5px;} 
	
	#alldirectors{height:800px;}
</style>
</head>
<body>
<div id="whole">
	<div id="alldirectors" class="directors">
		<c:forEach var="vo" items="${requestScope.directorsList }">
				
				<div class="director" id="director">
					<a href="${cp }/directorDetailList?num_pk=${vo.num_pk}">
						<img src="${cp }/home/assets/directorimgs/${vo.img_path }">
					</a>
					<p>${vo.name }</p>	
					<p>감독번호: ${vo.num_pk }<p>
					<a href="directorDelete?num_pk=${vo.num_pk }" id="dDeleteA">삭제</a>
					<a href="dUpdate?num_pk=${vo.num_pk }" id="dUpdateA">수정</a>  
					
				</div>
		</c:forEach>
	</div>
</div>	
</body>
</html>