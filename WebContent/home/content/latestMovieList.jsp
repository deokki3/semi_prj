<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="500">
	<tr>
		<th>영화번호</th>
		<th>제목</th>
		<th>내용</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.latestMovieList }">
		<tr>
			<td>${vo.num_pk }</td>
			<td>${vo.title }</td>
			<td>${vo.content }</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>