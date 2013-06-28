package com.boredatlunch.whatsforlunch.OAuth;

import org.scribe.builder.api.DefaultApi10a;

public class DiOAuthConfig {
	private String apiKey;
	private String apiSecret;
	private String callback;
	//The object ? implements the Api interface provided by scribe. 
	//Used generics implement this. See DiOAuthService for more info. 
	//Else, should have been an implementation of the Api interface in Scribe
	private DefaultApi10a api;
	private String token;
	private String tokenSecret;
	
	//Spring needs a no-args constructor
	public DiOAuthConfig() {
		super();
	}

	//Constructor for Spring to use to create an instance for dependency injection
	public DiOAuthConfig(String apiKey, String apiSecret, DefaultApi10a api, String token, String tokenSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.api = api;
		this.token = token;
		this.tokenSecret = tokenSecret;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getApiSecret() {
		return apiSecret;
	}
	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	
	public DefaultApi10a getApi() {
		return api;
	}

	public void setApi(DefaultApi10a api) {
		this.api = api;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}	
}
