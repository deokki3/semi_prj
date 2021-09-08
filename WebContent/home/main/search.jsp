<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	*{margin:0px; padding:0px;}
	
	body{background: #171721;}
	#whole{width:800px; height: 100px; margin:0 auto;}
	
	#header{width:800px; height:100px; margin-right:0px; }
	#header a{color:white; text-decoration:none;}
	
	#searchFrame{width: 800px; height: 50px; margin-top: 20px; margin-bottom: 20px;}
	
	
	#search input#searchBox{width: 700px; height: 50px; border-radius: 10px; outline: none;}
	#searchBox{width: 800px; height: 50px;}
	#contentTitle{color: white; margin-top: 20px; margin-bottom: 5px;}
	
	#btn{width: 750px; height: 90px;}
	.btn1{width: 217px; height: 40px; color: black; margin-bottom: 5px;}
	
	#resultBox{width: 700px; height: 600px; margin-left: 20px; margin-bottom: 5px;}
	#resultInner{width: 700px; height: 280;margin-bottom: 5px;}
	#resultSection{width: 340px; height: 100px; margin-left: 20px; margin-bottom: 20px;}
	#ul{margin-top: 20px; margin-right: 20px;}
	#content p{color:white; float: left; margin-right:10px; margin:10px 5px 0px 0px;}
	
	#content img{width:60px; height:92px; border-radius:5px;}
	#content{width:300px; height:90x; float: left;  margin-left:13px;
	 background-color:#212529; border-radius:5px;}
	 
	 #innerimg{width: 60px; height: 90px; float: left; position: re;}
	 #innertitle{width: 230px; height: 90px; float: right;}
	 
	 #h3{color: white;}
	 #h4{color: white; margin-top: 5px; margin-left: 70px;}
	 #minnertitle p{font-size: 13px; margin-left: 10px;}
	 
</style>
</head>
<body>
<div id="whole">
	<div id="header">
		<div id="searchFrame">	
			<div id="search">
				<form action="${pageContext.request.contextPath}/search.do" method="post">
				<input type="search" id="searchBox" name="keyword" placeholder=" 배우,감독,제목을 검색하세요" value="${keyword }">				
				</form>
			</div>
			
			<!-- 검색결과창 -->
			<div id="resultBox">
				<div id="resultInner">
					<h3 id="h3">영화정보</h3>
					<c:forEach var="vo" items="${requestScope.mslist }">					
						<div id="resultSection">
							<div id="content">
								<div id="innerimg">
								<a href="${cp }/movieDetail?num_pk=${vo.num_pk}">	
									<img src="${cp}/home/assets/imgs/${vo.img_path }">	
								</a>
								</div>	
								<div id="minnertitle">
									<h4 id="h4">${vo.title }</h4>
									<p>${vo.genre },${vo.country }</p>
									
									
								</div>	
							</div>
						</div>
					</c:forEach>
					
					<h3 id="h3">배우정보</h3>
					<c:forEach var="vo" items="${requestScope.aslist }">
						<div id="resultSection">
						<div id="content">
						<div id="innerimg">
						<a href="${cp }/actorDetailList?num_pk=${vo.num_pk}">
							<img src="${cp}/home/assets/actorimgs/${vo.img_path }">
						</a>
						</div>	
						<div id="innertitle">
							<p>${vo.name }</p>
						</div>
						</div>
						</div>
					</c:forEach>
					
					<h3 id="h3">감독정보</h3>
					<c:forEach var="vo" items="${requestScope.dslist }">
						<div id="resultSection">
						<div id="content">
						<div id="innerimg">
						<a href="${cp }/directorDetailList?num_pk=${vo.num_pk}">
							<img src="${cp}/home/assets/directorimgs/${vo.img_path }">
						</a>
						</div>
						<div id="innertitle">	
							<p>${vo.name }</p>
							</div>
						
						</div>
						</div>
					</c:forEach>
					
					
			
				</div>
			</div>
		
	</div>
</div>
</div>	


</body>
</html>























