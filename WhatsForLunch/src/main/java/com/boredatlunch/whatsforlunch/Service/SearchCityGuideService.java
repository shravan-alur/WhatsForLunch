package com.boredatlunch.whatsforlunch.Service;

public interface SearchCityGuideService {
	public String searchByLatLong(String searchTerm, double latitude, double longitude);
}
