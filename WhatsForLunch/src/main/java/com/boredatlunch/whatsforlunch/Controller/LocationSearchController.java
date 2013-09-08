package com.boredatlunch.whatsforlunch.Controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boredatlunch.whatsforlunch.Model.LocationSearchForm;
import com.boredatlunch.whatsforlunch.Service.SearchRestaurantServiceImpl;

@Controller
public class LocationSearchController {
	@Autowired
	SearchRestaurantServiceImpl searchRestaurantService;
	
	/*@RequestMapping(value = "findLunchLocations", method = RequestMethod.POST)
	public String search(Locale locale, final Model model, @ModelAttribute("locationSearchForm") LocationSearchForm locationSearchForm, @ModelAttribute("searchResults")Results searchResults) {
		Results searchResult = searchRestaurantService.searchCityGuideByZipCode(locationSearchForm.getSearchTerm(), locationSearchForm.getZipCode());
		model.addAttribute("searchResults", searchResult);
		return "searchListings";
	}*/
	
	@RequestMapping(value = "findLunchLocationsByCity", method = RequestMethod.POST)
	public String searchByCity(Locale locale, final Model model, @ModelAttribute("locationSearchForm") LocationSearchForm locationSearchForm) {
		String searchResult = searchRestaurantService.searchYelpByCity(locationSearchForm.getSearchTerm());
		//model.addAttribute("searchResults", searchResult);
		System.out.println("Search Result is: " + searchResult);
		return "searchListings";
	}

	public SearchRestaurantServiceImpl getSearchRestaurantService() {
		return searchRestaurantService;
	}

	public void setSearchRestaurantService(
			SearchRestaurantServiceImpl searchRestaurantService) {
		this.searchRestaurantService = searchRestaurantService;
	}	
}
