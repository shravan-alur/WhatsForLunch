package com.boredatlunch.whatsforlunch.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailNotificationServiceImpl {
	private Properties emailProperties;
	
	public void sendPollCreatedNotification(String recipients) {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", getEmailProperties().getProperty("mail.smtp.host"));
		prop.put("mail.smtp.socketFactory.port", getEmailProperties().getProperty("mail.smtp.socketFactory.port"));
		prop.put("mail.smtp.socketFactory.class", getEmailProperties().getProperty("mail.smtp.socketFactory.class"));
		prop.put("mail.smtp.auth", getEmailProperties().getProperty("mail.smtp.auth"));
		prop.put("mail.smtp.port", getEmailProperties().getProperty("mail.smtp.port"));
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("whatsforlunch.noreply@gmail.com","cann0tStarve07"); }
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("whatsforlunch.noreply@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
			message.setSubject("Whats For Lunch?");
			message.setText("This is a test email from Whats For Lunch. Red pill or blue pill?");
			Transport.send(message);
		}
		catch(Exception e) {
			System.out.println("Unable to send an email" + e.getMessage());
		}
	}

	public Properties getEmailProperties() {
		return emailProperties;
	}

	public void setEmailProperties(Properties emailProperties) {
		this.emailProperties = emailProperties;
	}
}
