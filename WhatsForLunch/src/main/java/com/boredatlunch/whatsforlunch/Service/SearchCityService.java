package com.boredatlunch.whatsforlunch.Service;

public interface SearchCityService {
	public String searchInCityByLatLong(String searchTerm, double latitude, double longitude);
}
