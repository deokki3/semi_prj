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
		<div id="movies2" class="movies">	
			<h2>뜨거운 여름엔 시원한 액션영화 한편!!</h2>
			<div class="collectionBox" id="collection2_box">	
			
				<div class="movies_collection1" id="collection2">	
					
					<c:forEach var="vo" items="${requestScope.actionMovieList }">
						<div id="movies_2" class="movie">
							<a href="movieDetail?num_pk=${vo.num_pk}&id_pk=${sessionScope.id_pk }">
								<img src="${cp }/home/assets/imgs/${vo.img_path }">
							</a>
							<p id="title">${vo.title }</p>
							<p><span id="star">★</span> ${vo.avgrate }<p>
						</div>
					</c:forEach>
				</div>
					
					<input type="button" value="<" id="leftButton2" class="leftbtn">
					<input type="button" value=">" id="rightButton2" class="rightbtn">
			
			</div>
		</div>
	</div>
<script type="text/javascript">
	var btn1=document.getElementById("leftButton2");
	btn1.addEventListener('click',function(e){
		document.querySelector('#collection2').style.transform+="translate(+720px)"
	});
	
	var btn2=document.getElementById("rightButton2");
	btn2.addEventListener('click',function(e){
		document.querySelector('#collection2').style.transform+="translate(-720px)"
	});

</script>	
</body>
</html>