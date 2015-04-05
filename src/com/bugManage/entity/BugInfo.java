package com.bugManage.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Bug信息封装类
 * @author lou-jiandong
 * @date 2013-4-29
 */
@SuppressWarnings("serial")
public class BugInfo implements java.io.Serializable{
	public int bugID;
	public String bugName;
	public String bugState;
	public Timestamp bugBeginTime;
	public Timestamp bugEndTime;
	public int projectID;
	public String bugType;
	public String bugFinder;
	public String bugDealer;
	
	/*******Begin Add 2013-05-04**********/
	private String bugContent;
	private String version;
	private String module;
	/*******End Add 2013-05-04**********/
	
	public BugInfo(){
		
	}
	
	/**
	 * @param bugID
	 * @param bugName
	 * @param bugState
	 * @param bugBeginTime
	 * @param bugEndTime
	 * @param projectID
	 * @param bugType
	 * @param bugFinder
	 * @param bugDealer
	 */
	public BugInfo(int bugID, String bugName, String bugState,
			Timestamp bugBeginTime, Timestamp bugEndTime, int projectID,
			String bugType, String bugFinder, String bugDealer,
			String bugContent, String version, String module) {
		super();
		this.bugID = bugID;
		this.bugName = bugName;
		this.bugState = bugState;
		this.bugBeginTime = bugBeginTime;
		this.bugEndTime = bugEndTime;
		this.projectID = projectID;
		this.bugType = bugType;
		this.bugFinder = bugFinder;
		this.bugDealer = bugDealer;
		this.bugContent = bugContent;
		this.version = version;
		this.module = module;
	}

	/**
	 * @return the bugID
	 */
	public int getBugID() {
		return bugID;
	}

	/**
	 * @param bugID the bugID to set
	 */
	public void setBugID(int bugID) {
		this.bugID = bugID;
	}

	/**
	 * @return the bugName
	 */
	public String getBugName() {
		return bugName;
	}

	/**
	 * @param bugName the bugName to set
	 */
	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	/**
	 * @return the bugState
	 */
	public String getBugState() {
		return bugState;
	}

	/**
	 * @param bugState the bugState to set
	 */
	public void setBugState(String bugState) {
		this.bugState = bugState;
	}

	/**
	 * @return the bugBeginTime
	 */
	public Date getBugBeginTime() {
		return bugBeginTime;
	}

	/**
	 * @param bugBeginTime the bugBeginTime to set
	 */
	public void setBugBeginTime(Timestamp bugBeginTime) {
		this.bugBeginTime = bugBeginTime;
	}

	/**
	 * @return the bugEndTime
	 */
	public Date getBugEndTime() {
		return bugEndTime;
	}

	/**
	 * @param bugEndTime the bugEndTime to set
	 */
	public void setBugEndTime(Timestamp bugEndTime) {
		this.bugEndTime = bugEndTime;
	}

	/**
	 * @return the projectID
	 */
	public int getProjectID() {
		return projectID;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	/**
	 * @return the bugType
	 */
	public String getBugType() {
		return bugType;
	}

	/**
	 * @param bugType the bugType to set
	 */
	public void setBugType(String bugType) {
		this.bugType = bugType;
	}

	/**
	 * @return the bugFinder
	 */
	public String getBugFinder() {
		return bugFinder;
	}

	/**
	 * @param bugFinder the bugFinder to set
	 */
	public void setBugFinder(String bugFinder) {
		this.bugFinder = bugFinder;
	}

	/**
	 * @return the bugDealer
	 */
	public String getBugDealer() {
		return bugDealer;
	}

	/**
	 * @param bugDealer the bugDealer to set
	 */
	public void setBugDealer(String bugDealer) {
		this.bugDealer = bugDealer;
	}

	/**
	 * @return the bugContent
	 */
	public String getBugContent() {
		return bugContent;
	}

	/**
	 * @param bugContent the bugContent to set
	 */
	public void setBugContent(String bugContent) {
		this.bugContent = bugContent;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}
	
}
