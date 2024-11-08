<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
</script>
<style>
    /* 전체 페이지에서 스크롤을 없앰 */
    html, body {
        margin: 0;
        padding: 0;
        height: 100%;
        overflow: hidden;  /* 스크롤을 없앰 */
    }
    
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
    }    
    
	.wrapper {
	    width: 100%;
	    max-width: 1200px; /* 최대 너비 */
	    display: flex;
	    flex-direction: column;
	    margin-left: 250px; /* left-menu 너비 만큼 공간을 둡니다 */
	}
	
</style>
<body>
<%@ include file="../inc/header.jsp"%>
<%@ include file="../inc/left.jsp"%> 
<div class="wrapper">
	<h2>코드리스트</h2>
</div>
<%@ include file="../inc/footer.jsp"%>
</body>
</html>