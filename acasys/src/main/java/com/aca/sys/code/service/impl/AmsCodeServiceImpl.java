package com.aca.sys.code.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aca.sys.code.service.AmsCodeService;
import com.aca.sys.code.vo.AmsCodeVO;

@Service("amsCodeService")
public class AmsCodeServiceImpl implements AmsCodeService {
	
	@Autowired
	AmsCodeMapper amsCodeMapper;
	
	/**
	 * @Method Name : getTermCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 공통 학기코드 조회
	 * @return
	 */
	@Override
	public List<AmsCodeVO> termCd(String termVal) { 
		return amsCodeMapper.termCd(termVal); 
	}
	
	/**
	 * @Method Name : getSchoolGubunCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 공통 학교 전공계열 구분 조회
	 * @return
	 */
	@Override
	public List<AmsCodeVO> schoolGubunCd(String schoolGubunVal) {
		return amsCodeMapper.schoolGubunCd(schoolGubunVal);
	}
	
	/**
	 * @Method Name : getSchoolMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 인문계 전공 조회
	 * @return
	 */
	@Override
	public List<AmsCodeVO> schoolMajorCd(String schoolMajorVal) {
		return amsCodeMapper.schoolMajorCd(schoolMajorVal);
	}
	
	/**
	 * @Method Name : getTierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 성적상태 코드 조회
	 * @return
	 */
	@Override
	public List<AmsCodeVO> schoolVocatiMajorCd(String schoolVocatiMajorVal) {
		return amsCodeMapper.schoolVocatiMajorCd(schoolVocatiMajorVal);
	}
	
	/**
	 * @Method Name : getSchoolVocatiMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 실업계 전공 조회
	 * @return
	 */
	@Override
	public List<AmsCodeVO> tierCd(String tierVal) {
		return amsCodeMapper.tierCd(tierVal);
	}
	

}
