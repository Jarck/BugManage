/**
 * 
 */
package com.bugManage.entity;

/**
 * 用户信息封装类
 * @author lou-jiandong
 * @date 2013-4-29
 */
public class UserInfo {
	public int uID;
	public String email;
	public String password;
	public String name;
	public int projectID;
	
	public UserInfo(){
		
	}
	
	/**
	 * @param uID
	 * @param email
	 * @param password
	 * @param name
	 * @param projectID
	 */
	public UserInfo(int uID, String email, String password, String name,
			int projectID) {
		super();
		this.uID = uID;
		this.email = email;
		this.password = password;
		this.name = name;
		this.projectID = projectID;
	}
	
	/**
	 * @return the uID
	 */
	public int getuID() {
		return uID;
	}
	/**
	 * @param uID the uID to set
	 */
	public void setuID(int uID) {
		this.uID = uID;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
}
