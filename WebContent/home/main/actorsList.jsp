<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#allactors .actor{margin-top:15px; height:260px;}
	
	#aUpdateA{float:right; margin-right:5px;}
	#aDeleteA{float:right; margin-right:5px;} 
	
	#searchactor{margin-bottom:5px;}
	#allactors{height:800px;}
	#actorsPage{margin-top:100px; margin-bottom:100px; text-align:center;}

</style>
<div id="whole">
	<div id="allactors" class="actors">
		<c:forEach var="vo" items="${requestScope.actorsList }">
				
				<div class="actor" id="actor">
					<a href="${cp }/actorDetailList?num_pk=${vo.num_pk}">
						<img src="${cp }/home/assets/actorimgs/${vo.img_path }">
					</a>
					<p>${vo.name }</p>	
					<p>배우번호: ${vo.num_pk }<p>
					<a href="aDelete?num_pk=${vo.num_pk }" id="aDeleteA">삭제</a>
					<a href="aUpdate?num_pk=${vo.num_pk }" id="aUpdateA">수정</a>  
					
				</div>
		</c:forEach>
	</div>
	<div id="actorsPage">
	<div id="searchactor">
		<form method="post" action="${cp }/aList">
			
		<input type="text" name="keyword" value="${keyword }">
		<input type="submit" value="검색">
		</form>
	</div>
		<!-- 이전페이지 -->
		<c:if test="${startPageNum>10 }">
			<a href="${cp }/aList?pageNum=${startPageNum-1 }">[이전]</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${pageNum==i }"><%--현재페이지인경우 --%>
					<a href="${cp }/aList?pageNum=${i }"><span style="color:blue">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${cp }/aList?pageNum=${i }"><span style="color:gray">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<!-- 다음페이지 -->
		<c:if test="${endPageNum<pageCount }">
			<a href="${cp }/aList?pageNum=${endPageNum+1 }">[다음]</a>
		</c:if>
		
	</div>
	
</div>
