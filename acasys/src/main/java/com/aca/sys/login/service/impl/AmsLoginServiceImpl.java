package com.aca.sys.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aca.sys.login.service.AmsLoginService;
import com.aca.sys.login.vo.AmsLoginVO;

@Service("amsLoginService")
public class AmsLoginServiceImpl implements AmsLoginService {
	
	@Autowired
	AmsLoginMapper amsLoginMapper;
	
	/**
	 * @Method Name : acasysLogin
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 로그인
	 * @return
	 */
	@Override
	public List<?> acasysLogin(AmsLoginVO amsLoginVO) throws Exception {
		return amsLoginMapper.acasysLogin(amsLoginVO);
	}
	
}
