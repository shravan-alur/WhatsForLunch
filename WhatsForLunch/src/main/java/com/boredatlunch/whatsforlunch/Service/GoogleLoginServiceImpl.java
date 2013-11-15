package com.boredatlunch.whatsforlunch.Service;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boredatlunch.whatsforlunch.OAuth.DiOAuthService;

public class GoogleLoginServiceImpl {
	@Autowired
	@Qualifier("googleOAuthService")
	DiOAuthService googleOAuthService;
	
	private String authUrl;
	
	public String connectToGoogle() {
		OAuthService service = getGoogleOAuthService().buildOAuthServiceWithScopeCallback();
		Token requestToken = service.getRequestToken();
		//Yelp doesn't need this token exchange. 
		//Google needs a request token followed by access token. Facebook sets request token to null.
		getGoogleOAuthService().getDiOAuthConfig().setToken(requestToken.getToken());
		String authUrl = getAuthUrl().concat(requestToken.getToken());
		return authUrl;
	}
	
	//This method is a stub. Scribe implementation in WFL does not support token exchange for OAuth - need to refactor Scribe injection. 
	/*public void getAccessToken(String oauthVerifier) {
		//OAuthService service = getGoogleOAuthService().buildOAuthServiceWithScopeCallback();
		Verifier verifier = new Verifier(oauthVerifier);
		//the set token meth
		getGoogleOAuthService().getDiOAuthConfig().setToken(token);
		Token accessToken = getGoogleOAuthService().buildOAuthAccessToken();
	}*/
	
	public DiOAuthService getGoogleOAuthService() {
		return googleOAuthService;
	}

	public void setGoogleOAuthService(DiOAuthService googleOAuthService) {
		this.googleOAuthService = googleOAuthService;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}
}
