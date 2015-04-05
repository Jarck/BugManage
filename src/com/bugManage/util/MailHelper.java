package com.bugManage.util;

import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bugManage.dao.HibernateDao;
import com.bugManage.entity.BugInfo;
import com.bugManage.entity.UserInfo;

/**
 * 发送邮件
 * @author lou-jiandong
 * @date 2013-5-18
 */
public class MailHelper {
	private static HibernateDao hibernateDao;
	
	/**
	 * @return the hibernateDao
	 */
	public HibernateDao getHibernateDao() {
		return hibernateDao;
	}

	/**
	 * @param hibernateDao the hibernateDao to set
	 */
	@SuppressWarnings("static-access")
	public void setHibernateDao(HibernateDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}
	
	public static void sendMail(String toEmail, String subject, String htmlContent){
		final String fileName = "MailHelper.java";
		
		TraceLog.debugLog(fileName, "sendMail", Constant.METHOD_START);
		
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		
		//发送邮箱的邮件服务器
		senderImpl.setHost(Common.getConfigTag("email.host"));
		
		//建立邮件消息
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, "UTF-8");
		
		try{
			//收件人邮箱
			messageHelper.setTo(toEmail);
		} catch(MessagingException e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
		try{
			//发件人邮箱
			messageHelper.setFrom(Common.getConfigTag("email.from"));
		} catch(MessagingException e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
		try{
			//邮件主题
			messageHelper.setSubject(subject);
		} catch(MessagingException e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
		try{
			//启动发送HTML格式邮件
			messageHelper.setText(htmlContent, true);
		} catch(MessagingException e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
		Properties prop = new Properties();
		//由服务器进行认证，判断用户名和密码是否正确
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.timeout", "100");
		
		MyAuthenticator  auth = new MyAuthenticator (Common.getConfigTag("email.username"),
				Common.getConfigTag("email.password"));
		
		Session session = Session.getDefaultInstance(prop, auth);
		senderImpl.setSession(session);
		
		try{
			senderImpl.send(mailMessage);
			System.out.println("MailHelper send email end ");
		} catch(Exception e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
	}
	
	//创建项目时发送邮件
	public static void mailDetail(List<UserInfo> list, String projectName){
		
		for(UserInfo userInfo : list){
			String name = "";
			String subject = "Bug跟踪管理系统_通知";
			
			name = userInfo.getName();
			
			// 正文
			StringBuilder builder = new StringBuilder();
			builder.append("<html><head>");
			builder
					.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
			builder.append("</head><body>");

			builder.append("您好，");
			builder.append(name).append(" <br />");
			builder.append("\t您已经成功加入  ");
			builder.append(projectName);
			builder.append("\t项目<br />");
			builder.append("</body></html>");
			String htmlContent = builder.toString();

			MailHelper.sendMail(userInfo.email, subject, htmlContent);
			builder.setLength(0);
		}

	}
	
	//创建或修改Bug时发送邮件
	public static void mailDetail(List<UserInfo> list, BugInfo bugInfo){
		
		for(UserInfo userInfo : list){
			String subject = "Bug跟踪管理系统_通知";
			// 正文
			StringBuilder builder = new StringBuilder();
			builder.append("<html><head>");
			builder
					.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
			builder.append("</head><body>");

			String bugState = bugInfo.bugState;
			if (bugState.equals("1")) {
				bugState = "新建";
			} else if (bugState.equals("2")) {
				bugState = "修复中";
			} else if (bugState.equals("3")) {
				bugState = "已修复";
			} else if (bugState.equals("4")) {
				bugState = "关闭";
			}

			String bugType = bugInfo.bugType;
			if (bugType.equals("1")) {
				bugType = "低";
			} else if (bugType.equals("2")) {
				bugType = "中";
			} else if (bugType.equals("3")) {
				bugType = "高";
			} else if (bugType.equals("4")) {
				bugType = "紧急";
			} else if (bugType.equals("5")) {
				bugType = "严重";
			}

			builder.append("您好，");
			builder.append(userInfo.name).append(":<br />");
			builder.append("\t您有新的Bug信息：<br />");
			builder.append("标题：").append(bugInfo.bugName);
			builder.append("<br />");
			builder.append("状态：").append(bugState);
			builder.append("<br />");
			builder.append("紧急度：").append(bugType);
			builder.append("<br />");
			builder.append("发现人：").append(bugInfo.bugFinder);
			builder.append("<br />");
			builder.append("处理人：").append(bugInfo.bugDealer);
			builder.append("<br />");
			builder.append("</body></html>");
			String htmlContent = builder.toString();

			MailHelper.sendMail(userInfo.email, subject, htmlContent);
			builder.setLength(0);
		}

	}
	
}
