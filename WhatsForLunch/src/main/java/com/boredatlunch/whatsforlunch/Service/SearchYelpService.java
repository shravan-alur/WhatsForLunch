package com.boredatlunch.whatsforlunch.Service;

public interface SearchYelpService {
	public String searchByLatLong(String searchTerm, double latitude, double longitude);
}
