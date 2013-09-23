package com.boredatlunch.whatsforlunch.Service;

public interface EmailNotificationService {
	//Send an email to friends notifying of a poll creation
	public void sendPollCreatedNotification(String recipients);
}
