<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AMS Academy Mangement System</title>
</head>

<style>
	.menu {
	    width: 100%;    
	    height: 50px; 
	    max-width: 100%;
	    background-color: #28a745;
	    color: white;
	    position: absolute; 
	    top: 0px;
	    display: flex; /* Flexbox 활성화 */
	    align-items: center; /* 세로 가운데 정렬 */
	    padding: 0 10px; /* 좌우 패딩 추가 */
	    justify-content: space-between; /* 좌측과 우측을 간격을 두고 배치 */
	}

	.topLogo {
	    display: flex; /* Flexbox 활성화 */
	    align-items: center; /* 세로 가운데 정렬 */
	    margin-left: 10px;
	}

	.topLogo h2 {
	    margin-right: 10px; /* h2와 p 간의 간격 추가 */
	    margin: 0; /* 기본 마진 제거 */
	}

	.topLogo p {
	    margin: 0; /* 기본 마진 제거 */
	    margin-top: 5px; /* h2와 p 간의 간격 조정 */
	    line-height: 1; /* 줄 높이 조정 (필요시) */
	    margin-left: 5px;
	}

	.logOutDiv {
	    display: flex;
	    align-items: center; /* 세로 가운데 정렬 */
	}

  .topLogo a {
    color: white; /* 글 색을 흰색으로 설정 */
    text-decoration: none; /* 기본적으로 밑줄 제거 */
  }

  .topLogo a:hover {
    color: white; /* 마우스 올렸을 때 글 색이 변하지 않도록 설정 */
    text-decoration: none; /* 마우스 올렸을 때 밑줄이 생기지 않도록 설정 */  
  }
  
    #logOutBtn {
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
    height: 40px; 
    margin-right: 5px;
	}

	#logOutBtn {
	    background-color: #adb5bd;  
	    color: white;
	}
	
	#logOutBtn:hover {
	    background-color: #868e96;  
	}

  	.admin-message {
       margin-right: 10px; /* 여백을 추가하여 로그아웃 버튼과 구분 */
   }

</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	
	$('#logOutBtn').on('click', function () {
	    location.href = '/login/amsLogout.do';
	});
	
});

</script>
<body>
<div class="menu" >
	<div class="topLogo">
		<h2><a href="/student/acasysStudetnList.do">AMS</a></h2><p>Academy Mangement System</p>
	</div>
	<div class="logOutDiv">
        <span class="admin-message">${adminId} 님 반갑습니다.</span>
        <button type="button" id="logOutBtn">로그아웃</button>
	</div>
</div>
</body>
</html>