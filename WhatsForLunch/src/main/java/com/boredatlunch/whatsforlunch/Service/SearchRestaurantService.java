package com.boredatlunch.whatsforlunch.Service;


public interface SearchRestaurantService {
	public String searchYelpByLatLong(String searchTerm, double latitude, double longitude);
	//public Results searchCityGuideByLatLong(String searchTerm, double latitude, double longitude);
	//public Results searchCityGuideByZipCode(String searchTerm, String zipCode);
}
