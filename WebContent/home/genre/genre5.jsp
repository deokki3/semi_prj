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
			
				<div class="amovieframe" id="framid">	
					<h3>2011's~2021's</h3>
					<c:forEach var="vo" items="${requestScope.threeMovieList }">
						<div id="mcontentidn" class="mcontentn">
							<a href="movieDetail?num_pk=${vo.num_pk}">
								<img src="${cp }/home/assets/imgs/${vo.img_path }">
							</a>
							<p id="mtitlen">${vo.title }</p>
							<p><span id="star">★</span> ${vo.avgrate }<p>
						</div>
					</c:forEach>
				</div>	
					
				<div class="amovieframem" id="framid">	
					<h3>2000's~2010's</h3>
					<c:forEach var="vo" items="${requestScope.twoMovieList }">
						<div id="mcontentidn" class="mcontentn">
							<a href="movieDetail?num_pk=${vo.num_pk}">
								<img src="${cp }/home/assets/imgs/${vo.img_path }">
							</a>
							<p id="mtitlen">${vo.title }</p>
							<p><span id="star">★</span> ${vo.avgrate }<p>
						</div>
					</c:forEach>
				</div>	
					
				<div class="amovieframem" id="framid">	
					<h3>1996's~2000's</h3>
					<c:forEach var="vo" items="${requestScope.oneMovieList }">
						<div id="mcontentidn" class="mcontentn">
							<a href="movieDetail?num_pk=${vo.num_pk}">
								<img src="${cp }/home/assets/imgs/${vo.img_path }">
							</a>
							<p id="mtitlen">${vo.title }</p>
							<p><span id="star">★</span> ${vo.avgrate }<p>
						</div>
					</c:forEach>
				</div>	
					
				</div>
			
			</div>
		</div>
	
</body>
</html>