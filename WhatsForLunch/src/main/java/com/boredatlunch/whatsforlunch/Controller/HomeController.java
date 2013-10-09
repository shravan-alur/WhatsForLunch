package com.boredatlunch.whatsforlunch.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
import com.boredatlunch.whatsforlunch.Model.Yelp.YelpResponse;
import com.boredatlunch.whatsforlunch.Service.EmailNotificationServiceImpl;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private List<String> selectedPollList = new ArrayList<String>();
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, final Model model, HttpSession session) {
		LocationSearchForm locationSearchForm = new LocationSearchForm();
		List<String> radiusList = new ArrayList<String>();
		radiusList.add("5 Miles");
		radiusList.add("10 Miles");
		radiusList.add("20 Miles");
		
		model.addAttribute("locationSearchForm", locationSearchForm);
		model.addAttribute("radiusList", radiusList);
		session.setAttribute("locationSearchForm", locationSearchForm);
		session.setAttribute("yelpResponse", new YelpResponse());
		session.setAttribute("radiusList", radiusList);
		return ".home";
	}
	
	@RequestMapping(method = RequestMethod.POST, params={"search"})
	public String search(Locale locale, final Model model, @ModelAttribute("locationSearchForm")@Valid LocationSearchForm locationSearchForm, BindingResult bindingResult) {
		YelpResponse response = null;
		try {
			if(bindingResult.hasErrors()) {
				return ".home";
			}
			//Get JSON from service
			String yelpResponse = searchRestaurantService.searchYelpByLocation(locationSearchForm.getSearchTerm(), locationSearchForm.getZipCode(), locationSearchForm.getRadius());
			
			//Get mapped object from mapper
			response = responseMapperUtil.mapYelpResponse(yelpResponse);
			
		} catch (Exception e) {
			logger.error("Something went wrong when trying to retrieve search results :" + e.getMessage());
		}
		model.addAttribute("yelpResponse", response);
		return ".results";
	}
	
	@RequestMapping(value="/addToPoll", method=RequestMethod.POST)
	public @ResponseBody String addToPoll(Locale locale, final Model model, @RequestParam("id") String id) {
		String returnVal = "FALSE";
		int size = selectedPollList.size();
		selectedPollList.add(id);
		int newSize = selectedPollList.size();
		System.out.println("Adding " + id + " to the poll");
		if(newSize == size + 1) {
			returnVal = "TRUE";
		}
		return returnVal;
	}
	
	@RequestMapping(value="/sendNotification", method=RequestMethod.POST) 
	public @ResponseBody String sendPollToFriends(Locale locale, final Model model, @RequestParam("emails") String emails) {
		String returnVal = "FALSE";
		System.out.println("Entered email IDs are: " + emails);
		//TODO: Validate if all entered emails are comma separated and also check for valid email addresses (@, .com/.domain)
		
		try {
				String[] emailAddressArray = StringUtils.split(emails, ",");
				for(String email : emailAddressArray) {
					emailNotificationService.sendPollCreatedNotification(StringUtils.trim(email));
			}
			returnVal = "TRUE";
		}
		catch(Exception e) {
			logger.error("Email not sent due to " + e.getMessage());
		}
		
		return returnVal;
	}
	
	public SearchRestaurantServiceImpl getSearchRestaurantService() {
		return searchRestaurantService;
	}

	public void setSearchRestaurantService(
			SearchRestaurantServiceImpl searchRestaurantService) {
		this.searchRestaurantService = searchRestaurantService;
	}

	public List<String> getSelectedPollList() {
		return selectedPollList;
	}
	
}
