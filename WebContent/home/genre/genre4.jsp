<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="genre">
		<div id="movies2" class="movies">	
			
			<div class="collectionBox" id="collection2_box">	
			
				<div class="amovieframem" id="framid">	
					<h3>로맨스</h3>
					<c:forEach var="vo" items="${requestScope.romanceMovie }">
						<div id="mcontentid" class="mcontent">
							<a href="movieDetail?num_pk=${vo.num_pk}">
								<img src="${cp }/home/assets/imgs/${vo.img_path }">
							</a>
							<p id="mtitle">${vo.title }</p>
							<p><span id="star">★</span> ${vo.avgrate }<p>
						</div>
					</c:forEach>
				</div>
					
				<div class="amovieframem" id="framid">	
					<h3>드라마</h3>
					<c:forEach var="vo" items="${requestScope.dramaMovie }">
						<div id="mcontentid" class="mcontent">
							<a href="movieDetail?num_pk=${vo.num_pk}">
								<img src="${cp }/home/assets/imgs/${vo.img_path }">
							</a>
							<p id="mtitle">${vo.title }</p>
							<p><span id="star">★</span> ${vo.avgrate }<p>
						</div>
					</c:forEach>
				</div>	
					
				<div class="amovieframem" id="framid">	
					<h3>SF</h3>
					<c:forEach var="vo" items="${requestScope.sfMoive }">
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