<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	#directorDetail p{color:white; }
	
	#directorDetailMovies img{width:180px; height:270px;}
	#directorDetailMovies h3{color:white; margin: 20px 0px 10px 0px;}
	#directorDetailMovies p{width:180px; overflow:hidden; text-overflow: ellipsis; white-space: nowrap;}
	#directorDetailMovies .movie{width:180px; height:350px; margin-top:5px; margin-bottom:15px;}

</style>

<div id="whole">
		<div id="directorDetail">
			
				<img src="${cp }/home/assets/directorimgs/${dvo.img_path }">
				<p>${dvo.name }</p>
		</div>
		<div id="directorDetailMovies">
			<h3>관련 작품</h3>
			<c:forEach var="vo" items="${requestScope.directorDetailList }">	
				<div class="movie">
					<a href="movieDetail?num_pk=${vo.num_pk}">
						<img src="${cp }/home/assets/imgs/${vo.img_path }">
					</a>
					<p>${vo.title }</p>
					<p><span id="star">★</span> ${vo.avgrate }<p>
				</div>
			</c:forEach>	
		</div>
	</div>
