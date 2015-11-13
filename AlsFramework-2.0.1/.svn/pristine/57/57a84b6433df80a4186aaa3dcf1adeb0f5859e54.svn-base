package com.als.abc.module.tst;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 本类测试邮件发送Html形式
 ** 
 */
public class MailSendTest {

	public static void main(String[] args) throws Exception {   
        JavaMailSenderImpl senderImpl =    
                      new JavaMailSenderImpl();   
           
        // 設定 Mail Server   
        senderImpl.setHost("smtp.163.com"); 
        senderImpl.setUsername("czmooo@163.com");
        senderImpl.setPassword("password");
          
        // 建立郵件訊息   
        MimeMessage mailMessage =    
            senderImpl.createMimeMessage();   
        MimeMessageHelper messageHelper =    
            new MimeMessageHelper(mailMessage, true);
                   
        // 設定收件人、寄件人、主題與內文   
        messageHelper.setTo("czmooo@163.com");   
        messageHelper.setFrom("czmooo@163.com");   
        messageHelper.setSubject("Ming Test");   
        messageHelper.setText("<html><head></head><body><h1>Hello! Spring!"           
+ "</h1></body></html>", true);   
           
        FileSystemResource file = new FileSystemResource(new File("I:/download/javamail1_4_4.zip"));   
        messageHelper.addAttachment("can_be_a_new_name.zip", file); 
        messageHelper.addAttachment("can_be_a_new_name2.zip", file); 
           
        // 傳送郵件   
        senderImpl.send(mailMessage);    
           
        System.out.println("郵件傳送成功...");   
    }   
}