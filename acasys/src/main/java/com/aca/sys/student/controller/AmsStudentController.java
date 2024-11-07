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
import com.aca.sys.code.controller.AmsCodeController;
import com.aca.sys.code.vo.AmsCodeVO;
import com.aca.sys.login.vo.AmsLoginVO;
import com.aca.sys.student.service.AmsStudentService;
import com.aca.sys.student.vo.AmsStudentInfoVO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AmsStudentController {

	@Autowired
	AmsStudentService amsStudentService;

	@Autowired
	AmsCodeController amsCodeController;
	/*
	 * @Method Name : acasysMainList
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학원생 리스트
	 * @return
	**/
	@GetMapping("/student/acasysStudetnList.do")  
	public String acasysStudetnList(@RequestParam(defaultValue = "0") int curPage, @RequestParam(defaultValue = "") String studenNmSearch, Model model, HttpServletRequest request, AmsStudentInfoVO amsStudentInfoVO) throws Exception{
		
	    // 로그인 여부 체크
		AmsLoginVO loginUser = (AmsLoginVO) request.getSession().getAttribute("LOGIN_USER");
	    if (loginUser == null) {
	        return "redirect:/login/amsMain.do"; // 로그인 페이지로 리디렉션
	    }
		
	    String adminId = loginUser.getAdminId();
	    
	    //페이징 처리
        Paging paging = amsStudentService.getPaging(curPage, amsStudentInfoVO);
        model.addAttribute("paging", paging);
        
        //페이징 검색조건
        paging.setStudenNmSearch(amsStudentInfoVO.getStudenNmSearch());
        amsStudentInfoVO.setPaging(paging);  

		// 학생 리스트
		List<AmsStudentInfoVO> studentList = amsStudentService.selectAcasysStudentList(amsStudentInfoVO);
		
		// 학기코드 조회
		String termVal = "term";
		List<AmsCodeVO> termCd = amsCodeController.getTermCd(termVal);  
		
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
		
		//학교전공 계열
		String schoolGubunVal = "schoolgubun";
		List<AmsCodeVO> schoolGubunCd = amsCodeController.getSchoolGubunCd(schoolGubunVal);
		
		String schoolMajorVal = "schoolmajor";
		List<AmsCodeVO> schoolMajorCd = amsCodeController.getSchoolMajorCd(schoolMajorVal);
		
		String tierVal = "tier";
		List<AmsCodeVO> tierCd = amsCodeController.getTierCd(tierVal);
		
		String schoolVocatiMajorVal = "schoolvocatimajor";
		List<AmsCodeVO> schoolVocatiMajorCd = amsCodeController.getSchoolVocatiMajorCd(schoolVocatiMajorVal);

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
	public HashMap<String, String>  acasysStudentRegistProc (@ModelAttribute AmsStudentInfoVO amsStudentInfoVO, HttpServletRequest request) {

		 //로그인 아이디
		String adminId = ((AmsLoginVO) request.getSession().getAttribute("LOGIN_USER")).getAdminId();
		
		amsStudentInfoVO.setRegUserId(adminId);
		amsStudentInfoVO.setUpdUserId(adminId);  
		
		String result = amsStudentService.acasysStudentRegistProc(amsStudentInfoVO);
		
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
	public HashMap<String, String>  acasysStudentDelProc (@ModelAttribute AmsStudentInfoVO acasysStudentInfoVO, HttpServletRequest request) {

		 //로그인 아이디
		String adminId = ((AmsLoginVO) request.getSession().getAttribute("LOGIN_USER")).getAdminId();
		
		acasysStudentInfoVO.setUpdUserId(adminId);  
		
		String result = amsStudentService.acasysStudentDelProc(acasysStudentInfoVO);
		
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
		
		AmsStudentInfoVO studentDetailList = amsStudentService.acasysStudentDetail(studentNo);
		
		String schoolGubunVal = "schoolgubun";
		List<AmsCodeVO> schoolGubunCd = amsCodeController.getSchoolGubunCd(schoolGubunVal);
		
		String schoolMajorVal = "schoolmajor";
		List<AmsCodeVO> schoolMajorCd = amsCodeController.getSchoolMajorCd(schoolMajorVal);
		
		String tierVal = "tier";
		List<AmsCodeVO> tierCd = amsCodeController.getTierCd(tierVal);
		
		
		String schoolVocatiMajorVal = "schoolvocatimajor";
		List<AmsCodeVO> schoolVocatiMajorCd = amsCodeController.getSchoolVocatiMajorCd(schoolVocatiMajorVal);
		
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
	public HashMap<String, String> acasysStudentDetailUpdateProc(@ModelAttribute AmsStudentInfoVO amsStudentInfoVO, HttpServletRequest request) {

		 //로그인 아이디
		String adminId = ((AmsLoginVO) request.getSession().getAttribute("LOGIN_USER")).getAdminId();

		amsStudentInfoVO.setUpdUserId(adminId);  
		
		String result = amsStudentService.acasysStudentDetailUpdateProc(amsStudentInfoVO);
		
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
