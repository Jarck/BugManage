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
 * ���ݷ��ʲ�Hibernateʵ��
 * @author lou-jiandong
 * @date 2013-5-2
 */
public class HibernateDaoImpl extends HibernateDaoSupport implements HibernateDao{
	
	private static final String fileName = "HibernateDaoImpl.java";
	
	/**
	 * ���캯��
	 */
	public HibernateDaoImpl(){
		setSessionFactory(HibernateSessionFactory.getSessionFactory());
	}
	
	/**
	 * �����û���Ϣ
	 * @param user          Ҫ���浽���ݿ��UserInfo����
	 * @return blnRet true: ����ɹ�  false: ����ʧ��
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
	 * ����Email�����ݿ��ڲ���
	 * @param email   Ҫ���ҵ�Email
	 * @return list   ����Ҫ���UserInfo�����б�
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
	 * �����û��������ݿ��ڲ���
	 * @param userName   Ҫ���ҵ��û���
	 * @return list      ����Ҫ���UserInfo�����б�
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
	 * ����Bug��Ϣ
	 * @param bugInfo       Ҫ���浽���ݿ��bugInfo����
	 * @return blnRet true: ����ɹ�  false: ����ʧ��
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
	 * ��ѯ��һ����Ŀ�����е�Bug��Ϣ
	 * @param bugInfo       Ҫ��ѯ��Bug��Ϣ
	 * @return  Bug��Ϣ�б�
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
	 * ����Bug��id��ѯ����Ӧ��Bug��Ϣ
	 * @param id    Bug��id
	 * @return      Bug��Ϣ�б�
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
	 * �޸�Bug��Ϣ
	 * @param bugInfo   Ҫ�޸ĵ�BugInfo����
	 * @return          blnRet true: �޸ĳɹ�  false: �޸�ʧ��
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
	 * ��ȡÿ���û����е���Ŀ��Ϣ
	 * @param userName    �û���
	 * @return            ��Ŀ�б�
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> FindProjectList(String userEmail){
		//1.�ȴ�UserProject���л�ȡ�û�����Ŀ֮����Ϣ
		//2.�ٸ���UserProject�е�projectName��ProjectInfo���л�ȡ��Ŀ��Ϣ
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
	 * ��ѯ����Ŀ�����е�Bug��Ϣ
	 * @param projectID		��Ŀ���
	 * @return				Bug��Ϣ�б�
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
	 * ������ĿID������Ŀ��Ϣ
	 * @param projectID  ��ĿID
	 * @return           ��Ŀ��Ϣ
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
	 * �½���Ŀ�����޸Ķ�Ӧ�ı���Ϣ
	 * @param projectName   ��Ŀ��
	 * @param EmailList     ��Ŀ�����ԱEmail
	 * @return              blnRet true: �����ɹ�  false: ����ʧ��
	 */
	public boolean CreateProject(String projectName, String EmailList){
		//1.��ProjectInfo����������Ŀ��Ϣ
		//2.��UserProject���������Ŀ����Ա֮���ϵ��Ϣ
		TraceLog.debugLog(fileName, "CreateProject", Constant.METHOD_START);
		
		boolean blnRet = false;
		
		ProjectInfo projectInfo = new ProjectInfo();
		try{
			//��ȡ��ǰϵͳʱ��
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
	 * ���ҷ�������˵�Bug��Ϣ
	 * @param dealer		������(�û���)
	 * @param projectID     ��ĿID
	 * @param closed 		closed true: �رյ�Bug��Ϣ  false: δ�رյ�Bug��Ϣ
	 * @return              Bug��Ϣ�б�
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
	 * ���ҷ�������˵�Bug��Ϣ
	 * @param dealer         ������(�û���)
	 * @param projectID      ��ĿID
	 * @param bugSearchInfo  ������Ϣ����
	 * @return               Bug��Ϣ�б�
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
	 * ��ȡ��Ŀ��������Ա��Ϣ
	 * @param projectName   ��Ŀ��
	 * @return              ��Ա��Ϣ�б�
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
	 * ����ĳ�û����з��ֵ�Bug
	 * @param projectID		��ĿID
	 * @param name 			�û���
	 * @return				Bug�б�
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
	 * ��Ӧ�û�Bug����
	 * @param projectID   ��ĿID
	 * @param name        �û���
	 * @param bugInfo     ����bugInfo����
	 * @return            BugInfo�б�
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
	 * ������Ŀ�ж�Ӧ״̬��Bug
	 * @param projectID		��ĿID
	 * @param bugState		Bug״̬
	 * @return				Bug�б�
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
	 * ������Ŀ�ж�Ӧ���͵�Bug
	 * @param projectID		��ĿID
	 * @param bugType		Bug����
	 * @return				Bug�б�
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
	 * ������־
	 * @param logHistory  ��־����
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