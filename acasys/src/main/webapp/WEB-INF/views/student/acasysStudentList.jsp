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
	    margin: 0; 
	    background-color: #f9f9f9;
	    display: flex; 
	    justify-content: center; 
	    align-items: center; 
	    height: 100vh; 
	    overflow: hidden; 
	}

	.search-container {
	    margin-bottom: 10px; 
	    display: flex; 
	    align-items: center; 
	}
	
	.wrapper {
	    width: 100%;
	    max-width: 1200px;
	    display: flex;
	    flex-direction: column;
	}

    #studenNmSearch {
        padding: 10px;
        height: 18px; 
        width: 200px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-right: 5px; 
    }

    #searchBtn {
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        background-color: #28a745;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s;
        height: 40px; 
        margin-right: 5px;
    }

    #searchBtn:hover {
        background-color: #218838;
    }

    .count-info {
        margin-top: 10px; 
        text-align: right; 
        font-weight: bold;
        margin-right: auto; 
    }
	
	table {
	    width: 100%;
	    border-collapse: collapse;
	    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	}
	
	.table-container {
	    height: 250px; /* 고정 높이 설정 */
	    overflow-y: auto; /* 세로 스크롤 추가 */
	    margin-top: 5px; /* 상단 여백 추가 */
	}
	
	.table-container-sub {
	    height: 250px; /* 고정 높이 설정 */
	    overflow-y: auto; /* 세로 스크롤 추가 */
	    margin-top: 5px; /* 상단 여백 추가 */
	}
	
	thead {
	    background-color: #f2f2f2; /* 헤더 배경 색상 */
	    position: sticky; /* 스크롤 시 헤더 고정 */
	    top: 0; /* 스크롤 최상단에 위치 */
	    z-index: 10; /* 다른 요소보다 위에 위치하도록 설정 */
	}

	th {
	    padding: 10px;
	    text-align: center;
	    border: 1px solid #ddd;
	}
	
	td {
	    padding: 10px;
	    text-align: left;
	    border: 1px solid #ddd;
	}
	
	.tbBtn {
		text-align: center;
	}

	th {
	    background-color: #f2f2f2;
	    color: #333;
	}

	tr:hover {
	    background-color: #f1f1f1;
	}	

	.no-data {
	    text-align: center;
	    font-weight: bold;
	    color: #888;
	}

    .admin-message {
        margin-left: auto; 
        margin-right: 5px;
    }

    .button-container {
        display: flex; 
        justify-content: flex-end; 
        margin-top: 10px; 
    }

    #registBtn, #delBtn, #logOutBtn,#registScoreBtn {
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

    #registBtn {
        background-color: #007bff; 
        color: white;
    }

    #registBtn:hover {
        background-color: #0056b3; 
    }

    #delBtn {
        background-color: #dc3545; 
        color: white;
    }

    #delBtn:hover {
        background-color: #c82333; 
    }

    .selected {
        background-color: #e2e6ea; /* 선택된 행의 배경색 */
    }
    
	#detailBtn {
	    background: none; /* 배경색 없음 */
	    border: none; /* 테두리 없음 */
	    color: inherit; /* 부모 요소의 글자 색상 상속 */
	    font: inherit; /* 부모 요소의 폰트 스타일 상속 */
	    cursor: pointer; /* 커서 포인터 */
	    padding: 0; /* 패딩 없음 */
	    margin: 0; /* 마진 없음 */
	}
	
    #detailBtn:hover {
        color: blue;
        border-bottom: 1px solid blue;
    }
	
    .details-table {
        margin-top: 20px; /* 상단 여백 추가 */
        width: 100%;
        border-collapse: collapse;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    .details-table th, .details-table td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
    }

    .details-table th {
        background-color: #f2f2f2;
        color: #333;
    }

    .details-table .no-data {
        text-align: center;
        font-weight: bold;
        color: #888;
    }
    
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
    	
        $("#adminPw").on("keypress", function(event) { 
            if(event.keyCode == 13) {
                fn_searchNm();
            }
        });
        
        $('#searchBtn').on('click', function () {
            fn_searchNm();
        });
        
    	$("#studenNmSearch").on('keypress', function(event) { 
       		if(event.keyCode == 13) {
       			fn_searchNm();
    		}
    	});
        
        $('#logOutBtn').on('click', function () {
            location.href = '/login/acasyslogout.do';
        });
        
        
        $('#registBtn').on('click', function () {
        	 location.href = '/student/acasysStudentRegist.do';
        });
        
        $('#delBtn').on('click', function () {
        	
            var selectedRow = $('#studentInfoTbody tr.selected');
            
            if (selectedRow.length > 0) {

                var studentNo = selectedRow.find('td:first').text();
				
                var result = confirm("정말 삭제하시겠습니까?");
                
                if(result) {
                	
       	        var param = {
       	        		studentNo : studentNo
       		        };
       		
    			$.ajax({
  						url : '/student/acasysStudentDelProc.do',
  						type : 'POST',
  						data : param,
  						dataType : "json",
  						success : function(response) {
  							if ( response.status === 'success') {
  								alert('삭제 을(를) 성공하였습니다.');
  							 	window.location.href = '/student/acasysStudetnList.do';
  							} else {
  								alert('삭제 을(를) 실패하였습니다.');
  							}
  						},
  						error : function(xhr, status, error) {
  							alert('서버 오류가 발생했습니다.');
  							return;
  						}
     				});
                	
                }
                
            } else {
            	alert('학생을 선택후 삭제해주세요.');  
            }

        });
        
        $('#studentInfoTbody tr').on('click', function (event) {
        	
            const clickedRow = $(this);
            var studentNo = clickedRow.find('td:first').text();
			
            fn_searchScore(studentNo)
            
        });
        
        // 행 클릭 이벤트 추가
        $('tbody').on('click', 'tr', function() {
            $(this).toggleClass('selected').siblings().removeClass('selected');
        });
        
    });
    
    function fn_searchNm() {
        var studenNmSearchVal = $('#studenNmSearch').val();
        var param = {
            studenNmSearch: studenNmSearchVal
        };

        $.ajax({
            url: '/student/acasysStudetnListSearch.do', 
            type: 'POST',
            data: param,
            dataType: "json",
            success: function(response) {
                var count = response.count;
                var data = response.studentSerachList;

                $('.count-info').text('총 ' + count + ' 건');
                $('#studentInfoTbody').empty();   

                if (data === "E") {
                    $('#studenNmSearch').val('');
                    $('#studenNmSearch').focus();
                    var rows = '<tr><td colspan="9" class="no-data">조회된 데이터가 없습니다.</td></tr>';
                    $('#studentInfoTbody').append(rows);
                    return;
                } else {
                    var rows = '';
                    for (var i = 0; i < data.length; i++) {
                        var student = data[i];
                        rows += '<tr>';
                        rows += '<td hidden>' + student.studentNo + '</td>';
                        rows += '<td>';
                        rows += '<form action="/student/acasysStudentDetail.do" method="post" style="display: inline;">';
                        rows += '<input type="hidden" name="studentNo" value=' + student.studentNo + '>';
                        rows += '<button type="submit" id="detailBtn">' + student.studentName + '</button>';  
                        rows +=	'</form>';
                        rows +=	'</td>';
                        rows += '<td>' + student.studentAge + '</td>';
                        rows += '<td>' + student.studentPhone + '</td>';
                        rows += '<td>' + student.studentMiddleSchool + '</td>';
                        rows += '<td>' + student.studentHighSchool + '</td>';
                        rows += '<td>' + student.studentSchoolGubunNm + '</td>';
                        rows += '<td>' + student.studentSchoolMajorNm + '</td>';
                        rows += '<td>' + student.studentTierStatusNm + '</td>';
                        rows += '</tr>';
                    }
                    $('#studentInfoTbody').append(rows);
                }
            },
            error: function(xhr, status, error) {
                alert('검색 중 오류가 발생했습니다.');
            }
        });
    }
    
    function fn_searchScore(studentNo) {

        var param = {
        		studentNo: studentNo
        };

        $.ajax({
            url: '/student/acasysStudentScoreSearch.do', 
            type: 'POST',
            data: param,
            dataType: "json",
            success: function(response) {
            	
                var data = response.studentScore; 
                var termData = response.termCd;
                           
           	 	$('#studentScoreTbody').empty();
                 
                if (data === "E") {
					
                    var rows = '<tr><td colspan="9" class="no-data">조회된 데이터가 없습니다.</td></tr>';
                    $('#studentScoreTbody').append(rows);
                    
                    $('#addRowBtn').on('click' , function()  {
                    	fn_addRow(termData);
                    });
                    
                    $('#registScoreBtn').on('click' , function()  {
                    	fn_regiScore();
                    });

                } else {
	
                    var rows = '';
                    for (var i = 0; i < data.length; i++) {
                        var studentScore = data[i];
                        rows += '<tr>';
                        rows += '<td hidden><input id="stuentNo" type="text" value=' + studentScore.studentNo +'></td>';
                        rows += '<td hidden><input id="stuentName" type="text" value=' + studentScore.studentName +'></td>';
                        rows += '<td hidden><input id="scoreNo" type="text" value=' + studentScore.scoreNo +'></td>';
                        rows += '<td><input id="startDate" type="date" value=' + studentScore.startDate +'></td>';
                        rows += '<td><input id="endDate" type="date" value=' + studentScore.endDate +'></td>';
		                rows += '<td><select id="termCd">';
		                for (var j = 0; j < termData.length; j++) {
		                    var term = termData[j];
		                    var selected = (term.cd === studentScore.termCd) ? 'selected' : '';
		                    rows += '<option value="' + term.cd + '" ' + selected + '>' + term.cdNm + '</option>';
		                }
		                rows += '</select></td>';
                        rows += '<td><input id="korean" type="text" value=' + studentScore.korean +'></td>';
                        rows += '<td><input id="math" type="text" value=' + studentScore.math +'></td>';
                        rows += '<td><input id="english" type="text" value=' + studentScore.english +'></td>';
                        rows += '<td><input id="society" type="text" value=' + studentScore.society +'></td>';
                        rows += '<td><input id="history" type="text" value=' + studentScore.history +'></td>';
                        rows += '<td><input id="science" type="text" value=' + studentScore.science +'></td>';
                        rows += '<td hidden><input id="gubunVal" type="text" value="update"></td>'; 
                        rows += '</tr>';
                    }
                    
                    $('#studentScoreTbody').append(rows);
                    
                    $('#addRowBtn').on('click' , function()  {
                    	fn_addRow(termData);
                    });
                    
                    $('#delRowBtn').on('click' , function()  {         	
                    	$('#studentScoreTbody tr:last').remove();
                    });
                    
                    $('#registScoreBtn').on('click' , function()  {
                    	fn_regiScore();
                    });
                    
                }
            },
            error: function(xhr, status, error) {  
                alert('서버 오류가 발생했습니다.');
            }
        });
    }
    
    function fn_regiScore() {
    	
    	var scoresList = [];
    	
    	// tbody의 모든 행을 순회
        $('#studentScoreTbody tr').each(function() {
            var studentNo = $(this).find('input[id="stuentNo"]').val();
            var studentName = $(this).find('input[id="stuentName"]').val();
            var startDate = $(this).find('input[id="startDate"]').val();
            var endDate = $(this).find('input[id="endDate"]').val();
            var termCd = $(this).find('select[id="termCd"]').val();
            var korean = $(this).find('input[id="korean"]').val();
            var math = $(this).find('input[id="math"]').val();
            var english = $(this).find('input[id="english"]').val();
            var society = $(this).find('input[id="society"]').val();
            var history = $(this).find('input[id="history"]').val();
            var science = $(this).find('input[id="science"]').val();
            var gubunVal = $(this).find('input[id="gubunVal"]').val(); 
            var scoreNo = $(this).find('input[id="scoreNo"]').val(); 
		
            // 각 행의 데이터를 객체로 만들어 scores 배열에 추가
            scoresList.push({
                studentNo: studentNo,
                studentName: studentName,
                startDate: startDate,
                endDate: endDate,
                termCd: termCd,
                korean: korean,
                math: math,
                english: english,
                society: society,
                history: history,
                science: science,
                gubunVal: gubunVal,
                scoreNo: scoreNo
            });
        });
    	
        var param = {
        		scoresList : scoresList
	        };
	        
        console.log(param);

		$.ajax({
					url : '/student/acasysStudentScoreRegistProc.do',
					type : 'POST',
				    contentType: 'application/json', // JSON 형식으로 전송
				    data: JSON.stringify(param), // 데이터를 JSON 문자열로 변환 
					success : function(response) {
						if ( response.status === 'success') {
							alert('성적 등록 을(를) 성공하였습니다.');
						} else {
							alert('성적 등록 을(를) 실패하였습니다.');
						}
					},
					error : function(xhr, status, error) {
						alert('서버 오류가 발생했습니다.');
						return;
					}
		});

    }
    
    
    function fn_addRow(termData) {
    	
    	$('#studentScoreTbody .no-data').remove();
    	
    	//선택한 행 넘버 값
    	var selectedRow = $('#studentInfoTbody tr.selected');
        var studentNo = selectedRow.find('td:first').text();
        var studentName = selectedRow.find('td:nth-child(2)').text(); // 두 번째 셀의 값
        
        // 새로운 행을 추가하기 위한 HTML 문자열 초기화
        var newRow = '<tr>';
        newRow += '<td hidden><input id="stuentNo" type="text" value='+ studentNo +'></td>'; // 학생 번호 입력란
        newRow += '<td hidden><input id="stuentName" type="text" value=' + studentName + '></td>'; // 학생 이름 입력란
        newRow += '<td><input id="startDate" type="date"></td>'; // 시작 날짜 입력란
        newRow += '<td><input id="endDate" type="date"></td>'; // 종료 날짜 입력란
        newRow += '<td><select id="termCd">'; // 학기 선택
        for (var j = 0; j < termData.length; j++) {
            var term = termData[j];
            newRow += '<option value="' + term.cd + '">' + term.cdNm + '</option>';
        }
        newRow += '</select></td>';
        newRow += '<td><input id="korean" type="text"></td>'; // 국어 점수 입력란
        newRow += '<td><input id="math" type="text"></td>'; // 수학 점수 입력란
        newRow += '<td><input id="english" type="text"></td>'; // 영어 점수 입력란
        newRow += '<td><input id="society" type="text"></td>'; // 사회 점수 입력란
        newRow += '<td><input id="history" type="text"></td>'; // 역사 점수 입력란
        newRow += '<td><input id="science" type="text"></td>'; // 과학 점수 입력란 
        newRow += '<td hidden><input id="gubunVal" type="text" value="insert"></td>'; // 과학 점수 입력란
        newRow += '</tr>';

        // 생성된 행을 tbody에 추가
        $('#studentScoreTbody').append(newRow);
        
    }
