package com.boredatlunch.whatsforlunch.Controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boredatlunch.whatsforlunch.Service.SearchEateriesServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	SearchEateriesServiceImpl searchEateriesService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//searchEateriesService.searchByLatLong("burritos", 30.361471, -87.164326);
		return "home";
	}

	public SearchEateriesServiceImpl getSearchEateriesService() {
		return searchEateriesService;
	}

	public void setSearchEateriesService(
			SearchEateriesServiceImpl searchEateriesService) {
		this.searchEateriesService = searchEateriesService;
	}
	
}
