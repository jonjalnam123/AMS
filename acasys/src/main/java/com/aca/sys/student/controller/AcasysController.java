package com.aca.sys.student.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aca.sys.Paging;
import com.aca.sys.login.vo.AmsLoginVO;
import com.aca.sys.student.service.AcasysService;
import com.aca.sys.student.vo.AcasysCommCdVO;
import com.aca.sys.student.vo.AcasysStudentInfoVO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AcasysController {

	@Autowired
	AcasysService acasysService;

	/*
	 * @Method Name : acasysMainList
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학원생 리스트
	 * @return
	**/
	@GetMapping("/student/acasysStudetnList.do")  
	public String acasysStudetnList(@RequestParam(defaultValue = "0") int curPage, @RequestParam(defaultValue = "") String studenNmSearch, Model model, HttpServletRequest request, AcasysStudentInfoVO acasysStudentInfoVO) throws Exception{
		
	    // 로그인 여부 체크
		AmsLoginVO loginUser = (AmsLoginVO) request.getSession().getAttribute("LOGIN_USER");
	    if (loginUser == null) {
	        return "redirect:/login/amsMain.do"; // 로그인 페이지로 리디렉션
	    }
		
	    String adminId = loginUser.getAdminId();
	    
	    //페이징 처리
        Paging paging = acasysService.getPaging(curPage, acasysStudentInfoVO);
        model.addAttribute("paging", paging);
        
        //페이징 검색조건
        paging.setStudenNmSearch(acasysStudentInfoVO.getStudenNmSearch());
        acasysStudentInfoVO.setPaging(paging);  

		// 학생 리스트
		List<AcasysStudentInfoVO> studentList = acasysService.selectAcasysStudentList(acasysStudentInfoVO);
		
		String termVal = "term";
		List<AcasysCommCdVO> termCd = acasysService.termCd(termVal);  
		
		/** json 변환 **/
		ObjectMapper ObjectMapper = new ObjectMapper();
		String termCdVal = ObjectMapper.writeValueAsString(termCd);
		
		// 학생 전체 건 수
		int count = paging.getTotalCount();  

		model.addAttribute("termCd", termCdVal);
		model.addAttribute("adminId", adminId);
		model.addAttribute("studentList", studentList);
		model.addAttribute("count", count);
		
		return "student/acasysStudentList";
	}
	
	/**
	 * @Method Name : acasysMain
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 화면
	 * @return
	 */
	@GetMapping("/student/acasysStudentRegist.do")
	public String acasysStudentRegist(Model model) {
		
		String schoolGubunVal = "schoolgubun";
		List<AcasysCommCdVO> schoolGubunCd = acasysService.schoolGubunCd(schoolGubunVal);
		
		String schoolMajorVal = "schoolmajor";
		List<AcasysCommCdVO> schoolMajorCd = acasysService.schoolMajorCd(schoolMajorVal);
		
		String tierVal = "tier";
		List<AcasysCommCdVO> tierCd = acasysService.tierCd(tierVal);
		
		String schoolVocatiMajorVal = "schoolvocatimajor";
		List<AcasysCommCdVO> schoolVocatiMajorCd = acasysService.schoolVocatiMajorCd(schoolVocatiMajorVal);

		model.addAttribute("schoolGubunCd", schoolGubunCd);
		model.addAttribute("schoolMajorCd", schoolMajorCd);
		model.addAttribute("schoolVocatiMajorCd", schoolVocatiMajorCd);
		model.addAttribute("tierCd", tierCd);
		
		return "student/acasysStudentRegist";  
	}
	
	/**
	 * @Method Name : acasysStudentRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 진행
	 * @return
	 */
	@PostMapping("/student/acasysStudentRegistProc.do")
	@ResponseBody
	public HashMap<String, String>  acasysStudentRegistProc (@ModelAttribute AcasysStudentInfoVO acasysStudentInfoVO, HttpServletRequest request) {

		 //로그인 아이디
		String adminId = ((AmsLoginVO) request.getSession().getAttribute("LOGIN_USER")).getAdminId();
		
		acasysStudentInfoVO.setRegUserId(adminId);
		acasysStudentInfoVO.setUpdUserId(adminId);  
		
		String result = acasysService.acasysStudentRegistProc(acasysStudentInfoVO);
		
	    // 결과 객체 생성
		HashMap<String, String> response = new HashMap<>();
		
	    if ("SUCCESS".equals(result)) {
	        response.put("status", "success");
	    } else {
	        response.put("status", "error");  
	    }
	    
	    return response;
	}
	
	/**
	 * @Method Name : acasysStudentDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 삭제
	 * @return
	 */
	@PostMapping("/student/acasysStudentDelProc.do")
	@ResponseBody
	public HashMap<String, String>  acasysStudentDelProc (@ModelAttribute AcasysStudentInfoVO acasysStudentInfoVO, HttpServletRequest request) {

		 //로그인 아이디
		String adminId = ((AmsLoginVO) request.getSession().getAttribute("LOGIN_USER")).getAdminId();
		
		acasysStudentInfoVO.setUpdUserId(adminId);  
		
		String result = acasysService.acasysStudentDelProc(acasysStudentInfoVO);
		
	    // 결과 객체 생성
		HashMap<String, String> response = new HashMap<>();
		
	    if ("SUCCESS".equals(result)) {
	        response.put("status", "success");
	    } else {
	        response.put("status", "error");  
	    }
	    
	    return response; 
	}
	
	/**
	 * @Method Name : acasysStudentDetail
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세
	 * @return
	 */
	@PostMapping("/student/acasysStudentDetail.do")
	public String acasysStudentDetail(@RequestParam String studentNo, Model model) {
		
		AcasysStudentInfoVO studentDetailList = acasysService.acasysStudentDetail(studentNo);
		
		String schoolGubunVal = "schoolgubun";
		List<AcasysCommCdVO> schoolGubunCd = acasysService.schoolGubunCd(schoolGubunVal);
		
		String schoolMajorVal = "schoolmajor";
		List<AcasysCommCdVO> schoolMajorCd = acasysService.schoolMajorCd(schoolMajorVal);
		
		String tierVal = "tier";
		List<AcasysCommCdVO> tierCd = acasysService.tierCd(tierVal);
		
		
		String schoolVocatiMajorVal = "schoolvocatimajor";
		List<AcasysCommCdVO> schoolVocatiMajorCd = acasysService.schoolVocatiMajorCd(schoolVocatiMajorVal);
		
		model.addAttribute("schoolGubunCd", schoolGubunCd);
		model.addAttribute("schoolMajorCd", schoolMajorCd);
		model.addAttribute("tierCd", tierCd);
		model.addAttribute("studentDetailList", studentDetailList);  
		model.addAttribute("schoolVocatiMajorCd", schoolVocatiMajorCd);
		
		return "student/acasysStudentDetail";  
	}
	
	/**
	 * @Method Name : acasysStudentDetailUpdateProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세 수정
	 * @return
	 */
	@PostMapping("/student/acasysStudentDetailUpdateProc.do")
	@ResponseBody
	public HashMap<String, String> acasysStudentDetailUpdateProc(@ModelAttribute AcasysStudentInfoVO acasysStudentInfoVO, HttpServletRequest request) {

		 //로그인 아이디
		String adminId = ((AmsLoginVO) request.getSession().getAttribute("LOGIN_USER")).getAdminId();

		acasysStudentInfoVO.setUpdUserId(adminId);  
		
		String result = acasysService.acasysStudentDetailUpdateProc(acasysStudentInfoVO);
		
	    // 결과 객체 생성
		HashMap<String, String> response = new HashMap<>();
		
	    if ("SUCCESS".equals(result)) {
	        response.put("status", "success");
	    } else {
	        response.put("status", "error");  
	    }
	    
	    return response;  
	}

}
