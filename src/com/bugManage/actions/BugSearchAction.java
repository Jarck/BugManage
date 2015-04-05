package com.bugManage.actions;

import java.util.List;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取Bug信息Action
 * @author lou-jiandong
 * @date 2013-5-5
 */
@SuppressWarnings("serial")
public class BugSearchAction extends ActionSupport{
	private int projectID;
	private String projectName;
	private BugInfo bugSearchInfo;
	private List<BugInfo> bugInfoList;
	private HibernateDao hibernateDao;
	
	public String execute(){
		projectID = bugSearchInfo.getProjectID();
		projectName = hibernateDao.FindProjectInfoByID(projectID).get(0).getProjectName();
		bugInfoList = hibernateDao.FindBugInfo(bugSearchInfo);
		
		return "success";
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
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the bugSearchInfo
	 */
	public BugInfo getBugSearchInfo() {
		return bugSearchInfo;
	}

	/**
	 * @param bugSearchInfo the bugSearchInfo to set
	 */
	public void setBugSearchInfo(BugInfo bugSearchInfo) {
		this.bugSearchInfo = bugSearchInfo;
	}

	/**
	 * @return the bugInfoList
	 */
	public List<BugInfo> getBugInfoList() {
		return bugInfoList;
	}

	/**
	 * @param bugInfoList the bugInfoList to set
	 */
	public void setBugInfoList(List<BugInfo> bugInfoList) {
		this.bugInfoList = bugInfoList;
	}

	/**
	 * @return the hibernateDao
	 */
	public HibernateDao getHibernateDao() {
		return hibernateDao;
	}

	/**
	 * @param hibernateDao the hibernateDao to set
	 */
	public void setHibernateDao(HibernateDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}
	
}
