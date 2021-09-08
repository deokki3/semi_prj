<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>event1</title>
<style>
	*{margin:0px; padding:0px;}
	
	body{background: #171721;}
	
	#header{width:800px; height:100px; margin-right:0px; }
	#header a{color:white; text-decoration:none; text-align: center;}
	.innerhead{width: 800px; height: 56px;}
	
	#whole{width:800px; margin: 0 auto ; margin: auto;}
	.eventtop{width: 800px; height: 450px; background-color:#212529;}
	.commingup{width:800px; height:350px;}
	.commingup h2{width: 800px; height: 40px; background-color:#171721; color:white; padding-left:20px; text-align: left;}
	.event{margin-top: 10px;}
	img{width: 800px; height: 350px;}
	p{text-align: center;}
	.line{width: 800px; background-color: white; margin-top: 10px; margin-bottom: 10px;}


</style>
</head>
<body>
<div id="whole">
	<div id="header">
		<div id="innerheader">
			<h1><a href="${pageContext.request.contextPath}/home">HOME</a></h1>
		</div>
	</div>
	<div id="eventtop" class="eventframe">
		<div class="commingup">	
			<h2>진행중인 이벤트</h2>
			<hr class="line">
			<div id="eventlist" class="event">
				<a href="http://www.cgv.co.kr/culture-event/popcorn-store/">
					<img src="${pageContext.request.contextPath }/home/assets/imgs/bannerimg1.jpg">
				</a>
			</div>
			<div id="eventlist" class="event">
			<hr class="line">
				<a href="${pageContext.request.contextPath }/home/banner/event2.jsp">
					<img src="${pageContext.request.contextPath }/home/assets/imgs/bannerimg2.jpg">
				</a>
			</div>
			<div id="eventlist" class="event">
			<hr class="line">
				<a href="${pageContext.request.contextPath }/home/banner/event3.jsp">
					<img src="${pageContext.request.contextPath }/home/assets/imgs/bannerimg3.jpg">
				</a>
			</div>
		</div>
	</div>
</div>	
</body>
</html>