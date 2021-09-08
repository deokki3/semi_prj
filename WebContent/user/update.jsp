<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<body>

<h1>정보 수정하기</h1>
<form action="${pageContext.request.contextPath }/user/update" method="post">
	<!--  hidden: 사용자 화면에서 안보이지만 서버로 전송됨 --> <!-- requestScope 생략가능 -->
	<input type="hidden" name="id_pk" value="${vo.id_pk }">
	아이디<input type="text" name="id_pk" value="${vo.id_pk }" disabled="disabled"><br>
	비밀번호<input type="password" name="pwd" value="${vo.pwd}"><br>
	닉네임<input type="text" name="nick" value="${vo.nick }"><br>
	생년월일<input type="text" name="birth_date"value="${vo.birth_date }"><br> 
	핸드폰번호<input type="text" name="phone" value="${vo.phone }"><br> 
	이메일<input type="text" name="email" value="${vo.email }"><br>
	<a>소개</a><br>
	<textarea name="intro" class="txt" 
				style="width:500px; height: 300px;">${vo.intro }</textarea><br> 
	<input type="submit" value="저장">
	</form>
	
	
	

</body>
</html>