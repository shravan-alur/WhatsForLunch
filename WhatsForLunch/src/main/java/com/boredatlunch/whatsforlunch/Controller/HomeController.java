package com.boredatlunch.whatsforlunch.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boredatlunch.whatsforlunch.Model.LocationSearchForm;
import com.boredatlunch.whatsforlunch.Model.ResultSearchForm;
import com.boredatlunch.whatsforlunch.Model.Polls.Poll;
import com.boredatlunch.whatsforlunch.Model.Polls.PollItem;
import com.boredatlunch.whatsforlunch.Model.Yelp.Business;
import com.boredatlunch.whatsforlunch.Model.Yelp.YelpResponse;
import com.boredatlunch.whatsforlunch.Service.EmailNotificationServiceImpl;
import com.boredatlunch.whatsforlunch.Service.GoogleLoginServiceImpl;
import com.boredatlunch.whatsforlunch.Service.PollPersistenceService;
import com.boredatlunch.whatsforlunch.Service.SearchRestaurantServiceImpl;
import com.boredatlunch.whatsforlunch.Util.ResponseMapperUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	SearchRestaurantServiceImpl searchRestaurantService;
	
	@Autowired
	ResponseMapperUtil responseMapperUtil;
	
	@Autowired
	EmailNotificationServiceImpl emailNotificationService;
	
	@Autowired
	GoogleLoginServiceImpl googleLoginService;
	
	@Autowired
	PollPersistenceService pollPersistenceService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, final Model model, HttpSession session) {
		LocationSearchForm locationSearchForm = new LocationSearchForm();
		ResultSearchForm resultSearchForm = new ResultSearchForm();
		model.addAttribute("locationSearchForm", locationSearchForm);
		//model.addAttribute("resultSearchForm", resultSearchForm);
		//session.setAttribute("resultSearchForm", resultSearchForm);
		return ".home";
	}
	
	@RequestMapping(method = RequestMethod.POST, params={"search"})
	public String search(Locale locale, final Model model, @ModelAttribute("locationSearchForm")@Valid LocationSearchForm locationSearchForm, BindingResult bindingResult, HttpSession session) {
		YelpResponse response = null;
		List<Business> selectedPollList = new ArrayList<Business>();
		try {
			if(bindingResult.hasErrors()) {
				return ".home";
			}
			//Get JSON from service
			String yelpResponse = searchRestaurantService.searchYelpByLocation(locationSearchForm.getSearchTerm(), locationSearchForm.getZipCode());
			
			//Get mapped object from mapper
			response = responseMapperUtil.mapYelpResponse(yelpResponse);
			
		} catch (Exception e) {
			logger.error("Something went wrong when trying to retrieve search results :" + e.getMessage());
		}
		session.setAttribute("selectedPollList", selectedPollList);
		model.addAttribute("yelpResponse", response);
		session.setAttribute("yelpResponse", response);
		return ".results";
	}
	
	@RequestMapping(value="/addToPoll", method=RequestMethod.POST)
	public @ResponseBody String addToPoll(Locale locale, final Model model, @RequestParam("id") String id, HttpSession session) {
		String returnVal = "FALSE";
		List<Business> selectedPollList = (List<Business>) session.getAttribute("selectedPollList");
		YelpResponse response = (YelpResponse)session.getAttribute("yelpResponse");
		
		int size = selectedPollList.size();
		for(Business business : response.getBusinesses()) {
			if(business.getId().equals(id)) {
				System.out.println("Adding " + id + " to the poll");
				selectedPollList.add(business);
			}
		}
		int newSize = selectedPollList.size();
		
		if(newSize == size + 1) {
			returnVal = "TRUE";
		}
		model.addAttribute("selectedPollList", selectedPollList);
		return returnVal;
	}
	
	@RequestMapping(value="/sendNotification", method=RequestMethod.POST) 
	public @ResponseBody String sendPollToFriends(Locale locale, final Model model, @RequestParam("emails") String emails, HttpSession session) {
		String returnVal = "FALSE";
		Poll poll = new Poll();
		poll.setPollId(UUID.randomUUID().toString());
		poll.setCreatedTimestamp(Calendar.getInstance().getTime());
		poll.setCreatorName("sk");
		List<Business> selectedPollList = (List<Business>) session.getAttribute("selectedPollList");
		String[] emailAddressArray = StringUtils.split(emails, ",");
		int numberOfVoters = emailAddressArray.length;
		poll.setNumberOfVoters(numberOfVoters);
		
		for(Business business : selectedPollList) {
			PollItem item = new PollItem();
			item.setBusinessName(business.getName());
			item.setBusinessYelpId(business.getId());
			item.setBusinessImageUrl(business.getImage_url());
			item.setBusinessRatingImageUrl(business.getRating_img_url_large());
			item.setBusinessAddress(business.getLocation().getDisplay_address());
			item.setBusinessYelpUrl(business.getUrl());
			item.setVoteCount(0);
			poll.getPollBusinessesList().add(item);
		}
		
		pollPersistenceService.savePoll(poll);
		//TODO: Validate email format here
		try {
				emailNotificationService.sendPollCreatedNotification(Arrays.asList(emailAddressArray), poll);
				returnVal = "TRUE";
			}
			catch(Exception e) {
				logger.error("Email not sent due to some issues" + e.getMessage());
			}
		return returnVal;
	}
	
	@RequestMapping(method = RequestMethod.POST, params={"connectToGoogle"})
	public String connectToGoogle(Locale locale, final Model model, @ModelAttribute("locationSearchForm")@Valid LocationSearchForm locationSearchForm, BindingResult bindingResult, HttpSession session) {
		String redirectUrl = googleLoginService.connectToGoogle();
		return "redirect:".concat(redirectUrl);
	}
	
	@RequestMapping(value="/googleConnected", method=RequestMethod.GET)
	public void loginToGoogle(@RequestParam("oauth_verifier")String oauthVerifier, @RequestParam("oauth_token")String oauthToken) {
		
	}
	
	public SearchRestaurantServiceImpl getSearchRestaurantService() {
		return searchRestaurantService;
	}

	public void setSearchRestaurantService(
			SearchRestaurantServiceImpl searchRestaurantService) {
		this.searchRestaurantService = searchRestaurantService;
	}

	public GoogleLoginServiceImpl getGoogleLoginService() {
		return googleLoginService;
	}

	public void setGoogleLoginService(GoogleLoginServiceImpl googleLoginService) {
		this.googleLoginService = googleLoginService;
	}
}
