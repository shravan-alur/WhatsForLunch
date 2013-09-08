package com.boredatlunch.whatsforlunch.Service;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boredatlunch.whatsforlunch.OAuth.DiOAuthService;

public class SearchRestaurantServiceImpl implements SearchRestaurantService {
	
	@Autowired
	@Qualifier("yelpOAuthService")
	private DiOAuthService yelpOAuthService;
	
	@Autowired
	private String devKey;
	
	//http://api.yelp.com/v2/search?term=food&ll=37.788022,-122.399797 
	/*Find for 'term' near the latitude, longitude supplied*/
	
	public String searchYelpByLatLong(String searchTerm, double latitude,
			double longitude) {
		
		String latlong = latitude + "," + longitude;
		String location="Raleigh";
		
		//Get an instance of the service using the consumer key and consumer secret.
		OAuthService service = getYelpOAuthService().buildOAuthService();
		//Get a token to initiate the conversation with Yelp
		Token accessToken = getYelpOAuthService().buildOAuthAccessToken();
		
		//Create the request
		OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
		request.addQuerystringParameter("term", searchTerm);
		//request.addQuerystringParameter("ll", latlong);
		request.addQuerystringParameter("location", location);
		
		//Sign the request with the OAuth Access token
		service.signRequest(accessToken, request);
		
		//Send it on its way
		Response response = request.send();
		System.out.println("The response is: " + response);
		return response.getBody();
	}
	
	public String searchYelpByCity(String searchTerm) {
		
		String location="Raleigh";
		
		//Get an instance of the service using the consumer key and consumer secret.
		OAuthService service = getYelpOAuthService().buildOAuthService();
		//Get a token to initiate the conversation with Yelp
		Token accessToken = getYelpOAuthService().buildOAuthAccessToken();
		
		//Create the request
		OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
		request.addQuerystringParameter("term", searchTerm);
		request.addQuerystringParameter("location", location);
		
		//Sign the request with the OAuth Access token
		service.signRequest(accessToken, request);
		
		//JSON response from Yelp
		Response response = request.send();
		System.out.println("The response is: " + response.getBody());
		
		return response.getBody();
	}
	
	/*public Result searchCityGuideByLatLong(String searchTerm, double latitude, double longitude) {
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
			URIBuilder uriBuilder = new URIBuilder(url);
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
			response = httpMethod.getResponseBodyAsString();
			
			//Use restTemplate to get the object directly from a GET request.
			Results result = restTemplate.getForObject(url, Results.class, params);
			System.out.println("Found " + result.getTotalHits() + " results for your search");
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public Results searchCityGuideByZipCode(String searchTerm, String zipCode) {
		String url = "http://api.citygridmedia.com/content/places/v2/search/where?what={searchTerm}&where={zipCode}&publisher={publisher}";
		try{
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			params.put("searchTerm", searchTerm);
			params.put("zipCode", zipCode);
			params.put("publisher", getDevKey());
			
			Results result = restTemplate.getForObject(url, Results.class, params);
			System.out.println("Found " + result.getTotalHits() + " results for your search");
			
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

	public DiOAuthService getYelpOAuthService() {
		return yelpOAuthService;
	}

	public void setYelpOAuthService(DiOAuthService yelpOAuthService) {
		this.yelpOAuthService = yelpOAuthService;
	}

	public String getDevKey() {
		return devKey;
	}

	public void setDevKey(String devKey) {
		this.devKey = devKey;
	}
}
