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
	    height: 255px; /* 고정 높이 설정 */         
	    overflow-y: auto; /* 세로 스크롤 추가 */
	    margin-top: 5px; /* 상단 여백 추가 */  
	}
	
	.table-container-sub {
	    height: 275px; /* 고정 높이 설정 */       
	    overflow-y: auto; /* 세로 스크롤 추가 */
	    margin-top: 3px; /* 상단 여백 추가 */  
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
  	    background-color: #f2f2f2;
	    color: #333;
	}
	
	td {
	    padding: 10px;
	    text-align: left;
	    border: 1px solid #ddd;
	}
	
	.tbBtn {
		text-align: center;
	}

	#studentInfoTbody tr:hover {
	    background-color: #f1f1f1;
	}	
	
	#studentScoreTbody input[type="number"], #studentScoreTfoot input[type="number"] {
	    background-color: transparent; /* 배경색 투명 */
	    border: none; /* 테두리 없음 */
	    outline: none; /* 포커스 시 테두리 없음 */
	    width: auto; /* 필요에 따라 너비 조정 */
	}
	
	#studentScoreTbody input[type="text"], #studentScoreTfoot input[type="text"] {
	    background-color: transparent; /* 배경색 투명 */
	    border: none; /* 테두리 없음 */
	    outline: none; /* 포커스 시 테두리 없음 */
	    width: auto; /* 필요에 따라 너비 조정 */
	}
		
		/* 스피너 숨기기 */
	#studentScoreTbody input[type="number"]::-webkit-inner-spin-button,
	#studentScoreTbody input[type="number"]::-webkit-outer-spin-button {
	    -webkit-appearance: none; /* Chrome, Safari, Edge */
	    margin: 0; /* 여백 없애기 */
	}
	
	tfoot {
	    position: sticky;
	    bottom: 0;
	    background-color: #f2f2f2;
	    z-index: 1; /* 다른 요소 위에 표시 */
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

    .button-container{
        display: flex; 
        justify-content: flex-end; 
        margin-top: 10px;   
    }
    
    
    .button-container-l {
        display: flex; 
        justify-content: flex-start;
        margin-top: 10px; 
    }

    #registBtn, #delBtn, #logOutBtn,#registScoreBtn,#delScoreBtn {
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

    #registBtn, #registScoreBtn {
        background-color: #007bff; 
        color: white;
    }
    
    #addRowBtn, #excelBtn {
    	height: 35px;  
   	 	padding: 10px 15px;  
    	border: none;
    	cursor: pointer;
    	margin-right: 5px;
     	border-radius: 5px;
        background-color: #28a745; 
        color: white;
    }

    #registBtn:hover, #registScoreBtn:hover {
        background-color: #0056b3; 
    }

    #delBtn, #delScoreBtn {
        background-color: #dc3545; 
        color: white;
    }

    #delBtn:hover, #delScoreBtn:hover {
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
	    width: 80px; /* 모든 열의 너비를 80px로 설정 */
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

	var check = 0; // 행 추가시 체크사항
    var studentNo; // 전역 변수
    var avgKorean, avgMath, avgEnglish, avgSociety, avgHistory, avgScience;

    $(document).ready(function() {

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
            
            fn_searchScore(studentNo);

            // 전체 선택 체크박스 해제
            $('#selectAll').prop('checked', false);
        });
        
        $('#registScoreBtn').on('click' , function()  {
        	
            var trCnt = $("#studentScoreTbody tr").length;
            var noDataVal = $("#studentScoreTbody tr td").attr('class');
            var hasError = false;
            
			if ( check === 0 ) {
				alert('학생을(를) 선택 후 등록 해주세요.');
				return;
			} 
			
            if (trCnt <= 1 && noDataVal === 'no-data') {
            	alert('등록할 성적이 없습니다.');
            	return;
            }
            
            $("#studentScoreTbody tr").each(function() {
                var startDateInput = $(this).find("input[type='date'][id='startDate']");
                var endDateInput = $(this).find("input[type='date'][id='endDate']");
                var startDate = $('#startDate').val()
                var endDate = $('#endDate').val() 
                var startDateVal = startDateInput.val();
                var endDateVal = endDateInput.val();

				if ( startDateVal !== undefined ) {
	                if (!startDateVal) {
	                    alert('시작날짜 (을)를 입력해주세요.');
	                    startDateInput.focus();
	                    hasError = true;
	                    return false;
	                }
				} else {
	                if ( startDate === '' ) {
	                    alert('시작날짜 (을)를 입력해주세요.');
	                    $('#startDate').focus();
	                    hasError = true;
	                    return false;
	                }
				}

				
				if ( endDateVal !== undefined ) {
	                if (!endDateVal) {
	                    alert('종료날짜 (을)를 입력해주세요.');
	                    endDateInput.focus();
	                    hasError = true;
	                    return false;
	                }
				}else {
	                if ( endDate === '' ) {
	                    alert('종료날짜 (을)를 입력해주세요.');
	                    $('#endDate').focus();
	                    hasError = true;
	                    return false;
	                }
				}

				if ( startDateVal !== undefined && endDateVal !== undefined ) {
	                if (startDateVal > endDateVal) {
	                    alert('종료날짜는 시작날짜보다 늦어야 합니다.');
	                    startDateInput.focus();
	                    hasError = true;
	                    return false;
	                }
				}else{
	                if (startDate > endDate) {
	                    alert('종료날짜는 시작날짜보다 늦어야 합니다.');
	                    $('#endDate').focus();
	                    hasError = true;
	                    return false;
	                }
				}
            });
            
            // 에러가 발생한 경우 추가 작업을 하지 않음
            if (hasError) return;

        	fn_regiScore();
        	
        });

        $('#delScoreBtn').on('click', function() {
        	
            var trCnt = $("#studentScoreTbody tr").length;
            var noDataClass = $("#studentScoreTbody tr td").attr('class');
			
            if (trCnt <= 1 && noDataClass === 'no-data') {
            	alert('삭제할 성적이 없습니다.');
            	return;
            }
        	
            
            var result = confirm("정말 삭제하시겠습니까?");
            
            if(result) {
            
	            // 체크된 체크박스 가져오기
            	var checkedRows = $('#studentScoreTbody input.student-checkbox:checked');
	            
	            // 체크된 체크박스가 없으면 알림
	            if (checkedRows.length === 0) {
	                alert("삭제할 성적 을(를) 체크해주세요.");
	                return;
	            }
	            
	            // 삭제할 학생 정보 저장할 배열
	            var studentsToDelete = [];
	
	            // 체크된 각 행에 대해 반복
	            checkedRows.each(function() {
	                var row = $(this).closest('tr'); // 체크박스의 부모 행 찾기
	                var scoreNo = row.find('input#scoreNo').val(); // scoreNo 가져오기
	                var studentNo = row.find('input#stuentNo').val(); // studentNo 가져오기
	                var studentName = row.find('input#stuentName').val(); // studentName 가져오기
	                
					if ( scoreNo === undefined ) {
						$(this).closest('tr').remove();
						return;
					}
	                
	                // 학생 정보를 배열에 추가
	                studentsToDelete.push({
	                    scoreNo: scoreNo,
	                    studentNo: studentNo,
	                    studentName: studentName
	                });
	            });
	
	            // 화면에서 체크된 행 삭제
	            checkedRows.each(function() {
	                $(this).closest('tr').remove();
	            });

	            var param = {
	            		studentsToDelete : studentsToDelete
	    	        }; 
	
	    		$.ajax({
	    					url : '/student/acasysStudentScoreDelProc.do',
	    					type : 'POST',
	    				    contentType: 'application/json', // JSON 형식으로 전송
	    				    data: JSON.stringify(param), // 데이터를 JSON 문자열로 변환 
	    					success : function(response) {
	    						if ( response.status === 'success') {
	    							alert('성적 삭제 을(를) 성공하였습니다.');
	    							location.reload();
	    						} else {
	    							alert('성적 삭제 을(를) 실패하였습니다.');
	    						}
	    					},
	    					error : function(xhr, status, error) {
	    						alert('서버 오류가 발생했습니다.');
	    						return;
	    					}
	    		});
            }
        });
        
        $('#addRowBtn').on('click' , function()  {
        	
			if ( check === 0 ) {
				alert('학생을(를) 선택 후 행 추가를 해주세요.');
				return;
			} 
			
        	fn_addRow();
        	
        });
        
        // 행 클릭 이벤트 추가
        $('#studentInfoTbody').on('click', 'tr', function() {
            $(this).toggleClass('selected').siblings().removeClass('selected');
        });
		
        //엑셀다운로드
        $("#excelBtn").on("click", function() {
        	
            var excelParam = {
                    studentNo: studentNo,
                    avgKorean: avgKorean,
                    avgMath: avgMath,
                    avgEnglish: avgEnglish,
                    avgSociety: avgSociety,
                    avgHistory: avgHistory,
                    avgScience: avgScience
                };

                // 입력 필드에 값 설정
                $("#studentNo").val(excelParam.studentNo);
                $("#avgKorean").val(excelParam.avgKorean);
                $("#avgMath").val(excelParam.avgMath);
                $("#avgEnglish").val(excelParam.avgEnglish);
                $("#avgSociety").val(excelParam.avgSociety);
                $("#avgHistory").val(excelParam.avgHistory);
                $("#avgScience").val(excelParam.avgScience);

                // 폼 제출
                $("#excelForm").submit();  
            
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
                $('#studentScoreTbody').empty();   
                $('#studentScoreTfoot').empty();   
                
                var rows = '<tr><td colspan="11" class="no-data">조회된 데이터가 없습니다.</td></tr>';
                $('#studentScoreTbody').append(rows);

                if (data === "E") {
                    $('#studenNmSearch').val('');
                    $('#studenNmSearch').focus();
                    var rows = '<tr><td colspan="9" class="no-data">조회된 데이터가 없습니다.</td></tr>';
                    $('#studentInfoTbody').append(rows);
                    return;
                } else {
                    var rows = '';
                    var majorVal
                    for (var i = 0; i < data.length; i++) {          	
                    	
                        var student = data[i];
                    	if ( student.studentSchoolMajorNm === null ) {
                    		schoolMajorVal = '';
                    	} else if ( student.studentSchoolMajorNm !== null ) {
                    		schoolMajorVal = student.studentSchoolMajorNm
                    	}
                        
                        rows += '<tr>';
                        rows += '<td hidden>' + student.studentNo + '</td>';
                        rows += '<td class="tbBtn">';
                        rows += '<form action="/student/acasysStudentDetail.do" method="post" style="display: inline;">';
                        rows += '<input type="hidden" name="studentNo" value=' + student.studentNo + '>';
                        rows += '<button type="submit" id="detailBtn">' + student.studentName + '</button>';  
                        rows +=	'</form>';
                        rows +=	'</td>';
                        rows += '<td style="text-align: center;">' + student.studentAge + ".Lv" + '</td>';
                        rows += '<td style="text-align: center;">' + student.studentPhone + '</td>';
                        rows += '<td>' + student.studentSchool + '</td>';
                        rows += '<td>' + student.studentWantedSchool + '</td>';
                        rows += '<td style="text-align: center;">' + student.studentSchoolGubunNm + '</td>';
                        rows += '<td style="text-align: center;">' + schoolMajorVal + '</td>';
                        rows += '<td style="text-align: center;">' + student.studentTierStatusNm + '</td>';
                        rows += '</tr>';
                    }
                    $('#studentInfoTbody').append(rows);
                    
                    $('#studentInfoTbody tr').on('click', function (event) {
                        const clickedRow = $(this);
                        var studentNo = clickedRow.find('td:first').text();
                        
                        fn_searchScore(studentNo);

                        // 전체 선택 체크박스 해제
                        $('#selectAll').prop('checked', false);
                    });

                }
            },
            error: function(xhr, status, error) {
                alert('검색 중 오류가 발생했습니다.');
            }
        });
    }
    
    function toggleCheckboxes(selectAllCheckbox) {
        // 전체 선택 체크박스의 상태를 가져옵니다.
        var isChecked = $(selectAllCheckbox).is(':checked');
        
        // 모든 학생 체크박스를 선택하거나 해제합니다.
        $('input[type="checkbox"].student-checkbox').prop('checked', isChecked);
    }
    
    function fn_searchScore(studentNoParam) {

    	studentNo = studentNoParam;
    	
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
                check = 1;
                
                avgKorean = '';
                avgMath = '';
                avgEnglish = ''; 
                avgSociety = '';
                avgHistory = '';
                avgScience = '';

                $('#studentScoreTbody').empty();
                $('#studentScoreTfoot').empty(); // tfoot 초기화
                
                if (data === "E") {
                    var rows = '<tr><td colspan="11" class="no-data">조회된 데이터가 없습니다.</td></tr>';
                    $('#studentScoreTbody').append(rows);
					return;
                } else {
                    var rows = '';
                    var totalKorean = 0;
                    var totalMath = 0;
                    var totalEnglish = 0;
                    var totalSociety = 0;
                    var totalHistory = 0;
                    var totalScience = 0;

                    var countKorean = 0;  // 유효한 한국어 점수 개수
                    var countMath = 0;    // 유효한 수학 점수 개수
                    var countEnglish = 0; // 유효한 영어 점수 개수
                    var countSociety = 0; // 유효한 사회 점수 개수
                    var countHistory = 0; // 유효한 역사 점수 개수
                    var countScience = 0; // 유효한 과학 점수 개수

                    for (var i = 0; i < data.length; i++) {
                        var studentScore = data[i];
                        
                        if (studentScore.averageScore === null) {
                            studentScore.averageScore = 0;
                        } 
                        
                        rows += '<tr>';
                        rows += '<td style="text-align: center; width: 60px;"><input type="checkbox" class="student-checkbox"></td>';
                        rows += '<td hidden><input id="stuentNo" type="text" value=' + studentScore.studentNo + '></td>';
                        rows += '<td hidden><input id="stuentName" type="text" value=' + studentScore.studentName + '></td>';
                        rows += '<td hidden><input id="scoreNo" type="text" value=' + studentScore.scoreNo + '></td>';
                        rows += '<td style="text-align: center;"><input id="startDate" type="date" value=' + studentScore.startDate + ' style="width: 100px;"></td>';
                        rows += '<td style="text-align: center;"><input id="endDate" type="date" value=' + studentScore.endDate + ' style="width: 100px;"></td>';
                        rows += '<td style="text-align: center;"><select id="termCd" style="width: 100%;">';
                        for (var j = 0; j < termData.length; j++) {
                            var term = termData[j];
                            var selected = (term.cd === studentScore.termCd) ? 'selected' : '';
                            rows += '<option value="' + term.cd + '" ' + selected + '>' + term.cdNm + '</option>';
                        }
                        rows += '</select></td>';
                        rows += '<td><input id="korean" class="number-input" type="number" min="0" max="100" style="width: 100%;" value=' + studentScore.korean + '></td>';
                        rows += '<td><input id="math" class="number-input" type="number" min="0" max="100" style="width: 100%;" value=' + studentScore.math + '></td>';
                        rows += '<td><input id="english" class="number-input" type="number" min="0" max="100" style="width: 100%;" value=' + studentScore.english + '></td>';
                        rows += '<td><input id="society" class="number-input" type="number" min="0" max="100" style="width: 100%;" value=' + studentScore.society + '></td>';
                        rows += '<td><input id="history" class="number-input" type="number" min="0" max="100" style="width: 100%;" value=' + studentScore.history + '></td>';
                        rows += '<td><input id="science" class="number-input" type="number" min="0" max="100" style="width: 100%;" value=' + studentScore.science + '></td>';
                        rows += '<td style="background-color: #f2f2f2;"><input id="averageScore" type="text" style="width: 100%;" value=' + studentScore.averageScore + '></td>';
                        rows += '<td hidden><input id="gubunVal" type="text" value="update"></td>';
                        rows += '</tr>';
                        
                        // 점수 합계 계산
                        if (studentScore.korean > 0) {
                            totalKorean += parseFloat(studentScore.korean) || 0;
                            countKorean++;
                        }
                        if (studentScore.math > 0) {
                            totalMath += parseFloat(studentScore.math) || 0;
                            countMath++;
                        }
                        if (studentScore.english > 0) {
                            totalEnglish += parseFloat(studentScore.english) || 0;
                            countEnglish++;
                        }
                        if (studentScore.society > 0) {
                            totalSociety += parseFloat(studentScore.society) || 0;
                            countSociety++;
                        }
                        if (studentScore.history > 0) {
                            totalHistory += parseFloat(studentScore.history) || 0;
                            countHistory++;
                        }
                        if (studentScore.science > 0) {
                            totalScience += parseFloat(studentScore.science) || 0;
                            countScience++;
                        }
                    }

                    $('#studentScoreTbody').append(rows);
                    
                    // 평균 계산
                    avgKorean = (countKorean > 0) ? (totalKorean / countKorean).toFixed(2) : 0;
                    avgMath = (countMath > 0) ? (totalMath / countMath).toFixed(2) : 0;
                    avgEnglish = (countEnglish > 0) ? (totalEnglish / countEnglish).toFixed(2) : 0;
                    avgSociety = (countSociety > 0) ? (totalSociety / countSociety).toFixed(2) : 0;
                    avgHistory = (countHistory > 0) ? (totalHistory / countHistory).toFixed(2) : 0;
                    avgScience = (countScience > 0) ? (totalScience / countScience).toFixed(2) : 0;

                    // tfoot에 평균 추가
                    var tfootRows = '<tr>';
                    tfootRows += '<td colspan="4" style="text-align: center;">과목 평균</td>';
                    tfootRows += '<td><input type="text" style="width: 50px;" value="' + avgKorean + '" readonly></td>';
                    tfootRows += '<td><input type="text" style="width: 50px;" value="' + avgMath + '" readonly></td>';
                    tfootRows += '<td><input type="text" style="width: 50px;" value="' + avgEnglish + '" readonly></td>';
                    tfootRows += '<td><input type="text" style="width: 50px;" value="' + avgSociety + '" readonly></td>';
                    tfootRows += '<td><input type="text" style="width: 50px;" value="' + avgHistory + '" readonly></td>';
                    tfootRows += '<td><input type="text" style="width: 50px;" value="' + avgScience + '" readonly></td>';
                    tfootRows += '<td><input type="text" style="width: 50px;" readonly></td>';
                    tfootRows += '</tr>';

                    $('#studentScoreTfoot').append(tfootRows);

                    // 최대 자리수와 값 범위 제한
                    $('.number-input').on('input', function() {
                        // 최대 3자리로 제한
                        if ($(this).val().length > 3) {
                            $(this).val($(this).val().slice(0, 3));
                        }
                        
                        // 입력값이 최소 0 최대 100을 초과하지 않도록 설정
                        let value = parseInt($(this).val(), 10);
                        if (value < 0) {
                            $(this).val(0); // 최소값 0
                        } else if (value > 100) {
                            $(this).val(100); // 최대값 100
                        }
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

		$.ajax({
					url : '/student/acasysStudentScoreRegistProc.do',
					type : 'POST',
				    contentType: 'application/json', // JSON 형식으로 전송
				    data: JSON.stringify(param), // 데이터를 JSON 문자열로 변환 
					success : function(response) {
						if ( response.status === 'success') {
							alert('성적 등록 을(를) 성공하였습니다.');
							location.reload();
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
    
    
    function fn_addRow() {
		
    	var termData = ${termCd};
    	$('#studentScoreTbody .no-data').remove();
    	
    	//선택한 행 넘버 값
    	var selectedRow = $('#studentInfoTbody tr.selected');
        var studentNo = selectedRow.find('td:first').text();
        var studentName = selectedRow.find('td:nth-child(2)').text(); // 두 번째 셀의 값
        
        // 새로운 행을 추가하기 위한 HTML 문자열 초기화
        var newRow = '<tr>';
        newRow += '<td style="text-align: center; width: 60px;"><input type="checkbox" class="student-checkbox"></td>'; // 체크박스 추가
        newRow += '<td hidden><input id="stuentNo" type="text" value='+ studentNo +'></td>'; // 학생 번호 입력란
        newRow += '<td hidden><input id="stuentName" type="text" value=' + studentName + '></td>'; // 학생 이름 입력란
        newRow += '<td style="text-align: center;"><input id="startDate" type="date" style="width: 100px;"></td>'; // 시작 날짜 입력란
        newRow += '<td style="text-align: center;"><input id="endDate" type="date" style="width: 100px;"></td>'; // 종료 날짜 입력란
        newRow += '<td style="text-align: center;"><select id="termCd" style="width: 100%;">'; // 학기 선택
        for (var j = 0; j < termData.length; j++) {
            var term = termData[j];
            newRow += '<option value="' + term.cd + '">' + term.cdNm + '</option>';
        }
        newRow += '</select></td>';
        newRow += '<td><input id="korean" class="number-input" type="number" min="0" max="100" style="width:100%;"></td>'; // 국어 점수 입력란
        newRow += '<td><input id="math" class="number-input" type="number" min="0" max="100" style="width:100%;"></td>'; // 수학 점수 입력란
        newRow += '<td><input id="english" class="number-input" type="number" min="0" max="100" style="width:100%;"></td>'; // 영어 점수 입력란
        newRow += '<td><input id="society" class="number-input" type="number" min="0" max="100" style="width:100%;"></td>'; // 사회 점수 입력란
        newRow += '<td><input id="history" class="number-input" type="number" min="0" max="100" style="width:100%;"></td>'; // 역사 점수 입력란
        newRow += '<td><input id="science" class="number-input" type="number" min="0" max="100" style="width:100%;"></td>'; // 과학 점수 입력란 
        newRow += '<td style="background-color: #f2f2f2;"><input id="" type="text" style="width:100%;" readonly></td>';
        newRow += '<td hidden><input id="gubunVal" type="text" value="insert"></td>'; // 과학 점수 입력란
        newRow += '</tr>';

        // 생성된 행을 tbody에 추가
        $('#studentScoreTbody').append(newRow);
        
        // 추가된 행의 첫 번째 입력 필드에 포커스 설정
        var lastRowInput = $('#studentScoreTbody tr:last-child input[type="date"]').first();
        lastRowInput.focus();
        
        // 최대 자리수와 값 범위 제한
        $('.number-input').on('input', function() {
            // 최대 3자리로 제한
            if ($(this).val().length > 3) {
                $(this).val($(this).val().slice(0, 3));
            }
            
            // 입력값이 최소 0 최대 100을 초과하지 않도록 설정
            let value = parseInt($(this).val(), 10);
            if (value < 0) {
                $(this).val(0); // 최소값 0
            } else if (value > 100) {
                $(this).val(100); // 최대값 100
            }
        });
    }
</script>
<body>
<div class="wrapper">
    <div class="search-container">
        <input type="text" id="studenNmSearch" placeholder="이름/ 나이/ 소속학교 / 지망학교">
        <button type="button" id="searchBtn">검색</button>
        <div class="count-info">총 ${count} 건</div>
        <span class="admin-message">${adminId} 님 반갑습니다.</span>
        <button type="button" id="logOutBtn">로그아웃</button>
    </div>
 	<div class="table-container">
	    <table>
	        <thead>
	            <tr>
			        <th style="width: 100px;">이름</th>
			        <th style="width: 50px;">나이</th>
			        <th style="width: 100px;">휴대폰</th>
			        <th style="width: 150px;">소속학교</th>
			        <th style="width: 150px;">지망학교</th>
			        <th style="width: 50px;">계열</th>
			        <th style="width: 50px;">전공</th>
			        <th style="width: 50px;">성적상태</th>
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
	                            <td style="text-align: center;">${student.studentAge}.Lv</td> 
	                            <td style="text-align: center;">${student.studentPhone}</td>
	                            <td>${student.studentSchool}</td>
	                            <td>${student.studentWantedSchool}</td>
	                            <td style="text-align: center;">${student.studentSchoolGubunNm}</td>
	                            <td style="text-align: center;">${student.studentSchoolMajorNm}</td>
	                            <td style="text-align: center;">${student.studentTierStatusNm}</td> 
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
	    <button type="button" id="delBtn">학생삭제</button>
	</div>
    
	<div class="button-container-l">
	 	<button type="button" id="addRowBtn" style="background-color: pink;">+</button>
	 	<form id="excelForm" action="/student/acasysStudentScoreExcel.do" method="post">
		    <input type="hidden" name="studentNo" id="studentNo">
		    <input type="hidden" name="avgKorean" id="avgKorean">
		    <input type="hidden" name="avgMath" id="avgMath">
		    <input type="hidden" name="avgEnglish" id="avgEnglish">
		    <input type="hidden" name="avgSociety" id="avgSociety">
		    <input type="hidden" name="avgHistory" id="avgHistory">
		    <input type="hidden" name="avgScience" id="avgScience">
		    <button type="button" id="excelBtn">Excel</button>  
		</form>
	</div> 
   <!-- 아래쪽에 세부정보 테이블 추가 -->
	<div class="table-container-sub">
	    <table class="details-table">
	        <thead>
	            <tr>
	                <th style="text-align: center; width: 36px;">
	                    <input type="checkbox" id="selectAll" onclick="toggleCheckboxes(this)">
	                </th>
	                <th style="width: 68px; text-align: center; ">시작날짜<span style="color: red;"> *</span></th> 
	                <th style="width: 68px; text-align: center;">종료날짜<span style="color: red;"> *</span></th> 
	                <th style="width: 50px; text-align: center;">학기</th>  
	                <th style="width: 50px; text-align: center;">국어</th> 
	                <th style="width: 50px; text-align: center;">수학</th> 
	                <th style="width: 50px; text-align: center;">영어</th>
	                <th style="width: 50px; text-align: center;">사회</th>
	                <th style="width: 50px; text-align: center;">역사</th>
	                <th style="width: 50px; text-align: center;">과학</th>
	                <th style="width: 50px; text-align: center;">분기 평균</th>
	            </tr>
	        </thead>
	        <tbody id="studentScoreTbody">
	            <tr><td colspan="11" class="no-data">조회된 데이터가 없습니다.</td></tr>
	        </tbody>
	        <tfoot id="studentScoreTfoot">
	        </tfoot>
	    </table>
	</div>
    <div class="button-container">
    	<button type="button" id="registScoreBtn">성적등록</button>
    	<button type="button" id="delScoreBtn">성적삭제</button>
    </div>
</div>
</body>
</html>