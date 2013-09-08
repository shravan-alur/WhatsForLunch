package com.boredatlunch.whatsforlunch.Model;

import org.hibernate.validator.constraints.NotBlank;


public class LocationSearchForm {
	@NotBlank
	private String searchTerm;
	
	@NotBlank
	private String zipCode;
	
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}	
}
