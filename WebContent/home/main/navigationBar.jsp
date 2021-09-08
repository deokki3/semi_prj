<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  	   <title>Responsive Navigation Demo</title>
   	   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   	   <link rel="stylesheet" href="style.css">
   	   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
   	   <script>
   	      $(function(){
   	      	var pull=$('#pull');
   	      	    menu=$('nav ul');
   	      	    menuHeight=menu.height();   	      
   	      $(pull).on('click', function(e){
   	      	e.preventDefault();
   	      	menu.slideToggle();   	      	
   	      });
   	      $(window).resize(function(){
   	      	var w=$(window).width();
   	      	if(w>600 && menu.is(':hidden'))
   	      		{menu.removeAttr('style');}
   	      });
   	  });
   	   </script>
 
   </head>
   <style>/* clearfix */
.clearfix:before, 
.clearfix:after{
	content:"";
	 display: table;
}
.clearfix:after{
	clear:both;
}
.clearfix{
	*zoom:1;
}

/* Basic Styles */

nav{
	height: 40px;
	width: 100%;
	background: #455868;
	font-size: 11pt;
	font-family: 'PT Sans', Arial, Sans-serif;
	font-weight: bold;
	position: relative;
	border-bottom: 2px solid #283744;
}
nav ul{
	padding: 0;
	margin: 0 auto;
	width: 600px;
	height: 40px;
}
nav li{
	display: inline;
	float: left;
}
nav a{
	color: #fff;
	display: inline-block;
	width: 100px;
	text-align: center;
	text-decoration: none;
	line-height: 40px;
	text-shadow: 1px 1px 0px #283744;
}
nav li a{
	border-right: 1px solid #576979;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
}
nav li:last-child a{
	border-right: 0;
    }
nav a:hover, nav a:active{
	background-color: #8c99a4;
}
nav a#pull{
	display: none;
}

/*Styles for screen 600px and lower*/
@media only screen and (max-width : 1000px) {
	nav {
		border-bottom: 0;
		height: auto;
	}
	nav ul {
		display: none;
		height: auto;
	}
	nav a {
	  	text-align: left;
	  	width: 100%;
	  	text-indent: 25px;
  	}
	nav a#pull {
		display: block;
		background-color: #283744;
		width: 100%;
		position: relative;
	}
	nav a#pull:after {
		content:"";
		background: url('nav-icon.png') no-repeat;
		width: 30px;
		height: 30px;
		display: inline-block;
		position: absolute;
		right: 15px;
		top: 10px;
	}
	nav li {
		display: block;
		float: none;
		width: 100%;
	}
	nav li a {
		border-bottom: 1px solid #576979;
	}
}



   </style>
   <body>
   
   <header>
   <!--
   	   <nav class="navbar navbar-fixed-top">
   	      <ul class="clearfix">
   	         <li><a href="${cp }/home">홈</a></li>
   	          <li><a href="${cp }/user/join">회원가입</a></li> 
   	          <li><a href="${cp }/movieBooking/home">예매하기</a></li>
			  <c:choose> 
					<c:when test="${empty sessionScope.id_pk }">
									
								 	
						<li><a href="${cp }/user/login.jsp">로그인</a></li>
					</c:when>
					<c:otherwise> 	
						<li><a href="${cp }/user/logout.jsp?id_pk=${sessionScope.id_pk }">로그아웃</a></li>
						<li><a href="${cp }/mypage?id_pk=${sessionScope.id_pk }">마이페이지</a></li> 
					</c:otherwise>
			</c:choose>
   	      </ul>
   	      <a id="pull" href="#">Menu</a>
   	  </nav>
   	   -->
   	</header>
   </body>
</html>