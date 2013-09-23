package com.boredatlunch.whatsforlunch.Controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boredatlunch.whatsforlunch.Model.LocationSearchForm;
import com.boredatlunch.whatsforlunch.Model.Yelp.YelpResponse;
import com.boredatlunch.whatsforlunch.Service.SearchRestaurantServiceImpl;
import com.boredatlunch.whatsforlunch.Util.ResponseMapperUtil;

public class ResultsController {
	@Autowired
	SearchRestaurantServiceImpl searchRestaurantService;
	
	@Autowired
	ResponseMapperUtil responseMapperUtil;
	
	private static final Logger logger = LoggerFactory.getLogger(ResultsController.class);
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, final Model model, @ModelAttribute("locationSearchForm")@Valid LocationSearchForm locationSearchForm, BindingResult bindingResult) {
		YelpResponse response = null;
		try {
			if(bindingResult.hasErrors()) {
				return ".home";
			}
			//Get JSON from service
			String yelpResponse = searchRestaurantService.searchYelpByLocation(locationSearchForm.getSearchTerm(), locationSearchForm.getZipCode());
			
			//Get mapped object from mapper
			response = responseMapperUtil.mapYelpResponse(yelpResponse);
			
			//Testing emails
			//emailNotificationService.sendPollCreatedNotification("shravan.alur@gmail.com");
		} catch (Exception e) {
			logger.error("Something went wrong when trying to retrieve search results :" + e.getMessage());
		}
		model.addAttribute("yelpResponse", response);
		return ".results";
	}
}
