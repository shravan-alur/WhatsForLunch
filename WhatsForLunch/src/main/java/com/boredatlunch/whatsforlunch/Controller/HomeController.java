package com.boredatlunch.whatsforlunch.Controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boredatlunch.whatsforlunch.Model.LocationSearchForm;
import com.boredatlunch.whatsforlunch.Model.Yelp.YelpResponse;
import com.boredatlunch.whatsforlunch.Service.SearchRestaurantServiceImpl;
import com.boredatlunch.whatsforlunch.Util.ResponseMapperUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	SearchRestaurantServiceImpl searchRestaurantService;
	
	@Autowired
	ResponseMapperUtil responseMapperUtil;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = {"home","/"},  method = RequestMethod.GET)
	public String home(Locale locale, final Model model) {
		LocationSearchForm locationSearchForm = new LocationSearchForm();
		model.addAttribute("locationSearchForm", locationSearchForm);
		return ".home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, final Model model, @ModelAttribute("locationSearchForm") LocationSearchForm locationSearchForm) {
		YelpResponse response = null;
		try {
			//Get JSON from service
			String yelpResponse = searchRestaurantService.searchYelpByCity(locationSearchForm.getSearchTerm());
			//Get mapped object from mapper
			response = responseMapperUtil.mapYelpResponse(yelpResponse);
		} catch (Exception e) {
			logger.error("Something went wrong when trying to retrieve search results :" + e.getMessage());
		}
		model.addAttribute("yelpResponse", response);
		return ".results";
	}
	
	public SearchRestaurantServiceImpl getSearchRestaurantService() {
		return searchRestaurantService;
	}

	public void setSearchRestaurantService(
			SearchRestaurantServiceImpl searchRestaurantService) {
		this.searchRestaurantService = searchRestaurantService;
	}
}