</script>
</head>
<body>
<div class="wrapper">
    <div class="search-container">
        <input type="text" id="studenNmSearch" placeholder="이름">
        <button type="button" id="searchBtn">검색</button>
        <div class="count-info">총 ${count} 건</div>
        <span class="admin-message">${adminId} 님 반갑습니다.</span>
        <button type="button" id="logOutBtn">로그아웃</button>
    </div>
 	<div class="table-container">
	    <table>
	        <thead>
	            <tr>
	                <th>이름</th>
	                <th>나이</th>
	                <th>휴대폰</th>
	                <th>중학교</th>
	                <th>고등학교</th>
	                <th>계열</th>
	                <th>전공</th>
	                <th>성적상태</th>
	            </tr>
	        </thead>
	        <tbody id="studentInfoTbody">
	            <c:choose>
	                <c:when test="${not empty studentList}">
	                    <c:forEach var="student" items="${studentList}">
	                        <tr>
	                            <td hidden>${student.studentNo}</td>
						        <td class="tbBtn">
						            <form action="/student/acasysStudentDetail.do" method="post" style="display: inline;">
						                <input type="hidden" name="studentNo" value="${student.studentNo}">
						                <button type="submit" id="detailBtn">
						                    ${student.studentName}
						                </button>
						            </form>
						        </td>
	                            <td>${student.studentAge}</td>
	                            <td>${student.studentPhone}</td>
	                            <td>${student.studentMiddleSchool}</td>
	                            <td>${student.studentHighSchool}</td>
	                            <td>${student.studentSchoolGubunNm}</td>
	                            <td>${student.studentSchoolMajorNm}</td>
	                            <td>${student.studentTierStatusNm}</td> 
	                        </tr>  
	                    </c:forEach>
	                </c:when>
	                <c:otherwise>
	                    <tr>
	                        <td colspan="9" class="no-data">조회된 데이터가 없습니다.</td>
	                    </tr>
	                </c:otherwise>
	            </c:choose>
	        </tbody>
	    </table>
	</div> 
	<div class="button-container">
	    <button type="button" id="registBtn">학생등록</button>
	    <button type="button" id="delBtn">삭제</button>
	</div>
    
	<div class="button-container">
	 	<button type="button" id="addRowBtn">+</button>
		<button type="button" id="delRowBtn">-</button>
	</div>
   <!-- 아래쪽에 세부정보 테이블 추가 -->
   <div class="table-container-sub">
        <table class="details-table">
            <thead>
                <tr>
                    <th>시작날짜</th>
                    <th>종료날짜</th>
                    <th>학기</th>
                    <th>국어</th>
                    <th>수학</th>
                    <th>영어</th>
                    <th>사회</th>
                    <th>역사</th>
                    <th>과학</th>
                </tr>
            </thead>
            <tbody id="studentScoreTbody">
				<tr><td colspan="11" class="no-data">조회된 데이터가 없습니다.</td></tr>
            </tbody>
        </table>
    </div>
    <div class="button-container">
    	<button type="button" id="registScoreBtn">성적확인</button>
    </div>
</div>
</body>
</html>