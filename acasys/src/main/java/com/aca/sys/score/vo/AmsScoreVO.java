package com.aca.sys.score.vo;

import lombok.Data;

public @Data class AmsScoreVO {

	private String studentNo;
	private String studentName;
	private String scoreNo;
	private String startDate;
	private String endDate;
	private String termCd;
	private String korean;
	private String math;
	private String english;
	private String society;
	private String science;
	private String history;
	private String gubunVal;
	private String regUserId;
	private String regDttm;
	private String updUserId;
	private String updDttm;
	private String avgKorean;
	private String avgMath;
	private String avgEnglish;
	private String avgSociety;
	private String avgScience;
	private String avgHistory;
	private String averageScore;
	private String termNm;

}
