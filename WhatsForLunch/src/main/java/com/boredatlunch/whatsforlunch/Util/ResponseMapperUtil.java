package com.boredatlunch.whatsforlunch.Util;

import org.codehaus.jackson.map.ObjectMapper;

import com.boredatlunch.whatsforlunch.Model.Yelp.YelpResponse;


public class ResponseMapperUtil {
	
	private ObjectMapper mapper;
	
	//This mapper util converts Yelp JSON->POJO
	public YelpResponse mapYelpResponse(String jsonResponse) throws Exception {
		YelpResponse yelpResponse = getMapper().readValue(jsonResponse, YelpResponse.class);
		return yelpResponse;
	}
	
	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	
}
