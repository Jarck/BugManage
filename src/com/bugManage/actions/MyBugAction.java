package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.bugManage.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取个人Bug信息Action
 * @author lou-jiandong
 * @date 2013-5-12
 */
@SuppressWarnings("serial")
public class MyBugAction extends ActionSupport{
	private int projectID;
	private String projectName;
	private List<BugInfo> unclosedBugList;
	private List<BugInfo> closedBugList;
	private HibernateDao hibernateDao;
	
	public String execute(){
		//获取登录用户名、项目ID和项目名
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserInfo user = (UserInfo) session.get("loginUser");	
		projectID = (Integer) session.get("projectID");
		projectName = (String) session.get("projectName");
		
		unclosedBugList = hibernateDao.FindMyBug(user.getName(), projectID, false);
		closedBugList = hibernateDao.FindMyBug(user.getName(), projectID, true);
		
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
	 * @return the unclosedBugList
	 */
	public List<BugInfo> getUnclosedBugList() {
		return unclosedBugList;
	}

	/**
	 * @param unclosedBugList the unclosedBugList to set
	 */
	public void setUnclosedBugList(List<BugInfo> unclosedBugList) {
		this.unclosedBugList = unclosedBugList;
	}

	/**
	 * @return the closedBugList
	 */
	public List<BugInfo> getClosedBugList() {
		return closedBugList;
	}

	/**
	 * @param closedBugList the closedBugList to set
	 */
	public void setClosedBugList(List<BugInfo> closedBugList) {
		this.closedBugList = closedBugList;
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
