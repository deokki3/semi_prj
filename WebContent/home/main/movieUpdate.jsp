<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#detailheader{margin-bottom:100px;}
	
	#movieUpdate p{color:white;}
	
	#actordirector{margin-top:110px;}
	
	body{margin-bottom:200px;}
	#submit{float:right;}
</style>
<body>
	<div id="whole">
		<div id="movieUpdate">
		<form action="${cp }/movieUpdate" method="post">	
			<div id="detailheader">
					<div id="detailheader_image">
						<img src="${cp }/home/assets/imgs/${mvo.img_path }">
						<p>영화 번호<input type="text" name="num_pk" value="${mvo.num_pk }"></p>
						<p>포스터 경로<input type="text" name="img_path" value="${mvo.img_path }"></p>
					</div>
			  		<div id="detailheader_content">
			  			<div id="detailheader_content_in">
							<div id="mtitle">
								<!--  <p>포스터 이미지 경로<input type="text" value="${mvo.country }"></p>-->
								<h1><input type="text" name="title" value="${mvo.title }"></h1>
							</div>
							
							<div id="movieinfo">
								<h3 class="h3a"><input type="date" name="opening_date" value="${mvo.opening_date }"> 개봉 |</h3>
								<h3 class="h3a"><input type="text" name="country" value="${mvo.country }"><a href=""> |</a></h3>
								<h3 class="h3a"><input type="text" name="genre" value="${mvo.genre }"><a href=""></a></h3>
							</div>
							
							<div id="mrate">
								<c:if test="${membersAvgrate<0.5 }">
									<h3 class="h3b">네티즌 평점<span id="star"> ☆☆☆☆☆ ${membersAvgrate }</span>  |</h3>
								</c:if>
								<c:if test="${membersAvgrate>=0.5 && membersAvgrate<1.5 }">
									<h3 class="h3b">네티즌 평점<span id="star"> ★☆☆☆☆ ${membersAvgrate }</span>  |</h3>
								</c:if>
								<c:if test="${membersAvgrate>=1.5 && membersAvgrate<2.5 }">
									<h3 class="h3b">네티즌 평점<span id="star"> ★★☆☆☆ ${membersAvgrate }</span>  |</h3>
								</c:if>
								<c:if test="${membersAvgrate>=2.5 && membersAvgrate<3.5 }">
									<h3 class="h3b">네티즌 평점<span id="star"> ★★★☆☆ ${membersAvgrate }</span>  |</h3>
								</c:if>
								<c:if test="${membersAvgrate>=3.5 && membersAvgrate<4.5 }">
									<h3 class="h3b">네티즌 평점<span id="star"> ★★★★☆ ${membersAvgrate }</span> |</h3>
								</c:if>
								<c:if test="${membersAvgrate>=4.5 }">
									<h3 class="h3b">네티즌 평점<span id="star"> ★★★★★ ${membersAvgrate }</span>  |</h3>
								</c:if>
								
								<c:if test="${pvo.rate<1.5 }">
									<h3 class="h3b">평론가 평점<span id="star"> ★☆☆☆☆ ${pvo.rate }</span></h3>
								</c:if>
		  						<c:if test="${pvo.rate>=1.5 && pvo.rate<2.5 }">
									<h3 class="h3b">평론가 평점<span id="star"> ★★☆☆☆ ${pvo.rate }</span></h3>
								</c:if>
								<c:if test="${pvo.rate>=2.5 && pvo.rate<3.5 }">
									<h3 class="h3b">평론가 평점<span id="star"> ★★★☆☆ ${pvo.rate }</span></h3>
								</c:if>
								<c:if test="${pvo.rate>=3.5 && pvo.rate<4.5 }">
									<h3 class="h3b">평론가 평점<span id="star"> ★★★★☆ ${pvo.rate }</span></h3>
								</c:if>
								<c:if test="${pvo.rate>=4.5  }">
									<h3 class="h3b">평론가 평점<span id="star"> ★★★★★ ${pvo.rate }</span></h3>
								</c:if>
								<div id="myrate">
								<h3> 평가하기!!</h3>
								</div>
							</div>
						</div>
					</div>
					
			</div>
			<div id="detailContent">
				<!-- 좋아요 찜하기 등 -->
				<div id="likediv">
					
					<a id="like" href="">좋아요</a>
	
				</div>
					
					<!-- 작품정보 -->
				<div id="content">
					<h3>작품정보</h3>
					<textarea rows="7" cols="120" name="content">${mvo.content }</textarea>
					
				</div>	
					
					<!-- 예고편 -->
				<div id="preview">
					<h3>예고편</h3>
					<iframe width="800" height="370" src="${mvo.preview_url }" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					<p>예고편 URL</p><textarea rows="3" cols="50" name="preview_url">${mvo.preview_url }</textarea>
				</div>	
			
				<!-- 감독/배우 -->	
				<div id="actordirector">
					<h3>감독/출연</h3>	
						<div class="director">
							<a href="${cp }/directorDetailList?num_pk=${dvo.num_pk }">
								<img src="${cp }/home/assets/directorimgs/${dvo.img_path }">
							</a>
							<p>${dvo.name }</p>
							<p id="drt">감독</p>
						</div>
	
					
					<%
						int cnt=0;
					%>
					<c:forEach var="avo" items="${requestScope.getActorInfo }">	
						<div class="actor">
					<%
						cnt+=1;
					%>
							<a href="${cp }/actorDetailList?num_pk=${avo.num_pk}">
								<img src="${cp }/home/assets/actorimgs/${avo.img_path }">
							</a>
							<p>${avo.name }</p>	
						</div>
					</c:forEach>	
	  				<%
					
					if(cnt>11){
					
					%>
						<div id="cnt12"></div>
						
					<%
					}else if(cnt>5){
						
					%>
						<div id="cnt6"></div>
					<%	
					}else{
					%>
						<div id="cnt0"></div>
					<%
					}
					%>
				</div> 
				
				<!-- 리뷰 -->
				<div id="review">
					<h3>모든 리뷰</h3>
					<c:forEach var="vo" items="${requestScope.getReviewList }">	
						<div class="review">
						
							<p>${vo.members_id_fk }</p>
							<p>${vo.title }</p>
							<p>${vo.content }</p>
						</div>
					</c:forEach>
				</div>
			</div>
			<input type="submit" id="submit" value="수정하기">
		</form>
		</div>	
	</div>
</body>
