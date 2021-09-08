<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#insertPage h1{color:#F6F6F6;}
	#insertPage input{background-color:silver;}
	#insertPage textarea{background-color:silver;}
	#insertPage p{color:#F6F6F6;}
</style>
<div id="whole">
	<div id="insertPage">
		<h1>배우 추가하기</h1>
		<form action="${cp }/aInsert" method="post">
			<select name="field">
					<option value="actor">배우</option>
					<option value="director">감독</option>
				</select>
			<p>이름</p>
			<input type="text" name="name"><br>
			<p>이미지 경로</p>
			<input type="text" name="img_path"><br>
			
			<input type="submit" value="등록">
		</form>
	</div>
</div>