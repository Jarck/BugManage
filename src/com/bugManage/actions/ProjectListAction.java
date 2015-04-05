package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.ProjectInfo;
import com.bugManage.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��Ŀ�б�Action
 * @author lou-jiandong
 * @date 2013-5-11
 */
@SuppressWarnings("serial")
public class ProjectListAction extends ActionSupport{
	private List<ProjectInfo> projectList;
	private HibernateDao hibernateDao;
	
	public String execute(){
		
		//��ȡ��¼�û���
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserInfo user = (UserInfo) session.get("loginUser");
		
		projectList = hibernateDao.FindProjectList(user.email);
		
		return "success";
	}

	/**
	 * @return the projectList
	 */
	public List<ProjectInfo> getProjectList() {
		return projectList;
	}

	/**
	 * @param projectList the projectList to set
	 */
	public void setProjectList(List<ProjectInfo> projectList) {
		this.projectList = projectList;
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
