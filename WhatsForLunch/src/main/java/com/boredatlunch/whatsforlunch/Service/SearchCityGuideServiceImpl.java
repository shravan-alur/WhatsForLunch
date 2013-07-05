package com.boredatlunch.whatsforlunch.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class SearchCityGuideServiceImpl implements SearchCityGuideService {
	@Autowired
	private String devKey;
	
	public String searchByLatLong(String searchTerm, double latitude, double longitude) {
		String response;
		//URL for Apache http client 
		//String url = "http://api.citygridmedia.com/content/places/v2/search/latlon?";
		
		//URL for spring rest template
		String url = "http://api.citygridmedia.com/content/places/v2/search/latlon?what={what}&lat={lat}&lon={lon}&publisher={publisher}";
		try {
			//Using Spring restTemplate to GET
			
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			params.put("what", searchTerm);
			params.put("lat", String.valueOf(latitude));
			params.put("lon", String.valueOf(longitude));
			params.put("publisher", getDevKey());
			response = restTemplate.getForObject(url, String.class, params);
					
			//Alternatively using HTTPClient to make a GET request and dump the response to console as string.
			/*URIBuilder uriBuilder = new URIBuilder(url);
			uriBuilder.addParameter("what", searchTerm);
			uriBuilder.addParameter("lat", String.valueOf(latitude));
			uriBuilder.addParameter("lon", String.valueOf(longitude));
			uriBuilder.addParameter("publisher", getDevKey());
			
			URI uri = uriBuilder.build();
			System.out.println(uri.toString());
			
			HttpClient httpClient = new HttpClient();
			HttpMethod httpMethod = null;
			httpMethod = new GetMethod(uri.toString());
			
			httpClient.executeMethod(httpMethod);
			response = httpMethod.getResponseBodyAsString();*/
			
			System.out.println("Response from CityGuide: " + response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	public String getDevKey() {
		return devKey;
	}

	public void setDevKey(String devKey) {
		this.devKey = devKey;
	}
	
	
} 
