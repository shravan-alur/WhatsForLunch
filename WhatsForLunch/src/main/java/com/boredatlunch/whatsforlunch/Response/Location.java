package com.boredatlunch.whatsforlunch.Response;

public class Location {
	//double id;
	boolean featured;
	String name;
	Address address;
	double distance;
	String phoneNumber;
	
	/*public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}*/
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
