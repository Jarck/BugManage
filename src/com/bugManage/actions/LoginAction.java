package com.bugManage.actions;

import java.util.List;
import java.util.Map;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录处理Action
 * @author lou-jiandong
 * @date 2013-5-3
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	private UserInfo user;
	private HibernateDao hibernateDao;
	
	public void validate() {
		//判断Email输入是否为空
		if ("".equals(user.getEmail()) || user.getEmail() == null) {
			this.addFieldError("email", "Email不能为空!");
		}
		
		//验证邮箱格式是否正确
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]" +
				"{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))" +
				"([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		if(!user.getEmail().matches(regex)){
			this.addFieldError("email", "Email格式错误");
		}
		
		//判断Password输入是否为空
		if ("".equals(user.getPassword()) || user.getPassword() == null) {
			this.addFieldError("password", "密码不能为空!");
		}
		
	}
	
	public String execute(){
		List<UserInfo> list = hibernateDao.FindUserInfoByEmail(user.getEmail());
		
		if(list.isEmpty()){
			this.addFieldError("login", "Email或密码错误!");
		}
		//密码相同
		else if(list.get(0).getPassword().equals(user.getPassword())){
			UserInfo loginUser = list.get(0);
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("loginUser", loginUser);
			
			return "success";
		} else {
			this.addFieldError("login", "Email或密码错误!");
		}
		
		return "login";
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
