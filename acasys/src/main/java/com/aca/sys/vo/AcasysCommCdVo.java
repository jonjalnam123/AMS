package com.aca.sys.vo;

public class AcasysCommCdVo {

	private String cd;
	private String upperCd;
	private String cdNm;
	private String bassCdVal;
	private String rm;
	private String sortOrdr;
	private String codeLvl;
	private String useYn;
	private String dispYn;
	private String regUserId;
	private String regDttm;
	private String updUserId;
	private String updDttm;

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getUpperCd() {
		return upperCd;
	}

	public void setUpperCd(String upperCd) {
		this.upperCd = upperCd;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getBassCdVal() {
		return bassCdVal;
	}

	public void setBassCdVal(String bassCdVal) {
		this.bassCdVal = bassCdVal;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getSortOrdr() {
		return sortOrdr;
	}

	public void setSortOrdr(String sortOrdr) {
		this.sortOrdr = sortOrdr;
	}

	public String getCodeLvl() {
		return codeLvl;
	}

	public void setCodeLvl(String codeLvl) {
		this.codeLvl = codeLvl;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getDispYn() {
		return dispYn;
	}

	public void setDispYn(String dispYn) {
		this.dispYn = dispYn;
	}

	public String getRegUserId() {
		return regUserId;
	}

	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	public String getRegDttm() {
		return regDttm;
	}

	public void setRegDttm(String regDttm) {
		this.regDttm = regDttm;
	}

	public String getUpdUserId() {
		return updUserId;
	}

	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
	}

	public String getUpdDttm() {
		return updDttm;
	}

	public void setUpdDttm(String updDttm) {
		this.updDttm = updDttm;
	}

	@Override
	public String toString() {
		return "AcasysCommCdVo [cd=" + cd + ", upperCd=" + upperCd + ", cdNm=" + cdNm + ", bassCdVal=" + bassCdVal
				+ ", rm=" + rm + ", sortOrdr=" + sortOrdr + ", codeLvl=" + codeLvl + ", useYn=" + useYn + ", dispYn="
				+ dispYn + ", regUserId=" + regUserId + ", regDttm=" + regDttm + ", updUserId=" + updUserId
				+ ", updDttm=" + updDttm + "]";
	}

}
