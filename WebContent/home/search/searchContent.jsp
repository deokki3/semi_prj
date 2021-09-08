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
	<jsp:include page="${requestScope.search }"/>
</div>
<div>
	<jsp:include page="${requestScope.searchContent1 }"/>
</div>

<div>
	<jsp:include page="${requestScope.category }"/>
</div>
</body>
</html>