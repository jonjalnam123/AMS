<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AMS Academy Mangement System</title>
<style>
	body {
	    font-family: Arial, sans-serif;
	    margin: 0; /* Change margin to 0 to avoid overflow */
	    background-color: #f9f9f9;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    height: 100vh;
	    overflow: hidden; /* Prevent scrolling */
	}

	.form-container {
	    width: 80%;
	    max-width: 600px;
	    background-color: white;
	    padding: 20px;
	    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	    border-radius: 8px;
	    overflow: auto; /* Allow scrolling within the container if needed */
	    max-height: 100vh; /* Set a maximum height */ 
	}

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
        color: #333;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

	textarea {
	    width: 100%;    
	    height: 60px;
	    resize: none;
	    padding: 10px;
	    border: 1px solid #ccc;
	    border-radius: 5px;
	    font-family: Arial, sans-serif;
	    box-sizing: border-box; /* Added to maintain consistent sizing */
	}

    input[type="text"], input[type="number"], select {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-family: Arial, sans-serif;
        margin-top: 5px;
        box-sizing: border-box; /* Added to prevent overflow */
    }

    input[type="number"] {
        -moz-appearance: textfield; /* Firefox */
    }

    input[type="number"]::-webkit-inner-spin-button,
    input[type="number"]::-webkit-outer-spin-button {
        -webkit-appearance: none; /* Chrome, Safari */
        margin: 0;
    }

    .button-container {
        display: flex; 
        justify-content: flex-end; 
        margin-top: 20px; 
    }

    button {
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
        height: 40px; 
        margin-left: 5px;
    }

    #registBtn {
        background-color: #007bff; 
        color: white;
    }

    #registBtn:hover {
        background-color: #0056b3; 
    }

    #toListBtn {
        background-color: #28a745; 
        color: white;
    }

    #toListBtn:hover {
        background-color: #218838; 
    }

    .required {
        color: red;
    }
    
    #studentPostCd {
    width: 70%; 
    display: inline-block; 
	}

	#postBtn {
	    width: 25%;
	    margin-left: 5px;
	    background-color: #007bff; 
	    color: white; 
	    border: none; 
	    border-radius: 5px;
	    cursor: pointer;
	    transition: background-color 0.3s;
	    height: 30px;
	}
	
	#postBtn:hover {
	    background-color: #0056b3;
	}
    
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
<script type="text/javascript">
$(document).ready(function() {	
    $('#toListBtn').on('click', function() {
        location.href = '/student/acasysStudetnList.do';
    });
	
    $('#registBtn').on('click', function() {

		if ( fn_valiCheck() ) {
			
	        var param = {
	            studentName : $('#studentName').val(),
	            studentAge : $('#studentAge').val(),
	            studentPhone : $('#studentPhone').val(),
	            studentMiddleSchool : $('#studentMiddleSchool').val(),
	            studentHighSchool : $('#studentHighSchool').val(),
	            studentSchoolGubunCd : $('#studentSchoolGubunCd').val(),
	            studentSchoolMajorCd : $('#studentSchoolMajorCd').val(),
	            studentTierStatusCd : $('#studentTierStatusCd').val(),
	            studentPostCd : $('#studentPostCd').val(),
	            studentAdd : $('#studentAdd').val(),
	            studentAddDetail : $('#studentAddDetail').val(),
	            studentNote : $('#studentNote').val()
	        };
	
			$.ajax({
					url : '/student/acasysStudentRegistProc.do',
					type : 'POST',
					data : param,
					dataType : "json",
					success : function(response) {
						if ( response.status === 'success') {
							alert('등록 을(를) 성공하였습니다.');
						 	window.location.href = '/student/acasysStudetnList.do';
						} else {
							alert('등록 을(를) 실패하였습니다.');
						}
					},
					error : function(xhr, status, error) {
						alert('서버 오류가 발생했습니다.');
						return;
					}
				});
			
    		}
		
		});
    
	});

	//다음 우편번호API
	function fn_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						var addr = '';
						var extraAddr = '';
						if (data.userSelectedType === 'R') {
							addr = data.roadAddress;
						} else {
							addr = data.jibunAddress;
						}
						if (data.userSelectedType === 'R') {
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							document.getElementById("studentAddDetail").value = extraAddr;
						} else {
							document.getElementById("studentAddDetail").value = '';
						}
						document.getElementById('studentPostCd').value = data.zonecode;
						document.getElementById("studentAdd").value = addr;
						document.getElementById("studentAddDetail").focus();
					}
				}).open();
	}

	//입력길이제한
	function fn_validateInput(input, inputId) {
		
		if ( inputId === 'studentAge') {
			if (input.value.length > 2) {
				input.value = input.value.slice(0, 2);
			}
		}
		
		if ( inputId === 'studentPhone') {
			if (input.value.length > 11) {
				input.value = input.value.slice(0, 11);
			}
		}
	}
	
	//입력체크
	function fn_valiCheck() {
		
		var studentName = $('#studentName').val()
		var studentAge = $('#studentAge').val()
		var studentPhone = $('#studentPhone').val()
		
		if ( studentName === '' ) {
			alert('학생 이름 을(를) 입력해주세요.');
			$('#studentName').focus();
			return false;
		}
		
		if ( studentAge === '' ) {
			alert('학생 나이 을(를) 입력해주세요.');
			$('#studentAge').focus();
			return false;
		}
		
		if ( studentAge === '' ) {
			alert('학생 핸드폰 을(를) 입력해주세요.');
			$('#studentPhone').focus();
			return false;
		}
		
		return true;
	}
	
