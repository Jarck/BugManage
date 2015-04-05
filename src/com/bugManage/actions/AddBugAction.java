package com.bugManage.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.bugManage.entity.UserInfo;
import com.bugManage.util.Constant;
import com.bugManage.util.DateHelper;
import com.bugManage.util.MailHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 添加BugAction
 * @author lou-jiandong
 * @date 2013-5-3
 */
@SuppressWarnings("serial")
public class AddBugAction extends ActionSupport{
	private int projectID;
	private String projectName; 
	private BugInfo bugInfo;
	private List<BugInfo> bugInfoList;
	private HibernateDao hibernateDao;
	
	public void validate() {
		//判断Bug 标题 输入是否为空
		if ("".equals(bugInfo.getBugName()) || bugInfo.getBugName() == null) {
			this.addFieldError("title", "Bug 标题不能为空!");
		}
	}
	
	public String execute(){
		boolean blnRet = false;
		List<UserInfo> userList = new ArrayList<UserInfo>();
		
		//获取登录用户名、项目ID和项目名
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserInfo user = (UserInfo) session.get("loginUser");	
		projectID = (Integer) session.get("projectID");
		projectName = (String) session.get("projectName");
		
		//获取当前系统时间
		String date = DateHelper.TimeMillisToDateStr(System.currentTimeMillis());
		
		//设置所属项目
		bugInfo.setProjectID(projectID);
		//设置Bug初始状态为 新建
		bugInfo.setBugState(Constant.BUG_SELECT_NUMBER_ONE);
		//设置Bug创建时间
		bugInfo.setBugBeginTime(Timestamp.valueOf(date));
		//设置Bug发现者名字
		bugInfo.setBugFinder(user.name);
		
		blnRet = hibernateDao.SaveBugInfo(bugInfo);
		if(true == blnRet){
			//发送邮件
//			userList = hibernateDao.FindUserByProject(projectName);
//			MailHelper.mailDetail(userList, bugInfo);
//			
			bugInfoList = hibernateDao.FindBugInfo(bugInfo);

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
