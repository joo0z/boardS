<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kr">
<head>
  <title>마이페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  	 body{
		min-width: 1600px;
		width : auto;	
		border: 1px solid white;
		box-sizing: border-box;
	}
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    .text-center{
		min-width: 1800px;
		display: inline-block;
		display: inline-block;
		
	}
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: white;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #000060;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    
    .center{
		height: auto;
   	}
   	
   	/*------------------------기본설정 건들지 마세요--------------------------------------------*/
   	
</head>


<body>
	  
  <style>
	  body {
        margin: 0px;
        padding: 0px;
      }
	#logoimg{
   		width: 200px;
		height: 70px;
   	}
	.topbar{
		height: 100px;
		background: white;
	}
   	.box1{
		background : #000060;
		text-align: center;
		color: white;
   	}
   	.box2{
		background-color: #000060;
		text-align: center;
		color: white;
		height: 55px;
   	}
   	
	.mm {
		margin: 10px;
   		float: right;
   		display: inline;
	}
	.logo{
		width: 200px;
		height: 100px;
	}
    #ul{
    	list-style: none;
    	padding-left: 0px;
    }
	.kat{
		margin-left: 80px;
		font-size: 1.5em;
		background-color: #000060;
		color: white;
	}
	.tk{
		margin-left: 400px;
		text-align: center;
	}
	.logobar{
		border: white; 
	}
	.logobar2{
		height: auto;
	}
  </style>
  
<nav class="navbar logobar navbar-inverse topbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand logobar2" href="../../view/main/main.jsp"><img id="logoimg" src="../Gimg/logo.PNG"></a>
    </div>
    <div class="collapse navbar-collapse navbar-right" id="myNavbar">
      <ul class="nav navbar-nav">
        <a class="navbar-brand" href="../view/main.jsp"><li>Home</li></a>
        <li><a href="../login/login.html">로그인</a></li>
        <li><a href="#">구매내역조회</a></li>
        <li><a href="#">마이페이지</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<!-- nav2 -->
<nav class="navbar navbar-inverse box2">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav" id="menu">
        <li class="kat tk"><a class="menu" href="#">승차권</a></li>
        <li class="kat"><a class="menu" href="#">여행상품</a></li>
        <li class="kat"><a class="menu" href="#">종합이용안내</a></li>
        <li class="kat"><a class="menu" href="#">기차역정보</a></li>
        <li class="kat"><a class="menu" href="#">공지사항</a></li>
      </ul>
    </div>
  </div>
</nav>

	


<style>
	#mem{
		height: 100px;
	}
	#tt{
		text-align: center;
		font-weight: bold;
	}
	p{
		font-weight: bold;
		font-size: 1.2em;
	}
	td {
		margin: 20px;
	}
	.bt{
		margin-left: 820px;
	}
	
	#tab1 tr{
		width : 60px;
		margin-left: 20px;
	}
	#tab1{
		width : 200px;
		height: 200px;
	
	}
	#tab2 {
		width : 50%;
		height : 300px;
		border : 5px solid gray;
	}
	.text-left{
		margin-top: 50px;
	}
	iframe {
		width: 60%;
		height: 400px;
		border: 1px solid white; 
		margin-left: 230px;
	}
	
</style>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script>
$(document).ready(function(){
	//clinet side에서는 서버사이드 변수나 값을 사용가능
	memberAjax("${param.mem_id}");

	$('#pp').on('click',function(){
		$('#frm').submit();
		alert("변경완료")
	});

	$('#send').on('click',function(){
		var input_pass = $('#mem_pass2').val(); 
// 		console.log(input_pass)
// 		console.log("${param.mem_pass}")
		if(input_pass == ${param.mem_pass})
			$('#wform').submit();
		else
			alert("비밀번호를 다시 입력하세요")
	});
	
});

