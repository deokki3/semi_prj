<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  
<style type="text/css">

	.genre1{width: 800px; height: 900px; margin: auto; 0;}
	.movieframe{width: 800px; height: 1700px; margin: auto;}
	
	.mcontent{width:180px; height:375px; float:left; margin-right:20px;
	background-color:#212529; border-radius:10px;}
	
	.mcontent img{width: 180px; height: 290px; border-radius:10px;}
	.mcontent p{color:#F6F6F6; margin-left:10px; font-size:15px;}
	
	#mtitle{width:180px; overflow:hidden; text-overflow: ellipsis; 
			white-space: nowrap; margin-top:5px;}
	
	
	
	
	
</style>
-->
</head>
<body>

<div class="genre">
		<div id="movies2" class="moviest">	
			
			<div class="collectionBox" id="collection2_box">	
			
				<div class="kmovieframe" id="framid">	
					<h3>액션</h3>
					<c:forEach var="vo" items="${requestScope.actionsCategory }">
						<div id="mcontentid" class="mcontent">
							<a href="movieDetail?num_pk=${vo.num_pk}">
								<img src="${cp }/home/assets/imgs/${vo.img_path }">
							</a>
							<p id="mtitle">${vo.title }</p>
							<p><span id="star">★</span> ${vo.avgrate }<p>
						</div>
					</c:forEach>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>










