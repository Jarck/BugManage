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
 * �����ʼ�
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
		
		//����������ʼ�������
		senderImpl.setHost(Common.getConfigTag("email.host"));
		
		//�����ʼ���Ϣ
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, "UTF-8");
		
		try{
			//�ռ�������
			messageHelper.setTo(toEmail);
		} catch(MessagingException e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
		try{
			//����������
			messageHelper.setFrom(Common.getConfigTag("email.from"));
		} catch(MessagingException e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
		try{
			//�ʼ�����
			messageHelper.setSubject(subject);
		} catch(MessagingException e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
		try{
			//��������HTML��ʽ�ʼ�
			messageHelper.setText(htmlContent, true);
		} catch(MessagingException e){
			TraceLog.errLog(fileName, "sendMail", Constant.METHOD_END);
		}
		
		Properties prop = new Properties();
		//�ɷ�����������֤���ж��û����������Ƿ���ȷ
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
	
	//������Ŀʱ�����ʼ�
	public static void mailDetail(List<UserInfo> list, String projectName){
		
		for(UserInfo userInfo : list){
			String name = "";
			String subject = "Bug���ٹ���ϵͳ_֪ͨ";
			
			name = userInfo.getName();
			
			// ����
			StringBuilder builder = new StringBuilder();
			builder.append("<html><head>");
			builder
					.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
			builder.append("</head><body>");

			builder.append("���ã�");
			builder.append(name).append(" <br />");
			builder.append("\t���Ѿ��ɹ�����  ");
			builder.append(projectName);
			builder.append("\t��Ŀ<br />");
			builder.append("</body></html>");
			String htmlContent = builder.toString();

			MailHelper.sendMail(userInfo.email, subject, htmlContent);
			builder.setLength(0);
		}

	}
	
	//�������޸�Bugʱ�����ʼ�
	public static void mailDetail(List<UserInfo> list, BugInfo bugInfo){
		
		for(UserInfo userInfo : list){
			String subject = "Bug���ٹ���ϵͳ_֪ͨ";
			// ����
			StringBuilder builder = new StringBuilder();
			builder.append("<html><head>");
			builder
					.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
			builder.append("</head><body>");

			String bugState = bugInfo.bugState;
			if (bugState.equals("1")) {
				bugState = "�½�";
			} else if (bugState.equals("2")) {
				bugState = "�޸���";
			} else if (bugState.equals("3")) {
				bugState = "���޸�";
			} else if (bugState.equals("4")) {
				bugState = "�ر�";
			}

			String bugType = bugInfo.bugType;
			if (bugType.equals("1")) {
				bugType = "��";
			} else if (bugType.equals("2")) {
				bugType = "��";
			} else if (bugType.equals("3")) {
				bugType = "��";
			} else if (bugType.equals("4")) {
				bugType = "����";
			} else if (bugType.equals("5")) {
				bugType = "����";
			}

			builder.append("���ã�");
			builder.append(userInfo.name).append(":<br />");
			builder.append("\t�����µ�Bug��Ϣ��<br />");
			builder.append("���⣺").append(bugInfo.bugName);
			builder.append("<br />");
			builder.append("״̬��").append(bugState);
			builder.append("<br />");
			builder.append("�����ȣ�").append(bugType);
			builder.append("<br />");
			builder.append("�����ˣ�").append(bugInfo.bugFinder);
			builder.append("<br />");
			builder.append("�����ˣ�").append(bugInfo.bugDealer);
			builder.append("<br />");
			builder.append("</body></html>");
			String htmlContent = builder.toString();

			MailHelper.sendMail(userInfo.email, subject, htmlContent);
			builder.setLength(0);
		}

	}
	
}
