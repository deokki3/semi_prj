<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/home/assets/css/maincss.css?ver=3"/>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/home/assets/css/movieDetailcss.css?ver=5"/>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/home/assets/css/top.css"/>
</head>
<body>
<div>
	<jsp:include page="${requestScope.mainpage }"/>
</div>

<div>
	<jsp:include page="${requestScope.content }"/>
</div>

</body>
</html>