</script>
</head>
<body>

    <div class="form-container">
        <table>
            <thead>
                <tr>
                    <th>항목</th>
                    <th>입력</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>이름<span class="required">*</span></td>
                    <td><input id="studentName" type="text" placeholder="이름 입력" maxlength="7"></td>
                </tr>
                <tr>
                    <td>나이<span class="required">*</span></td>
                    <td><input id="studentAge" type="number" oninput="fn_validateInput(this, this.id)" placeholder="나이 입력"></td>
                </tr>
                <tr>
                    <td>휴대폰<span class="required">*</span></td>
                    <td><input id="studentPhone" type="number" oninput="fn_validateInput(this, this.id)" placeholder="휴대폰 입력"></td>
                </tr>
                <tr>
                    <td>중학교</td>
                    <td><input id="studentMiddleSchool" type="text" placeholder="중학교 입력" maxlength="10"></td>
                </tr>
                <tr>
                    <td>고등학교</td>
                    <td><input id="studentHighSchool" type="text" placeholder="고등학교 입력" maxlength="10"></td>
                </tr>
                <tr>
                    <td>계열</td>
                    <td>
                        <select id="studentSchoolGubunCd">
                            <c:forEach var="schoolGubun" items="${schoolGubunCd}">
                                <option value="${schoolGubun.cd}">${schoolGubun.cdNm}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>전공</td>
                    <td>
                        <select id="studentSchoolMajorCd">
                            <c:forEach var="schoolMajor" items="${schoolMajorCd}">
                                <option value="${schoolMajor.cd}">${schoolMajor.cdNm}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>성적상태</td>
                    <td>
                        <select id="studentTierStatusCd">
                            <c:forEach var="tier" items="${tierCd}">
                                <option value="${tier.cd}">${tier.cdNm}</option> 
                            </c:forEach>
                        </select>         
                    </td>
                </tr>
                <tr>
                    <td>우편번호</td>
                    <td>
                        <input id="studentPostCd" type="text" placeholder="우편번호 입력" readonly>
                        <input id="postBtn" type="button" onclick="fn_execDaumPostcode()" value="우편번호 찾기">
                    </td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input id="studentAdd" type="text" placeholder="주소 입력" readonly></td>
                </tr>
                <tr>
                    <td>상세주소</td>
                    <td><input id="studentAddDetail" type="text" placeholder="상세주소 입력" maxlength="30"></td>
                </tr>
                <tr>
                    <td>비고</td>
                    <td><textarea id="studentNote" maxlength="333" placeholder="비고 입력"></textarea></td>
                </tr>
            </tbody>
        </table>
        <div class="button-container">
            <button type="button" id="registBtn">등록</button>
            <button type="button" id="toListBtn">목록</button>
        </div>
    </div>
</body>
</html>