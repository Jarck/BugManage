package com.bugManage.actions;

import com.bugManage.dao.HibernateDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action服务基类
 * @author lou-jiandong
 * @date 2013-5-2
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	
	private HibernateDao hibernateDao;

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
