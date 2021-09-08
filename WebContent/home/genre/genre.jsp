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
	<jsp:include page="${requestScope.genre1 }"/>
</div>
<div>
	<jsp:include page="${requestScope.genre2 }"/>
</div>
<div>
	<jsp:include page="${requestScope.genre3 }"/>
</div>
<div>
	<jsp:include page="${requestScope.genre4 }"/>
</div>
<div>
	<jsp:include page="${requestScope.genre5 }"/>
</div>
</body>
</html>