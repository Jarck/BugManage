package com.bugManage.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * 
 * @author lou-jiandong
 * @date 2013-4-29
 */
public class Common {
    
	@SuppressWarnings("unused")
	private static final String filename = "Common.java";

	//获取配置文件参数
	public static String getConfigTag(String tagName){
		String tagValue = "";
		
		//读取配置文件
		ResourceBundle resourcesTable = ResourceBundle.getBundle(Constant.CONFIG_FILE);
		tagValue = resourcesTable.getString(tagName);
		
		return tagValue;
	}
	
	//获取当前时间
	public static String getNowDate(String format){
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		String time = bartDateFormat.format(date);
		
		return time;
	}
	
	//判断是否为数字
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	 }
	
}