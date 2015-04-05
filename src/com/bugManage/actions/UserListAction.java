package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ȡĳ��Ŀ�����в�����Ա��ϢAction
 * @author lou-jiandong
 * @date 2013-5-18
 */
@SuppressWarnings("serial")
public class UserListAction extends ActionSupport{
	private int projectID;
	private String projectName;
	private List<UserInfo> userList;
	private HibernateDao hibernateDao;
	
	public String execute(){
		//��ȡ��¼�û�������ĿID����Ŀ��
		Map<String, Object> session = ActionContext.getContext().getSession();
		projectID = (Integer) session.get("projectID");
		projectName = (String) session.get("projectName");
		
		userList = hibernateDao.FindUserByProject(projectName);
		
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
	 * @return the userList
	 */
	public List<UserInfo> getUserList() {
		return userList;
	}
	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
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
