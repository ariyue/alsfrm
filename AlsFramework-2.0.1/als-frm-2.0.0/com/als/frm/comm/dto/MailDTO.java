package com.als.frm.comm.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.core.io.FileSystemResource;

/**
 * 邮件DTO
 * @author Administrator
 *
 */
public class MailDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<FileSystemResource> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<FileSystemResource> attachmentList) {
		this.attachmentList = attachmentList;
	}
	private String host;
	private String userName;
	private String password;
	private String from;
	private String to;
	private String subject;
	private String content;//可以是HTML
	private List<FileSystemResource> attachmentList;
	
}
