package com.demo.utils;

import java.util.Properties;
import java.util.concurrent.Future;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class sendMailUtil {
	@Value("${spring.mail.host:DefaultValue}")
	private String host;
	@Value("${spring.mail.protocol}")
	private String protocol;
	@Value("${spring.mail.port}")
	private String port;
	@Value("${spring.mail.default-encoding}")
	private String defaultEncoding;

	public int sendText(String username, String password, String email[], String title, String text) {
		try {
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
			// 设定mail server
			senderImpl.setHost(host);
			senderImpl.setProtocol(protocol);
			senderImpl.setPort(Integer.parseInt(port));
			senderImpl.setDefaultEncoding(defaultEncoding);

			// 建立邮件消息
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			// 设置收件人，寄件人 用数组发送多个邮件
			// String[] array = new String[]
			// {"sun111@163.com","sun222@sohu.com"};
			// mailMessage.setTo(array);
			mailMessage.setTo(email);
			mailMessage.setFrom(username);
			mailMessage.setSubject(title);
			mailMessage.setText(text);

			senderImpl.setUsername(username); // 根据自己的情况,设置username
			senderImpl.setPassword(password); // 根据自己的情况, 设置password

			Properties prop = new Properties();
			prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
			prop.put("mail.smtp.timeout", "25000");
			prop.put("mail.smtp.ssl.enable", "true");
			senderImpl.setJavaMailProperties(prop);
			// 发送邮件
			// senderImpl.send(mailMessage);
			senderImpl.send(mailMessage);
			System.out.println(" 邮件发送成功.. ");
			return 200;
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}
	}

	@Async
	public Future<String> sendHtml(String username, String password, String title, String html, String to) {
		try {
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

			// 设定mail server
			senderImpl.setHost(host);
			senderImpl.setProtocol(protocol);
			senderImpl.setPort(Integer.parseInt(port));
			senderImpl.setDefaultEncoding(defaultEncoding);

			// 建立邮件消息,发送简单邮件和html邮件的区别
			MimeMessage mailMessage = senderImpl.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);

			// 设置收件人，寄件人
			// String[] a = new String[]{"xincheng.zhuang@wowjoy.c"};
			messageHelper.setTo(to);
			messageHelper.setFrom(username);
			messageHelper.setSubject(title);
			// true 表示启动HTML格式的邮件
			messageHelper.setText(html, true);
			senderImpl.setUsername(username); // 根据自己的情况,设置username
			senderImpl.setPassword(password); // 根据自己的情况, 设置password
			Properties prop = new Properties();
			prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
			prop.put("mail.smtp.timeout", "25000");
			prop.put("mail.smtp.ssl.enable", "true");
			senderImpl.setJavaMailProperties(prop);
			// 发送邮件
			senderImpl.send(mailMessage);

			System.out.println("邮件发送成功..");

			return new AsyncResult<String>("200");

		} catch (Exception e) {
			// MailAuthenticationException
			System.out.println(e instanceof MailAuthenticationException);
			e.printStackTrace();
			if (e instanceof MailAuthenticationException) {
				return new AsyncResult<String>("535");
			} else {
				return new AsyncResult<String>("500");
			}
		}
	}

}
