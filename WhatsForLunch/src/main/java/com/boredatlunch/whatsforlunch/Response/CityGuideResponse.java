package com.boredatlunch.whatsforlunch.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="results")
public class CityGuideResponse {
	@XmlElement(name="uri")
	String uri;
	
	@XmlElement(name="call_id")
	String callId;
	
	@XmlElement(name="locations")
	List<Location> locations;
	
}
