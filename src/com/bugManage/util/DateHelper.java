package com.bugManage.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转化方法的封装
 * @author lou-jiandong
 * @date 2013-4-29
 */
public class DateHelper {

	/**
	 * 将String类型的时间转换为Long(系统毫秒数)
	 * @param time
	 */
	public static Long DateStrToTimeMillis(String time) {
		// String time = "2012-09-04 10:27:27";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return formatter.parse(time).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将Long（系统毫秒数）转换为Date String
	 * @param time
	 * @return
	 */
	public static String TimeMillisToDateStr(Long time) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(time);
		String ctime = formatter.format(date);
		return ctime;

	}

	/**
	 * 将Long（系统毫秒数）转换为Date String(10位)
	 * @param time
	 * @param format   	eg. "yyyyMMddHH"
	 * @return			eg. "2012091210"
	 */
	public static String TimeMillisToDateStr(Long time, String format) {		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date(time);
		String ctime = formatter.format(date);
		return ctime;
	}
	
	/**
	 * 将时间戳转换为Date String(12位)
	 * @param time
	 * @param format   	eg. "yyyyMMddHHmm"
	 * @return			eg. "201209141437"
	 */
	public static String TimeStampToStr(Timestamp time, String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(time);		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		String DateStr = TimeMillisToDateStr(System.currentTimeMillis());
		
		System.out.println(DateStr);
		
		System.out.println(DateStrToTimeMillis(DateStr));
		
		System.out.println(TimeMillisToDateStr(System.currentTimeMillis(), "yyyyMMddHH"));
		*/
		Timestamp time = new Timestamp(System.currentTimeMillis());
		time = Timestamp.valueOf(DateHelper.TimeMillisToDateStr(System.currentTimeMillis()));
		System.out.println(time);
		
	}

}
