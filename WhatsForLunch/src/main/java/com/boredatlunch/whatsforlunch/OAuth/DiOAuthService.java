package com.boredatlunch.whatsforlunch.OAuth;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

//Why call this a 'DiOAuthService' ? Because it supports Dependency Injection.
//What does this class offer? Gives me basic OAuth functionality in a dependency injection friendly way.
public class DiOAuthService {

	private DiOAuthConfig diOAuthConfig;

	/*The serviceBuilder needs an 'apiClass' to create a new service, 
	this may be an instance of Api or an instance of any extended class. 
	We choose to extend for the purposes of dependency injection*/ 
	public OAuthService buildOAuthService() {
		return new ServiceBuilder()
				.provider(getDiOAuthConfig().getApi())
				.apiKey(getDiOAuthConfig().getApiKey())
				.apiSecret(getDiOAuthConfig().getApiSecret())
				.build();
	}
	
	public OAuthService buildOAuthServiceWithScopeCallback() {
		return new ServiceBuilder()
				.provider(getDiOAuthConfig().getApi())
				.apiKey(getDiOAuthConfig().getApiKey())
				.apiSecret(getDiOAuthConfig().getApiSecret())
				.callback(getDiOAuthConfig().getCallback())
				.scope(getDiOAuthConfig().getScope())
				.build();
	}
	
	//We need a service and an access token. This token is created using the token and the token secret provided by facebook/twitter/yelp etc.. 
	public Token buildOAuthAccessToken() {
		return new Token(getDiOAuthConfig().getToken(), getDiOAuthConfig().getTokenSecret());
	}
	
	
	/*
	We need a service and an access token. This token is created using the token and the token secret provided by facebook/twitter/yelp etc.. 
	public Token buildOAuthAccessToken(Verifier ) {
		return new Token(getDiOAuthConfig().getToken(), getDiOAuthConfig().getTokenSecret());
	}*/
	
	public DiOAuthConfig getDiOAuthConfig() {
		return diOAuthConfig;
	}

	public void setDiOAuthConfig(DiOAuthConfig diOAuthConfig) {
		this.diOAuthConfig = diOAuthConfig;
	}
}