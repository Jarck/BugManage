package com.bugManage.util;

import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.LogHistory;

/**
 * 日志处理
 * @author lou-jiandong
 * @date 2013-4-29
 */
public class TraceLog {

	private static Logger logger = Logger.getLogger("LogFile");
	
	private static HibernateDao hibernateDao;
	
	/**
	 * @return the hibernateDao
	 */
	public HibernateDao getHibernateDao() {
		return hibernateDao;
	}

	/**
	 * @param hibernateDao the hibernateDao to set
	 */
	@SuppressWarnings("static-access")
	public void setHibernateDao(HibernateDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}

	//Debug
	public static void debugLog(String filename,String method,String msg) {		
		try{
			logger.debug(filename + "->" + method + ":" +msg);
			putDbLog(filename,method,msg,1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Info
	public static void infoLog(String filename,String method,String msg) {		
		try{
			logger.info(filename + "->" + method + ":" +msg);
			putDbLog(filename,method,msg,2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Warn
	public static void warnbLog(String filename,String method,String msg) {		
		try{
			logger.warn(filename + "->" + method + ":" +msg);
			putDbLog(filename,method,msg,3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//ERROR
	public static void errLog(String filename,String method,String msg){		
		try {
			logger.error(filename + "->" + method + ":" +msg);
			putDbLog(filename,method,msg,4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 保存Log到数据库
	 * @param
	 * @return
	 * @throws Exception
	 */
	public static void putDbLog(String filename,String method,String msg,int level) {		
		
		try{
			Integer intLevel = 0;
			String logLevel = Common.getConfigTag("LogLevel");
			
			//logLevel
			if(logLevel==null || logLevel.equals("") || !Common.isInteger(logLevel)){
				intLevel = 0;
			}else{
				intLevel = Integer.parseInt(logLevel);
			}
			
			if(intLevel>0 && intLevel<=level){
				//保存Log
				saveLog(String.valueOf(level),filename, method, msg);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void saveLog(String level,String filename,String method,String msg) throws Exception {
		
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String t = bartDateFormat.format(d);
		
		String message = "";
		
//		Date date = bartDateFormat.parse(t);
		Time time = new Time(d.getTime());		
		LogHistory logHistory = new LogHistory();
		
		message = substring(msg, 200);
		
//		logHistory.setLogDate(date);
		logHistory.setLogDate(t);
		logHistory.setLogTime(time);
		logHistory.setLogLevel(level);
		logHistory.setFileName(filename);
		logHistory.setMethodName(method);
		logHistory.setMsg(message);
		
		System.out.println("***************************************");
		System.out.println("logHistory : " + logHistory.getFileName());
		
		hibernateDao.saveLogHistory(logHistory);
		
	}
	
	private static String substring(String orignal,int count) throws UnsupportedEncodingException {
		  if (orignal != null && !"".equals(orignal)) {
		   byte[] byt = orignal.getBytes("utf-8");
		   if(byt.length > count){
		    StringBuffer buff = new StringBuffer();
		          char c;
		          for (int i = 0; i < count; i++) {
		              c = orignal.charAt(i);
		              buff.append(c);
		              if(isChineseChar(c)){
		                  --count;
		              }
		          }
		          return buff.toString();
		   }else{
		    return orignal;
		   }
		  }else{
		   return "";
		  }
		 }
	private static boolean isChineseChar(char c) throws UnsupportedEncodingException {
		return String.valueOf(c).getBytes("GBK").length > 1;
		}  
		 
}