package com.als.frm.comm.util;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.MailDTO;


/**
 * 
 * @author Vincent
 *
 */
public class MailSendHelper {

	/**
	 * 发送系统邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param content 内容
	 * @param attachmentList 附件
	 */
	public static void sendSystemMail(String to, String subject, String content, List<FileSystemResource> attachmentList){
		
		MailDTO mail = new MailDTO();
		mail.setAttachmentList(attachmentList);
		mail.setContent(content);
		mail.setFrom(FrmConstant.appInitParams.get("mail.from").toString());
		mail.setHost(FrmConstant.appInitParams.get("mail.host").toString());
		mail.setUserName(FrmConstant.appInitParams.get("mail.username").toString());
		mail.setPassword(FrmConstant.appInitParams.get("mail.password").toString());
		mail.setSubject(subject);
		mail.setTo(to);
		sendMail(mail);
	}
	
	/**
	 * 发送邮件
	 * @param mail
	 */
	public static void sendMail(MailDTO mail){
		
		try {
			JavaMailSenderImpl senderImpl =  new JavaMailSenderImpl();   
			
			//设定 Mail Server   
			senderImpl.setHost(mail.getHost()); 
			senderImpl.setUsername(mail.getUserName());
			senderImpl.setPassword(mail.getPassword());
			  
			//建立邮件信息
			MimeMessage mailMessage =    
			    senderImpl.createMimeMessage();   
			MimeMessageHelper messageHelper =    
			    new MimeMessageHelper(mailMessage, true);
			           
			// 設定收件人、寄件人、主題與內文   
			messageHelper.setTo(mail.getTo());   
			messageHelper.setFrom(mail.getFrom());   
			messageHelper.setSubject(mail.getSubject());   
			messageHelper.setText(mail.getContent(), true);   
			if(mail.getAttachmentList() != null){
				for (int i = 0, len = mail.getAttachmentList().size(); i < len; i++){
					FileSystemResource file = mail.getAttachmentList().get(i);
					messageHelper.addAttachment(file.getFilename(), file); 
				}
			}
			   
			// 发送邮件
			senderImpl.send(mailMessage);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
           
        System.out.println("邮件发送成功...");  
	}
}
