package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 列出项目中所有Bug信息Action
 * @author lou-jiandong
 * @date 2013-5-11
 */
@SuppressWarnings("serial")
public class ProjectBugListAction extends ActionSupport{
	private int projectID;
	private String projectName;
	private List<BugInfo> bugInfoList;
	private HibernateDao hibernateDao;
	
	public String execute(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		projectID = (Integer) session.get("projectID");
		projectName = (String) session.get("projectName");
		
		projectName = hibernateDao.FindProjectInfoByID(projectID).get(0).getProjectName();
		bugInfoList = hibernateDao.FindProjectBugList(projectID);
		
//		Map<String,Object> session = ActionContext.getContext().getSession();
//		session.put("projectID", projectID);
//		session.put("projectName", projectName);
		
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
