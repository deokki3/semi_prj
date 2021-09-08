<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#whole1{width:800px; height: 500px; margin:0 auto;}
	
	#movies_1 img{width: 100px; height: 260px;}
	#movies_1{width: 100px; height: 260px; padding-bottom: 20px;}
	#img{width: 100px; height: 200px;}
	
	#contentTitle{color: white; margin-top: 20px; margin-bottom: 5px;}
	
	#aa{width: 800px; height: 450px;}
</style>
</head>
<body>
<div id="whole1">
	<div id="contentTitle">
			<h3>이런 영화는 어때요?</h3>
		</div>		
		<div id="aa">
			<div id="bb">
				<c:forEach var="vo" items="${requestScope.suggestMovie }">
					<div id="movies_4" class="movie">
						<a href="movieDetail?num_pk=${vo.num_pk}&id_pk=${sessionScope.id_pk }">
							<img src="${cp }/home/assets/imgs/${vo.img_path }">
						</a>
						<p>${vo.title }</p>
					</div>
				</c:forEach>
			</div>
		</div>
</div>

</body>
</html>