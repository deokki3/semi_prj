<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	#wrap{width: 1000px; position: absolute; left: 500px}
	p{font-size: 1.5em;}
	table{border-color: green; margin-left: auto; margin-right: auto; margin-bottom: 10px;}
	#content{border-top: 2px solid gray; border-bottom: 2px solid gray; margin: 10px;}
	#tbl{border-bottom: 2px solid gray;}
</style>

<% 

	
	String errMsg=(String)request.getAttribute("errMsg");
	String id=(String)request.getAttribute("id");
	String pwd=(String)request.getAttribute("pwd");
	String email=(String)request.getAttribute("email");
	String phone=(String)request.getAttribute("phone");
	String nick=(String)request.getAttribute("nick");
	if(errMsg==null) errMsg="";
	if(id==null){
		id="";
		pwd="";
		email="";
		phone="";
		nick="";
	}
%>
</head>
<body>
<div id="wrap">
	<div id="content">
		<h1 style="text-align: center">회원가입</h1>
	</div>
	<div id="tbl">
	<form action="${pageContext.request.contextPath }/user/join" method="post" onsubmit="return check()">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id_pk" class="txt" value="<%=id %>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" class="txt" value="<%=pwd %>"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nick" class="txt" value="<%=nick %>"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth_date" placeholder="YYYY-MM-DD" class="txt"></td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td><input type="text" name="phone" class="txt" value="<%=phone %>"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" class="txt" value="<%=email %>"></td>
				
				
			</tr>
			<tr>
				<td>소개</td>
				<td><textarea name="intro" class="txt" 
				style="width:500px; height: 300px;"
				placeholder="간단한 소개 해주세요!"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="가입">
				<input type="button" value="다시입력" id="reset"></td>
			</tr>
		</table>
	</form>
	</div>
</div>

<script type="text/javascript">
	var reset=document.getElementById("reset");

	var texts=document.getElementsByClassName("txt");
	var txtarea=document.getElementsByName("intro")[0];
	var sbm=document.getElementById("sbm");
	reset.onclick=function(){
		for(let i=0;i<texts.length;i++){
			texts[i].value="";
		}
	}
	txtarea.onclick=function(){
		txtarea.placeholder=""; //
	}
	
	function check() {
		var name=document.getElementsByName("id")[0];
		var pwd=document.getElementsByName("pwd")[0];
		var nick=document.getElementsByName("nick")[0];
		var birth_date=document.getElementsByName("birth_date")[0];
		var email=document.getElementsByName("email")[0];
		var phone=document.getElementsByName("phone")[0];
		if(name.value==""){
			alert("아이디를 입력하세요");
			name.focus();
			return false;
		}
		if(pwd.value==""){
			alert("비밀번호를 입력하세요");
			name.focus();
			return false;
		}
		if(email.value==""){
			alert("이메일을 입력하세요");
			name.focus();
			return false;
		}
		if(phone.value==""){
			alert("휴대폰번호를 입력하세요");
			name.focus();
			return false;
		}
		if(birth_date.value==""){
			alert("생년월일을 입력하세요");
			name.focus();
			return false;
		}
		if(nick.value==""){
			alert("닉네임을 입력하세요");
			name.focus();
			return false;
		}
		
	}

	
</script>
</body>
</html>