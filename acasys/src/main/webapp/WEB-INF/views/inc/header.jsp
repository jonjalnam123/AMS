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
	}
	
	.topLogo {
	    display: flex; /* Flexbox 활성화 */
	    align-items: center; /* 세로 가운데 정렬 */
	    margin-left: 10px;
	}
	
	.topLogo h2{
	    margin-right: 10px; /* h2와 p 간의 간격 추가 */
	    margin: 0; /* 기본 마진 제거 */
	}
	
	.topLogo p {
	    margin: 0; /* 기본 마진 제거 */
	    margin-top: 5px; /* h2와 p 간의 간격 조정 */
	    line-height: 1; /* 줄 높이 조정 (필요시) */
	    margin-left: 5px;
	}
</style>
<body>
<div class="menu" >
	<div class="topLogo">
		<h2>AMS</h2><p>Academy Mangement System</p>
	</div>
</div>
</body>
</html>