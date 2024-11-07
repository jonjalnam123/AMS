package com.aca.sys.login.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aca.sys.login.vo.AmsLoginVO;

@Mapper
public interface AmsLoginMapper {

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
