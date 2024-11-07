package com.aca.sys.score.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aca.sys.login.vo.AmsLoginVO;
import com.aca.sys.score.service.AmsScoreService;
import com.aca.sys.score.vo.AmsScoreVO;
import com.aca.sys.student.vo.AcasysCommCdVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AmsScoreController {

	@Autowired
	AmsScoreService amsScoreService;

	/**
	 * @Method Name : acasysStudentScoreSearch
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 조회
	 * @return
	 */
	@PostMapping("/score/amsStudentScoreSearch.do")
	@ResponseBody
	public HashMap<String, Object> acasysStudentScoreSearch(@ModelAttribute AmsScoreVO amsScoreVO, HttpServletRequest request) {

		List<AmsScoreVO> studentScore = amsScoreService.acasysStudentScoreSearch(amsScoreVO);
		
		String termVal = "term";
		List<AcasysCommCdVO> termCd = amsScoreService.termCd(termVal);
		
	    // 결과 객체 생성
		HashMap<String, Object> response = new HashMap<>();
		
	    if (studentScore.isEmpty()) {
		   response.put("studentScore", 'E');
		   response.put("termCd", termCd);
	    } else {    
	    	response.put("studentScore", studentScore);
	    	response.put("termCd", termCd);
	    }
	    
	    return response;  
	}
	
	/**
	 * @Method Name : acasysStudentScoreRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 등록 진행
	 * @return
	 */
	@PostMapping("/score/amsStudentScoreRegistProc.do")
	@ResponseBody
	public HashMap<String, String>  acasysStudentScoreRegistProc (@RequestBody HashMap<String, List<AmsScoreVO>> amsScoreVO, HttpServletRequest request) {

	    List<AmsScoreVO> scoresList = amsScoreVO.get("scoresList");

	    String adminId = ((AmsLoginVO) request.getSession().getAttribute("LOGIN_USER")).getAdminId();

	    HashMap<String, String> response = new HashMap<>();
	    String overallResult = "SUCCESS";

	    for (AmsScoreVO score : scoresList) {
	        score.setUpdUserId(adminId); // 업데이트 시에도 adminId 설정

	        if ("insert".equals(score.getGubunVal())) { 
	            score.setRegUserId(adminId);
	            String result = amsScoreService.acasysStudentScoreRegistProc(score);
	            if (!"SUCCESS".equals(result)) {
	                overallResult = "ERROR";
	            }
	        } else if ("update".equals(score.getGubunVal())) {
	            String result = amsScoreService.acasysStudentScoreUpdateProc(score);
	            if (!"SUCCESS".equals(result)) {
	                overallResult = "ERROR";  
	            }
	        }
	    }

	    response.put("status", "SUCCESS".equals(overallResult) ? "success" : "error");
	    return response;
	}
	
	/**
	 * @Method Name : acasysStudentScoreDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 삭제 진행
	 * @return
	 */
	@PostMapping("/score/amsStudentScoreDelProc.do")
	@ResponseBody
	public HashMap<String, String>  acasysStudentScoreDelProc (@RequestBody HashMap<String, List<AmsScoreVO>> amsScoreVO, HttpServletRequest request) {

	    List<AmsScoreVO> studentsToDelete = amsScoreVO.get("studentsToDelete");

	    HashMap<String, String> response = new HashMap<>();
	    String overallResult = "SUCCESS";

	    for (AmsScoreVO delScore : studentsToDelete) {

        	String result = amsScoreService.acasysStudentScoreDelProc(delScore);
            if (!"SUCCESS".equals(result)) {
                overallResult = "ERROR";
            } 

	    }

	    response.put("status", "SUCCESS".equals(overallResult) ? "success" : "error");
	    return response;
	}
	
	/**
	 * @Method Name : acasysStudentScoreExcel
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 엑셀
	 * @return
	 */
	@PostMapping("/score/amsStudentScoreExcel.do")
	public void acasysStudentScoreExcel (@ModelAttribute AmsScoreVO amsScoreVO, HttpServletResponse response) throws IOException {
//      Workbook wb = new HSSFWorkbook(); xls 확장자를 가진 엑셀 파일 -> HSSFWorkbook
      Workbook wb = new XSSFWorkbook(); // xlsx 확장자를 가진 엑셀 파일 -> XSSFWorkbook
      Sheet sheet = wb.createSheet("첫번째 시트");
      Row row = null;
      Cell cell = null;
      int rowNum = 0;
      
      String studentNo = amsScoreVO.getStudentNo();
      String studentName = amsScoreService.acasysStudentNameForExcel(studentNo);
      List<AmsScoreVO> excel = amsScoreService.acasysStudentScoreExcel(studentNo);

      // Header
      row = sheet.createRow(rowNum++);
      cell = row.createCell(0);
      cell.setCellValue("시작날짜");
      cell = row.createCell(1);
      cell.setCellValue("종료날짜");
      cell = row.createCell(2);
      cell.setCellValue("학기");
      cell = row.createCell(3);
      cell.setCellValue("국어");
      cell = row.createCell(4);
      cell.setCellValue("수학");
      cell = row.createCell(5);
      cell.setCellValue("영어");
      cell = row.createCell(6);
      cell.setCellValue("사회");
      cell = row.createCell(7);
      cell.setCellValue("역사");
      cell = row.createCell(8);
      cell.setCellValue("과학");
      cell = row.createCell(9);
      cell.setCellValue("분기 평균");
      
      // Header 열 너비 설정 (단위: 1/256)
      sheet.setColumnWidth(0, 256 * 15); // 시작날짜  
      sheet.setColumnWidth(1, 256 * 15); // 종료날짜
      sheet.setColumnWidth(2, 256 * 10); // 학기
      sheet.setColumnWidth(3, 256 * 10); // 국어
      sheet.setColumnWidth(4, 256 * 10); // 수학
      sheet.setColumnWidth(5, 256 * 10); // 영어
      sheet.setColumnWidth(6, 256 * 10); // 사회
      sheet.setColumnWidth(7, 256 * 10); // 역사
      sheet.setColumnWidth(8, 256 * 10); // 과학
      sheet.setColumnWidth(9, 256 * 10); // 분기 평균
      
      for (AmsScoreVO score : excel) {
    	  
          row = sheet.createRow(rowNum++);
          cell = row.createCell(0);
          cell.setCellValue(score.getStartDate());
          cell = row.createCell(1);
          cell.setCellValue(score.getEndDate());
          cell = row.createCell(2);
          cell.setCellValue(score.getTermNm());  
          cell = row.createCell(3);
          cell.setCellValue(score.getKorean());  
          cell = row.createCell(4);
          cell.setCellValue(score.getMath());  
          cell = row.createCell(5);
          cell.setCellValue(score.getEnglish());  
          cell = row.createCell(6);
          cell.setCellValue(score.getSociety());  
          cell = row.createCell(7);
          cell.setCellValue(score.getHistory());  
          cell = row.createCell(8);
          cell.setCellValue(score.getScience());
          cell = row.createCell(9);
          cell.setCellValue(score.getAverageScore()); 
      }
      
      //마지막 값 확인
      int lastRowNum = rowNum;     
      row = sheet.createRow(lastRowNum);
      cell = row.createCell(0);
      cell.setCellValue("");
      cell = row.createCell(1);
      cell.setCellValue("");
      cell = row.createCell(2);
      cell.setCellValue("과목평균"); 
      cell = row.createCell(3);
      cell.setCellValue(amsScoreVO.getAvgKorean());
      cell = row.createCell(4);
      cell.setCellValue(amsScoreVO.getAvgMath());
      cell = row.createCell(5);
      cell.setCellValue(amsScoreVO.getAvgEnglish());
      cell = row.createCell(6);
      cell.setCellValue(amsScoreVO.getAvgSociety());
      cell = row.createCell(7);
      cell.setCellValue(amsScoreVO.getAvgHistory());
      cell = row.createCell(8);
      cell.setCellValue(amsScoreVO.getAvgScience());
      cell = row.createCell(9); 
      cell.setCellValue("");
      cell = row.createCell(10);
      cell.setCellValue("학생 번호");
      cell = row.createCell(11);
      cell.setCellValue(" : " + studentNo);
      cell = row.createCell(12);
      cell.setCellValue("학생 이름");
      cell = row.createCell(13);    
      cell.setCellValue(" : " + studentName);  

      Date today = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
      String formattedDate = formatter.format(today);  
      
      // 컨텐츠 타입과 파일명 지정
      response.setContentType("ms-vnd/excel"); 
      response.setHeader("Content-Disposition", "attachment;filename=" + formattedDate + "_studentScore.xlsx");

      // Excel File Output
      wb.write(response.getOutputStream());    
      wb.close();
	}

}
