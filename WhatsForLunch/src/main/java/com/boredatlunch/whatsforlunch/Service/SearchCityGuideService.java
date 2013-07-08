package com.boredatlunch.whatsforlunch.Service;

import com.boredatlunch.whatsforlunch.Model.Results;

public interface SearchCityGuideService {
	public Results searchByLatLong(String searchTerm, double latitude, double longitude);
}
