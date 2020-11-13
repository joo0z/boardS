<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>top기본</title>
<style>
	#im{
		border-radius: 20px; 
	}
	#logo{
		width: calc( 20% - 10px );
		height: 110px;
	}
	#logor{
		width: calc(80%);
		height: 70px;
	}
	.login {
		margin-top : 100px;
		 width: 100%;
		 text-align: center;
	 }
	.in {
		display: inline-block;
	 }
		
	table {
		border : 1px solid #00060;
		margin-top : 10%;
		margin-left : 40%;
		height: calc(50%);
		width: 500px;
	}	
	.log{
		width : 100px;
		background: #000060; 
		color: white;
		
	}
</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#log").on("click", function() {
		$('#loginForm').submit();
	});
	$("#inBtn").on("click", function() {
		document.location = "/member/Regist";
	});

});
</script>
<body>
	<div>
		<div>
			<a class="navbar-brand"><img id="logo" src="../Gimg/logo.PNG"></a>
			<img id="logor" alt="" src="../Gimg/top.PNG">
		</div>
	</div>
	
	<form action="${pageContext.request.contextPath }/login/process" id="loginForm"  method="post">
	<table>
		<tr>
			<td id="d1">
				<input type="text" name="mem_id" placeholder="아이디"><br>
				<input type="password" name="mem_pass" placeholder="비밀번호"><br>
				<hr>
				<input type="button" id="log" value="로그인"><br><br><br>
			</td> 
			<td>
				<img id="im" alt="" src="../Gimg/ktx.png">
			</td> 
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="inBtn" value="회원가입">
			</td>
		</tr>
	</table>
	</form>
 
	
</body>
</html>
