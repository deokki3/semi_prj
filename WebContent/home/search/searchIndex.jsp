<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/home/assets/css/maincss.css?ver=3"/>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/home/assets/css/genrecss.css"/>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/home/assets/css/top.css"/>
</head>
<body>
<div>
	<jsp:include page="${requestScope.searchMain }"/>
</div>

<div>
	<jsp:include page="${requestScope.searchContent }"/>
</div>
</body>
</html>