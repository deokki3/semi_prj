<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	#allmovies img{width:180px; height:270px;}
	#allmovies .movie{width:180px; height:400px; margin-top:5px; margin-bottom:15px;}
	#mUpdateA{float:right; margin-right:10px;}
	#mDeleteA{float:right; margin-right:10px;}
</style>

<div id="whole">
	<div id="allmovies" class="movies">
		<c:forEach var="vo" items="${requestScope.moviesList }">
				
				<div id="movies_1" class="movie">
				
					<a href="movieDetail?num_pk=${vo.num_pk}">
						<img src="${cp }/home/assets/imgs/${vo.img_path }">
					</a>
					<!-- 제목 -->
					<p>${vo.title }</p>
					<p>영화번호: ${vo.num_pk }<p>
					<a href="mDelete?num_pk=${vo.num_pk }&title=${vo.title }" onclick="delchk()" id="mDeleteA">삭제</a>
					<a href="movieUpdate?num_pk=${vo.num_pk }" id="mUpdateA">수정</a>  
				</div>
		</c:forEach>
	</div>
</div>
<script type="text/javascript">
	function delchk(){
		if(!confirm("이 영화의 모든 정보를 삭제하시겠습니까?")){
			event.preventDefault ();
			alert("취소 되었습니다.");
		}else{
			//window.location.href ="";
		}
	}
</script>