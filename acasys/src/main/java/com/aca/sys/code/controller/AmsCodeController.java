package com.aca.sys.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aca.sys.code.service.AmsCodeService;
import com.aca.sys.code.vo.AmsCodeVO;
import com.aca.sys.login.vo.AmsLoginVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller 
public class AmsCodeController {
	
	@Autowired
	AmsCodeService amsCodeService;
	
	/**
	 * @Method Name : getTermCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 공통 학기코드 조회
	 * @return
	 */
	public List<AmsCodeVO> getTermCd(String termVal) {
		
		List<AmsCodeVO> termCd = amsCodeService.termCd(termVal);
		
		return termCd;
	}
	
	/**
	 * @Method Name : getSchoolGubunCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 공통 학교 전공계열 구분 조회
	 * @return
	 */
	public List<AmsCodeVO> getSchoolGubunCd(String schoolGubunVal) {
		
		List<AmsCodeVO> schoolGubunCd = amsCodeService.schoolGubunCd(schoolGubunVal);
		
		return schoolGubunCd;
	}
	
	/**
	 * @Method Name : getSchoolMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 인문계 전공 조회
	 * @return
	 */
	public List<AmsCodeVO> getSchoolMajorCd(String schoolMajorVal) {
		
		List<AmsCodeVO> schoolMajorCd = amsCodeService.schoolMajorCd(schoolMajorVal);
		
		return schoolMajorCd;
	}
	
	/**
	 * @Method Name : getTierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 성적상태 코드 조회
	 * @return
	 */
	public List<AmsCodeVO> getTierCd(String tierVal) {
		
		List<AmsCodeVO> tierCd = amsCodeService.tierCd(tierVal);
		
		return tierCd;
	}
	
	/**
	 * @Method Name : getSchoolVocatiMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 실업계 전공 조회
	 * @return
	 */
	public List<AmsCodeVO> getSchoolVocatiMajorCd(String schoolVocatiMajorVal) {
		
		List<AmsCodeVO> schoolVocatiMajorCd = amsCodeService.schoolVocatiMajorCd(schoolVocatiMajorVal);
		
		return schoolVocatiMajorCd;
	}
	
	@GetMapping("/amsCode/amsCodeManageMain.do") 
	public String codeManageMain( HttpServletRequest request, Model model) { 
		
	    // 로그인 여부 체크
		AmsLoginVO loginUser = (AmsLoginVO) request.getSession().getAttribute("LOGIN_USER");
	    if (loginUser == null) {
	        return "redirect:/login/amsMain.do"; // 로그인 페이지로 리디렉션
	    }
		
	    String adminId = loginUser.getAdminId();
	    
	    model.addAttribute("adminId", adminId);  
		
		System.out.println("코드 진입");
		
		return "code/amsCodeList";
	}
	
	


}
