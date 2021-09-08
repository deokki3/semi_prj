<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>event3</title>
<style>
	*{margin:0px; padding:0px;}
	
	body{background: #171721;}
	
	#header{width:800px; height:85px; margin-right:0px; }
	#header a{color:white; text-decoration:none; text-align: center;}
	#whole{width:800px; margin: 0 auto ; margin: auto;}
	.event{width: 980px; height: 3671px; margin-top: 10px;}
	img{width: 800px; height: 3000px;}
	.line{width: 800px; background-color: white; margin-top: 10px; margin-bottom: 10px;}
</style>	
</head>
<body>
<div id="whole">
	<div id="header">
		<h1><a href="event1.jsp">EVENT</a></h1>
	</div>
	<div id="eventtop" class="eventframe">
		<div class="commingup">	
			<h2>이벤트3</h2>
			<hr class="line">
		</div>	
			<div id="eventlist" class="event">
				<img src="${pageContext.request.contextPath }/home/assets/imgs/bannerimg_event3.jpg">
			</div>
	</div>		
</div>
</body>
</html>