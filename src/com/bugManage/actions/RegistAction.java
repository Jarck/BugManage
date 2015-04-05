package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 注册Action
 * @author lou-jiandong
 * @date 2013-5-2
 */
@SuppressWarnings("serial")
public class RegistAction extends ActionSupport{
	private UserInfo user;
	private HibernateDao hibernateDao;
	
	public void validate() {
		
		//判断Email格式
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]" +
		"{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))" +
		"([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		
		//判断Email输入是否为空
		if ("".equals(user.getEmail()) || user.getEmail() == null) {
			this.addFieldError("email", "Email不能为空!");
		} else if(!user.getEmail().matches(regex)){
			this.addFieldError("email", "Email格式错误");
		} else {
			//判断Email是否已被注册
			System.out.println("RegistAction :" + user.email);
			List<UserInfo> registEmail = hibernateDao.FindUserInfoByEmail(user.getEmail());
			System.out.println(registEmail.size());
			if(0 != registEmail.size()){
				this.addFieldError("emaildouble", "该Email已经被注册!");
			}
		}
		
		//判断用户名输入是否为空
		if ("".equals(user.getName()) || user.getName() == null) {
			this.addFieldError("name", "用户名不能为空!");
		} 
		else {
			List<UserInfo> registUser = hibernateDao.FindUserInfoByName(user.name);
			if(0 != registUser.size()){
				this.addFieldError("namedouble", "用户名重复!");
			}
		}
		
		//判断Password输入是否为空
		if ("".equals(user.getPassword()) || user.getPassword() == null) {
			this.addFieldError("password", "密码不能为空!");
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