function memberAjax(mem_id){
	$.ajax({url: "/member/memberAjax",
			data : {mem_id : mem_id},
			method : "get",
			success : function(data){
				var member = data.memberVo;
				$(".mem_id").html(member.mem_id);
				$("#mem_name").html(member.mem_name);
				$("#mem_bir").html(member.mem_bir);
				$("#mem_mail").html(member.mem_mail);
				$("#mem_tel").html(member.mem_tel);
			}
	});
}

function updatePass(mem_pass){
	$.ajax({url: "/member/updatePass",
			data : {mem_pass : mem_pass},
			method : "post",
			success : function(data){
				alert("변경되었습니다.")
			}
	});
}

function goBack() {
	  window.history.back();
}
	
</script>

<div class="container-fluid text-center">    
  <div class="row content">
   <div class="col-sm-2 sidenav center">
		<div id="basic">
			<table id='tab1'>
				<tr>
					<td id='tt' colspan='2'><h3>*회원 정보</h3></td>
				</tr>
				<tr>
					<td><img id='mem' src='../Gimg/member.png'></td>
					<td>
						<span class="mem_id"></span>님
						<hr>
					</td>
				</tr>
			</table>
			<br>
			<hr>
			<br>
			
		</div>
		<p>회원 메뉴 선택</p><br>
      <ul>
      	<li><a href="../buyticket/buyticket.html" target="ifr">승차권 이용내역</a></li>
      	<li><a href="../buyprod/buyprod.html" target="ifr">여행상품 이용내역</a></li>
      	<li><a href="../mark/mark.html" target="ifr">노선 즐겨찾기</a></li>
     	<li><a href="../reservation/memberReservation.html" target="ifr">승차권예약내역</a></li>
     	<li><a href="../memberprod/memberprod.html" target="ifr">상품장바구니</a></li>
    </ul>
    </div>
	    <div class="col-sm-8 text-left center"> 
<!-- 	<iframe name="ifr"> -->
	      <h2>나의 기본정보</h2>
	      <p class="bt">
<!-- 	      <input type="button" value="회원정보수정">  -->
	      <input type="button" value="회원탈퇴" id="drop" data-toggle="modal" data-target="#wModal"> 
	      </p>
	      <hr>
		<div id="info">
			<table id='tab2' border=1>
				<tr>
					<td>회원명</td>
					<td id="mem_name"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td class="mem_id"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td id="mem_bir"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td id="mem_mail"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="button" value="비밀번호변경" id="pas" data-toggle="modal" data-target="#uModal"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td id="mem_tel"></td>
				</tr>
			</table>
		</div>
			<hr>
			
<!--       </iframe> -->
	    </div>
    
    <!--비밀번호 변경 Modal -->
<div id="uModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">비밀번호변경</h4>
      </div>
         <div class="modal-body">
      	   <form id="frm" action="/member/updatePass" method="post">
      	   		변경할 비밀번호를 입력해주세요. <input type="text" class="indata" id="mem_pass" name="mem_pass"><br><br>
      	   		<input type="hidden" value="${S_MEMBER.mem_id }" name="mem_id"> 
      	   </form>
      	 </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="pp">확인</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!--회원 탈퇴 Modal -->
<div id="wModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">비밀번호 확인</h4>
      </div>
         <div class="modal-body">
      	   <form id="wform" action="/member/dropMember" method="post">
      	   		비밀번호확인  <input type="text" class="indata" id="mem_pass2" name="mem_pass"><br><br>
      	   		<input type="hidden" value="${S_MEMBER.mem_id }" name="mem_id">
      	   		<input id="send" type="button" value="탈퇴">
      	   		<input type="button" value="취소">
      	   </form>

      	 </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
    
    
  </div>
</div>

	
<footer class="container-fluid text-center">
  <p>상호:GoRail&nbsp;&nbsp; 사업자등록:111-11-1111&nbsp;&nbsp;
  	 통신판매업신고:대전중구-호&nbsp;&nbsp; 주소:대전광역시중구 영민빌딩 &nbsp;&nbsp;TEL: 042)248-2131</p>
  <p>COPYRIGHT KOREA (c)GORAILROAD.ALL RIGHTS RESEVED.</p>	
</footer>

</body>
</html>