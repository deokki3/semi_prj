<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- result page -->
<c:choose>
	<c:when test="${requestScope.code=='success' }">
		<h1>성공!!</h1>
	</c:when>
	<c:otherwise>
		<h1>실패,,</h1>
	</c:otherwise>	
</c:choose>