package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ע��Action
 * @author lou-jiandong
 * @date 2013-5-2
 */
@SuppressWarnings("serial")
public class RegistAction extends ActionSupport{
	private UserInfo user;
	private HibernateDao hibernateDao;
	
	public void validate() {
		
		//�ж�Email��ʽ
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]" +
		"{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))" +
		"([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		
		//�ж�Email�����Ƿ�Ϊ��
		if ("".equals(user.getEmail()) || user.getEmail() == null) {
			this.addFieldError("email", "Email����Ϊ��!");
		} else if(!user.getEmail().matches(regex)){
			this.addFieldError("email", "Email��ʽ����");
		} else {
			//�ж�Email�Ƿ��ѱ�ע��
			System.out.println("RegistAction :" + user.email);
			List<UserInfo> registEmail = hibernateDao.FindUserInfoByEmail(user.getEmail());
			System.out.println(registEmail.size());
			if(0 != registEmail.size()){
				this.addFieldError("emaildouble", "��Email�Ѿ���ע��!");
			}
		}
		
		//�ж��û��������Ƿ�Ϊ��
		if ("".equals(user.getName()) || user.getName() == null) {
			this.addFieldError("name", "�û�������Ϊ��!");
		} 
		else {
			List<UserInfo> registUser = hibernateDao.FindUserInfoByName(user.name);
			if(0 != registUser.size()){
				this.addFieldError("namedouble", "�û����ظ�!");
			}
		}
		
		//�ж�Password�����Ƿ�Ϊ��
		if ("".equals(user.getPassword()) || user.getPassword() == null) {
			this.addFieldError("password", "���벻��Ϊ��!");
		}
	}
	public String execute() throws Exception {
		
		if(true == hibernateDao.SaveUserInfo(user)){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("loginUser", user);
			
			return "success";
		}

		return "error";
	}
	/**
	 * @return the user
	 */
	public UserInfo getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserInfo user) {
		this.user = user;
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
