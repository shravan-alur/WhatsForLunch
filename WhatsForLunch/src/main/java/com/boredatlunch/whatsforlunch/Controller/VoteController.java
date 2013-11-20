package com.boredatlunch.whatsforlunch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boredatlunch.whatsforlunch.Model.Polls.Poll;
import com.boredatlunch.whatsforlunch.Service.PollPersistenceService;

@Controller
public class VoteController {
	@Autowired
	PollPersistenceService pollPersistenceService;
	
	@RequestMapping(value="/vote", method = RequestMethod.GET)
	public void vote(@RequestParam("poll") String poll) {
		System.out.println("The poll Id requested is: " + poll + " retrieving this from DB....");
		Poll requestedPoll = pollPersistenceService.findPollById(poll);
		System.out.println("The requested poll is: " + requestedPoll);
	}
	
}
