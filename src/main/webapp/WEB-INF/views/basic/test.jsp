<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		min-width: 1700px;
		width : auto;	
		border: 1px solid white;
		box-sizing: border-box;
	}
	.text-center{
		min-width: 1800px;
		display: inline-block;
		display: inline-block;
		
	}
	.sidenav {
		background: skyblue;
		text-align: left;
	}
    /* 둥근 테두리 제거 */ 
    .navbar {
      background-color: #000060;
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* 그리드 높이 설정 sidenav가 100% 되도록(필요에 따라 조정) */
    .row.content {
    	height: auto;
    }
    
    /* 회색배경 100% 높이 설정 */
    .sidenav {
      padding-top: 20px;
      background-color: white;
      font-weight : bold;
      height: 100%;
      width: calc(100%-30%);
    }
    
    /* 파란색 배경, 흰색 텍스트, 일부 패딩 설정 */
    footer {
      background-color: #000060;
      color: white;
      padding: 15px;
      min-width: 100%;
    }
    
    /* 작은 화면에서 sidenav and grid 높이를 자동으로 설정 */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
       
      }
      .row.content {
      	height:auto;
      } 
    }
    .sidenav{
    	width: 400px;
    }
    .text-left{
        height: calc(100%-10px);
    	width: calc(53%);
    	
    }
    .list-group-item{
    	font-size: 1.3em;
    }
    #note{
    	margin-top : 20px;
    	border: 1px solid #000060;
    	width: 300px;
    }
    #res{
    	margin-top : 20px;
    	border: 1px solid #000060;
    	width: 300px;
    	
    }
    /*========================수정 금지================================*/
  </style>
</head>
<body>
	<jsp:include page="nav.html"></jsp:include>
	<jsp:include page="content.html"></jsp:include>
	<jsp:include page="footer.html"></jsp:include>
</body>
</html>
    