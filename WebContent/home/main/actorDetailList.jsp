<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	
	#actorDetail p{color:white; }
	
	#actorDetailMovies img{width:180px; height:270px;}
	#actorDetailMovies h3{color:white; margin: 20px 0px 10px 0px;}
	#actorDetailMovies  p{width:180px; overflow:hidden; text-overflow: ellipsis; white-space: nowrap;}
	
	#actorDetailMovies .movie{width:180px; height:350px; margin-top:5px; margin-bottom:15px;}

	
</style>

	<div id="whole">
		<div id="actorDetail">
			
				<img src="${cp }/home/assets/actorimgs/${avo.img_path }">
				<p>${avo.name }</p>
		</div>
		<div id="actorDetailMovies">
			<h3>관련 작품</h3>
			<c:forEach var="vo" items="${requestScope.actorDetailList }">	
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
