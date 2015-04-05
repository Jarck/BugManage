package com.bugManage.dao.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.bugManage.entity.LogHistory;
import com.bugManage.entity.ProjectInfo;
import com.bugManage.entity.UserInfo;
import com.bugManage.entity.UserProject;
import com.bugManage.util.Constant;
import com.bugManage.util.DateHelper;
import com.bugManage.util.TraceLog;

/**
 * 数据访问层Hibernate实现
 * @author lou-jiandong
 * @date 2013-5-2
 */
public class HibernateDaoImpl extends HibernateDaoSupport implements HibernateDao{
	
	private static final String fileName = "HibernateDaoImpl.java";
	
	/**
	 * 构造函数
	 */
	public HibernateDaoImpl(){
		setSessionFactory(HibernateSessionFactory.getSessionFactory());
	}
	
	/**
	 * 保存用户信息
	 * @param user          要保存到数据库的UserInfo对象
	 * @return blnRet true: 保存成功  false: 保存失败
	 */
	public boolean SaveUserInfo(UserInfo user){
		TraceLog.debugLog(fileName, "SavaUserInfo", Constant.METHOD_START);
		boolean blnRet = false;
		try{
			this.getHibernateTemplate().save(user);
			blnRet = true;
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "SaveUserInfo", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "SaveUserInfo", Constant.METHOD_END);

		return blnRet;
	}
	
	/**
	 * 根据Email到数据库内查找
	 * @param email   要查找的Email
	 * @return list   符合要求的UserInfo对象列表
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> FindUserInfoByEmail(String email){
		TraceLog.debugLog(fileName, "FindUserInfo", Constant.METHOD_START);
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		try{
			String hql = "from UserInfo where email =:email";
			list = this.getHibernateTemplate().findByNamedParam(hql, 
			new String[]{"email"}, new String[]{email});
			this.getHibernateTemplate().flush();
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindUserInfo", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindUserInfo", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 根据用户名到数据库内查找
	 * @param userName   要查找的用户名
	 * @return list      符合要求的UserInfo对象列表
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> FindUserInfoByName(String userName){
		TraceLog.debugLog(fileName, "FindUserInfo", Constant.METHOD_START);
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		try{
			String hql = "from UserInfo where name =:userName";
			
			list = this.getHibernateTemplate().findByNamedParam(hql, 
					new String[]{"userName"}, new String[]{userName});
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindUserInfo", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindUserInfo", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 保存Bug信息
	 * @param bugInfo       要保存到数据库的bugInfo对象
	 * @return blnRet true: 保存成功  false: 保存失败
	 */
	public boolean SaveBugInfo(BugInfo bugInfo){
		TraceLog.debugLog(fileName, "SaveBugInfo", Constant.METHOD_START);
		boolean blnRet = false;
		
		try{
			this.getHibernateTemplate().save(bugInfo);
			
			blnRet = true;
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindUserInfo", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindUserInfo", Constant.METHOD_END);
		
		return blnRet;
	}
	
	/**
	 * 查询出一个项目中所有的Bug信息
	 * @param bugInfo       要查询的Bug信息
	 * @return  Bug信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> FindBugInfo(BugInfo bugSearchInfo){
		TraceLog.debugLog(fileName, "FindBugInfo", Constant.METHOD_START);
		
		String bugType = "";
		String bugState = "";
		String bugName = "";
		int projectID;
		List<BugInfo> list = new ArrayList<BugInfo>();
		try{
			bugType = bugSearchInfo.getBugType();
			bugState = bugSearchInfo.getBugState();
			bugName = bugSearchInfo.getBugName();
			projectID = bugSearchInfo.getProjectID();
			
			StringBuffer hql = new StringBuffer();
			hql.append("from BugInfo where 1=1 ");
			
			if(!"".equals(bugType) && null != bugType){
				if(!bugType.equals(Constant.BUG_SELECT_NUMBER_ALL)){
					hql.append("and bugType = '").append(bugType).append("'");
				}
			}
			
			if(!"".equals(bugState) && null != bugState){
				if(!bugState.equals(Constant.BUG_SELECT_NUMBER_ALL)){
					hql.append("and bugState = '").append(bugState).append("'");
				}
			}
			
			if(!"".equals(bugName) && null != bugName){
				hql.append("and bugName = '").append(bugName).append("'");
			}
			
			hql.append("and projectID =").append(projectID);
			
			list = this.getHibernateTemplate().find(hql.toString());
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindBugInfo", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindBugInfo", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 根据Bug的id查询出对应的Bug信息
	 * @param id    Bug的id
	 * @return      Bug信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> FindBugInfoByID(int id){
		TraceLog.debugLog(fileName, "FindBugInfoByID", Constant.METHOD_START);
		
		List<BugInfo> list = new ArrayList<BugInfo>();
		
		try{
			String hql = "from BugInfo where bugID =" + id;
			list = this.getHibernateTemplate().find(hql);
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindBugInfo", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindBugInfoByID", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 修改Bug信息
	 * @param bugInfo   要修改的BugInfo对象
	 * @return          blnRet true: 修改成功  false: 修改失败
	 */
	public boolean ModifyBugInfo(BugInfo bugInfo){
		TraceLog.debugLog(fileName, "ModifyBugInfo", Constant.METHOD_START);
		
		boolean blnRet = false;
		BugInfo bugInfoTemp = new BugInfo();
		
		if(bugInfo.equals(null)){
			TraceLog.errLog(fileName, "ModifyBugInfo", Constant.METHOD_END);
			return blnRet;
		}
		
		int bugId = bugInfo.getBugID();
		try{
			List<BugInfo> list = FindBugInfoByID(bugId);
			
			if(!list.isEmpty()){
				bugInfoTemp = list.get(0);
				bugInfoTemp.setBugState(bugInfo.getBugState());
				bugInfoTemp.setBugContent(bugInfo.getBugContent());
				
				this.getHibernateTemplate().saveOrUpdate(bugInfoTemp);
				blnRet = true;
			}
			
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "ModifyBugInfo", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "ModifyBugInfo", Constant.METHOD_END);
		
		return blnRet;
	}
	
