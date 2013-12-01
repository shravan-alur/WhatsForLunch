package com.boredatlunch.whatsforlunch.Service;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import com.boredatlunch.whatsforlunch.Model.Polls.Poll;
import com.boredatlunch.whatsforlunch.Model.Polls.PollItem;


public class EmailNotificationServiceImpl {
	private Properties emailProperties;
	
	public void sendPollCreatedNotification(List<String> recipients, Poll poll) throws Exception{
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
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("whatsforlunch.noreply@gmail.com"));
		for(String recipient : recipients) {
			//String url = "http://localhost:8082/WhatsForLunch/poll?poll=".concat(poll.getPollId());
			String url = "http://localhost:8082/WhatsForLunch/poll";
			HttpGet getUrl = new HttpGet(url);
			URI uri = new URIBuilder(getUrl.getURI()).addParameter("poll", poll.getPollId()).addParameter("voterId", StringUtils.trim(recipient)).build();
			message.setSubject("Your friend asks What's for Lunch?");
			message.setText("Your friend has invited you to vote on a poll created on What's for Lunch? Go here to vote for your choice: " + uri);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(StringUtils.trim(recipient)));
			Transport.send(message);
		}
	}
	
	public void sendSpreadTheWordNotification(String recipients) throws Exception{
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
		
		
		String url = "http://localhost:8082/WhatsForLunch/";
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("whatsforlunch.noreply@gmail.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
		message.setSubject("What's for lunch?");
		message.setText("Your friend recently participated in a What's for Lunch poll and wants to spread the word about us! Please check us out at " + url);
		Transport.send(message);
	}

	public Properties getEmailProperties() {
		return emailProperties;
	}

	public void setEmailProperties(Properties emailProperties) {
		this.emailProperties = emailProperties;
	}
}
