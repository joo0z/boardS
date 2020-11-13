<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<title>회원가입</title>

<style>

#logor{
	display : inline;
	height: 50px;
	margin-top: 10px;
	margin-right: 0px; 
		
	}
.alert {
	display: none;
}

#logo {
	display : inline;
	width: 200px;
	height: 110px;
}

#logor {
	width: calc(80%);
	height: 70px;
}

footer {
	background-color: #000060;
	color: white;
	padding: 15px;
	text-align: center;
}
.navbar-brand{
	height: 110px;
}
#memberForm {
	margin-left: 40%;
	height: 60%;
	margin-top: 40px;
}

#check {
	margin-left: 50px;
	height: 200px;
}

.but {
	margin: 10px;
	background: skyblue;
	width: 100px;
}

.te {
	width: 200px;
}

#resignupbtn {
	margin: 10px;
	background: skyblue;
	width: 100px;
}
 /* 파란색 배경, 흰색 텍스트, 일부 패딩 설정 */
    footer {
      background-color: #000060;
      color: white;
      padding: 15px;
    }
    #logobar{
    	min-width : 100%;
    	box-sizing: border-box;
    }
</style>


<script>
$(function() {
	var flag = false;
	$('#mem_id').on('keyup',function() {
		idval = $(this).val();
		// 아이디 유효성 검사
		var regex = /^[a-z][a-zA-Z0-9]{5,20}/;
		var result = regex.test($("#mem_id").val());
		if (result) {
			$(".id.regex").html("");
		} else {
			$(".id.regex")
					.html("형식에 맞게 입력해주세요.(영어 소문자로 시작/ 6-20글자/ 영문, 숫자로 입력)");
			$(".id.regex").css("color", "red");
			return false;
		}
		flag = false;
	})
	// 		비밀번호 유효성 검사-------------------------------------------------------
	$('#mem_pass').on('keyup', function() {
		passval = $(this).val();
		var regex = /^[A-Za-z\d]{8,20}$/;
		var result = regex.test($("#mem_pass").val())
		if (result) {
			$(".pw.regex").html("");
		} else {
			$(".pw.regex").html("형식에 맞게 입력해주세요.(영문,숫자로 입력/ 8-20글자)");
			$(".pw.regex").css("color", "red");
			return false;
		}
	})
	// 비밀번호 확인    
	$("#passCheck").on("keyup", function() {
		if ($("#mem_pass").val() == $("#passCheck").val()) {
			$(".repw.regex").html("비밀번호가 일치합니다");
			$(".repw.regex").css("color", "blue");
		} else {
			$(".repw.regex").html("비밀번호가 일치하지않습니다");
			$(".repw.regex").css("color", "red");
		}
	})
	// 		이름 유효성 검사-------------------------------------------------------
	$('#mem_name').on('keyup', function() {
		nameval = $(this).val();
		var regex = /[가-힣]{2,20}/;
		var result = regex.test($("#mem_name").val());
		if (result) {
			$(".name.regex").html("");
		} else {
			$(".name.regex").html("형식에 맞게 입력해주세요.(한글만 입력/ 2-20글자)");
			$(".name.regex").css("color", "red");
			return false;
		}
	})
	// 		생년월일 유효성 검사-------------------------------------------------------
	$('#mem_bir').on('keyup',function() {
		birval = $(this).val();
		var regex = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
		var result = regex.test($("#mem_bir").val());
		if (result) {
			$(".bir.regex").html("");
		} else {
			$(".bir.regex").html(
					"형식에 맞게 입력해주세요.(ex) 19941211)");
			$(".bir.regex").css("color", "red");
			return false;
		}
	})
	// 		전화번호 유효성 검사-------------------------------------------------------
	$('#mem_tel').on('keyup', function() {
		telval = $(this).val();
		var regex = /[01](0|1|6|7|8|9)[-](\d{4}|\d{3})[-]\d{4}$/;
		var result = regex.test($("#mem_tel").val());
		if (result) {
			$(".phone.regex").html("");
		} else {
			$(".phone.regex").html("형식에 맞게 입력해주세요.(숫자, '-'포함 입력)");
			$(".phone.regex").css("color", "red");
			return false;
		}
	})
	// 		이메일 유효성 검사-------------------------------------------------------
	$('#mem_mail').on('keyup', function() {
		mailval = $(this).val();
		var regex = /.+@[a-z]+(\.[a-z]+){1,2}$/;
		var result = regex.test($("#mem_mail").val());
		if (result) {
			$(".email.regex").html("");
		} else {
			$(".email.regex").html("올바른 이메일이 아닙니다");
			$(".email.regex").css("color", "red");
			return false;
		}
	})
	
	$('#send').on('click',function() {
		$('#memberForm').submit();
	})

})

function goBack() {
  window.history.back();
}

</script>
</head>
<body>
	<div>
		<div id="logobar">
			<a class="navbar-brand" href="../main/main.jsp"><img id="logo" alt="로고" src="../Gimg/logo.PNG"></a>
			<img id="logor" alt="" src="../Gimg/top.PNG">
		</div>
	</div>

</body>
<div id="big">
	<form id="memberForm" action="/member/regist" method="post">
		<h2>회원가입</h2>
		<h3>Sign up</h3>
		<br>
		아이디<br>
		<input class="te" type="text" id="mem_id"name="mem_id" value="">
		<span id="idspan"></span><br>
		<div class="id regex"></div>
<br>
		비밀번호<br>
		<input class="te" type="password" id="mem_pass"name="mem_pass" value=""><br>
		<div class="pw regex"></div>
		<br>
		비밀번호 확인<br>
		<input class="te" type="password" id="passCheck"value="">
		<div class="repw regex"></div>
<br>
		이름<br>
		<input class="te" type="text" id="mem_name"name="mem_name" value=""><br>
		<div class="name regex"></div>
<br>
		생년월일<br>
		<input class="te" type="text" id="mem_bir"name="mem_bir" value=""><br>
		<div class="bir regex"></div>
<br>
		전화번호<br>
		<input class="te" type="text" id="mem_tel"name="mem_tel" value=""><br>
		<div class="phone regex"></div>
<br>
		이메일 주소<br>
		<input class="te" type="email" id="mem_mail"name="mem_mail"><br>
		<div class="email regex"></div>

		<hr>
		<div id="check">
			<input class="but" type="button" id="send" value="회원가입">
			<input onclick="goBack()" class="but" type="button" value="가입취소">
			<input type="reset" value="초기화" id="resignupbtn">
			<span id="sendspan"></span>
		</div>
	</form>
</div>


<footer class="container-fluid text-center">
  <p>상호:GoRail&nbsp;&nbsp; 사업자등록:111-11-1111&nbsp;&nbsp;
  	 통신판매업신고:대전중구-호&nbsp;&nbsp; 주소:대전광역시중구 영민빌딩 &nbsp;&nbsp;TEL: 042)248-2131</p>
  <p>COPYRIGHT KOREA (c)GORAILROAD.ALL RIGHTS RESEVED.</p>	
</footer>
</html>