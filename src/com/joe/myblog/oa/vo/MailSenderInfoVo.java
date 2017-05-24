package com.joe.myblog.oa.vo;

public class MailSenderInfoVo {

	private String smtpHost;
	//发送者
	private String form;
	//发送者密码
	private String formUserPassword;
	//接收者
	private String to;
	//标题
	private String subject;
	//正文
	private String messageText;
	
	private String messageType;

	public MailSenderInfoVo() {
		// TODO Auto-generated constructor stub
	}
	public MailSenderInfoVo(String smtpHost, String form, String formUserPassword, String to, String subject,
			String messageText, String messageType) {
		super();
		this.smtpHost = smtpHost;
		this.form = form;
		this.formUserPassword = formUserPassword;
		this.to = to;
		this.subject = subject;
		this.messageText = messageText;
		this.messageType = messageType;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getFormUserPassword() {
		return formUserPassword;
	}

	public void setFormUserPassword(String formUserPassword) {
		this.formUserPassword = formUserPassword;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	
}
