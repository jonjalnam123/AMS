package com.aca.sys.service;

import java.util.List;

import com.aca.sys.vo.AcasysAdminLoginVO;
import com.aca.sys.vo.AcasysCommCdVo;
import com.aca.sys.vo.AcasysStudentInfoSearchVO;
import com.aca.sys.vo.AcasysStudentInfoVO;

public interface AcasysService {

	/**
	 * @Method Name : acasysLogin
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 로그인
	 * @return
	 */
	List<?> acasysLogin(AcasysAdminLoginVO acasysAdminLoginVO) throws Exception;
	
	/**
	 * @Method Name : studentCount
	 * @작성일 : 2024. 10. 22
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생전체 목록 건 수
	 * @return
	 */
	String studentCount();
	
	/**
	 * @Method Name : acasysMain
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 메인
	 * @return
	 */
	List<AcasysStudentInfoVO> selectAcasysStudentList();
	
	/**
	 * @Method Name : studentCount
	 * @작성일 : 2024. 10. 22
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생검색 목록 건 수
	 * @return
	 */
	String studentSearchCount(AcasysStudentInfoSearchVO acasysStudentInfoSearchVO);

	/**
	 * @Method Name : acasysStudetnListSearch
	 * @작성일 : 2024. 10. 22
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생검색 조회
	 * @return
	 */
	List<AcasysStudentInfoVO> acasysStudetnListSearch(AcasysStudentInfoSearchVO acasysStudentInfoSearchVO);

	/**
	 * @Method Name : schoolGubunCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 계열 코드
	 * @return
	 */
	List<AcasysCommCdVo> schoolGubunCd(String schoolGubunVal);

	/**
	 * @Method Name : schoolMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 전공 코드
	 * @return
	 */
	List<AcasysCommCdVo> schoolMajorCd(String schoolMajorVal);

	/**
	 * @Method Name : tierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 성적 코드
	 * @return
	 */
	List<AcasysCommCdVo> tierCd(String tierVal);

	/**
	 * @Method Name : acasysStudentRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 진행
	 * @return
	 */
	String acasysStudentRegistProc(AcasysStudentInfoVO acasysStudentInfoVO);

	/**
	 * @Method Name : acasysStudentDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 삭제
	 * @return
	 */  
	String acasysStudentDelProc(AcasysStudentInfoVO acasysStudentInfoVO);

	
	/**
	 * @Method Name : acasysStudentDetail
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세
	 * @return
	 */
	AcasysStudentInfoVO acasysStudentDetail(String studentNo);

	String acasysStudentDetailUpdateProc(AcasysStudentInfoVO acasysStudentInfoVO);

}