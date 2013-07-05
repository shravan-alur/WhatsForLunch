package com.boredatlunch.whatsforlunch.Service;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boredatlunch.whatsforlunch.OAuth.DiOAuthService;

public class SearchYelpServiceImpl implements SearchYelpService {
	
	@Autowired
	@Qualifier("diOAuthService")
	private DiOAuthService oAuthService;
	
	//http://api.yelp.com/v2/search?term=food&ll=37.788022,-122.399797 
	/*Find for 'term' near the latitude, longitude supplied*/
	
	public String searchByLatLong(String searchTerm, double latitude,
			double longitude) {
		
		String latlong = latitude + "," + longitude;
		String location="Raleigh";
		
		//Get an instance of the service using the consumer key and consumer secret.
		OAuthService service = getoAuthService().buildOAuthService();
		//Get a token to initiate the conversation with Yelp
		Token accessToken = getoAuthService().buildOAuthAccessToken();
		
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

	public DiOAuthService getoAuthService() {
		return oAuthService;
	}

	public void setoAuthService(DiOAuthService oAuthService) {
		this.oAuthService = oAuthService;
	}

}
