package com.aca.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class AcaSysCodeController {
	
	@GetMapping("/amsCode/codeManageMain.do")
	public String codeManageMain() { 
		
		System.out.println("코드 진입");
		
		return "code/acasysCodeList";
	}

}