	/**
	 * 获取每个用户所有的项目信息
	 * @param userName    用户名
	 * @return            项目列表
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> FindProjectList(String userEmail){
		//1.先从UserProject表中获取用户与项目之间信息
		//2.再根据UserProject中的projectName到ProjectInfo表中获取项目信息
		TraceLog.debugLog(fileName, "FindProjectList", Constant.METHOD_START);
		
		String projectName = "";
		List<ProjectInfo> allList = new ArrayList<ProjectInfo>();
		List<UserProject> list = new ArrayList<UserProject>();
		try{
			String uHql = "from UserProject where email =:userEmail";
			list = this.getHibernateTemplate().findByNamedParam(uHql, 
					new String[]{"userEmail"}, new String[]{userEmail});
			
			List<ProjectInfo> userList = new ArrayList<ProjectInfo>();
			if(!list.isEmpty()){
				for(UserProject userProject : list){
					projectName = userProject.getProjectName();
					String pHql = "from ProjectInfo where projectName =:projectName";
					userList = this.getHibernateTemplate().findByNamedParam(pHql, 
							new String[]{"projectName"}, new String[]{projectName});
					
					allList.addAll(userList);
				}
			}
			
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindProjectList", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindProjectList", Constant.METHOD_END);
		
		return allList;
	}
	
	/**
	 * 查询出项目中所有的Bug信息
	 * @param projectID		项目编号
	 * @return				Bug信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> FindProjectBugList(int projectID){
		TraceLog.debugLog(fileName, "FindProjectBugList", Constant.METHOD_START);
		List<BugInfo> list = new ArrayList<BugInfo>();
		
		try{
			String hql = "from BugInfo where projectID=" + projectID 
				+ " order by bugBeginTime DESC ";
			list = this.getHibernateTemplate().find(hql);
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindProjectBugList", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindProjectBugList", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 根据项目ID查找项目信息
	 * @param projectID  项目ID
	 * @return           项目信息
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> FindProjectInfoByID(int projectID){
		TraceLog.debugLog(fileName, "FindProjectInfo", Constant.METHOD_START);
		List<ProjectInfo> list = new ArrayList<ProjectInfo>();
		
		try{
			String hql = "from ProjectInfo where projectID=" + projectID;
			list = this.getHibernateTemplate().find(hql);
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindProjectInfo", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindProjectInfo", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 新建项目并且修改对应的表信息
	 * @param projectName   项目名
	 * @param EmailList     项目组成人员Email
	 * @return              blnRet true: 创建成功  false: 创建失败
	 */
	public boolean CreateProject(String projectName, String EmailList){
		//1.在ProjectInfo表中新增项目信息
		//2.在UserProject表中添加项目与人员之间关系信息
		TraceLog.debugLog(fileName, "CreateProject", Constant.METHOD_START);
		
		boolean blnRet = false;
		
		ProjectInfo projectInfo = new ProjectInfo();
		try{
			//获取当前系统时间
			String date = DateHelper.TimeMillisToDateStr(System.currentTimeMillis());
			
			projectInfo.setProjectName(projectName);
			projectInfo.setProjectBeginTime(Timestamp.valueOf(date));
			this.getHibernateTemplate().save(projectInfo);
			String[] Email = EmailList.split(";");
			
			for(int i=0; i<Email.length; i++){
				UserProject userProject = new UserProject();
				String emali = Email[i].trim();
				if(!"".equals(emali) && null != emali){
					System.out.println("hibernateDao createProject email : " + emali);
					userProject.setProjectName(projectName);
					userProject.setEmail(emali);
					this.getHibernateTemplate().save(userProject);
				}
			}
			
			blnRet = true;
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "CreateProject", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "CreateProject", Constant.METHOD_END);
		
		return blnRet;
	}
	
