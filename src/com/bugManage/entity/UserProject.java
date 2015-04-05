package com.bugManage.entity;

/**
 * 用户与项目信息封装类
 * @author lou-jiandong
 * @date 2013-5-11
 */
public class UserProject {
	private int ID;
	private String email;
	private String projectName;
	
	public UserProject(){
		
	}
	
	/**
	 * @param iD
	 * @param email
	 * @param projectID
	 */
	public UserProject(int iD, String email, String projectName) {
		super();
		ID = iD;
		this.email = email;
		this.projectName = projectName;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
