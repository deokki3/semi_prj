<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bannerInsert.jsp</title>
</head>
<body>
<h1>배너등록</h1>
<form action="${pageContext.request.contextPath }/insert" method="post">
	배너제목<br>
	<input type="text" name=title><br>
	배너내용<br>
	<input type="text" name=content><br>
	배너경로<br>
	<input type="text" name=imgPath><br>
	이동페이지<br>
	<input type="text" name=url><br>
	시작<br>
	<input type="text" name=startDate>
	종료<br>
	<input type="text" name=endDate>
	<input type="submit" value="등록">
</form>
</body>
</html>