	/**
	 * 查找分配给个人的Bug信息
	 * @param dealer		处理者(用户名)
	 * @param projectID     项目ID
	 * @param closed 		closed true: 关闭的Bug信息  false: 未关闭的Bug信息
	 * @return              Bug信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> FindMyBug(String dealer, int projectID, boolean closed){
		TraceLog.debugLog(fileName, "FindMyBug", Constant.METHOD_START);
		List<BugInfo> list = new ArrayList<BugInfo>();
		
		try{
			String hql = "";
			
			if(false == closed){
				hql = "from BugInfo where bugDealer =:dealer and " +
						"bugState !=" + Constant.BUG_STATE_CLOSED + " and projectID =" + projectID;
				list = this.getHibernateTemplate().findByNamedParam(hql, 
						new String[]{"dealer"}, new Object[]{dealer});
			} else {
				hql = "from BugInfo where bugDealer =:dealer and " +
						"bugState =" + Constant.BUG_STATE_CLOSED +" and projectID =" + projectID;
				list = this.getHibernateTemplate().findByNamedParam(hql, 
						new String[]{"dealer"}, new String[]{dealer});
				
			}
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindMyBug", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindMyBug", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 查找分配给个人的Bug信息
	 * @param dealer         处理者(用户名)
	 * @param projectID      项目ID
	 * @param bugSearchInfo  检索信息对象
	 * @return               Bug信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> FindMyBug(String dealer, int projectID, boolean closed,BugInfo bugSearchInfo){
		TraceLog.debugLog(fileName, "FindMyBug", Constant.METHOD_START);
		List<BugInfo> list = new ArrayList<BugInfo>();
		
		//TODO
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&& FindMyBug begin :");
		
		String bugType = "";
		String bugName = "";
		try{
			
			StringBuffer hql = new StringBuffer();
			
			bugType = bugSearchInfo.getBugType();
			bugName = bugSearchInfo.getBugName();
			
			hql.append("from BugInfo where 1=1 ");
			hql.append(" and bugDealer = '").append(dealer).append("'");
			hql.append(" and projectID = ").append(projectID);
			
			if(!"".equals(bugType) && null != bugType){
				
				if(!bugType.equals(Constant.BUG_SELECT_NUMBER_ALL)){
					hql.append(" and bugType = '").append(bugType).append("'");
				}
			}
			
			if(!"".equals(bugName) && null != bugName){
				hql.append(" and bugName = '").append(bugName).append("'");
			}
			
			if(false == closed){
				hql.append(" and bugState != ").append(Constant.BUG_STATE_CLOSED);
			} else {
				hql.append(" and bugState = ").append(Constant.BUG_STATE_CLOSED);
			}
			
			list = this.getHibernateTemplate().find(hql.toString());
			
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindMyBug", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindMyBug", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 获取项目中所有人员信息
	 * @param projectName   项目名
	 * @return              人员信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> FindUserByProject(String projectName){
		TraceLog.debugLog(fileName, "FindUserByProject", Constant.METHOD_START);
		
		System.out.println("&&&&&&&&&&&&&&&&&& HibernateDao FindUserByProject projectName : " + projectName);
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		List<UserInfo> tempList = new ArrayList<UserInfo>();
		List<UserProject> listTemp = new ArrayList<UserProject>();
		try{
			String uHql = "from UserProject where projectName =:projectName";
			listTemp = this.getHibernateTemplate().findByNamedParam(uHql, 
					new String[]{"projectName"}, new String[]{projectName});
			
			for(UserProject temp : listTemp){
				String email = temp.getEmail();
				tempList = FindUserInfoByEmail(email);
				
				list.addAll(tempList);
			}
			
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindUserByProject", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindUserByProject", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 查找某用户所有发现的Bug
	 * @param projectID		项目ID
	 * @param name 			用户名
	 * @return				Bug列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> MyFindBug(int projectID, String name){
		TraceLog.debugLog(fileName, "MyFindBug", Constant.METHOD_START);
		
		List<BugInfo> list = new ArrayList<BugInfo>();
		
		try{
			String hql = "From BugInfo where bugFinder =:name and projectID =" + projectID;
			
			list = this.getHibernateTemplate().findByNamedParam(hql, 
					new String[]{"name"}, new String[]{name});
			
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "MyFindBug", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "MyFindBug", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 对应用户Bug查找
	 * @param projectID   项目ID
	 * @param name        用户名
	 * @param bugInfo     检索bugInfo对象
	 * @return            BugInfo列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> MyFindBug(int projectID, String name, BugInfo bugInfo){
		TraceLog.debugLog(fileName, "MyFindBug", Constant.METHOD_START);
		
		List<BugInfo> list = new ArrayList<BugInfo>();
		
		try{
			String bugType = bugInfo.getBugType();
			String bugState = bugInfo.getBugState();
			String bugName = bugInfo.getBugName();
			
			StringBuffer hql = new StringBuffer();
			hql.append("from BugInfo where 1=1 ");
			
			if(!"".equals(name) && null != name){
				if(!bugType.equals(Constant.BUG_SELECT_NUMBER_ALL)){
					hql.append("and bugFinder = '").append(name).append("'");
				}
			}
			
			if(!"".equals(bugType) && null != bugType){
				if(!bugType.equals(Constant.BUG_SELECT_NUMBER_ALL)){
					hql.append("and bugType = '").append(bugType).append("'");
				}
			}
			
			if(!"".equals(bugState) && null != bugState){
				if(!bugState.equals(Constant.BUG_SELECT_NUMBER_ALL)){
					hql.append("and bugState = '").append(bugState).append("'");
				}
			}
			
			if(!"".equals(bugName) && null != bugName){
				hql.append("and bugName = '").append(bugName).append("'");
			}
			
			hql.append("and projectID =").append(projectID);
			
			list = this.getHibernateTemplate().find(hql.toString());
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "MyFindBug", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "MyFindBug", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 查找项目中对应状态的Bug
	 * @param projectID		项目ID
	 * @param bugState		Bug状态
	 * @return				Bug列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> FindBugList(int projectID, int bugState){
		TraceLog.debugLog(fileName, "FindBugList", Constant.METHOD_START);
		
		List<BugInfo> list = new ArrayList<BugInfo>();
		String hql = "";
		try{
			if(Constant.BUG_STATE_NEW == bugState){
				hql = "from BugInfo where projectID =" + projectID 
					+ " and bugState =" + Constant.BUG_STATE_NEW;
			} else if(Constant.BUG_STATE_SOLVE == bugState){
				hql = "from BugInfo where projectID =" + projectID 
					+ " and bugState =" + Constant.BUG_STATE_SOLVE;
			} else if(Constant.BUG_STATE_CLOSED == bugState){
				hql = "from BugInfo where projectID =" + projectID 
					+ " and bugState =" + Constant.BUG_STATE_CLOSED;
			}
			
			list = this.getHibernateTemplate().find(hql);
		} catch(HibernateException e){
			TraceLog.errLog(fileName, "FindBugList", Constant.METHOD_END);
		}
		TraceLog.debugLog(fileName, "FindBugList", Constant.METHOD_END);
		
		return list;
	}
	
	/**
	 * 查找项目中对应类型的Bug
	 * @param projectID		项目ID
	 * @param bugType		Bug类型
	 * @return				Bug列表
	 */
	@SuppressWarnings("unchecked")
	public List<BugInfo> FindBugByState(int projectID, int bugType){
		TraceLog.debugLog(fileName, "FindBugByState", Constant.METHOD_START);
		
		List<BugInfo> list = new ArrayList<BugInfo>();
		
		try{
			String hql = "from BugInfo where projectID =" + projectID
				+ "and bugType =" + bugType;
			
			list = this.getHibernateTemplate().find(hql);
			
		} catch(Exception e){
			System.out.println("HibernateDao FindBugByState : " + e.getMessage());
			TraceLog.errLog(fileName, "FindBugByState", Constant.METHOD_END);
		}
		
		TraceLog.debugLog(fileName, "FindBugByState", Constant.METHOD_END);
		return list;
	}
	
	/**
	 * 保存日志
	 * @param logHistory  日志对象
	 * @throws Exception
	 */
	public void saveLogHistory(LogHistory logHistory) throws Exception {
		try {
			System.out.println("saveLogHistory logHistory : " + logHistory.getFileName());
			this.getHibernateTemplate().save(logHistory);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		HibernateDaoImpl hibernateDaoImpl = new HibernateDaoImpl();
		BugInfo bugSearchInfo = new BugInfo();
		bugSearchInfo.setBugType("1");
		List<BugInfo> list = hibernateDaoImpl.FindMyBug("111", 1, false, bugSearchInfo);
		System.out.println(list.size());
		System.out.println(list.get(0).getBugName());
		System.out.println("OVER");
	}
}