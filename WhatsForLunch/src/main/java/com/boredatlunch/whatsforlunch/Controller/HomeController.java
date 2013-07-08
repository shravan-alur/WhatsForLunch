package com.boredatlunch.whatsforlunch.Controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boredatlunch.whatsforlunch.Service.SearchCityGuideServiceImpl;
import com.boredatlunch.whatsforlunch.Service.SearchYelpServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	SearchYelpServiceImpl searchYelpService;
	
	@Autowired
	SearchCityGuideServiceImpl searchCityGuideService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//searchCityGuideService.searchByLatLong("taco bell", 30.361471, -87.164326);
		return "home";
	}

	public SearchYelpServiceImpl getSearchYelpService() {
		return searchYelpService;
	}

	public void setSearchYelpService(SearchYelpServiceImpl searchYelpService) {
		this.searchYelpService = searchYelpService;
	}

	public SearchCityGuideServiceImpl getSearchCityGuideService() {
		return searchCityGuideService;
	}

	public void setSearchCityGuideService(
			SearchCityGuideServiceImpl searchCityGuideService) {
		this.searchCityGuideService = searchCityGuideService;
	}
	
	
}
