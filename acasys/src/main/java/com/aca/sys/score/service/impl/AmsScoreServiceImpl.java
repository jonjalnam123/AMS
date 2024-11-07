package com.aca.sys.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aca.sys.score.service.AmsScoreService;
import com.aca.sys.score.vo.AmsScoreVO;
import com.aca.sys.student.vo.AmsStudentCommCdVO;

@Service("amsScoreService")
public class AmsScoreServiceImpl implements AmsScoreService {
	
	@Autowired
	AmsScoreMapper amsScoreMapper;
	
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
		return amsScoreMapper.termCd(termVal);
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
	public String acasysStudentScoreRegistProc(AmsScoreVO score) {
		int result = amsScoreMapper.acasysStudentScoreRegistProc(score);
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
	public String acasysStudentScoreUpdateProc(AmsScoreVO score) {
		int result = amsScoreMapper.acasysStudentScoreUpdateProc(score);
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
	public String acasysStudentScoreDelProc(AmsScoreVO delScore) {
		int result = amsScoreMapper.acasysStudentScoreDelProc(delScore);
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
	public List<AmsScoreVO> acasysStudentScoreSearch(AmsScoreVO amsScoreVO) {
		return amsScoreMapper.acasysStudentScoreSearch(amsScoreVO);
	}
	
	/**
	 * @Method Name : acasysStudentScoreExcel
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 엑셀
	 * @return
	 */
	@Override
	public List<AmsScoreVO> acasysStudentScoreExcel(String studentNo) {
		// TODO Auto-generated method stub
		return amsScoreMapper.acasysStudentScoreExcel(studentNo);
	}
	
	/**
	 * @Method Name : acasysStudentNameForExcel
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 엑셀 이름 조회
	 * @return
	 */
	@Override
	public String acasysStudentNameForExcel(String studentNo) {
		return amsScoreMapper.acasysStudentNameForExcel(studentNo);
	}
	
}
