/**
 * 
 */
package com.bugManage.entity;

import java.util.Date;

/**
 * 项目信息封装类
 * @author lou-jiandong
 * @date 2013-4-29
 */
public class ProjectInfo {
	private int projectID;
	private String projectName;
	private Date projectBeginTime;
	private Date projectEndTime;
	private String projectStatus;
	
	public ProjectInfo(){
		
	}
	
	/**
	 * @param projectID
	 * @param varchar
	 * @param projectBeginTime
	 * @param projectEndTime
	 * @param projectStatus
	 */
	public ProjectInfo(int projectID, String projectName, Date projectBeginTime,
			Date projectEndTime, String projectStatus) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.projectBeginTime = projectBeginTime;
		this.projectEndTime = projectEndTime;
		this.projectStatus = projectStatus;
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
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param varchar the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectBeginTime
	 */
	public Date getProjectBeginTime() {
		return projectBeginTime;
	}

	/**
	 * @param projectBeginTime the projectBeginTime to set
	 */
	public void setProjectBeginTime(Date projectBeginTime) {
		this.projectBeginTime = projectBeginTime;
	}

	/**
	 * @return the projectEndTime
	 */
	public Date getProjectEndTime() {
		return projectEndTime;
	}

	/**
	 * @param projectEndTime the projectEndTime to set
	 */
	public void setProjectEndTime(Date projectEndTime) {
		this.projectEndTime = projectEndTime;
	}

	/**
	 * @return the projectStatus
	 */
	public String getProjectStatus() {
		return projectStatus;
	}

	/**
	 * @param projectStatus the projectStatus to set
	 */
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
}
