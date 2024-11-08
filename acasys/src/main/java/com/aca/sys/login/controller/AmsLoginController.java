package com.aca.sys.login.controller;

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

import com.aca.sys.CommonUtils;
import com.aca.sys.login.service.AmsLoginService;
import com.aca.sys.login.vo.AmsLoginVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AmsLoginController {

	@Autowired
	AmsLoginService amsLoginService;
	
	/**
	 * @Method Name : acasysMain
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 메인
	 * @return
	 */
	@GetMapping("/")
	public String main () {
		return "redirect:/login/amsMain.do";   
	}
	
	/**
	 * @Method Name : acasysMain
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 메인
	 * @return
	 */
	@GetMapping("/login/amsMain.do")
	public String acasysMain( HttpServletRequest request ) {
		
        String username = "";
        if ( request.getCookies() != null ) {
	        Cookie[] cookies = request.getCookies();
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("idSaveCheck")) {
	                username = cookie.getValue();
	            }
	        }
	        request.setAttribute("idSaveCheck", username);
        }else {
        	request.setAttribute("idSaveCheck", username);
        }
        
		return "login/amsLogin";
	}
	
	/**
	 * @Method Name : acasysLogin
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 로그인
	 * @return
	 */
	@PostMapping("/login/amsLogin.do")
	@ResponseBody
	public HashMap<String, String> acasysLogin( @ModelAttribute AmsLoginVO amsLoginVO, @RequestParam String idSaveCheck, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, String> longResultMap = new HashMap<>();

		//암호화된 Password 비교하기.
		CommonUtils util = new CommonUtils();
		String userPassword = amsLoginVO.getAdminPw();
		String shaPassword = util.encrypt(userPassword);
		amsLoginVO.setAdminPw(shaPassword);
		 
		List<?> loginResult = amsLoginService.acasysLogin(amsLoginVO);

		if ( loginResult.size() > 0 ) { // 성공
			
			HttpSession session = request.getSession();
			
			if ( session.getAttribute("LOGIN_USER") != null ){
				// 기존에 login이란 세션 값이 존재한다면
				session.removeAttribute("LOGIN_USER"); // 기존값을 제거해 준다.
			}

			session.setAttribute("LOGIN_USER", amsLoginVO);
			
			longResultMap.put("result", "S");
			
			
		      if (idSaveCheck == null) {
		    	  idSaveCheck = "";
		        }
			
		        if (idSaveCheck.equals("on")) {
		            Cookie cookie = new Cookie("idSaveCheck", amsLoginVO.getAdminId());
		            response.addCookie(cookie);
		        } else {
		            Cookie cookie = new Cookie("idSaveCheck", "");
		            response.addCookie(cookie);
		        }
			
		} else if ( loginResult.size() <=  0 ) { //실패 
			longResultMap.put("result", "F");
		}

		return longResultMap;
	}
	

	/**
	 * @Method Name : acasyslogout
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 로그아웃
	 * @return
	 */
	@GetMapping("/login/amsLogout.do")   
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    HttpSession session = request.getSession();  
	    session.invalidate();
	    
	    // 로그인 페이지로 리디렉션
	    return "redirect:/login/amsMain.do";   
	}
	
}
