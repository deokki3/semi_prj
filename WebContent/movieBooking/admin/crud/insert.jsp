<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movieBooking/admin/crud/insert.jsp</title>
</head>
<body>
	<h1>영화추가</h1>
	<c:forEach var="vo" items="${requestScope.list }">
		<form method="post"
			action="${pageContext.request.contextPath}/movieBooking/admin/movieInsert">
			영화번호<input type="text" name="movie_num_fk" value="${vo.num_pk }" readonly="readonly"><br>
			영화제목<input type="text" name="title" value="${vo.title }"><br>
			가격<input type="text" name="price" value="10000"><br>
			시작시간<input type="datetime-local" name="start_time" value=""><br>
			종료시간<input type="datetime-local" name="end_time" value=""><br>
			영화관<input type="text" name="theater_name" value="megabox"><br>
			상영관
			<input type="radio" name="theater_num" value="1">1관
    		<input type="radio" name="theater_num" value="2">2관
    		<input type="radio" name="theater_num" value="3">3관<br>
			총좌석수<input type="text" name="seat_tot_cnt" value="60"><br>
			<input type=submit value="추가">
		</form>
	</c:forEach>
</body>
</html>