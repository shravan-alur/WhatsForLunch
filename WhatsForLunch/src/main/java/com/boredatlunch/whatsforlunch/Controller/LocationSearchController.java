package com.boredatlunch.whatsforlunch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.boredatlunch.whatsforlunch.Service.SearchRestaurantServiceImpl;

@Controller
public class LocationSearchController {
	@Autowired
	SearchRestaurantServiceImpl searchRestaurantService;
	
	public SearchRestaurantServiceImpl getSearchRestaurantService() {
		return searchRestaurantService;
	}

	public void setSearchRestaurantService(
			SearchRestaurantServiceImpl searchRestaurantService) {
		this.searchRestaurantService = searchRestaurantService;
	}	
}
