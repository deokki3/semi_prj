<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/*.movies_collection2{width:3000px; height:500px;}
	.movies2{width:180px; height:320px; float:left; margin-left:20px; background-color:#212529;}
	.movies_collection2 h2{background-color:#171721; color:gold; padding-left:20px;}
	img{width:200px; height:300px;}
	p{color:white;}
	*/
</style>
</head>
<body>
	<div id="whole">
		<div id="movies3" class="movies">
			<h2>범죄/스릴러물을 좋아하는 당신에게 추천!!</h2>
			<div class="collectionBox" id="collection3_box">
				<div class="movies_collection1" id="collection3">	
					<c:forEach var="vo" items="${requestScope.crimeThrillerMovieList }">
						<div id="movies_3" class="movie">
							<a href="movieDetail?num_pk=${vo.num_pk}&id_pk=${sessionScope.id_pk }">
								<img src="${cp }/home/assets/imgs/${vo.img_path }">
							</a>
							<p id="title">${vo.title }</p>
							<p><span id="star">★</span> ${vo.avgrate }<p>
						</div>
					</c:forEach>
				</div>
				
					<input type="button" value="<" id="leftButton3" class="leftbtn">
					<input type="button" value=">" id="rightButton3" class="rightbtn">
			</div>		
		</div>
	</div>
<script type="text/javascript">
	var btn1=document.getElementById("leftButton3");
	btn1.addEventListener('click',function(e){
		document.querySelector('#collection3').style.transform+="translate(+720px)"
	});
	
	var btn2=document.getElementById("rightButton3");
	btn2.addEventListener('click',function(e){
		document.querySelector('#collection3').style.transform+="translate(-720px)"
	});

</script>
</body>
</html>