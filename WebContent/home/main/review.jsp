<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review</title>
</head>
<script type="text/javascript">

var locked=0;

function show(star) {
	if(locked)
		return;
	var i;
	var image;
	var el;
	var e = document.getElementById('startext');
	var stateMSg; //메세지 (평점에 대한 코맨트)
	//이미지 변환
	for(i=1;i<=star;i++){
		image='image'+i;
		el=document.getElementById(image);
		el.src="${cp }/home/assets/imgs/star1.PNG";
		
	}
	//별에 대한 코멘트
	switch(star) {
	case 1:
		stateMsg="별로에요";
		break;
	case 2:
		stateMsg="살짝 아쉬워요";
		break;
	case 3:
		stateMsg="무난했어요";
		break;
	case 4:
		stateMsg="기대해도 좋아요!";
		break;
	case 5:
		stateMsg="진짜 추천 합니다!!";		
		break;
	default:
		stateMsg="";
	}
	e.innerHTML=stateMsg;
}

function noshow(star) {
	if(locked)
		return;
	var i;
	var image;
	var el;
	
	for(i=1;i<=star;i++) {
		image ='image'+i;
		el =document.getElementById(image);
		el.src= "${cp }/home/assets/imgs/star0.PNG"; //처음 별 0개
	}
}
function lock(star){
	show(star);
	locked=1;
	
}
function mark(star){
	lock(star);
	document.review.star.value=star; //cmtform?? 태그를 보자
	//별이 클릭되었을 때, lock을 걸고 hidden 타입의 input 태그 value 값에 매개변수로 받은 star를 넘겨주는 식으로 수정

}
function check() {
	if(${requestScope.insert == 1})
		alert("이미 댓글을 다셨어요~");
}

</script>
<body>

<form action="${cp }/review?num_pk=${mvo.num_pk}&id_pk=${m1vo.id_pk}" method ="post" name="review">
<table width="700">
<tr>							<!-- 아이디쪽 가져오기 컨틀롤러에서 -->
	<td width="100" rowspan="2">${m1vo.nick }</td>
	<td width="500" height="50" colspan="2">
		<div id=rating align=center>
			<span>
			 <img id=image1 onmouseover=show(1) onclick=mark(1) onmouseout=noshow(1) src ="${cp }/home/assets/imgs/star0.PNG">
			 <img id=image2 onmouseover=show(2) onclick=mark(2) onmouseout=noshow(2) src ="${cp }/home/assets/imgs/star0.PNG">
			 <img id=image3 onmouseover=show(3) onclick=mark(3) onmouseout=noshow(3) src ="${cp }/home/assets/imgs/star0.PNG">
			 <img id=image4 onmouseover=show(4) onclick=mark(4) onmouseout=noshow(4) src ="${cp }/home/assets/imgs/star0.PNG">
			 <img id=image5 onmouseover=show(5) onclick=mark(5) onmouseout=noshow(5) src ="${cp }/home/assets/imgs/star0.PNG">
			</span>
			<br><span id=startext>평가하기</span>
		</div>
		<input type="hidden" name="star"/>
	</td>
	<td width="100" rowspan="2"><input type="submit" name="submit" value="등록" onclick=check()></td>
	
</tr>
<tr>

	<c:choose>
	
	<c:when test="${empty m1vo.id_pk }">
		<td width="500" height="100" colspan="2"><textarea name="content" cols="65" rows="7" readonly="readonly">
		로그인 후 이용가능합니다.</textarea></td>
	</c:when>
	<c:otherwise>
	
		<td width="500" height="100" colspan="2"><textarea name="content" cols="65" rows="7" ></textarea></td>
	</c:otherwise>
	</c:choose>

</tr>
</table>
</form>
<div id="commList"></div>
<!--  등록된 한줄평 뿌리는곳 ... 카운트인듯..? -->




</body>
</html>