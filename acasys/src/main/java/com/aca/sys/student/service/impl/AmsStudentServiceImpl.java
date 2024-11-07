package com.aca.sys.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aca.sys.Paging;
import com.aca.sys.student.service.AmsStudentService;
import com.aca.sys.student.vo.AmsStudentCommCdVO;
import com.aca.sys.student.vo.AmsStudentInfoVO;

@Service("amsStudentService")
public class AmsStudentServiceImpl implements AmsStudentService {
	
	@Autowired
	AmsStudentMapper amsStudentMapper;
	
	/**
	 * @Method Name : studentCount
	 * @작성일 : 2024. 10. 22
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생전체 목록 건 수
	 * @return
	 */
	@Override
	public String studentCount() {
		return amsStudentMapper.studentCount();
	}
	
	/**
	 * @param acasysStudentInfoVO 
	 * @Method Name : selectAcasysStudentList
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 메인 학생 조회
	 * @return
	 */
	@Override
	public List<AmsStudentInfoVO> selectAcasysStudentList(AmsStudentInfoVO amsStudentInfoVO) {
		return amsStudentMapper.selectAcasysStudentList(amsStudentInfoVO);
	}
	
	/**
	 * @Method Name : getPaging
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 페이징 관련 조회
	 * @return
	 */
	@Override
	public Paging getPaging(int curPage, AmsStudentInfoVO amsStudentInfoVO) {
		
		//총 게시글 수 조회 
		int totalCount = amsStudentMapper.studentCountForPaging(amsStudentInfoVO);
		
		//페이징계산 
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	/**
	 * @Method Name : schoolGubunCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 계열 코드
	 * @return
	 */
	@Override
	public List<AmsStudentCommCdVO> schoolGubunCd(String schoolGubunVal) {
		return amsStudentMapper.schoolGubunCd(schoolGubunVal);
	}
	
	/**
	 * @Method Name : schoolMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 전공 코드
	 * @return
	 */
	@Override
	public List<AmsStudentCommCdVO> schoolMajorCd(String schoolMajorVal) {
		return amsStudentMapper.schoolMajorCd(schoolMajorVal);
	}
	
	/**
	 * @Method Name : tierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 성적 코드
	 * @return
	 */
	@Override
	public List<AmsStudentCommCdVO> tierCd(String tierVal) {
		return amsStudentMapper.tierCd(tierVal);
	}
	
	/**
	 * @Method Name : tierCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학기 코드
	 * @return
	 */
	@Override
	public List<AmsStudentCommCdVO> termCd(String termVal) {
		return amsStudentMapper.termCd(termVal);
	}
	
	/**
	 * @Method Name : schoolVocatiMajorCd
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 실업계 코드 조회
	 * @return
	 */
	@Override
	public List<AmsStudentCommCdVO> schoolVocatiMajorCd(String schoolVocatiMajorVal) {
		return amsStudentMapper.schoolVocatiMajorCd(schoolVocatiMajorVal);
	}
	
	/**
	 * @Method Name : acasysStudentRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 진행
	 * @return
	 */
	@Override
	public String acasysStudentRegistProc(AmsStudentInfoVO score) {
		
		int result = amsStudentMapper.acasysStudentRegistProc(score);
		
		return result > 0 ? "SUCCESS" : "FAIL";
	}
	
	/**
	 * @Method Name : acasysStudentDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 등록 삭제
	 * @return
	 */
	@Override
	public String acasysStudentDelProc(AmsStudentInfoVO amsStudentInfoVO) {
		
		int result = amsStudentMapper.acasysStudentDelProc(amsStudentInfoVO);
		amsStudentMapper.acasysStudentDelScore(amsStudentInfoVO);
		
		return result > 0 ? "SUCCESS" : "FAIL";
	}
	
	/**
	 * @Method Name : acasysStudentDetail
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세
	 * @return
	 */
	@Override
	public AmsStudentInfoVO acasysStudentDetail(String studentNo) {
		return amsStudentMapper.acasysStudentDetail(studentNo);
	}
	
	/**
	 * @Method Name : acasysStudentDetailUpdateProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 상세 수정
	 * @return
	 */
	@Override
	public String acasysStudentDetailUpdateProc(AmsStudentInfoVO amsStudentInfoVO) {
		int result = amsStudentMapper.acasysStudentDetailUpdateProc(amsStudentInfoVO);
		return result > 0 ? "SUCCESS" : "FAIL";
	}
	
}
