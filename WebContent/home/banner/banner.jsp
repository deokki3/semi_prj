<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>banner</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
</head>
<style>
	.wrap_center{
		width: 100%;
		height: 350px;
	}
	.container{
		margin: 0 auto;
		width: 800px;
		height: 350px;
		overflow: hidden;
	}
	.img_wrap{
		width: 800px;
		height: 350px;
		position: absolute;
		overflow: hidden;
	}
	.rollimgs{
		list-style: none;
		padding: 0;
		margin: 0;
	}
	.rollimgs li{
		position: absolute;
		width: 800px;
		height: 350px;
		left: 800px;
	}
	.rollimgs li img{
		width: 100%;
		height: 100%;
	}
	.rollimgs li.currentroll{
		left: 0;
		transition: left .5s ease-in-out, right .5s ease-in-out;
	}
	.rollimgs li.prevroll{
		left: -980px;
		transition: left .5s ease-in-out, right .5s ease-in-out;
	}
	.rollimgs.reverse li.prevroll{
    transition: none;
	}
	.rollimgs li.nextroll{
	    left: 980px;
	    display: block;
	    transition: none;
	}
	.rollimgs.reverse li.nextroll{
	    transition: left .5s ease-in-out, right .5s ease-in-out;
	}
	.img_wrap .btnmove{
    position: absolute;
    top: 268px;
    width: 40px;
    height: 85px;
    z-index: 1;
    font-size: 4em;
    opacity: 0.5;
	}
	.img_wrap .btnmove.prev{
	    left: 10px;
	}
	.img_wrap .btnmove.next{
	    right: 10px;
	}
	.img_wrap i{
	    color: #fff;
	}
</style>
<body>
<div class="wrap_center">
	<div class="container">
		<div class="img_wrap">
			<div class="prev btnmove">
       			 <a href="#" title="이전"><i class="fas fa-chevron-left"></i></a>
    		</div>
   		    <div class="next btnmove">
       			 <a href="#" title="다음"><i class="fas fa-chevron-right"></i></a>
   		    </div>    
				<ul class="rollimgs">
					<li>
					<a href="http://www.cgv.co.kr/culture-event/popcorn-store/">
					<img src="${pageContext.request.contextPath }/home/assets/imgs/bannerimg1.jpg"></a>
					</li>
					<li>
					<a href="${pageContext.request.contextPath }/home/banner/event2.jsp">
					<img src="${pageContext.request.contextPath }/home/assets/imgs/bannerimg2.jpg"></a>
					</li>
					<li>
					<a href="${pageContext.request.contextPath }/home/banner/event3.jsp">
					<img src="${pageContext.request.contextPath }/home/assets/imgs/bannerimg3.jpg"></a>
					</li>
				</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
let banner = {
	    rollId: null,
	    interval: 2000,

	    //롤링 배너 초기화
	    rollInit: function (newinterval) {
	        if(parseInt(newinterval) > 0){
	            this.interval = newinterval;
	        }
	        //현재 배너
	        let firstitem = document.querySelector('.rollimgs li');
	        if(firstitem){
	            firstitem.classList.add('currentroll');
	        }
	        //다음 배너
	        let seconditem = document.querySelectorAll('.rollimgs li')[1];
	        if(seconditem){
	            seconditem.classList.add('nextroll');
	        }
	        //이전 배너
	        document.querySelector('.rollimgs li:last-child').classList.add('prevroll');
	        this.rollId = setInterval(this.rollNext, this.interval);//롤링 인터벌 호출
	    },
	    
	    //다음 배너 롤링
	    rollNext: function () {
	        if(document.querySelector('.prevroll')){
	            document.querySelector('.prevroll').classList.remove('prevroll');
	        }
	        if(document.querySelector('.currentroll')){
	            document.querySelector('.currentroll').classList.add('prevroll');
	            document.querySelector('.currentroll').classList.remove('currentroll');
	        }
	        if(document.querySelector('.nextroll')){
	            document.querySelector('.nextroll').classList.add('currentroll');
	            document.querySelector('.nextroll').classList.remove('nextroll');
	        }
	    //다음 이미지 있으면 다음 롤링 이미지로 선택, 없으면 첫번째 이미지를 롤링 이미지로 지정
	        if(document.querySelector('.currentroll').nextElementSibling){
	            document.querySelector('.currentroll').nextElementSibling.classList.add('nextroll');
	        }else{
	            document.querySelector('.rollimgs li').classList.add('nextroll');
	        }
	    },
	  //이전 배너 롤링
	    rollPrev: function () {
	        document.querySelector('.rollimgs').classList.add('reverse');
	        if(document.querySelector('.nextroll')){
	            document.querySelector('.nextroll').classList.remove('nextroll');
	        }
	        if(document.querySelector('.currentroll')){
	            document.querySelector('.currentroll').classList.add('nextroll');
	            document.querySelector('.currentroll').classList.remove('currentroll');
	        }
	        if(document.querySelector('.prevroll')){
	            document.querySelector('.prevroll').classList.add('currentroll');
	            document.querySelector('.prevroll').classList.remove('prevroll');
	        }else{

	        }
	        if(document.querySelector('.currentroll').previousElementSibling){
	            document.querySelector('.currentroll').previousElementSibling.classList.add('prevroll');
	        }else{
	            document.querySelector('.rollimgs li:last-child').classList.add('prevroll');
	        }
	    }
	    
	    
	}

	document.addEventListener('DOMContentLoaded', function(){
	    banner.rollInit(4000); // 배너 롤링
	});

	
	
	
	
	
	//앞뒤 클릭 이벤트 리스너
	document.querySelectorAll('.btnmove').forEach(function(item){
	    item.addEventListener('click', function(e){
	        clearInterval(banner.rollId);//롤링 인터벌 해제
	        //화살표 방향 구분
	        if(e.target.parentElement.parentElement.classList.contains('prev')){
	            banner.rollPrev();
	        }else{
	            banner.rollNext();
	        }
	        banner.rollId = setInterval(banner.rollPrev, banner.interval);//롤링 인터벌 재호출
	    });
	});
	
	
</script>
</body>
</html>



















