/**
 *  
 */
package com.aca.sys;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


/**
 * @FileName : CommonUtils.java
 * @Project : ssis
 * @Date : 2023. 9. 12.
 * @작성자 : admin
 * @변경이력 :
 * @프로그램 설명 : 공통 유틸리티
 */
public class CommonUtils extends StringUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

	// ==============================
	// 문자열(String) 관련 유틸
	// =============================
	/**
	 * @Method Name : convertUniCode2Ksc
	 * @작성일 : 2023. 9. 12.
	 * @작성자 : admin
	 * @변경이력 :
	 * @Method 설명 : 8859_1 ---> Ksc5601 문자열로 변환하여 return.
	 * @param code unicode 문자열
	 * @return String 변환 문자열
	 * @throws UnsupportedEncodingException
	 */
	public static String convertUnicode2Ksc(String code) throws UnsupportedEncodingException {
		String retr = "";
		retr = new String(code.getBytes("8859_1"), "KSC5601");

		return retr;
	}

	/**
	 * @Method Name : convertKsc2Unicode
	 * @작성일 : 2023. 9. 12.
	 * @작성자 : admin
	 * @변경이력 :
	 * @Method 설명 : Ksc5601 ---> 8859_1 문자열로 변환하여 return.
	 * @param code ksc5601 문자열
	 * @return String 변환 문자열
	 * @throws UnsupportedEncodingException
	 */
	public static String convertKsc2Unicode(String code) throws UnsupportedEncodingException {
		String retr = "";
		retr = new String(code.getBytes("8859_1"), "KSC5601");

		return retr;
	}

	/**
	 * @Method Name : removeCharacter
	 * @작성일 : 2023. 9. 12.
	 * @작성자 : admin
	 * @변경이력 : 
	 * @Method 설명 : 해당 문자열의 특정 character를 제거한 문자열을 return
	 * 
	 * <blockquote><pre>
	 * 예1) removeCharacter("33,111,000", ",") => 33111000
	 * 예2) removeCharacter("2002/02/02", "/") => 20020202
	 * </pre></blockquote>
	 * 
	 * @param sStr 원 문자열
	 * @param sChr 삭제할 문자
	 * @return 제거된 문자열
	 */
	public static String removeCharacter(String sStr, String sChr) {
		String retr = "";
		StringTokenizer st = new StringTokenizer(sStr, sChr);

		while (st.hasMoreTokens()) {
			retr += st.nextToken();
		}

		return retr;
	}

	/**
	 * @Method Name : toDecimalFormat
	 * @작성일 : 2023. 9. 12.
	 * @작성자 : admin
	 * @변경이력 : 
	 * @Method 설명 : 숫자열을 정의된 pattern 대로 변환하여 return
	 * 
	 * <blockquote><pre>
	 * 예1) toDecimalFormat("123456.789", "###,###.00") => 123,456.79
	 * 예2) toDecimalFormat("123456", "###,###.00") => 123,456.00
	 * 예3) toDecimalFormat("12345", "##0.###E0") => 12.345E3
	 * 예4) toDecimalFormat("12345", "#0.###E0") => 1.2345E4
	 * </pre></blockquote>
	 * 
	 * @param amount 변환할 숫자
	 * @param pattern 변환할 패턴
	 * @return
	 */
	public static String toDecimalFormat(double amount, String pattern) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		DecimalFormat df = (DecimalFormat) nf;
		String retr = "";

		df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		df.setDecimalSeparatorAlwaysShown(true);
		df.applyPattern(pattern);

		try {
			retr = df.format(amount);
		} catch (IllegalArgumentException e) {
			LOGGER.error("JtoDecimalFormat() has error");
		}

		return retr;
	}

	/**
	 * @Method Name : formatCurrency
	 * @작성일 : 2023. 9. 12.
	 * @작성자 : admin
	 * @변경이력 : 
	 * @Method 설명 : 숫자를 세자리로 끊은 값을 return.
	 * 
	 * <blockquote><pre>
	 * 예) formatCurrency(1234567) => 1,234,567
	 * </pre></blockquote
	 * 
	 * @param amount 변환할 숫자
	 * @return 숫자 문자열
	 */
	public static String formatCurrency(double amount) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String retr = "";

		try {
			retr = nf.format(amount);

			// 통화 단위 삭제
			if (retr.charAt(0) == '-') {
				retr = '-' + retr.substring(2);
			} else {
				retr = retr.substring(1);
			}
		} catch (NumberFormatException e) {
			LOGGER.error("JSPUtil.formatCurrency() has error");
		}

		return retr;
	}

	/**
	 * @Method Name : cutStringByLimit
	 * @작성일 : 2023. 9. 12.
	 * @작성자 : admin
	 * @변경이력 : 
	 * @Method 설명 : 제한 글자 이상의 글은 잘라서 return.
	 * 
	 * <blockquote><pre>
	 * Usage : cutStringByLimit("한글사용가능한지", 3);
	 * 예 ) cutStringByLimit("한글은 몇자까지 가능합니까?", 3) => 한글은
	 * </pre></blockquote>
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String cutStringByLimit(String str, int length) {
		int initLength = str.length();
		int cnt = 0;

		if (initLength <= length)
			return str;

		if (initLength > length) {
			for (int i = length; i >= 0; i--) {
				if ((int) str.charAt(i) < 127) {
					break;
				} else {
					cnt = cnt + 1;
				}
			}

			if (cnt == 0) {
				cnt = 1;
			}

			cnt = cnt % 2;

			if (cnt == 0) {
				length = length - 1;
			}
		}

		return str.substring(0, length);
	}

	// =========================================
	// 날자(Date) 관련 유틸
	// =========================================
	/**
	 * @Method Name : getCurrentDay
	 * @작성일 : 2023. 9. 13.
	 * @작성자 : admin
	 * @변경이력 :
	 * @Method 설명 : 오늘 날짜를 리턴한다.(yyyy-MM-dd)
	 * @return String
	 */
	public static String getCurrentDay() {
		return (new java.sql.Date(System.currentTimeMillis())).toString();
	}

	/**
	 * @Method Name : getCurrentFormatDate
	 * @작성일 : 2023. 9. 13.
	 * @작성자 : admin
	 * @변경이력 : 
	 * @Method 설명 : pattern 에 맞는 현재 시간 반환
	 * 
	 * <blockquote><pre>
	 * (예 1) format "yyyy-MM-dd"      =>  2023-09-13
	 * (예 2) format "yyyyMMddHHmmss"  =>  20230913232121 (0~23시간 타입)
	 * </pre></blockquote>
	 * 
	 * @param format 현재시간의 pattern(default yyyyMMdd)
	 * @return format pattern으로 변환된 현재 한국 시간
	 */
	public static String getCurrentFormatDate(String format) {
		int millisPerHour = 60 * 60 * 1000; // 1hour(ms) = 60s * 60m * 1000ms
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		SimpleTimeZone timeZone = new SimpleTimeZone(9 * millisPerHour, "KST");
		fmt.setTimeZone(timeZone);

		long time = System.currentTimeMillis();
		String str = fmt.format(new java.util.Date(time));

		return str;
	}

	/**
	 * @Method Name : getFormatDate
	 * @작성일 : 2023. 9. 13.
	 * @작성자 : admin
	 * @변경이력 :
	 * @Method 설명 : 파라메타로 받은 날짜를 해당 format 맞게 반환
	 * @param sDate  변환할 문자열 날짜
	 * @param format
	 * @return String
	 */
	public static String getFormatDate(String sDate, String format) {
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		ParsePosition pp = new ParsePosition(0);
		Date date = dateFormat.parse(sDate, pp);
		SimpleDateFormat retFormat = new SimpleDateFormat(format);

		return retFormat.format(date);
	}

	/**
	 * @Method Name : getDifferDays
	 * @작성일 : 2023. 9. 13.
	 * @작성자 : admin
	 * @변경이력 :
	 * @Method 설명 : 두 날짜 사이의 일수 계산
	 * @param sDate 시작일자
	 * @param eDate 종료일자
	 * @return long
	 * @throws ParseException
	 */
	public static long getDifferDays(String sDate, String eDate) throws ParseException {
		String strFormat = "yyyyMMdd"; // strStartDate 와 strEndDate 의 format

		// SimpleDateFormat 을 이용하여 startDate와 endDate의 Date 객체를 생성한다.
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		Date startDate = sdf.parse(sDate);
		Date endDate = sdf.parse(eDate);

		// 두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
		long diffDay = (startDate.getTime() - endDate.getTime()) / (24 * 60 * 60 * 1000);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("{} 일", diffDay);
		}

		return diffDay;
	}

	/**
	 * @Method Name : encrypt
	 * @작성일 : 2024. 3. 7.
	 * @작성자 : Yoga Pro 9i
	 * @변경이력 : 
	 * @Method 설명 : 입력 문자열을 SHA-256으로 암호화하여 해시 값을 반환하는 메서드
	 * @param text
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String encrypt(String text) throws NoSuchAlgorithmException {
		// SHA-256 알고리즘의 인스턴스 생성
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		// 입력 문자열의 바이트 배열을 업데이트하여 해시 값을 계산
		md.update(text.getBytes());

		// 계산된 해시 값을 16진수 문자열로 변환하여 반환
		return bytesToHex(md.digest());
	}

	/**
	 * @Method Name : bytesToHex
	 * @작성일 : 2024. 3. 7.
	 * @작성자 : Yoga Pro 9i
	 * @변경이력 : 
	 * @Method 설명 : 바이트 배열을 16진수 문자열로 변환하는 메서드
	 * @param bytes
	 * @return
	 */
	private String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();

		for (byte b : bytes) {
			// 바이트 값을 16진수 문자열로 변환하여 StringBuilder에 추가
			builder.append(String.format("%02x", b));
		}

		// StringBuilder의 내용을 문자열로 반환
		return builder.toString();
	}

}
