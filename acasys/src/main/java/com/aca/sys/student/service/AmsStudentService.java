package com.aca.sys.student.service;

import java.util.List;

import com.aca.sys.Paging;
import com.aca.sys.student.vo.AmsStudentCommCdVO;
import com.aca.sys.student.vo.AmsStudentInfoVO;

public interface AmsStudentService {

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
	 * @param acasysStudentInfoVO 
	 * @Method Name : selectAcasysStudentList
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 메인 학생 조회
	 * @return
	 */
	List<AmsStudentInfoVO> selectAcasysStudentList(AmsStudentInfoVO amsStudentInfoVO);
	
	/**
	 * @Method Name : getPaging
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 페이징 관련 조회
	 * @return
	 */
	Paging getPaging(int curPage, AmsStudentInfoVO amsStudentInfoVO);

	/**
	 * @Method Name : schoolGubunCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 계열 코드
	 * @return
	 */
	List<AmsStudentCommCdVO> schoolGubunCd(String schoolGubunVal);

	/**
	 * @Method Name : schoolMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 전공 코드
	 * @return
	 */
	List<AmsStudentCommCdVO> schoolMajorCd(String schoolMajorVal);

	/**
	 * @Method Name : schoolVocatiMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 실업계 코드 조회
	 * @return
	 */
	List<AmsStudentCommCdVO> schoolVocatiMajorCd(String schoolVocatiMajorVal);
	
	/**
	 * @Method Name : tierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 성적 코드
	 * @return
	 */
	List<AmsStudentCommCdVO> tierCd(String tierVal);
	
	/**
	 * @Method Name : tierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학기 코드
	 * @return
	 */
	List<AmsStudentCommCdVO> termCd(String termVal);

	/**
	 * @Method Name : acasysStudentRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 진행
	 * @return
	 */
	String acasysStudentRegistProc(AmsStudentInfoVO amsStudentInfoVO);

	/**
	 * @Method Name : acasysStudentDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 삭제
	 * @return
	 */  
	String acasysStudentDelProc(AmsStudentInfoVO amsStudentInfoVO);

	
	/**
	 * @Method Name : acasysStudentDetail
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세
	 * @return
	 */
	AmsStudentInfoVO acasysStudentDetail(String studentNo);

	/**
	 * @Method Name : acasysStudentDetailUpdateProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세 수정
	 * @return
	 */
	String acasysStudentDetailUpdateProc(AmsStudentInfoVO amsStudentInfoVO);
	
}
