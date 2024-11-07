package com.aca.sys.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class AmsCodeController {
	
	@GetMapping("/amsCode/amsCodeManageMain.do")
	public String codeManageMain() { 
		
		System.out.println("코드 진입");
		
		return "code/amsCodeList";
	}

}
