package com.aca.sys.login.service;

import java.util.List;

import com.aca.sys.login.vo.AmsLoginVO;

public interface AmsLoginService {

	/**
	 * @Method Name : acasysLogin
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 로그인
	 * @return
	 */
	List<?> acasysLogin(AmsLoginVO amsLoginVO) throws Exception;

}
