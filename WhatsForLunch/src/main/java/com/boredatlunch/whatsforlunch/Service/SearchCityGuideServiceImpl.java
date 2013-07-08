package com.boredatlunch.whatsforlunch.Service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.boredatlunch.whatsforlunch.Model.Results;

public class SearchCityGuideServiceImpl implements SearchCityGuideService {
	@Autowired
	private String devKey;
	
	public Results searchByLatLong(String searchTerm, double latitude, double longitude) {
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
			
			//Use restTemplate to get the object directly from a GET request.
			Results result = restTemplate.getForObject(url, Results.class, params);
			System.out.println("Found " + result.getTotalHits() + " results for your search");
			
			return result;
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
