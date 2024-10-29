<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>빵승의 국어 여행</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .login-container {
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
        width: 300px;
        text-align: center;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    input[type="text"], input[type="password"] {
        width: 90%; /* 전체 너비 사용 */
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        height: 30px; /* 높이 조정 */
        margin-bottom: 10px; /* 아래쪽 간격 추가 */
    }

    #loginBtn {
        padding: 10px;
        border: none;
        border-radius: 5px;
        background-color: #28a745;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s;
        width: 98%;    
        height: 40px;
    }

    #loginBtn:hover {
        background-color: #218838;
    }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
    	
        $('#loginBtn').click(function() {
        	fn_lognProc()
        });
        
    	$("#adminPw").on("keypress", function(event) { 
       		if(event.keyCode == 13) {
    			fn_lognProc()
    		}
    	});
        
    });
	
    function fn_lognProc () {
    	
    	 var idVal = $("#adminId").val();
         var pwVal = $("#adminPw").val();

         if (idVal === '') {
             alert('아이디를 입력하세요.');
             $("#adminId").focus();
             return;
         }

         if (pwVal === '') {
             alert('비밀번호를 입력하세요.');
             $("#adminPw").focus();
             return;
         }

         var param = {
				                adminId: idVal,
				                adminPw: pwVal
				              };

         $.ajax({
             url: '/login/acasysLogin.do',
             type: 'POST',
             data: param,
             dataType: "json",
             success: function(data) {
                 var rtn = data.result;
                 if (rtn === 'S') {
                     alert('로그인에 성공하셨습니다.');
                     window.location.href = '/student/acasysStudetnList.do';
                 } else if (rtn === 'F') {
                     $("#adminId").val('');
                     $("#adminPw").val('');
                     alert('로그인에 실패 : 아이디, 비밀번호(을)를 다시 확인하세요.');
                     $('#adminId').focus();
                     return;
                 }
             },
             error: function(xhr, status, error) {
                 alert('로그인 중 오류가 발생했습니다.');
             }
         });
    }
    
</script>
</head>
<body>
    <div class="login-container">
        <h2>빵승의 국어 여행</h2>
        <input id="adminId" name="adminId" type="text" placeholder="아이디" value="">
        <input id="adminPw" name="adminPw" type="password" placeholder="비밀번호" value=""> 
        <button type="button" id="loginBtn">로그인</button>
    </div>    
</body>
</html>