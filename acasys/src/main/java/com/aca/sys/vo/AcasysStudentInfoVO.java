package com.aca.sys.vo;

import com.aca.sys.Paging;

import lombok.Data;

public @Data class AcasysStudentInfoVO {

	private String studentNo;
	private String studentName;
	private String studentAge;
	private String studentSchool;
	private String studentWantedSchool;
	private String studentSchoolGubunCd;
	private String studentSchoolGubunNm;
	private String studentSchoolMajorCd;
	private String studentSchoolMajorNm;
	private String studentTierStatusCd;
	private String studentTierStatusNm;
	private String studentPostCd;
	private String studentAdd;
	private String studentAddDetail;
	private String studentPhone;
	private String studentParentsPhone;
	private String studentNote;
	private String studentDelYn;
	private String regUserId;
	private String regDttm;
	private String updUserId;
	private String updDttm;
	private String studenNmSearch;
	private Paging paging;

}
