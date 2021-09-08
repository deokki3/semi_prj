<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<jsp:include page="${top }"/>
</div>
<div>
	<jsp:include page="${requestScope.banner }"/>
</div>
<div>
	<jsp:include page="${requestScope.content1 }"/>
</div>
<div>
	<jsp:include page="${requestScope.content2 }"/>
</div>
<div>
	<jsp:include page="${requestScope.content3 }"/>
</div>
</body>
</html>