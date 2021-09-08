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
	<div id="whole">
		<div id="detailheader">
				<div id="detailheader_image">
					<img src="${cp }/home/assets/imgs/${mvo.img_path }">
				</div>
		  		<div id="detailheader_content">
		  			<div id="detailheader_content_in">
						<div id="mtitle">
							<h1>${mvo.title }</h1>
						</div>
						
						<div id="movieinfo">
							<h3 class="h3a">${mvo.opening_date } 개봉 |</h3>
							<h3 class="h3a"><a href="">${mvo.country } |</a></h3>
							<h3 class="h3a"><a href="">${mvo.genre }</a></h3>
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
			<a id="dislike" href="${cp }/unlike?num_pk=${mvo.num_pk}&id_pk=${m1vo.id_pk}"><img id="imagedislike" onclick="changeImage()" src="${cp }/home/assets/imgs/undislike.png"></a><a>싫어요!!</a>
			<a id="like" href="${cp }/like?num_pk=${mvo.num_pk}&id_pk=${m1vo.id_pk}"><img id="imagelike" onclick="changeImages()" src="${cp }/home/assets/imgs/unlike.png"></a><a>좋아요!!</a>
			<div>
				<jsp:include page="${requestScope.review }"/>
			</div>
			<div id="list">
			<table width="700">
			<c:forEach var="vo2" items="${requestScope.rateList }" >
				<c:forEach var="vo1" items="${requestScope.reviewList }">
					<tr>
						<td rowspan="3" width="100"> ${vo1.members_id_fk }</td> 
						<td width="550" height="20">
							<font size="5" border="border">${vo1.members_id_fk }</font> &nbsp;&nbsp;&nbsp;&nbsp;
							<font size="1">${vo1.reg_date }</font>
						</td>

					</tr>
					
					<tr>
						
						<td colspan="2" width="200" >
							<c:if test="${vo2.rate==1 }" >
								<img src="${cp }/home/assets/imgs/stars1.PNG" >
							</c:if>
							<c:if test="${vo2.rate==2 }" >
								<img src="${cp }/home/assets/imgs/stars2.PNG" >
							</c:if>	
							<c:if test="${vo2.rate==3 }" >
								<img src="${cp }/home/assets/imgs/stars3.PNG" >
							</c:if>	
							<c:if test="${vo2.rate==4 }" >
								<img src="${cp }/home/assets/imgs/stars4.PNG" >
							</c:if>	
							<c:if test="${vo2.rate==5 }" >
								<img src="${cp }/home/assets/imgs/stars5.PNG" >
							</c:if>	
						
							<td>
						</td>
						
					</tr>
					<tr>
						<td height="100" colspan="2">${vo1.content }</td>	
					</tr>
					</c:forEach>
				</c:forEach>
					
				</table>
				</div>
				
				
			
			
				<!-- 작품정보 -->
			<div id="content">
				<h3>작품정보</h3>
				<p>${mvo.content }</p>
			</div>	
				
				<!-- 예고편 -->
			<div id="preview">
				<h3>예고편</h3>
				<iframe width="800" height="370" src="${mvo.preview_url }" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
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
			
		</div>
	</div>	
</body>
<script type="text/javascript">

state=0;//싫어요 버튼(누르기전)
flag=0;//좋아요 버튼(누르기전)
if(${requestScope.status==-1}){ 
	
		
	document.getElementById('imagedislike').src="${cp }/home/assets/imgs/dislike.png";
	state=1;//싫어요 버튼 (누른후)
	}
else if(${requestScope.status==0}) {
	
	document.getElementById('imagedislike').src="${cp }/home/assets/imgs/undislike.png";
		document.getElementById('imagelike').src="${cp }/home/assets/imgs/unlike.png";
}
else if(${requestScope.status==1}) {
	document.getElementById('imagelike').src="${cp }/home/assets/imgs/like.png";
	flag=1;
}

function changeImage() { 
 	//로그인 확인
	if( ${ m1vo.id_pk ==null})
		{
				alert("로그인 후 이용가능합니다.");
				return ;
		}
 	//로그인했으면
	else{
		//0인상태에서 싫어요를 누르면
		if(state==0) {
			
			
			state=1;
			flag=0;
			document.getElementById('imagelike').src="${cp }/home/assets/imgs/unlike.png";
			document.getElementById('imagedislike').src="${cp }/home/assets/imgs/dislike.png";
			
			alert("싫어요를 누르셨어요");
		}//싫어요를 취소하면
		else {
			state=0;
			flag=0;
			document.getElementById('imagedislike').src="${cp }/home/assets/imgs/undislike.png";
			
			alert("싫어요를 취소 하셨습니다.");
		}
	}



}

function changeImages() {
//로그인 확인
		if( ${ m1vo.id_pk ==null})
			{
					alert("로그인 후 이용가능합니다.");
					return ;
			}
			//로그인했으면
		else{
			//흑백에서 좋아요를 눌렀을때
			if(flag==0) {	
				//좋아요를 누르려는데 싫어요가 눌려져있다면
				//이미지 변경 
				state=0;
				flag=1;
				
				document.getElementById('imagedislike').src="${cp }/home/assets/imgs/undislike.png";
				document.getElementById('imagelike').src="${cp }/home/assets/imgs/like.png";
				
				alert("좋아요를 누르셨어요");
			}
			//좋아요가 눌려져있고 다시 취소를 하려면
			else {
				flag=0;
				state=0;
				document.getElementById('imagelike').src="${cp }/home/assets/imgs/unlike.png";
				alert("좋아요를 취소 하셨습니다.");
			}
		}



}
</script>
</html>