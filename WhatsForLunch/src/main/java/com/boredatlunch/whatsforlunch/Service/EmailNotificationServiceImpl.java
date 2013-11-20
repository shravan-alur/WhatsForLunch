package com.boredatlunch.whatsforlunch.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;

import com.boredatlunch.whatsforlunch.Model.Polls.Poll;
import com.boredatlunch.whatsforlunch.Model.Polls.PollItem;


public class EmailNotificationServiceImpl {
	private Properties emailProperties;
	
	public void sendPollCreatedNotification(String recipients, Poll poll) throws Exception{
		String pollCandidates = null;
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
		
		List<String> businessNames = new ArrayList<String>();
		for(PollItem item : poll.getPollBusinessesList()) {
			businessNames.add(item.getBusinessName());
		}
		
		pollCandidates = StringUtils.join(businessNames, ",");
		String url = "http://localhost:8082/WhatsForLunch/vote?poll=".concat(poll.getPollId());
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("whatsforlunch.noreply@gmail.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
		message.setSubject("You friend asks Whats for Lunch?");
		message.setText("Your friend has invited you to vote on a poll created on Whats for Lunch? Go here to vote for your choice: " + url);
		Transport.send(message);
	}

	public Properties getEmailProperties() {
		return emailProperties;
	}

	public void setEmailProperties(Properties emailProperties) {
		this.emailProperties = emailProperties;
	}
}
