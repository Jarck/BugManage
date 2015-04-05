package com.bugManage.dao;

import java.util.List;

import com.bugManage.entity.BugInfo;
import com.bugManage.entity.LogHistory;
import com.bugManage.entity.ProjectInfo;
import com.bugManage.entity.UserInfo;


/**
 * ���ݷ��ʲ�Ľӿڰ����������ݲ�����ؽӿ�
 * @author lou-jiandong
 * @date 2013-5-2
 */
public interface HibernateDao {
	
	/**
	 * �����û���Ϣ
	 * @param user    Ҫ���浽���ݿ��UserInfo����
	 * @return blnRet true: ����ɹ�  false: ����ʧ��
	 */
	public boolean SaveUserInfo(UserInfo user);
	
	/**
	 * ����Email�����ݿ��ڲ���
	 * @param email   Ҫ���ҵ�Email
	 * @return list   ����Ҫ���UserInfo�����б�
	 */
	public List<UserInfo> FindUserInfoByEmail(String email);
	
	/**
	 * �����û��������ݿ��ڲ���
	 * @param userName   Ҫ���ҵ��û���
	 * @return list      ����Ҫ���UserInfo�����б�
	 */
	public List<UserInfo> FindUserInfoByName(String userName);
	
	/**
	 * ����Bug��Ϣ
	 * @param bugInfo       Ҫ���浽���ݿ��bugInfo����
	 * @return blnRet true: ����ɹ�  false: ����ʧ��
	 */
	public boolean SaveBugInfo(BugInfo bugInfo);
	
	/**
	 * ��ѯ��һ����Ŀ�����е�Bug��Ϣ
	 * @return  Bug��Ϣ�б�
	 */
	public List<BugInfo> FindBugInfo(BugInfo bugSearchInfo);
	
	/**
	 * ����Bug��id��ѯ����Ӧ��Bug��Ϣ
	 * @param id    Bug��id
	 * @return      Bug��Ϣ�б�
	 */
	public List<BugInfo> FindBugInfoByID(int id);
	
	/**
	 * �޸�Bug��Ϣ
	 * @param bugInfo   Ҫ�޸ĵ�BugInfo����
	 * @return          blnRet true: �޸ĳɹ�  false: �޸�ʧ��
	 */
	public boolean ModifyBugInfo(BugInfo bugInfo);
	
	/**
	 * ��ȡÿ���û����е���Ŀ��Ϣ
	 * @param userName    �û���
	 * @return            ��Ŀ�б�
	 */
	public List<ProjectInfo> FindProjectList(String userName);
	
	/**
	 * ��ѯ����Ŀ�����е�Bug��Ϣ
	 * @param projectID		��Ŀ���
	 * @return				Bug��Ϣ�б�
	 */
	public List<BugInfo> FindProjectBugList(int projectID);
	
	/**
	 * ������ĿID������Ŀ��Ϣ
	 * @param projectID  ��ĿID
	 * @return           ��Ŀ��Ϣ
	 */
	public List<ProjectInfo> FindProjectInfoByID(int projectID);
	
	/**
	 * �½���Ŀ�����޸Ķ�Ӧ�ı���Ϣ
	 * @param projectName   ��Ŀ��
	 * @param EmailList     ��Ŀ�����ԱEmail
	 * @return              blnRet true: �����ɹ�  false: ����ʧ��
	 */
	public boolean CreateProject(String projectName, String EmailList);
	
	/**
	 * ���ҷ�������˵�Bug��Ϣ
	 * @param dealer		������(�û���)
	 * @param projectID     ��ĿID
	 * @param closed 		closed true: �رյ�Bug��Ϣ  false: δ�رյ�Bug��Ϣ
	 * @return              Bug��Ϣ�б�
	 */
	public List<BugInfo> FindMyBug(String dealer, int projectID, boolean closed);
	
	/**
	 * ���ҷ�������˵�Bug��Ϣ
	 * @param dealer         ������(�û���)
	 * @param projectID      ��ĿID
	 * @param bugSearchInfo  ������Ϣ����
	 * @return               Bug��Ϣ�б�
	 */
	public List<BugInfo> FindMyBug(String dealer, int projectID, boolean closed,BugInfo bugSearchInfo);
	
	/**
	 * ��ȡ��Ŀ��������Ա��Ϣ
	 * @param projectName   ��Ŀ��
	 * @return              ��Ա��Ϣ�б�
	 */
	public List<UserInfo> FindUserByProject(String projectName);
	
	/**
	 * �������ж�Ӧ�û����ֵ�Bug
	 * @param projectID		��ĿID
	 * @param name 			�û���
	 * @return				Bug�б�
	 */
	public List<BugInfo> MyFindBug(int projectID, String name);
	
	/**
	 * ��Ӧ�û�Bug����
	 * @param projectID   ��ĿID
	 * @param name        �û���
	 * @param bugInfo     ����bugInfo����
	 * @return            BugInfo�б�
	 */
	public List<BugInfo> MyFindBug(int projectID, String name, BugInfo bugInfo);
	
	/**
	 * ������Ŀ�ж�Ӧ״̬��Bug
	 * @param projectID		��ĿID
	 * @param bugState		Bug״̬
	 * @return				Bug�б�
	 */
	public List<BugInfo> FindBugList(int projectID, int bugState);
	
	/**
	 * ������Ŀ�ж�Ӧ���͵�Bug
	 * @param projectID		��ĿID
	 * @param bugType		Bug����
	 * @return				Bug�б�
	 */
	public List<BugInfo> FindBugByState(int projectID, int bugType);
	
	/**
	 * ������־
	 * @param logHistory  ��־����
	 * @throws Exception
	 */
	public void saveLogHistory(LogHistory logHistory) throws Exception;
}
