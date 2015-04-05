package com.bugManage.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.UserInfo;
import com.bugManage.util.Constant;
import com.bugManage.util.MailHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 创建新项目Action
 * @author lou-jiandong
 * @date 2013-5-11
 */
@SuppressWarnings("serial")
public class CreateProjectAction extends ActionSupport{
	private String projectName;
	private String emailList;
	private HibernateDao hibernateDao;
	
	public void validate() {
		if ("".equals(projectName) || projectName == null) {
			this.addFieldError("projectName", "项目名不能为空!");
		}
	}
	
	public String execute(){
		//获取登录用户名、项目ID和项目名
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserInfo user = (UserInfo) session.get("loginUser");
		
		String email = user.email + Constant.SEM + emailList;
		
		boolean blnRet = hibernateDao.CreateProject(projectName, email);
		
		if(true == blnRet){
			//发送邮件
//			List<UserInfo> list = new ArrayList<UserInfo>();
//			list = hibernateDao.FindUserByProject(projectName);
//			MailHelper.mailDetail(list,projectName);
			return "success";
		}
		
		return "error";
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
	 * @return the emailList
	 */
	public String getEmailList() {
		return emailList;
	}
	/**
	 * @param emailList the emailList to set
	 */
	public void setEmailList(String emailList) {
		this.emailList = emailList;
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
