package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.bugManage.util.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 项目Bug信息Action
 * @author lou-jiandong
 * @date 2013-5-16
 */
@SuppressWarnings("serial")
public class ProjectInfoAction extends ActionSupport{
	private int allBugNum;						//所有的Bug数
	private int unClosedBugNum;					//新建的Bug数
	private int sloveBugNum;    				//已修复的Bug数
	private int closedBugNum;					//关闭的Bug数
	private int projectID;
	private String projectName;
	private List<BugInfo> urgentBugInfoList;
	private List<BugInfo> newBugInfoList;
	private HibernateDao hibernateDao;
	
	public String execute(){
		
		projectName = hibernateDao.FindProjectInfoByID(projectID).get(0).getProjectName();
		
		Map<String, Object> session = ActionContext.getContext().getSession();

//		if(session.get("projectID").equals(null)){
			session.put("projectID", projectID);
			session.put("projectName", projectName);
//		} else {
//			projectID = (Integer) session.get("projectID");
//		}
		
		System.out.println("&&&&&&&&&&&&&&& ProjectInfoAction session projectID : " + projectID);
		System.out.println("&&&&&&&&&&&&&&& ProjectInfoAction session projectName : " + projectName);
		
		allBugNum = hibernateDao.FindProjectBugList(projectID).size();
		unClosedBugNum = hibernateDao.FindBugList(projectID, Constant.BUG_STATE_NEW).size();
		sloveBugNum = hibernateDao.FindBugList(projectID, Constant.BUG_STATE_SOLVE).size();
		closedBugNum = hibernateDao.FindBugList(projectID, Constant.BUG_STATE_CLOSED).size();
		
		urgentBugInfoList = hibernateDao.FindBugByState(projectID, Constant.BUG_TYPE_URGENT);
		newBugInfoList = hibernateDao.FindProjectBugList(projectID);
		
		return "success";
	}
	
	/**
	 * @return the allBugNum
	 */
	public int getAllBugNum() {
		return allBugNum;
	}
	/**
	 * @param allBugNum the allBugNum to set
	 */
	public void setAllBugNum(int allBugNum) {
		this.allBugNum = allBugNum;
	}
	/**
	 * @return the unClosedBugNum
	 */
	public int getUnClosedBugNum() {
		return unClosedBugNum;
	}
	/**
	 * @param unClosedBugNum the unClosedBugNum to set
	 */
	public void setUnClosedBugNum(int unClosedBugNum) {
		this.unClosedBugNum = unClosedBugNum;
	}
	/**
	 * @return the sloveBugNum
	 */
	public int getSloveBugNum() {
		return sloveBugNum;
	}
	/**
	 * @param sloveBugNum the sloveBugNum to set
	 */
	public void setSloveBugNum(int sloveBugNum) {
		this.sloveBugNum = sloveBugNum;
	}
	/**
	 * @return the closedBugNum
	 */
	public int getClosedBugNum() {
		return closedBugNum;
	}
	/**
	 * @param closedBugNum the closedBugNum to set
	 */
	public void setClosedBugNum(int closedBugNum) {
		this.closedBugNum = closedBugNum;
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
	 * @return the urgentBugInfoList
	 */
	public List<BugInfo> getUrgentBugInfoList() {
		return urgentBugInfoList;
	}
	/**
	 * @param urgentBugInfoList the urgentBugInfoList to set
	 */
	public void setUrgentBugInfoList(List<BugInfo> urgentBugInfoList) {
		this.urgentBugInfoList = urgentBugInfoList;
	}
	/**
	 * @return the newBugInfoList
	 */
	public List<BugInfo> getNewBugInfoList() {
		return newBugInfoList;
	}
	/**
	 * @param newBugInfoList the newBugInfoList to set
	 */
	public void setNewBugInfoList(List<BugInfo> newBugInfoList) {
		this.newBugInfoList = newBugInfoList;
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
