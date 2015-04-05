package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * BugœÍœ∏–≈œ¢Action
 * @author lou-jiandong
 * @date 2013-5-5
 */
@SuppressWarnings("serial")
public class BugDetailAction extends ActionSupport{
	private int id;
	private int projectID;
	private String projectName;
	private BugInfo bugInfo;
	private List<BugInfo> list;
	private HibernateDao hibernateDao;
	
	public String execute(){
		Map<String, Object> session = ActionContext.getContext().getSession();	
		projectID = (Integer) session.get("projectID");
		projectName = (String) session.get("projectName");
		
		list = hibernateDao.FindBugInfoByID(id);
		bugInfo = list.get(0);
		
		return "success";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the bugInfo
	 */
	public BugInfo getBugInfo() {
		return bugInfo;
	}

	/**
	 * @param bugInfo the bugInfo to set
	 */
	public void setBugInfo(BugInfo bugInfo) {
		this.bugInfo = bugInfo;
	}

	/**
	 * @return the list
	 */
	public List<BugInfo> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<BugInfo> list) {
		this.list = list;
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
