package com.boredatlunch.whatsforlunch.Controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boredatlunch.whatsforlunch.Model.Polls.Poll;
import com.boredatlunch.whatsforlunch.Model.Polls.PollItem;
import com.boredatlunch.whatsforlunch.Service.EmailNotificationServiceImpl;
import com.boredatlunch.whatsforlunch.Service.PollPersistenceService;

@Controller
public class PollController {
	@Autowired
	PollPersistenceService pollPersistenceService;
	
	@Autowired
	EmailNotificationServiceImpl emailNotificationService;
	
	private static final Logger logger = LoggerFactory.getLogger(PollController.class);
	
	@RequestMapping(value="/poll", method = RequestMethod.GET)
	public String vote(final Model model, @RequestParam("poll") String poll, @RequestParam("voterId") String voterId, HttpSession session ) {
		System.out.println("The poll Id requested is: " + poll + " retrieving this from DB....");
		Poll requestedPoll = pollPersistenceService.findPollById(poll);
		System.out.println("The requested poll is: " + requestedPoll);
		model.addAttribute("requestedPoll", requestedPoll);
		session.setAttribute("requestedPoll", requestedPoll);
		session.setAttribute("voterId", voterId);
		return ".pollResults";
	}
	
	@RequestMapping(value="/spreadTheWord", method=RequestMethod.POST) 
	public @ResponseBody String shareWithFriends(Locale locale, final Model model, @RequestParam("recipients") String recipients, HttpSession session) {
		String returnVal = "FALSE";
		try {
				String[] emailAddressArray = StringUtils.split(recipients, ",");
				for(String email : emailAddressArray) {
					emailNotificationService.sendSpreadTheWordNotification(recipients);
			}
			returnVal = "TRUE";
		}
		catch(Exception e) {
			logger.error("Email not sent due to some issues" + e.getMessage());
		}
		return returnVal;
	}
	
	@RequestMapping(value="/voteForChoice", method=RequestMethod.POST)
	public @ResponseBody String voteForPoll(Locale locale, final Model model, @RequestParam("id") String id, HttpSession session) {
		String returnVal = "FALSE";
		System.out.println("Voted for business yelp id: " + id);
		String voterId = (String) session.getAttribute("voterId");
		Poll requestedPoll = (Poll)session.getAttribute("requestedPoll");
		for(PollItem item : requestedPoll.getPollBusinessesList()) {
			if(item.getBusinessYelpId().equals(id)) {
					//only allow voting if id has not voted
					if(!requestedPoll.getVotersList().contains(voterId)) {
					System.out.println("Increasing the vote count for " + id + " on poll " + requestedPoll.getPollId() + " voted by " + voterId);
					//increase vote count for this business on this poll, set the name of the person who voted for this choice and persist back to the DB.
					int currentVotecount = item.getVoteCount();
					//increse vote count
					item.setVoteCount(currentVotecount+1);
					//set the name of the person who voted for this
					List<String> itemVotersList = item.getItemVotersList();
					itemVotersList.add(voterId);
					item.setItemVotersList(itemVotersList);
					
					List<String> pollVotersList = requestedPoll.getVotersList();
					pollVotersList.add(voterId);
					requestedPoll.setVotersList(pollVotersList);
					
					//Persist the updated poll
					pollPersistenceService.savePoll(requestedPoll);
					returnVal = "TRUE";
				}
				else {
					//this id has voted already, do not allow voting again
					returnVal = "VOTED";
				}
			}
		}
		return returnVal;
	}
}
