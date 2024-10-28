package com.aca.sys.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aca.sys.vo.AcasysAdminLoginVO;
import com.aca.sys.vo.AcasysCommCdVo;
import com.aca.sys.vo.AcasysStudentInfoSearchVO;
import com.aca.sys.vo.AcasysStudentInfoVO;
import com.aca.sys.vo.AcasysStudentScoreVO;

@Mapper
public interface AcasysMapper {

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
	 * @Method Name : tierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학기 코드
	 * @return
	 */
	List<AcasysCommCdVo> termCd(String termVal); 
	
	/**
	 * @Method Name : acasysStudentRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 진행
	 * @return
	 */
	int acasysStudentRegistProc(AcasysStudentInfoVO acasysStudentInfoVO);
	
	/**
	 * @Method Name : acasysStudentScoreRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 등록 진행
	 * @return
	 */
	int acasysStudentScoreRegistProc(AcasysStudentScoreVO score);

	/**
	 * @Method Name : acasysStudentScoreUpdateProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 수정 진행
	 * @return
	 */
	int acasysStudentScoreUpdateProc(AcasysStudentScoreVO score);
	
	/**
	 * @Method Name : acasysStudentScoreDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 삭제 진행
	 * @return
	 */
	int acasysStudentScoreDelProc(AcasysStudentScoreVO delScore);
	
	/**
	 * @Method Name : acasysStudentDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 삭제
	 * @return
	 */
	int acasysStudentDelProc(AcasysStudentInfoVO acasysStudentInfoVO);

	/**
	 * @Method Name : acasysStudentDetail
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세
	 * @return
	 */
	AcasysStudentInfoVO acasysStudentDetail(String studentNo);

	/**
	 * @Method Name : acasysStudentDetailUpdateProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세 수정
	 * @return
	 */
	int acasysStudentDetailUpdateProc(AcasysStudentInfoVO acasysStudentInfoVO);

	/**
	 * @Method Name : acasysStudentScoreSearch
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 조회
	 * @return
	 */
	List<AcasysStudentScoreVO> acasysStudentScoreSearch(AcasysStudentScoreVO acasysStudentScoreVO);


}
