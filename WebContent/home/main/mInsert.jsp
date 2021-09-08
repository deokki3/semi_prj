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
		<h1>영화 추가하기</h1>
		<form action="${cp }/mInsert" method="post">
			<p>제목</p>
			<input type="text" class="input" name="title"><br>
			<p>내용</p>
			<textarea rows="7" cols="50" class="input" name="content"></textarea><br>
			<p>포스터 경로</p>
			<input type="text" class="input" name="img_path"><br>
			<p>장르</p>
			<input type="text" class="input" name="genre"><br>
			<p>제작 국가</p>
			<input type="text" class="input" name="country"><br>
			<p>연대</p>
			<input type="date" class="input" name="opening_date"><br>
			<p>예고편</p>
			<input type="text" class="input" name="preview_url"><br>
			
			<input type="submit" value="등록">
		</form>
	</div>
</div>