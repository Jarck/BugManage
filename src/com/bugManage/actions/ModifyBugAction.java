package com.bugManage.actions;

import java.util.ArrayList;
import java.util.List;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.bugManage.entity.UserInfo;
import com.bugManage.util.MailHelper;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Bug状态修改Action
 * @author lou-jiandong
 * @date 2013-5-10
 */
@SuppressWarnings("serial")
public class ModifyBugAction extends ActionSupport{
	private int projectID;
	private String projectName; 
	private BugInfo bugModifyInfo;
	private List<BugInfo> bugInfoList;
	private HibernateDao hibernateDao;
	
	public String execute(){
		
		if(hibernateDao.ModifyBugInfo(bugModifyInfo)){
			bugInfoList = hibernateDao.FindBugInfoByID(bugModifyInfo.getBugID());
			//要有项目ID和项目名，不然AllBug.jsp会报错
			projectID = bugInfoList.get(0).getProjectID();
			projectName = hibernateDao.FindProjectInfoByID(projectID).get(0).getProjectName();
			
			//发送邮件
//			List<UserInfo> userList = new ArrayList<UserInfo>();
//			BugInfo bugInfo = hibernateDao.FindBugInfoByID(bugModifyInfo.getBugID()).get(0);
//			userList = hibernateDao.FindUserByProject(projectName);
//			MailHelper.mailDetail(userList, bugInfo);
			
			return "success";
		}
		
		return "error";
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
	 * @return the bugModifyInfo
	 */
	public BugInfo getBugModifyInfo() {
		return bugModifyInfo;
	}
	/**
	 * @param bugModifyInfo the bugModifyInfo to set
	 */
	public void setBugModifyInfo(BugInfo bugModifyInfo) {
		this.bugModifyInfo = bugModifyInfo;
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
