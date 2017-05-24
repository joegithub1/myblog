package com.joe.myblog.oa.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.joe.myblog.oa.vo.MailSenderInfoVo;



public class EmailUtil {

	public static Map<String, Object> sendMessage(Map<String, Object> param){
		Map<String, Object> result=new HashMap<>();
		
		String smtpHost = String.valueOf(param.get("smtpHost"));
		String form = String.valueOf(param.get("form"));
		String formUserPassword = String.valueOf(param.get("formUserPassword"));
		String to = String.valueOf(param.get("to"));
		String subject = String.valueOf(param.get("subject"));//标题
		//发送内容
		String messageText = String.valueOf(param.get("messageText"));
		//发送类型
		String messageType = String.valueOf(param.get("messageType"));
		
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		//props.put("mail.debug", "true");
		Session session  = Session.getInstance(props,new MyAuthenticator(form,formUserPassword));
		
		try {
			InternetAddress formAddress = new InternetAddress(form);
			InternetAddress toAddress = new InternetAddress(to);
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(formAddress);
			message.addRecipient(RecipientType.TO, toAddress);
			
			message.setSentDate(Calendar.getInstance().getTime());
			message.setSubject(subject);
			message.setContent(messageText, messageType);
			
			//发送
			Transport transport = session.getTransport("smtp");
			transport.connect(smtpHost, form, formUserPassword);
			transport.sendMessage(message, message.getRecipients(RecipientType.TO));
			System.out.println("message yes");
			result.put("result", "1");
			result.put("message", "发送成功");
		} catch (AddressException e) {
			result.put("result", "0");
			result.put("message", e.getMessage());
			System.out.println("InternetAddress  异常");
			e.printStackTrace();
		} catch (MessagingException e) {
			result.put("result", "0");
			result.put("message", e.getMessage());
			System.out.println("MimeMessage  异常");
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	* Title: EmailUtil.java
	* Description: 发送html内容邮件
	* @param mailInfo
	* @return
	* @author HuangJian
	* @date 2017年5月16日
	*/
	public static Map<String, Object> sendHtmlMail(MailSenderInfoVo mailInfo){
		Map<String, Object> result=new HashMap<>();
		
		/*String smtpHost = String.valueOf(param.get("smtpHost"));
		String form = String.valueOf(param.get("form"));
		String formUserPassword = String.valueOf(param.get("formUserPassword"));
		String to = String.valueOf(param.get("to"));
		String subject = String.valueOf(param.get("subject"));//标题
		//发送内容
		String messageText = String.valueOf(param.get("messageText"));
		//发送类型
		String messageType = String.valueOf(param.get("messageType"));*/
		
		Properties props = new Properties();
		props.put("mail.smtp.host", mailInfo.getSmtpHost());
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		//props.put("mail.debug", "true");
		Session session  = Session.getInstance(props,new MyAuthenticator(mailInfo.getForm(),mailInfo.getFormUserPassword()));
		
		try {
			InternetAddress formAddress = new InternetAddress(mailInfo.getForm());
			InternetAddress toAddress = new InternetAddress(mailInfo.getTo());
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(formAddress);
			message.addRecipient(RecipientType.TO, toAddress);
			
			message.setSentDate(Calendar.getInstance().getTime());
			message.setSubject(mailInfo.getSubject());
			//message.setContent(mailInfo.getMessageText(), mailInfo.getMessageType());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象   
			Multipart mailPart=new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			html.setContent(mailInfo.getMessageText(), mailInfo.getMessageType());
			mailPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容  
			message.setContent(mailPart);
			//发送
			Transport transport = session.getTransport("smtp");
			transport.connect(mailInfo.getSmtpHost(), mailInfo.getForm(), mailInfo.getFormUserPassword());
			transport.sendMessage(message, message.getRecipients(RecipientType.TO));
			
			
			System.out.println("message yes");
			result.put("result", "1");
			result.put("message", "发送成功");
		} catch (AddressException e) {
			result.put("result", "0");
			result.put("message", e.getMessage());
			System.out.println("InternetAddress  异常");
			e.printStackTrace();
		} catch (MessagingException e) {
			result.put("result", "0");
			result.put("message", e.getMessage());
			System.out.println("MimeMessage  异常");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Map<String, Object> userSendMessage(String toEmail,String key){
		Map<String, Object> result = new HashMap<>();
		
		Map<String, Object> map=new HashMap<>();
		map.put("smtpHost", "smtp.126.com");
		map.put("form", "day_1111@126.com");
		map.put("formUserPassword", "day_1111");
		map.put("to", toEmail);
		map.put("subject", "黄键个人博客密码找回");
		//map.put("messageText", "您本次找回密码的验证码为:"+random);
		map.put("messageType", "text/html;charset=utf-8");
		
		//result = EmailUtil.sendMessage(map);
		StringBuffer sb=new StringBuffer("");
		sb.append("您好!<br/>");
		sb.append("您收到这封电子邮件是因为您(也可能是某人冒充您的名义)申请了一个找回密码的请求<br/>");
		sb.append("您可以点击如下链接重新设置您的密码,如果点击无效,把下面的链接拷贝到浏览器的地址栏中:<br/>");
		sb.append("<a href='"+key+"'>'"+key+"'</a><br/>");
		sb.append("在访问链接之后,您可以重新设置密码.<br/>");
		sb.append("");
		sb.append("请不要直接回复本邮件.");
		MailSenderInfoVo mailInfo = new MailSenderInfoVo();
		mailInfo.setSmtpHost("smtp.126.com");
		mailInfo.setForm("day_1111@126.com");
		mailInfo.setFormUserPassword("day_1111");
		mailInfo.setTo(toEmail);
		mailInfo.setSubject("黄键个人博客密码找回");
		mailInfo.setMessageText(sb.toString());
		mailInfo.setMessageType("text/html;charset=utf-8");
		result = EmailUtil.sendHtmlMail(mailInfo);
		
		return result;
	}
	
}
class MyAuthenticator extends Authenticator{
	String userName="";
	String passWord ="";
	public MyAuthenticator() {
		// TODO Auto-generated constructor stub
	}
	public MyAuthenticator(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication(userName, passWord);
	}
}
