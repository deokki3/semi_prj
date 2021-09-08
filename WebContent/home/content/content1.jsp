<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<div id="whole">
		
	<!-- (중간)컨텐츠 부분 영화 컬렉션 -->
	<div id="movies1" class="movies">
	
		<!-- 11111 첫번째 상영영화 컬렉션 -->
		<div class="collectionBox" id="collection1_box">
			<h2>최근 개봉 영화!!</h2>
			<div class="movies_collection1" id="collection1">	
				
				<c:forEach var="vo" items="${requestScope.latestMovieList }">
					
					<div id="movies_1" class="movie">
					
						<a href="movieDetail?num_pk=${vo.num_pk }&id_pk=${sessionScope.id_pk }">
							<img src="${cp }/home/assets/imgs/${vo.img_path }">
						</a>
					<!-- 제목 -->
					<p id="title">${vo.title }</p>
					<p><span id="star">★</span> ${vo.avgrate }<p>
					
					</div>
				</c:forEach>
			</div>
			<div id="lbtn">
				
					<input type="button" value="<" id="leftButton1" class="leftbtn">
			</div>
			
			
			<div id="rbtn">
				<input type="button" value=">" id="rightButton1" class="rightbtn">
			</div>
		</div>
		
	</div>
</div>
<script type="text/javascript">
var btn1=document.getElementById("leftButton1");
btn1.addEventListener('click',function(e){
	document.querySelector('#collection1').style.transform+="translateX(+720px)"
	
});

var btn2=document.getElementById("rightButton1");
btn2.addEventListener('click',function(e){
	document.querySelector('#collection1').style.transform+="translateX(-720px)"
	
});

</script>
</body>
</html>
