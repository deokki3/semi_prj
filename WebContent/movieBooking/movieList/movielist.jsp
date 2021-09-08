<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/movieBooking/assets/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/movieBooking/assets/css/style.css">

<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&amp;subset=korean"
	rel="stylesheet">
<title>movieBooking/movieList/movielist.jsp</title>
</head>
<body>
	<div>
		<jsp:include page="../header.jsp" />
	</div>
	<section id="movie">
		<div class="container">
			<div class="row">
				<h2 class="ir_so">상영작 리스트</h2>
				<div class="movie">
					<div class="movie_title">
						<ul class="clearfix">
							<li class="active"><a href="#">박스오피스</a></li>
							<li><a href="#">최신개봉작</a></li>
							<li><a href="#">상영예정작</a></li>
						</ul>
					</div>
					<div class="movie_chart">
						<c:forEach var="vo" items="${requestScope.movieBookingList }">
							<div class="swiper-container2">
								<div class="chart_cont1 swiper-wrapper">
									<div class="swiper-slide">
										<div class="poster">
											<figure>
												<img
													src="${pageContext.request.contextPath}/movieBooking/assets/img/로그원 스타워즈 스토리.png"
													alt="">
											</figure>
											<div class="rank">
												<strong>1</strong>
											</div>
										</div>
										<div class="infor">
											<h3>
												<span class="icon all ir_pm">전체관람가</span> <strong>로그원
													스타워즈: 스토리</strong>
											</h3>
											<div class="infor_btn">
												<a
													href="${pageContext.request.contextPath}/movieDetail?num_pk=${vo.movie_ls_num_fk}">상세정보</a>
												<a
													href="${pageContext.request.contextPath}/movieBooking/movieChoice?num_pk=${vo.num_pk}">예매하기</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<!-- //chart_cont1-->

						<!-- //chart_cont2-->

						<!-- //chart_cont3-->

					</div>
				</div>
			</div>
		</div>
		<c:if test="${id == 'admin' }">
			<form action="${pageContext.request.contextPath}/movieBooking/admin/insertList">
				<input type="submit" value="영화추가">
			</form>
		</c:if>
	</section>

</body>
</html>