<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#actorDetailUpdate p{color:#F6F6F6}
	#actorDetailUpdate h3{color:#F6F6F6}
	
	#crew h3{color:#F6F6F6; margin: 10px 0px 10px 0px;}
</style>

<div id="whole">
	
	<div id="actorDetailUpdate">
		<form action="${cp }/aUpdate" method="post">
			<p>배우 번호<input type="text" name="num_pk" value="${requestScope.vo.num_pk }" readonly="readonly"></p>
			<img src="${cp }/actorimgs/${requestScope.vo.img_path }">
			<p>배우 이미지 경로<input type="text" name="img_path" value="${requestScope.vo.img_path }"></p>
			<p>배우 이름<input type="text" name="name" value="${requestScope.vo.name }"></p>
			<input type="submit" value="수정하기">
		</form>
	</div>
				
		<div id="crew">
			<h3>관련 작품</h3>
			<c:forEach var="vo" items="${requestScope.actorDetailList }">	
				<div class="movie">
					<a href="movieDetail?num_pk=${vo.num_pk}">
						<img src="${cp }/imgs/${vo.img_path }">
					</a>
					<p>${vo.title }</p>
					<p><span id="star">★</span> ${vo.avgrate }<p>
				</div>
			</c:forEach>	
		</div>
		
</div>