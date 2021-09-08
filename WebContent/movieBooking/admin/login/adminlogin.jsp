<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminlogin.jsp</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	<style>
		#adminlogin{
			position: absolute;
			width: 350px;
			height: 500px;
			padding: 20px;
			top: 50%;
			left: 50%;
			transform: translate(-50%,-50%);
		}
		
		.form(){
			padding: 20px;
		}
		.pt-1{
			padding-top:1rem;
		}
	</style>
</head>
<body>
	<section id="adminlogin">
		<div class="card z-depth-3">
			<div class="card-panel center light-blue darken-3">
				<span class="card-title white-text">Admin Login</span>
			</div>
			<form class="form" method="post" action="${pageContext.request.contextPath}/admin/login">
				<div class="input-field">
					<input type="text" id="id" name="id" class="validate">
					<label>ID</label>
				</div>
				<div class="input-field">
					<input type="password" id="pwd" name="pwd" class="validate">
					<label>Password</label>
				</div>
				<div class="center">
					<button type="submit" class="btn-large light-blue darken-3">
						로그인
					</button>
				</div>
				<div class="center pt-1">
					<a href="#">아이디</a>|<a href="#">비밀번호 찾기</a>
				</div>
			</form>
		</div>
		<div style="color: red;size: 12px;">${errMsg }</div>
	</section>
	<!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>