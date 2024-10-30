package com.aca.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aca.sys.service.AcasysService;
import com.aca.sys.vo.AcasysAdminLoginVO;
import com.aca.sys.vo.AcasysCommCdVo;
import com.aca.sys.vo.AcasysStudentInfoSearchVO;
import com.aca.sys.vo.AcasysStudentInfoVO;
import com.aca.sys.vo.AcasysStudentScoreVO;

@Service("acasysService")
public class AcasysServiceImpl implements AcasysService {
	
	@Autowired
	AcasysMapper acasysMapper;
	
	/**
	 * @Method Name : acasysLogin
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 로그인
	 * @return
	 */
	@Override
	public List<?> acasysLogin(AcasysAdminLoginVO acasysAdminLoginVO) throws Exception {
		return acasysMapper.acasysLogin(acasysAdminLoginVO);
	}
	
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
		return acasysMapper.studentCount();
	}
	
	/**
	 * @Method Name : acasysMain
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 메인
	 * @return
	 */
	@Override
	public List<AcasysStudentInfoVO> selectAcasysStudentList() {
		return acasysMapper.selectAcasysStudentList();
	}
	
	/**
	 * @Method Name : studentCount
	 * @작성일 : 2024. 10. 22
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생검색 목록 건 수
	 * @return
	 */
	@Override
	public String studentSearchCount(AcasysStudentInfoSearchVO acasysStudentInfoSearchVO) {
		return acasysMapper.studentSearchCount(acasysStudentInfoSearchVO);
	}
	
	/**
	 * @Method Name : acasysStudetnListSearch
	 * @작성일 : 2024. 10. 22
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생검색 조회
	 * @return
	 */
	@Override
	public List<AcasysStudentInfoVO> acasysStudetnListSearch(AcasysStudentInfoSearchVO acasysStudentInfoSearchVO) {
		return acasysMapper.acasysStudetnListSearch(acasysStudentInfoSearchVO);
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
	public List<AcasysCommCdVo> schoolGubunCd(String schoolGubunVal) {
		return acasysMapper.schoolGubunCd(schoolGubunVal);
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
	public List<AcasysCommCdVo> schoolMajorCd(String schoolMajorVal) {
		return acasysMapper.schoolMajorCd(schoolMajorVal);
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
	public List<AcasysCommCdVo> tierCd(String tierVal) {
		return acasysMapper.tierCd(tierVal);
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
	public List<AcasysCommCdVo> termCd(String termVal) {
		return acasysMapper.termCd(termVal);
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
	public String acasysStudentRegistProc(AcasysStudentInfoVO score) {
		
		int result = acasysMapper.acasysStudentRegistProc(score);
		
		return result > 0 ? "SUCCESS" : "FAIL";
	}
	
	/**
	 * @Method Name : acasysStudentScoreRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 등록 진행
	 * @return
	 */
	@Override
	public String acasysStudentScoreRegistProc(AcasysStudentScoreVO score) {
		int result = acasysMapper.acasysStudentScoreRegistProc(score);
		return result > 0 ? "SUCCESS" : "FAIL";
	}
	
	/**
	 * @Method Name : acasysStudentScoreUpdateProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 수정 진행
	 * @return
	 */
	@Override
	public String acasysStudentScoreUpdateProc(AcasysStudentScoreVO score) {
		int result = acasysMapper.acasysStudentScoreUpdateProc(score);
		return result > 0 ? "SUCCESS" : "FAIL";
	}
	
	/**
	 * @Method Name : acasysStudentScoreDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 삭제 진행
	 * @return
	 */
	@Override
	public String acasysStudentScoreDelProc(AcasysStudentScoreVO delScore) {
		int result = acasysMapper.acasysStudentScoreDelProc(delScore);
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
	public String acasysStudentDelProc(AcasysStudentInfoVO acasysStudentInfoVO) {
		
		int result = acasysMapper.acasysStudentDelProc(acasysStudentInfoVO);
		
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
	public AcasysStudentInfoVO acasysStudentDetail(String studentNo) {
		return acasysMapper.acasysStudentDetail(studentNo);
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
	public String acasysStudentDetailUpdateProc(AcasysStudentInfoVO acasysStudentInfoVO) {
		int result = acasysMapper.acasysStudentDetailUpdateProc(acasysStudentInfoVO);
		return result > 0 ? "SUCCESS" : "FAIL";
	}
	
	/**
	 * @Method Name : acasysStudentScoreSearch
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 조회
	 * @return
	 */
	@Override
	public List<AcasysStudentScoreVO> acasysStudentScoreSearch(AcasysStudentScoreVO acasysStudentScoreVO) {
		return acasysMapper.acasysStudentScoreSearch(acasysStudentScoreVO);
	}
	
	@Override
	public List<AcasysStudentScoreVO> acasysStudentScoreExcel(String studentNo) {
		// TODO Auto-generated method stub
		return acasysMapper.acasysStudentScoreExcel(studentNo);
	}
	
	@Override
	public List<AcasysCommCdVo> schoolVocatiMajorCd(String schoolVocatiMajorVal) {
		// TODO Auto-generated method stub
		return acasysMapper.schoolVocatiMajorCd(schoolVocatiMajorVal);
	}
	
}
