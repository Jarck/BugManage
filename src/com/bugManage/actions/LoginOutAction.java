package com.bugManage.actions;

import java.util.Map;

import com.bugManage.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ÍË³öÏµÍ³Action
 * @author lou-jiandong
 * @date 2013-5-17
 */
@SuppressWarnings("serial")
public class LoginOutAction extends ActionSupport{
	
	public String execute(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserInfo user = (UserInfo)session.get("loginUser");
		System.out.println("loginUser : " + user.name);
		
		session.remove("loginUser");
		
		return "success";
	}
}
