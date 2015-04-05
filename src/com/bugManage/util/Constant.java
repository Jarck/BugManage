package com.bugManage.util;

/**
 * 常量定义
 * @author lou-jiandong
 * @date 2013-4-28
 */
public class Constant {
	
	public static final String CONFIG_FILE="config";
	public static final String METHOD_START = " Begin";
	public static final String METHOD_END = " End";
	public static final String TIME_FORMAT = "yyyy-MM-dd";
	public static final String SEM = ";";
	
	/************** Bug Info Begin *********************/
	public static final int BUG_STATE_NEW = 1;					//Bug状态为新建
	public static final int BUG_STATE_UNCLOSED = 2;				//Bug状态为修复中
	public static final int BUG_STATE_SOLVE = 3;				//Bug状态为已修复
	public static final int BUG_STATE_CLOSED = 4;				//Bug状态为关闭
	public static final int BUG_TYPE_URGENT = 5;				//Bug类型为严重
	public static final String BUG_SELECT_NUMBER_ALL = "0";
	public static final String BUG_SELECT_NUMBER_ONE = "1";
	/************** Bug Info End *********************/
}