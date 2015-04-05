package com.bugManage.entity;

import java.sql.Time;

/**
 * 日志信息封装类
 * @author lou-jiandong
 * @date 2013-5-14
 */
public class LogHistory {
	private String uid;
	private String logDate;
	private Time logTime;
	private String logLevel;
	private String fileName;
	private String methodName;
	private String msg;
	
	public LogHistory(){
		
	}
	
	/**
	 * @param uid
	 * @param logDate
	 * @param logTime
	 * @param logLevel
	 * @param fileName
	 * @param methodName
	 * @param msg
	 */
	public LogHistory(String uid, String logDate, Time logTime, String logLevel,
			String fileName, String methodName, String msg) {
		super();
		this.uid = uid;
		this.logDate = logDate;
		this.logTime = logTime;
		this.logLevel = logLevel;
		this.fileName = fileName;
		this.methodName = methodName;
		this.msg = msg;
	}
	
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the logDate
	 */
	public String getLogDate() {
		return logDate;
	}
	/**
	 * @param logDate the logDate to set
	 */
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	/**
	 * @return the logTime
	 */
	public Time getLogTime() {
		return logTime;
	}
	/**
	 * @param logTime the logTime to set
	 */
	public void setLogTime(Time logTime) {
		this.logTime = logTime;
	}
	/**
	 * @return the logLevel
	 */
	public String getLogLevel() {
		return logLevel;
	}
	/**
	 * @param logLevel the logLevel to set
	 */
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}
	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}