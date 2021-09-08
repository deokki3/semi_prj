<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	#whole2{width:800px; height: 500px; margin:0 auto;}
	.button{width: 218px; background-color: #424242; border: none; padding: 15px 0; text-align: center; text-decoration: none; display: inline-block; 
			font-size: 15px; margin: 4px; cursor: pointer; color:#fff; border-radius:10px 10px 10px 10px; margin-top: 5px; margin-left: 5px; margin-right: 10px;
			font-family: inherit;}

</style>
</head>
<body>
<div id="whole2">
	<div id="contentTitle">
			<div id="genre">
				<h3>장르별 카테고리</h3>
			</div>
			<div id="btn">
				<a href="${pageContext.request.contextPath}/actionsCategory">
				<button class="button">액션</button>
				</a>
				
				<a href="${pageContext.request.contextPath}/crimeThrillerCategory">
				<button class="button">범죄&스릴러</button>
				</a>
				
				<a href="${pageContext.request.contextPath}/otherMovieCategory">
				<button class="button">기타</button>
				</a>
				
				<a href="${pageContext.request.contextPath}/nationalsCategory">
				<button class="button">국가별</button>
				</a>
				
				<a href="${pageContext.request.contextPath}/yearCategory">
				<button class="button">연도별</button>
				</a>
				
			</div>
		</div>
</div>
</body>
</html>