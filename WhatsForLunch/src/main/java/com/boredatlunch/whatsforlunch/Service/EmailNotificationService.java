package com.boredatlunch.whatsforlunch.Service;

import com.boredatlunch.whatsforlunch.Model.Polls.Poll;

public interface EmailNotificationService {
	//Send an email to friends notifying of a poll creation
	public void sendPollCreatedNotification(String recipients, Poll poll);
}
