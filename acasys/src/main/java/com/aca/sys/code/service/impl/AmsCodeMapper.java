package com.aca.sys.code.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aca.sys.code.vo.AmsCodeVO;

@Mapper
public interface AmsCodeMapper {

	/**
	 * @Method Name : getTermCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 공통 학기코드 조회
	 * @return
	 */
	List<AmsCodeVO> termCd(String termVal);

	/**
	 * @Method Name : getSchoolGubunCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 공통 학교 전공계열 구분 조회
	 * @return
	 */
	List<AmsCodeVO> schoolGubunCd(String schoolGubunVal);

	/**
	 * @Method Name : getSchoolMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 인문계 전공 조회
	 * @return
	 */
	List<AmsCodeVO> schoolMajorCd(String schoolMajorVal);

	/**
	 * @Method Name : getTierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 성적상태 코드 조회
	 * @return
	 */
	List<AmsCodeVO> schoolVocatiMajorCd(String schoolVocatiMajorVal);

	/**
	 * @Method Name : getSchoolVocatiMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 실업계 전공 조회
	 * @return
	 */
	List<AmsCodeVO> tierCd(String tierVal);


}
