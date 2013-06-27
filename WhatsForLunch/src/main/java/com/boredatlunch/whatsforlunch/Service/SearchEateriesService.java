package com.boredatlunch.whatsforlunch.Service;

public interface SearchEateriesService {
	public String searchByLatLong(String searchTerm, double latitude, double longitude);
}
