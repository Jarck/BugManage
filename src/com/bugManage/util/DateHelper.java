package com.bugManage.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ��ת�������ķ�װ
 * @author lou-jiandong
 * @date 2013-4-29
 */
public class DateHelper {

	/**
	 * ��String���͵�ʱ��ת��ΪLong(ϵͳ������)
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
	 * ��Long��ϵͳ��������ת��ΪDate String
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
	 * ��Long��ϵͳ��������ת��ΪDate String(10λ)
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
	 * ��ʱ���ת��ΪDate String(12λ)
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
