<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <a class="navbar-brand logobar2" href="../view/main.jsp"><img id="logoimg" src="../Gimg/logo.PNG"></a>
    </div>
    <div class="collapse navbar-collapse navbar-right" id="myNavbar">
      <ul class="nav navbar-nav">
        <a class="navbar-brand" href="../view/main.jsp"><li>Home</li></a>
		<c:choose>
			<c:when test="${S_MEMBER.mem_id == S_MEMBER.mem_id}">[${S_MEMBER.mem_id}]</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
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
        <li class="kat tk"><a class="menu" href="#">승차권 예매</a></li>
        <li class="kat"><a class="menu" href="#">여행상품</a></li>
        <li class="kat"><a class="menu" href="#">종합이용안내</a></li>
        <li class="kat"><a class="menu" href="#">기차역정보</a></li>
        <li class="kat"><a class="menu" href="#">공지사항</a></li>
      </ul>
    </div>
  </div>
</nav>