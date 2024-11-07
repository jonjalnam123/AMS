package com.aca.sys.score.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aca.sys.code.vo.AmsCodeVO;
import com.aca.sys.score.vo.AmsScoreVO;

@Mapper
public interface AmsScoreMapper {
	
	/**
	 * @Method Name : acasysStudentScoreRegistProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 등록 진행
	 * @return
	 */
	int acasysStudentScoreRegistProc(AmsScoreVO score);

	/**
	 * @Method Name : acasysStudentScoreUpdateProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 수정 진행
	 * @return
	 */
	int acasysStudentScoreUpdateProc(AmsScoreVO score);
	
	/**
	 * @Method Name : acasysStudentScoreDelProc
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 삭제 진행
	 * @return
	 */
	int acasysStudentScoreDelProc(AmsScoreVO delScore);

	/**
	 * @Method Name : acasysStudentScoreSearch
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 조회
	 * @return
	 */
	List<AmsScoreVO> acasysStudentScoreSearch(AmsScoreVO amsScoreVO);

	/**
	 * @Method Name : acasysStudentScoreExcel
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 엑셀
	 * @return
	 */
	List<AmsScoreVO> acasysStudentScoreExcel(String studentNo);

	/**
	 * @Method Name : acasysStudentNameForExcel
	 * @작성일 : 2024. 10. 21
	 * @작성자 : 최정석
	 * @변경이력 :
	 * @Method 설명 : 학생 성적 엑셀 이름 조회
	 * @return
	 */
	String acasysStudentNameForExcel(String studentNo);

}
