package com.bugManage.dao;

import java.util.List;

import com.bugManage.entity.BugInfo;
import com.bugManage.entity.LogHistory;
import com.bugManage.entity.ProjectInfo;
import com.bugManage.entity.UserInfo;


/**
 * 数据访问层的接口包，放置数据操作相关接口
 * @author lou-jiandong
 * @date 2013-5-2
 */
public interface HibernateDao {
	
	/**
	 * 保存用户信息
	 * @param user    要保存到数据库的UserInfo对象
	 * @return blnRet true: 保存成功  false: 保存失败
	 */
	public boolean SaveUserInfo(UserInfo user);
	
	/**
	 * 根据Email到数据库内查找
	 * @param email   要查找的Email
	 * @return list   符合要求的UserInfo对象列表
	 */
	public List<UserInfo> FindUserInfoByEmail(String email);
	
	/**
	 * 根据用户名到数据库内查找
	 * @param userName   要查找的用户名
	 * @return list      符合要求的UserInfo对象列表
	 */
	public List<UserInfo> FindUserInfoByName(String userName);
	
	/**
	 * 保存Bug信息
	 * @param bugInfo       要保存到数据库的bugInfo对象
	 * @return blnRet true: 保存成功  false: 保存失败
	 */
	public boolean SaveBugInfo(BugInfo bugInfo);
	
	/**
	 * 查询出一个项目中所有的Bug信息
	 * @return  Bug信息列表
	 */
	public List<BugInfo> FindBugInfo(BugInfo bugSearchInfo);
	
	/**
	 * 根据Bug的id查询出对应的Bug信息
	 * @param id    Bug的id
	 * @return      Bug信息列表
	 */
	public List<BugInfo> FindBugInfoByID(int id);
	
	/**
	 * 修改Bug信息
	 * @param bugInfo   要修改的BugInfo对象
	 * @return          blnRet true: 修改成功  false: 修改失败
	 */
	public boolean ModifyBugInfo(BugInfo bugInfo);
	
	/**
	 * 获取每个用户所有的项目信息
	 * @param userName    用户名
	 * @return            项目列表
	 */
	public List<ProjectInfo> FindProjectList(String userName);
	
	/**
	 * 查询出项目中所有的Bug信息
	 * @param projectID		项目编号
	 * @return				Bug信息列表
	 */
	public List<BugInfo> FindProjectBugList(int projectID);
	
	/**
	 * 根据项目ID查找项目信息
	 * @param projectID  项目ID
	 * @return           项目信息
	 */
	public List<ProjectInfo> FindProjectInfoByID(int projectID);
	
	/**
	 * 新建项目并且修改对应的表信息
	 * @param projectName   项目名
	 * @param EmailList     项目组成人员Email
	 * @return              blnRet true: 创建成功  false: 创建失败
	 */
	public boolean CreateProject(String projectName, String EmailList);
	
	/**
	 * 查找分配给个人的Bug信息
	 * @param dealer		处理者(用户名)
	 * @param projectID     项目ID
	 * @param closed 		closed true: 关闭的Bug信息  false: 未关闭的Bug信息
	 * @return              Bug信息列表
	 */
	public List<BugInfo> FindMyBug(String dealer, int projectID, boolean closed);
	
	/**
	 * 查找分配给个人的Bug信息
	 * @param dealer         处理者(用户名)
	 * @param projectID      项目ID
	 * @param bugSearchInfo  检索信息对象
	 * @return               Bug信息列表
	 */
	public List<BugInfo> FindMyBug(String dealer, int projectID, boolean closed,BugInfo bugSearchInfo);
	
	/**
	 * 获取项目中所有人员信息
	 * @param projectName   项目名
	 * @return              人员信息列表
	 */
	public List<UserInfo> FindUserByProject(String projectName);
	
	/**
	 * 查找所有对应用户发现的Bug
	 * @param projectID		项目ID
	 * @param name 			用户名
	 * @return				Bug列表
	 */
	public List<BugInfo> MyFindBug(int projectID, String name);
	
	/**
	 * 对应用户Bug查找
	 * @param projectID   项目ID
	 * @param name        用户名
	 * @param bugInfo     检索bugInfo对象
	 * @return            BugInfo列表
	 */
	public List<BugInfo> MyFindBug(int projectID, String name, BugInfo bugInfo);
	
	/**
	 * 查找项目中对应状态的Bug
	 * @param projectID		项目ID
	 * @param bugState		Bug状态
	 * @return				Bug列表
	 */
	public List<BugInfo> FindBugList(int projectID, int bugState);
	
	/**
	 * 查找项目中对应类型的Bug
	 * @param projectID		项目ID
	 * @param bugType		Bug类型
	 * @return				Bug列表
	 */
	public List<BugInfo> FindBugByState(int projectID, int bugType);
	
	/**
	 * 保存日志
	 * @param logHistory  日志对象
	 * @throws Exception
	 */
	public void saveLogHistory(LogHistory logHistory) throws Exception;
}
